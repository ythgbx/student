package net.bus.web.common.weixin.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bus.web.common.weixin.config.WeiXinConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edifi_000 on 2016-10-07.
 */
public class WeiXinCore {

    public static Map<String, String> getInfo(String code){

        Map<String, String> accessInfo = getAccessToken(code);

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<String, String>();
        String accessToken = accessInfo.get("access_token");
        String openId =  accessInfo.get("openid");
        if(StringUtils.isBlank(accessToken)||StringUtils.isBlank(openId)){
            return null;
        }

        vars.put("access_token", accessToken);
        vars.put("openid",openId);
        String resultJson = restTemplate.getForObject(" https://api.weixin.qq.com/sns/userinfo?access_token={access_token}&openid={openid}", String.class, vars);

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(resultJson);

            Map<String, String> result = new HashMap<String, String>();
            result.put("unionid",root.path("unionid").textValue());
            result.put("headimgurl", root.path("headimgurl").textValue());//用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
            result.put("nickname", root.path("nickname").textValue());

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Map<String, String> getAccessToken(String code){
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("app_id", WeiXinConfig.app_id);
        vars.put("secret", WeiXinConfig.secret);
        vars.put("code",code);
        String resultJson = restTemplate.getForObject("https://api.weixin.qq.com/sns/oauth2/access_token?appid={app_id}&secret={secret}&code={code}&grant_type=authorization_code", String.class, vars);

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(resultJson);

            Map<String, String> result = new HashMap<String, String>();
            result.put("access_token",root.path("access_token").textValue());
            result.put("expires_in", root.path("expires_in").textValue());
            result.put("refresh_token", root.path("refresh_token").textValue());
            result.put("openid", root.path("openid").textValue());
            result.put("scope", root.path("scope").textValue());

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

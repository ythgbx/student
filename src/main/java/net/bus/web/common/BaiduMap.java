package net.bus.web.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edifi_000 on 2016-08-10.
 */
public class BaiduMap {

    public static  Map<String, String> getCityInfo(Double lat,Double lng,String baiduKey)
    {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("lat", lat.toString());//"30.990998"
        vars.put("lng", lng.toString());//"103.645966"
        vars.put("baidu_key",baiduKey);//"Lgv9LkGS96Z06OI4E61zErKZDDPh2l7T"
        String resultJson = restTemplate.getForObject("http://api.map.baidu.com/geocoder/v2/?ak={baidu_key}&location={lat},{lng}&output=json&pois=0", String.class, vars);
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(resultJson);
            JsonNode resultNode = root.path("result");

            JsonNode addressComponentNode = resultNode.path("addressComponent");
            JsonNode cityNode = addressComponentNode.path("city");
            JsonNode provinceNode = addressComponentNode.path("province");
            Map<String, String> result = new HashMap<String, String>();
            result.put("city",cityNode.textValue());
            result.put("province", provinceNode.textValue());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

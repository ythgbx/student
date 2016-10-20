package net.bus.web.common.weixin.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-10-19.
 */
public class CommonUtil {

    public static String postRequest(String url,String requestXML){
        RestTemplate restTemplate = new RestTemplate();
        reInitMessageConverter(restTemplate);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
        headers.setContentType(type);
        headers.add("Accept", MediaType.ALL.toString());

        HttpEntity<String> formEntity = new HttpEntity<String>(requestXML, headers);

        String result = restTemplate.postForObject(url, formEntity, String.class);
        return result;
    }

    /*
        *初始化RestTemplate，RestTemplate会默认添加HttpMessageConverter
        * 添加的StringHttpMessageConverter非UTF-8
        * 所以先要移除原有的StringHttpMessageConverter，
        * 再添加一个字符集为UTF-8的StringHttpMessageConvert
        * */
    public static void reInitMessageConverter(RestTemplate restTemplate){
        List<HttpMessageConverter<?>> converterList=restTemplate.getMessageConverters();
        HttpMessageConverter<?> converterTarget = null;
        for (HttpMessageConverter<?> item : converterList) {
            if (item.getClass() == StringHttpMessageConverter.class) {
                converterTarget = item;
                break;
            }
        }

        if (converterTarget != null) {
            converterList.remove(converterTarget);
        }
        HttpMessageConverter<?> converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        converterList.add(converter);
    }
}

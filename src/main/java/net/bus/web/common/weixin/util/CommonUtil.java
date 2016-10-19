package net.bus.web.common.weixin.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Edifi_000 on 2016-10-19.
 */
public class CommonUtil {

    public static String postRequest(String url,String requestXML){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/xml; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_XML.toString());

        HttpEntity<String> formEntity = new HttpEntity<String>(requestXML, headers);

        String result = restTemplate.postForObject(url, formEntity, String.class);
        return result;
    }
}

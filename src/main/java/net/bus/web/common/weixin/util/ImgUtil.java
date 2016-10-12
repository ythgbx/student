package net.bus.web.common.weixin.util;

import org.apache.commons.io.FileUtils;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.List;

/**
 * Created by Edifi_000 on 2016-10-12.
 */
public class ImgUtil {

    public static boolean SaveUrlImg(String imgUrl,String path) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

            ResponseEntity<byte[]> response = restTemplate.exchange(
                    imgUrl,
                    HttpMethod.GET,
                    new HttpEntity<byte[]>(headers),
                    byte[].class);

            byte[] result = response.getBody();
            File file = new File(path);
            if (!file.exists()){
               FileUtils.writeByteArrayToFile(file, result);
                return true;
            }
        return false;
    }
}

package net.bus.web.common.weixin.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by Edifi_000 on 2016-11-08.
 */
public class ClientCustomSSL {

    public static String postRequest(String key,String url,String requestXML) throws Exception{
        KeyStore keyStore  = KeyStore.getInstance("PKCS12");
        //TODO 修改为相对位置的.p12文件
        FileInputStream instream = new FileInputStream(new File("E:\\Work\\IBus\\mydocument\\cert\\cert\\apiclient_cert.p12"));
        try {
            keyStore.load(instream, key.toCharArray());
        } finally {
            instream.close();
        }

        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, key.toCharArray())
                .build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[] { "TLSv1" },
                null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
        try {

            HttpPost httpPost = new HttpPost(url);
            StringEntity xmlEntity = new StringEntity(requestXML, "UTF-8");
            httpPost.setEntity(xmlEntity);

            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpPost.addHeader("Accept", "*/*");

            HttpResponse response = httpclient.execute(httpPost);
            HttpEntity resEntity = response.getEntity();
            InputStreamReader reader = new InputStreamReader(resEntity.getContent(), "ISO-8859-1");
            char[] buff = new char[1024];
            int length = 0;
            StringBuilder sb= new StringBuilder();
            while ((length = reader.read(buff)) != -1) {
                sb.append(new String(buff, 0, length));
            }

            httpclient.getConnectionManager().shutdown();

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
        return null;
    }
}

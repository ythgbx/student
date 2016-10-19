package net.bus.web.common.weixin.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.bus.web.common.weixin.config.WeiXinConfig;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
/**
 * Created by Edifi_000 on 2016-10-19.
 */
public class PayCommonUtil {

    public static String CreateNoncestr(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res += chars.indexOf(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    public static String CreateNoncestr() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < 16; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + WeiXinConfig.API_KEY);
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }

    @SuppressWarnings("unchecked")
    public static String getRequestXml(SortedMap<Object,Object> parameters){
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if ("attach".equalsIgnoreCase(k)||"body".equalsIgnoreCase(k)||"sign".equalsIgnoreCase(k)) {
                sb.append("<"+k+">"+"<![CDATA["+v+"]]></"+k+">");
            }else {
                sb.append("<"+k+">"+v+"</"+k+">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

    public static String setXML(String return_code, String return_msg) {
        return "<xml><return_code><![CDATA[" + return_code
                + "]]></return_code><return_msg><![CDATA[" + return_msg
                + "]]></return_msg></xml>";
    }



    @SuppressWarnings("unchecked")
    public static Map<String, String>  getPrepayId(String totalFee,String ipAddress,String orderNumber,String body,String openid) throws Exception{
        SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
        parameters.put("appid", WeiXinConfig.app_id);
        parameters.put("mch_id", WeiXinConfig.MCH_ID);
        parameters.put("nonce_str", CreateNoncestr());
        parameters.put("body", body);
        parameters.put("out_trade_no", orderNumber);
        parameters.put("total_fee", totalFee);
        parameters.put("spbill_create_ip",ipAddress);
        parameters.put("notify_url", WeiXinConfig.NOTIFY_URL);
        parameters.put("trade_type", "APP");//APP -temp
        //parameters.put("openid", openid);//APP -temp
        String sign = PayCommonUtil.createSign("UTF-8", parameters);
        parameters.put("sign", sign);
        String requestXML = PayCommonUtil.getRequestXml(parameters);
        String result =CommonUtil.postRequest(WeiXinConfig.UNIFIED_ORDER_URL, requestXML);
        Map<String, String> map = XMLUtil.doXMLParse(result);//解析微信返回的信息，以Map形式存储便于取值
        return map;
    }

    public static Map<String, String>  queryWeiXinOrder(String orderNumber) throws Exception{
        SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
        parameters.put("appid", WeiXinConfig.app_id);
        parameters.put("mch_id", WeiXinConfig.MCH_ID);
        parameters.put("nonce_str", CreateNoncestr());
        parameters.put("out_trade_no", orderNumber);
        String sign = PayCommonUtil.createSign("UTF-8", parameters);
        parameters.put("sign", sign);
        String requestXML = PayCommonUtil.getRequestXml(parameters);
        String result =CommonUtil.postRequest(WeiXinConfig.CHECK_ORDER_URL, requestXML);
        Map<String, String> map = XMLUtil.doXMLParse(result);//解析微信返回的信息，以Map形式存储便于取值
        return map;
    }



    public static String createPackageValue(String prepay_id) throws Exception{
        SortedMap<Object,Object> params = new TreeMap<Object,Object>();
        params.put("appId", WeiXinConfig.app_id);
        params.put("timeStamp", Long.toString(new Date().getTime()));
        params.put("nonceStr", PayCommonUtil.CreateNoncestr());
        params.put("package", "prepay_id="+prepay_id);
        params.put("signType", WeiXinConfig.SIGN_TYPE);
        String paySign =  PayCommonUtil.createSign("UTF-8", params);
        params.put("packageValue", "prepay_id="+prepay_id);    //这里用packageValue是预防package是关键字在js获取值出错
        params.put("paySign", paySign);                                                          //paySign的生成规则和Sign的生成规则一致
        params.put("sendUrl", WeiXinConfig.SUCCESS_URL);                               //付款成功后跳转的页面
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(params);
        return json;
    }
}

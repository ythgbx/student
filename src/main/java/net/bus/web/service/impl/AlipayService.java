package net.bus.web.service.impl;


//import com.alipay.api.AlipayApiException;
//import com.alipay.api.internal.util.AlipaySignature;
import net.bus.web.common.alipay.config.AlipayConfig;
import net.bus.web.common.alipay.sign.RSA;
import net.bus.web.common.alipay.util.AlipayCore;
import net.bus.web.common.alipay.util.AlipayNotify;
import net.bus.web.context.AlipayCallBack;
import net.bus.web.service.IAlipayService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Edifi_000 on 2016-09-08.
 */
@Service
public class AlipayService implements IAlipayService{

    private Logger logger = Logger.getLogger("CommonLogger");

    public String sign(String subject, String body, String price)
    {
        return getOrderInfo(subject,body,price);
    }

    public boolean async(Map<String, String> params)
    {
        //获取返回数据
        AlipayCallBack callBack = getCallBack(params);

        //sign
        String sign = handleFormStr(params.get("sign").replace(" ","+"));//客户端请求可能导致,"+"号字符变成空格

        //TODO 检验1 2 3 4
        //TODO 1 outTradeNo 是否存在
        //TODO 2 outTradeNo 对应的 amount 是否匹配
        //TODO 3 outTradeNo 对应的 seller_id 是否匹配
        //TODO 4 outTradeNo 对应的 app_id 是否匹配

        try {
            if(true||AlipayNotify.verifyResponse(callBack.getNotifyId()).equals("true")){
                if(AlipayNotify.getSignVeryfy(params, sign)){
                    if(callBack.getTradeStatus().equals("TRADE_FINISHED") || callBack.getTradeStatus().equals("TRADE_SUCCESS")) {

                        //要写的逻辑。自己按自己的要求写
                        logger.info("async sign verified success");
                        //封装交易信息实体，存入数据库之类的
                        System.out.println(">>>>>异步返回:" + callBack.getTradeNo());
                    }
                    return true;
                }else{
                    logger.info("async sign verified failed");
                    return false;
                }
            }else{
                logger.info("async sign verifyResponse failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean ret(String prestr,Map<String, String> params)
    {
        //String prestr="";//"_input_charset=\"utf-8\"&body=\"商品介绍12345\"&notify_url=\"http://service.zfbus.net/alipay/async\"&out_trade_no=\"e92d782ee82946bab955c0a7b08af731\"&partner=\"2088421421805384\"&payment_type=\"1\"&seller_id=\"whytxnkj@163.com\"&service=\"mobile.securitypay.pay\"&subject=\"测试商品1\"&total_fee=\"0.01\"&success=\"true\"";

        //sign
        String sign = handleFormStr(params.get("sign").replace(" ","+"));//"lQTwUBnwJeGbgc6rSEuueuOYfBwiqySQqhOHa7RG+BxfLO2mrsAUqxTqWopnJ02070E9qZl6/87csAyaPrmJDyN/NmRt9XzzzCk6ffHdmr2hz0HXCbIrt1R0YMcvbccUa+Tiux6zVUMxT0OEct1srJoRsTLtYRSvlMmvMDWQxkw=";

        String success = handleFormStr(handleFormStr(params.get("success")));
        String partner = handleFormStr(handleFormStr(params.get("partner")));
        String service = handleFormStr(handleFormStr(params.get("service")));


        try {
            if(prestr!="")
            {
                if(success.equals("true"))//判断success是否为true.
                {
                    //验证参数是否匹配
                    if(partner.equals(AlipayConfig.partner)&&service.equals(AlipayConfig.service))
                    {
                        //获得验签结果
                        if(RSA.verify(prestr, sign, AlipayConfig.alipay_public_key, AlipayConfig.input_charset)){
                            //此处可做商家业务逻辑，建议商家以异步通知为准。
                            logger.info("ret sign verified success");
                            return true;
                        }else{
                            logger.info("ret sign verified failed");
                        }
                    }else{
                        logger.info("客户端信息与服务端配置信息有误!");
                    }
                }else{
                    logger.info("此同步返回无效!");
                }
            }else{
                logger.info("无客户端参数!");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getOrderInfo(String subject, String body, String price) {

        Map<String,String> params = new HashMap<String,String>();
        params.put("service","\""+ AlipayConfig.service+"\"");
        params.put("partner", "\""+AlipayConfig.partner+"\"");
        params.put("_input_charset", "\""+AlipayConfig.input_charset+"\"");
        params.put("notify_url", "\""+AlipayConfig.notify_url+"\"");
        params.put("out_trade_no", "\""+getOutTradeNo()+"\"");
        params.put("subject", "\""+subject+"\"");
        params.put("payment_type", "\"1\"");
        params.put("seller_id", "\""+AlipayConfig.seller_id+"\"");
        params.put("total_fee","\""+price+"\"");
        params.put("body","\""+body+"\"");

        String data=AlipayCore.createLinkString(params);

        //将待签名字符串使用私钥签名。
        String rsa_sign= null;
        try {
            rsa_sign = URLEncoder.encode(RSA.sign(data, AlipayConfig.private_key, AlipayConfig.input_charset), AlipayConfig.input_charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //把签名得到的sign和签名类型sign_type拼接在待签名字符串后面。
        data=data+"&sign=\""+rsa_sign+"\"&sign_type=\""+AlipayConfig.sign_type+"\"";

        return data;
    }

    private AlipayCallBack getCallBack(Map<String, String> params)
    {
        //获取返回数据
        AlipayCallBack callBack = new AlipayCallBack();
        callBack.setOrderTitle(handleFormStr(params.get("subject")));//订单名称
        callBack.setPayType(handleFormStr(params.get("payment_type")));//支付类型
        callBack.setOutTradeNo(handleFormStr(params.get("out_trade_no")));//订单号
        callBack.setTradeNo(handleFormStr(params.get("trade_no")));//支付宝交易号
        callBack.setNotifyId(handleFormStr(params.get("notify_id")));//支付校验id
        callBack.setAmount(handleFormStr(params.get("total_fee")));//交易金额
        callBack.setNotifyTime(handleFormStr(params.get("notify_time")));//通知时间
        callBack.setTradeStatus(handleFormStr(params.get("trade_status")));//交易状态
        callBack.setReturnId(handleFormStr(params.get("extra_common_param")));//项目id
        callBack.setPayer(handleFormStr(params.get("buyer_email")));//支付者账号
        callBack.setSellerId(handleFormStr(params.get("seller_id")));//商户id
        callBack.setAppId(handleFormStr(params.get("app_id")));//商户应用id

        return callBack;
    }

    private String getOutTradeNo()
    {
        //TODO 生成订单编号
        return UUID.randomUUID().toString().replace("-","");
    }

    private String handleFormStr(String param)
    {
        if(param!=null){
            return param.replace("\"","");
        }else{
            return param;
        }
    }
}

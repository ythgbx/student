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
        AlipayCallBack callBack = new AlipayCallBack();
        callBack.setOrderTitle(params.get("subject"));//订单名称
        callBack.setPayType(params.get("payment_type"));//支付类型
        callBack.setOutTradeNo(params.get("out_trade_no"));//订单号
        callBack.setTradeNo(params.get("trade_no"));//支付宝交易号
        callBack.setNotifyId(params.get("notify_id"));//支付校验id
        callBack.setAmount(params.get("total_fee"));//交易金额
        callBack.setNotifyTime(params.get("notify_time"));//通知时间
        callBack.setTradeStatus(params.get("trade_status"));//交易状态
        callBack.setReturnId(params.get("extra_common_param"));//项目id
        callBack.setPayer(params.get("buyer_email"));//支付者账号
        callBack.setSellerId(params.get("seller_id"));//商户id
        callBack.setAppId(params.get("app_id"));//商户应用id

        //sign
        String sign=params.get("sign");

        //TODO 检验1 2 3 4
        //TODO 1 outTradeNo 是否存在
        //TODO 2 outTradeNo 对应的 amount 是否匹配
        //TODO 3 outTradeNo 对应的 seller_id 是否匹配
        //TODO 4 outTradeNo 对应的 app_id 是否匹配

        try {
            if(AlipayNotify.verifyResponse(callBack.getNotifyId()).equals("true")){
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getOrderInfo(String subject, String body, String price) {

        Map<String,String> params = new HashMap<String,String>();
        params.put("service",AlipayConfig.service);
        params.put("partner", AlipayConfig.partner);
        params.put("_input_charset",AlipayConfig.input_charset);
        params.put("notify_url",AlipayConfig.notify_url);

        params.put("out_trade_no",getOutTradeNo());
        params.put("subject",subject);
        params.put("payment_type","1");
        params.put("seller_id",AlipayConfig.seller_id);
        params.put("total_fee",price);
        params.put("body",body);

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

    private String getOutTradeNo()
    {
        //TODO 生成订单编号
        return UUID.randomUUID().toString().replace("-","");
    }
}

package net.bus.web.service.impl;


import net.bus.web.common.alipay.config.AlipayConfig;
import net.bus.web.common.alipay.sign.RSA;
import net.bus.web.common.alipay.util.AlipayCore;
import net.bus.web.common.alipay.util.AlipayNotify;
import net.bus.web.common.alipay.util.AlipaySubmit;
import net.bus.web.model.Orders;
import net.bus.web.model.Pojo.AlipayAsyncCallBack;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Pojo.AlipayOrderCallBack;
import net.bus.web.model.Pojo.Product;
import net.bus.web.service.IAlipayService;
import net.bus.web.service.IProductService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edifi_000 on 2016-09-08.
 */
@Service
public class AlipayService implements IAlipayService ,IPayService{



    private Logger logger = Logger.getLogger("CommonLogger");

    public String sign(String tradeNo, String subject, String body, String price)
    {
        return getOrderInfo(tradeNo,subject,body,price);
    }

    public AlipayOrderCallBack sign(Product product,String tradeNo){
        AlipayOrderCallBack orderCallBack = null;
        try {
            String sign = getOrderInfo(tradeNo, product.getSubject(), product.getBody(), product.getPrice().toString());
            orderCallBack = new AlipayOrderCallBack();
            orderCallBack.setSign(sign);
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderCallBack;
    }

    public AlipayAsyncCallBack async(Map<String, String> params)
    {
        //获取返回数据
        AlipayAsyncCallBack callBack = getCallBack(params);

        //sign
        String sign = handleFormStr(params.get("sign").replace(" ","+"));//客户端请求可能导致,"+"号字符变成空格

        //TODO 检验1 2 3 4
        //TODO 1 outTradeNo 是否存在
        //TODO 2 outTradeNo 对应的 amount 是否匹配
        //TODO 3 outTradeNo 对应的 seller_id 是否匹配
        //TODO 4 outTradeNo 对应的 app_id 是否匹配

        try {
            logger.info("async notify check:" + callBack.getNotifyId());
            if(true||AlipayNotify.verifyResponse(callBack.getNotifyId()).equals("true")){
                if(AlipayNotify.getSignVeryfy(params, sign)){
                    if(callBack.getTradeStatus().equals("TRADE_FINISHED") || callBack.getTradeStatus().equals("TRADE_SUCCESS")) {
                        logger.info("async sign verified success:"+callBack.getOutTradeNo());
                    }else{
                        logger.info("trade not finished or success");
                        callBack.setFailed("trade not finished or success");
                    }
                }else{
                    logger.info("async sign verified failed");
                    callBack.setFailed("async sign verified failed");
                }
            }else{
                logger.info("async sign verifyResponse failed");
                callBack.setFailed("async sign verifyResponse failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            callBack = null;
        }
        return callBack;
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

    public boolean refund(Orders orders,String refundTradeNo,String userId){
        //批次号，必填，格式：当天日期[8位]+序列号[3至24位]，如：201603081000001
        String batch_no = "201611140001";
        //退款笔数，必填，参数detail_data的值中，“#”字符出现的数量加1，最大支持1000笔（即“#”字符出现的数量999个）
        String batch_num = "1";
        //退款详细数据，必填，格式（支付宝交易号^退款金额^备注），多笔请用#隔开
        String detail_data =orders.getPayTradeNo()+"^"+orders.getPay()+"^test refund";

        java.text.DateFormat format2 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("service", (AlipayConfig.refund_service));
        sParaTemp.put("partner", (AlipayConfig.partner));
        sParaTemp.put("_input_charset", (AlipayConfig.input_charset));
        sParaTemp.put("notify_url", AlipayConfig.refund_notify_url);
        sParaTemp.put("seller_user_id", (AlipayConfig.partner));
        sParaTemp.put("refund_date", format2.format(new Date()));
        sParaTemp.put("batch_no", batch_no);
        sParaTemp.put("batch_num", batch_num);
        sParaTemp.put("detail_data", detail_data);

        //建立请求
        String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
        try {
            logger.info(sHtmlText);
            return true;
        }catch (Exception e){

        }
        return false;
    }

    private String getOrderInfo(String tradeNo,String subject, String body, String price) {

        Map<String,String> params = new HashMap<String,String>();
        params.put("service","\""+ AlipayConfig.service+"\"");
        params.put("partner", "\""+AlipayConfig.partner+"\"");
        params.put("_input_charset", "\""+AlipayConfig.input_charset+"\"");
        params.put("notify_url", "\"" + AlipayConfig.notify_url+"\"");
        params.put("out_trade_no", "\"" + tradeNo+"\"");
        params.put("subject", "\"" + subject+"\"");
        params.put("payment_type", "\"1\"");
        params.put("seller_id", "\"" + AlipayConfig.seller_id+"\"");
        params.put("total_fee", "\"" + price+"\"");
        params.put("body", "\"" + body+"\"");

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

    private AlipayAsyncCallBack getCallBack(Map<String, String> params)
    {
        //获取返回数据
        AlipayAsyncCallBack callBack = new AlipayAsyncCallBack();
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

    private String handleFormStr(String param)
    {
        if(param!=null){
            return param.replace("\"","");
        }else{
            return param;
        }
    }

    private String handleAddChar(String param){
        if(param!=null){
            return "\""+ param+"\"";
        }else{
            return param;
        }
    }
}

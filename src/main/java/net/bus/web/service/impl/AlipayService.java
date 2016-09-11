package net.bus.web.service.impl;


import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import net.bus.web.context.AlipayCallBack;
import net.bus.web.service.IAlipayService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Edifi_000 on 2016-09-08.
 */
@Service
public class AlipayService implements IAlipayService{

    private static String APP_ID ="2016083101827187";
    private static String APP_PRIVATE_KEY ="MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAMWimByhTal6fT13" +
            "6BQvxJDH27tOukbGiW39OHwlb9mCYCTC6jo0HMCZXyewCAkhdfQ2RUU5q+yBF5st" +
            "Lvw3L4jDjDWR+JItNvqYVI8Vqea5LTC0p3rLA/+d/VUXWVoG0pmb++xj21m0SiSo" +
            "siH8eTcysj7SgW8Re7i1GvTA5nlTAgMBAAECgYEAvIG/sN8yIksRFgY+uLJvPOFE" +
            "dr468rL/9ocmz1MuAjtW1PmNTALUwegIWOSQZZUi2tLA86x0jdr71ykbvbotfQdQ" +
            "nMqMYakP5+Tlwk/ZkbtVO2pPDhCDEdbiATryyWMv1hOrJncEBBILcWgl1TqLrGpZ" +
            "kqj5bVXHi6Qe/nIwumECQQD9chDiTGmM9Ml5/akyWcGRF/5a8erpUF/zKQxQck8g" +
            "NPKwMKHvtzLRvSg0H2FHPw0oeqJnzx/a7YAwtamNl1u7AkEAx6CHCx/7fUk9eZfk" +
            "9K+eFqH3jSUTpaSTcm3E5yhJygAwZUgVaPvIomtsRr3Dvr/Q4lhSCwdmtydp4kIl" +
            "KoxjSQJBAKuJuZ3BBCuwPnF/2zXGBDo1GCXr2QgjK14D6V7Fj4KH876GnAQIZbAJ" +
            "rB1jI886AKjmH+fNC4189CeDvQelayMCQQCMKaMH5aHPmuAGAudoAfKO05Qbzx+X" +
            "WxGH85if8QK2SSGxy0X1G2wI1kIE/XJ1+PoyIm8gfUbabFsE2Qp9cGq5AkEAsSeB" +
            "ArVUPzIfBcwU6XbXnnIrBEZcieYxgL681kKchxZ9W4VOY0SSAA9h9upRcoiYx1mh" +
            "PdkrgRTXGc/zeRP8dw==";
    private static String ALIPAY_PUBLIC_KEY ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB\n";

    private static String PARTNER ="2088421421805384";
    private static String SELLER ="2687137048@qq.com";

    private static String NOTIFY_URL ="http://notify.msp.hk/notify.htm";//TODO 修改为自己的网站地址

    private static String CHARSET = "utf-8";

    public String sign(String subject, String body, String price)
    {
        try {
            return AlipaySignature.rsa256Sign(getOrderInfo(subject,body,price),APP_PRIVATE_KEY,"utf-8");
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return null;
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

        //TODO 检验1 2 3 4
        //TODO 1 outTradeNo 是否存在
        //TODO 2 outTradeNo 对应的 amount 是否匹配
        //TODO 3 outTradeNo 对应的 seller_id 是否匹配
        //TODO 4 outTradeNo 对应的 app_id 是否匹配

        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET);
            if(signVerified){//验证成功
                if(callBack.getTradeStatus().equals("TRADE_FINISHED") || callBack.getTradeStatus().equals("TRADE_SUCCESS")) {

                    //要写的逻辑。自己按自己的要求写

                    //封装交易信息实体，存入数据库之类的
                    System.out.println(">>>>>异步返回:" + callBack.getTradeNo());
                }
                return true;
            }else{//验证失败
                return false;
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getOrderInfo(String subject, String body, String price) {

        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + PARTNER + "\"";
        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + SELLER + "\"";
        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + getOutTradeNo() + "\"";
        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";
        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";
        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";
        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + NOTIFY_URL + "\"";

        return orderInfo;
    }

    private String getOutTradeNo()
    {
        //TODO 生成订单编号
        return UUID.randomUUID().toString();
    }
}

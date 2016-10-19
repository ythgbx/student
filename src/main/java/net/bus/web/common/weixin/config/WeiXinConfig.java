package net.bus.web.common.weixin.config;

/**
 * Created by Edifi_000 on 2016-10-07.
 */
public class WeiXinConfig {
    public static String app_id = "wxff74953269e37d8f";
    public static String secret = "d06566665ed01562507dc778424fe169";

    //应用对应的密钥
    public final static String TOKEN = "weixinCourse";//服务号的配置token
    public final static String MCH_ID = "xxxxxxxx";//商户号
    public final static String API_KEY = "xdddasd";//API密钥
    public final static String SIGN_TYPE = "MD5";//签名加密方式
    public final static String CERT_PATH = "";//微信支付证书存放路径地址
    //微信支付统一接口的回调action
    public final static String NOTIFY_URL = "";
    //微信支付成功支付后跳转的地址
    public final static String SUCCESS_URL = "http://www.xiaoshuaishuai.com";
    //oauth2授权时回调action
    public final static String REDIRECT_URI = "";
    /**
     * 微信基础接口地址
     */
    //获取token接口(GET)
    public final static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    //oauth2授权接口(GET)
    public final static String OAUTH2_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    //刷新access_token接口（GET）
    public final static String REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";

    /**
     * 微信支付接口地址
     */
    //微信支付统一接口(POST)
    public final static String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    //微信退款接口(POST)
    public final static String REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
    //订单查询接口(POST)
    public final static String CHECK_ORDER_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
    //关闭订单接口(POST)
    public final static String CLOSE_ORDER_URL = "https://api.mch.weixin.qq.com/pay/closeorder";
    //退款查询接口(POST)
    public final static String CHECK_REFUND_URL = "https://api.mch.weixin.qq.com/pay/refundquery";
    //对账单接口(POST)
    public final static String DOWNLOAD_BILL_URL = "https://api.mch.weixin.qq.com/pay/downloadbill";
    //短链接转换接口(POST)
    public final static String SHORT_URL = "https://api.mch.weixin.qq.com/tools/shorturl";
    //接口调用上报接口(POST)
    public final static String REPORT_URL = "https://api.mch.weixin.qq.com/payitil/report";
}

package  net.bus.web.common.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：1.0
 *日期：2016-06-06
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	//合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String partner = "2088421421805384";

	//商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key ="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAL9Ag08ls0ViI2QL" +
			"fVwRvMaspfqiR8lfJUq/IVhaHaWbKxQgbNHfY1zCxdsjMJgKiaD5D9vEt3J8vfHS" +
			"Y3QIo5l0CVSIALrJ6gw+4gZeVoNVQ/uuXdnDlEkkb/fPC+RGMvHzwUF7pkVX5k5Y" +
			"NynqD39vN65hMoZyLB0gmtQ+BdgdAgMBAAECgYALJE0CDWY2QpNhPrIc7QOcZ257" +
			"/XxFJP/dLOlaZlWX0kReNc1hJKx7OPWh4JjyIpsF/7yGxx0Q1GeUcPdOSTqOmjyK" +
			"BVGv1fANSBru2rFP9Be8hYRnDM2S/GKni/jXQ0G+vreZpqbcoz4zqPuJxS9J3ZN3" +
			"eAb+yeJd5aeU9jZRAQJBAOle3w7oZmwJtFhCSUlmrERKZ5kjd1HxOVHtnUvLsDyd" +
			"BDQ5a0F36IcAgb0bkbRoOLhm6aDB+XMNkDjF+IPWYT0CQQDRzBnkILNV+M1dBXUY" +
			"JOapeCES4umJmWuvQ7uPbZS32aZgBvDDMtXnGiwkFE13bSPKK8Dljf+YL5iSLOv3" +
			"pwBhAkASIdDq85uhoU9l3CCdl2CjHbTW7S6EK13sw62JChZzXy/Ibv2qZIqokp2B" +
			"9/ZmMgLWMQjN+MRM8CzYfGlGtQ1xAkBYlJut9ZyixQ04pHA/RH1buowEZGiEn5GX" +
			"C7sqoPL0+WHFE8keMd2c2TEf/q6CqUM+PmEQy3bKs/XwaiUriIihAkBnwIiRAiyo" +
			"XNBWgrQhDmmf7ya/wc5PeMAj4Oc7TvYTCC6dDz6NFd2yrcH9prl64393J8XTcIi3" +
			"UE9uBWKmoHMq";
	
	//支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String alipay_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	
	// 签名方式
	public static String sign_type = "RSA";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path ="C://";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 接收通知的接口名
	public static String service = "mobile.securitypay.pay";

	// 服务器接受回调地址
	public static String notify_url = "http://service.zfbus.net/alipay/async";

	//卖家支付宝账号
	public static String seller_id ="whytxnkj@163.com";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	//退款通知的接口名
	public static String refund_service = "refund_fastpay_by_platform_pwd";

	// 服务器接受退款回调地址
	public static String refund_notify_url = "http://service.zfbus.net/alipay/refundasync";

	public static String app_id = "2016083101827187";
}


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
	public static String private_key ="MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAMWimByhTal6fT13" +
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
	public static String seller_id ="2687137048@qq.com";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}


package net.bus.web.service.impl;

import net.bus.web.common.weixin.config.WeiXinConfig;
import net.bus.web.common.weixin.util.PayCommonUtil;
import net.bus.web.context.WxCallBack;
import net.bus.web.service.IWxpayService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Edifi_000 on 2016-10-19.
 */
@Service
public class WxpayService implements IWxpayService{

    private Logger logger = Logger.getLogger("CommonLogger");

    public String getOutTradeNo()
    {
        //TODO 生成订单编号
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Map<String,String> prepay(Long id)
    {
        Map<String,String> prepayInfo = null;
        try {
            prepayInfo =  PayCommonUtil.getPrepayId("1", "192.168.1.110",getOutTradeNo(),"测试商品","");
			prepayInfo.put("time_stamp",(new Date().getTime() / 1000)+"");
			prepayInfo.put("package","Sign=WXPay");
			SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
			parameters.put("appid", WeiXinConfig.app_id);
			parameters.put("partnerid", WeiXinConfig.MCH_ID);
			parameters.put("prepayid", prepayInfo.get("prepay_id"));
			parameters.put("package", prepayInfo.get("package"));
			parameters.put("noncestr",prepayInfo.get("nonce_str"));
			parameters.put("timestamp", prepayInfo.get("time_stamp"));
			String sign = PayCommonUtil.createSign("UTF-8", parameters);
			prepayInfo.put("sign",sign);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prepayInfo;
    }

    public boolean async(Map<String, String> params){
        logger.info("async info print:"+params.toString());
        WxCallBack callBack = getCallBack(params);

        if(callBack.getResultCode().equals("SUCCESS")){
            SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
            parameters.put("appid", WeiXinConfig.app_id);
            //packageParams.put("attach", order.getMember().getId().toString()); //用自己系统的数据：会员id
            parameters.put("bank_type", callBack.getBankType());
            //parameters.put("cash_fee", cash_fee);
            parameters.put("fee_type", callBack.getFeeType());
            parameters.put("is_subscribe", callBack.isSubscribe()?"Y":"N");
            parameters.put("mch_id", WeiXinConfig.MCH_ID);
            parameters.put("nonce_str", callBack.getNonceStr());
            parameters.put("openid", callBack.getOpenId());
            parameters.put("out_trade_no", callBack.getOutTradeNo());
            parameters.put("result_code", callBack.getResultCode());
            parameters.put("return_code", callBack.getReturnCode());
            parameters.put("sub_mch_id", callBack.getSubMchId());
            parameters.put("time_end", callBack.getTimeEnd());
            parameters.put("total_fee", callBack.getTotalFee()); //用自己系统的数据：订单金额
            parameters.put("trade_type", callBack.getTradeType());
            parameters.put("transaction_id", callBack.getTransactionId());

            String sign = PayCommonUtil.createSign("UTF-8", parameters);
            logger.info("async check sign:"+sign+" callback.sign:"+callBack.getSign());
            if(callBack.getSign().equals(sign)){
                //TODO 判断支付并执行后续处理
                logger.info("async sign verified success:"+callBack.getOutTradeNo());
            }
        }

        return false;
    }

    private WxCallBack getCallBack(Map<String, String> params)
    {
        //获取返回数据
        WxCallBack callBack = new WxCallBack();
        callBack.setAppid(handleFormStr(params.get("appid")));//应用ID
        callBack.setAttach(handleFormStr(params.get("attach")));//商家数据包
        callBack.setBankType(handleFormStr(params.get("bank_type")));//付款银行
        callBack.setFeeType(handleFormStr(params.get("fee_type")));//货币种类
        callBack.setIsSubscribe(handleFormStr(params.get("is_subscribe")) == "Y" ? true : false);//是否关注公众账号
        callBack.setMchId(handleFormStr(params.get("mch_id")));//商户号
        callBack.setNonceStr(handleFormStr(params.get("nonce_str")));//随机字符串
        callBack.setOpenId(handleFormStr(params.get("openid")));//用户标识
        callBack.setOutTradeNo(handleFormStr(params.get("out_trade_no")));//商户订单号
        callBack.setResultCode(handleFormStr(params.get("result_code")));//业务结果 SUCCESS/FAIL
        callBack.setReturnCode(handleFormStr(params.get("return_code")));//返回状态码
        callBack.setSign(handleFormStr(params.get("sign")));//签名
        callBack.setSubMchId(handleFormStr(params.get("sub_mch_id")));//商户应用id
        callBack.setTimeEnd(handleFormStr(params.get("time_end")));//支付完成时间
        callBack.setTotalFee(BigDecimal.valueOf(Double.parseDouble(handleFormStr(params.get("total_fee")))));//总金额
        callBack.setTradeType(handleFormStr(params.get("trade_type")));//交易类型
        callBack.setTransactionId(handleFormStr(params.get("transaction_id")));//微信支付订单号

        return callBack;
    }

    private String handleFormStr(String param)
    {
        return param;
    }
}

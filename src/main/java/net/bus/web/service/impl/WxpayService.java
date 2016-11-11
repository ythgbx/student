package net.bus.web.service.impl;

import net.bus.web.common.weixin.config.WeiXinConfig;
import net.bus.web.common.weixin.util.PayCommonUtil;
import net.bus.web.enums.ProducedTypeEnum;
import net.bus.web.model.Orders;
import net.bus.web.model.Pojo.WxAsyncCallBack;
import net.bus.web.model.Pojo.Product;
import net.bus.web.model.Pojo.WxOrderCallBack;
import net.bus.web.service.IProductService;
import net.bus.web.service.IWxpayService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Edifi_000 on 2016-10-19.
 */
@Service
public class WxpayService implements IWxpayService ,IPayService{

    private Logger logger = Logger.getLogger("CommonLogger");

    public String getOutTradeNo()
    {
        //TODO 生成订单编号
        return UUID.randomUUID().toString().replace("-", "");
    }

    public WxOrderCallBack prepay(Product product,String tradeNo)
    {
        Map<String,String> prepayInfo = null;
        try {
            String totalFee = Integer.valueOf((product.getPrice().multiply(BigDecimal.valueOf(100d))).intValue()).toString();//以分为计费单位
            String body = "追风巴士-"+product.getSubject();
            prepayInfo =  PayCommonUtil.getPrepayId(totalFee, "192.168.1.110",tradeNo,body,"");
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
        return getOrderCallBack(prepayInfo);
    }

    public WxAsyncCallBack async(Map<String, String> params){
        logger.info("async info print:"+params.toString());
        WxAsyncCallBack callBack = getCallBack(params);

        if(callBack.getResultCode().equals("SUCCESS")){
            SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
            //packageParams.put("attach", order.getMember().getId().toString()); //用自己系统的数据：会员id
            parameters.put("appid", WeiXinConfig.app_id);
            parameters.put("out_trade_no", callBack.getOutTradeNo());
            parameters.put("total_fee", callBack.getTotalFee()); //用自己系统的数据：订单金额
            parameters.put("bank_type", callBack.getBankType());
            parameters.put("openid", callBack.getOpenId());
            parameters.put("fee_type", callBack.getFeeType());
            parameters.put("mch_id", WeiXinConfig.MCH_ID);
            parameters.put("cash_fee", callBack.getCashFee());
            parameters.put("trade_type", callBack.getTradeType());
            parameters.put("nonce_str", callBack.getNonceStr());
            parameters.put("transaction_id",callBack.getTransactionId());
            parameters.put("is_subscribe", callBack.isSubscribe()?"Y":"N");
            parameters.put("result_code", callBack.getResultCode());
            parameters.put("time_end", callBack.getTimeEnd());
            parameters.put("return_code", callBack.getReturnCode());
            if(!StringUtils.isBlank(callBack.getSubMchId())){
                parameters.put("sub_mch_id", callBack.getSubMchId());
            }

            String sign = PayCommonUtil.createSign("UTF-8", parameters);
            logger.info("async check sign:"+sign+" callback.sign:"+callBack.getSign());
            if(callBack.getSign().equals(sign)){
                logger.info("async sign verified success:"+callBack.getOutTradeNo());
            }else{
                logger.info("async sign verified failed");
                callBack.setFailed("async sign verified failed");
            }
        }else{
            logger.info("trade not finished or success");
            callBack.setFailed("trade not finished or success");
        }

        return callBack;
    }

    public boolean refund(Orders orders,String refundTradeNo,String userId){

        try {
            String totalFee = Integer.valueOf( orders.getPay().multiply(BigDecimal.valueOf(100)).intValue()).toString();
            Map<String,String> parameters = PayCommonUtil.refundWeiXinOrder(orders.getTradeNo(),refundTradeNo,totalFee,totalFee,userId);
            if(parameters.containsKey("result_code")&&parameters.get("result_code").equals("SUCCESS")){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private WxOrderCallBack getOrderCallBack(Map<String,String> prepayInfo){

        WxOrderCallBack orderCallBack = null;
        if(prepayInfo.get("return_code").equals("SUCCESS")&&prepayInfo.containsKey("prepay_id")){
            orderCallBack = new WxOrderCallBack();
            orderCallBack.setPartnerId(prepayInfo.get("mch_id"));
            orderCallBack.setPrepayId(prepayInfo.get("prepay_id"));
            orderCallBack.setNonceStr(prepayInfo.get("nonce_str"));
            orderCallBack.setTimeStamp(Long.parseLong(prepayInfo.get("time_stamp")));
            orderCallBack.setWxPackage(prepayInfo.get("package"));
            orderCallBack.setSign(prepayInfo.get("sign"));
        }

        return orderCallBack;
    }

    private WxAsyncCallBack getCallBack(Map<String, String> params)
    {
        //获取返回数据
        WxAsyncCallBack callBack = new WxAsyncCallBack();
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
        callBack.setTotalFee(Integer.parseInt(handleFormStr(params.get("total_fee"))));//总金额
        callBack.setCashFee(Integer.parseInt(handleFormStr(params.get("cash_fee"))));//现金支付金额
        callBack.setTradeType(handleFormStr(params.get("trade_type")));//交易类型
        callBack.setTransactionId(handleFormStr(params.get("transaction_id")));//微信支付订单号

        return callBack;
    }

    private String handleFormStr(String param)
    {
        return param;
    }
}

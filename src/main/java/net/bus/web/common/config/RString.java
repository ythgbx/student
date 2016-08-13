package net.bus.web.common.config;

/**
 * Created by Edifi_000 on 2016-08-12.
 */
public class RString {

    public static String LOGIN_SUCCESS;
    public static String LOGIN_FAILED;

    public static String REGISTER_FAILED_USER_HAD;
    public static String REGISTER_FAILED_SMS_CODE;

    public static String SMS_FAILED_NO_PHONE;
    public static String SMS_FAILED_REPEAT_SEND;
    public static String SMS_FAILED_SEND;


    public static String MODIFY_PASSWORD_FAILED;
    public static String RETRIEVE_PASSWORD_FAILED;


    public void setLOGIN_SUCCESS(String LOGIN_SUCCESS) {
        RString.LOGIN_SUCCESS = LOGIN_SUCCESS;
    }

    public void setLOGIN_FAILED(String LOGIN_FAILED) {
        RString.LOGIN_FAILED = LOGIN_FAILED;
    }

    public void setREGISTER_FAILED_USER_HAD(String REGISTER_FAILED_USER_HAD) {
        RString.REGISTER_FAILED_USER_HAD = REGISTER_FAILED_USER_HAD;
    }

    public void setSMS_FAILED_NO_PHONE(String SMS_FAILED_NO_PHONE) {
        RString.SMS_FAILED_NO_PHONE = SMS_FAILED_NO_PHONE;
    }

    public void setSMS_FAILED_REPEAT_SEND(String SMS_FAILED_REPEAT_SEND) {
        RString.SMS_FAILED_REPEAT_SEND = SMS_FAILED_REPEAT_SEND;
    }

    public void setSMS_FAILED_SEND(String SMS_FAILED_SEND) {
        RString.SMS_FAILED_SEND = SMS_FAILED_SEND;
    }

    public void setREGISTER_FAILED_SMS_CODE(String REGISTER_FAILED_SMS_CODE) {
        RString.REGISTER_FAILED_SMS_CODE = REGISTER_FAILED_SMS_CODE;
    }

    public void setMODIFY_PASSWORD_FAILED(String MODIFY_PASSWORD_FAILED) {
        RString.MODIFY_PASSWORD_FAILED = MODIFY_PASSWORD_FAILED;
    }

    public void setRETRIEVE_PASSWORD_FAILED(String RETRIEVE_PASSWORD_FAILED) {
        RString.RETRIEVE_PASSWORD_FAILED = RETRIEVE_PASSWORD_FAILED;
    }
}

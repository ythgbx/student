package net.bus.web.service.exception;

/**
 * Created by sky on 16/10/24.
 */

/**
 * 重复下单异常
 */
public class RepeatApplyException extends RuntimeException {

    public RepeatApplyException(String message) {
        super(message);
    }

    public RepeatApplyException(String message,Throwable throwable){
        super(message,throwable);
    }
}

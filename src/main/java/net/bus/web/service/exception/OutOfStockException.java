package net.bus.web.service.exception;

/**
 * Created by sky on 16/10/24.
 */

/**
 * 商品已售完
 */
public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String message) {
        super(message);
    }

    public OutOfStockException(String message,Throwable throwable){
        super(message,throwable);
    }
}

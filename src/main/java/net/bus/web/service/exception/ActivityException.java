package net.bus.web.service.exception;

/**
 * Created by sky on 16/10/25.
 */
public class ActivityException extends RuntimeException {

    public ActivityException(String message) {
        super(message);
    }

    public ActivityException(String message, Throwable cause) {
        super(message, cause);
    }
}

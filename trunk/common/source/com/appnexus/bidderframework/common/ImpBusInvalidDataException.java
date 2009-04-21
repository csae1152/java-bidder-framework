package com.appnexus.bidderframework.common;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:54:02 AM
 */
public class ImpBusInvalidDataException extends Exception {

    public ImpBusInvalidDataException() {
        super();
    }

    public ImpBusInvalidDataException(String message) {
        super(message);
    }

    public ImpBusInvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImpBusInvalidDataException(Throwable cause) {
        super(cause);
    }
}

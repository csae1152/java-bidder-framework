package com.appnexus.bidderframework.common;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 11, 2009
 * Time: 4:04:33 PM
 */
public class ImpBusFormatException extends Exception {


    public ImpBusFormatException(String message) {
        super(message);
    }

    public ImpBusFormatException(String message, Exception e) {
        super(message, e);
    }
}

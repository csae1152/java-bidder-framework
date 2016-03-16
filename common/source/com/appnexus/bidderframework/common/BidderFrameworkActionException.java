package com.appnexus.bidderframework.common;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:03:49 AM
 * 
 * Extended by @author: Helmut Steiner
 */
public class BidderFrameworkActionException extends Exception {

    public BidderFrameworkActionException() {
    }

    public BidderFrameworkActionException(String deviceId) {
        super(deviceId);
    }

    public BidderFrameworkActionException(String messageId, Throwable cause) {
        super(messageId, cause);
    }

    public BidderFrameworkActionException(Throwable cause) {
        super(cause);
    }
    
    public IsoAgroBusConnectionException(Throwable cause) {
        super(message, cause);
    }
}

package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.dataobjects.BidResponse;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:15:35 PM
 */

public class BidResponseHandler extends AbstractHandler<BidResponse>{
    public void write(Writer writer) throws IOException {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {

    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }
    private static ThreadLocal<BidResponseHandler> factoryCache = new ThreadLocal<BidResponseHandler>() {
        public synchronized BidResponseHandler initialValue() {
            return new BidResponseHandler();
        }

        public synchronized BidResponseHandler get() {
            return super.get();
        }

        public synchronized void set(BidResponseHandler value) {
            super.set(value);
        }
    };

    public static BidResponseHandler get() {
        return factoryCache.get();
    }
}

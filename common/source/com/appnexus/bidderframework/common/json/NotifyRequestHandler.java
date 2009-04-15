package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.dataobjects.NotifyRequest;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:14:44 PM
 */

public class NotifyRequestHandler extends AbstractHandler<NotifyRequest>{
    public void write(Writer writer) throws IOException {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {

    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }
    private static ThreadLocal<NotifyRequestHandler> factoryCache = new ThreadLocal<NotifyRequestHandler>() {
        public synchronized NotifyRequestHandler initialValue() {
            return new NotifyRequestHandler();
        }

        public synchronized NotifyRequestHandler get() {
            return super.get();
        }

        public synchronized void set(NotifyRequestHandler value) {
            super.set(value);
        }
    };

    public static NotifyRequestHandler get() {
        return factoryCache.get();
    }
}

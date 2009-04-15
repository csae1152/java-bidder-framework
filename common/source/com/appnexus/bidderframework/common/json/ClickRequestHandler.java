package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.dataobjects.ClickRequest;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:13:23 PM
 */

public class ClickRequestHandler extends AbstractHandler<ClickRequest>{
    public void write(Writer writer) throws IOException {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {

    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }
    private static ThreadLocal<ClickRequestHandler> factoryCache = new ThreadLocal<ClickRequestHandler>() {
        public synchronized ClickRequestHandler initialValue() {
            return new ClickRequestHandler();
        }

        public synchronized ClickRequestHandler get() {
            return super.get();
        }

        public synchronized void set(ClickRequestHandler value) {
            super.set(value);
        }
    };

    public static ClickRequestHandler get() {
        return factoryCache.get();
    }
}

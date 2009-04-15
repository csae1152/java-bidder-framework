package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.PixelRequest;
import com.appnexus.bidderframework.common.ImpBusFormatException;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:11:29 PM
 */
public class PixelRequestHandler extends AbstractHandler<PixelRequest>{

    public void write(Writer writer) throws IOException {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {

    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }
    private static ThreadLocal<PixelRequestHandler> factoryCache = new ThreadLocal<PixelRequestHandler>() {
        public synchronized PixelRequestHandler initialValue() {
            return new PixelRequestHandler();
        }

        public synchronized PixelRequestHandler get() {
            return super.get();
        }

        public synchronized void set(PixelRequestHandler value) {
            super.set(value);
        }
    };

    public static PixelRequestHandler get() {
        return factoryCache.get();
    }
}

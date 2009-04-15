package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.PixelResponse;
import com.appnexus.bidderframework.common.ImpBusFormatException;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:11:29 PM
 */
public class PixelResponseHandler extends AbstractHandler<PixelResponse>{

    public void write(Writer writer) throws IOException {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {

    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }
    private static ThreadLocal<PixelResponseHandler> factoryCache = new ThreadLocal<PixelResponseHandler>() {
        public synchronized PixelResponseHandler initialValue() {
            return new PixelResponseHandler();
        }

        public synchronized PixelResponseHandler get() {
            return super.get();
        }

        public synchronized void set(PixelResponseHandler value) {
            super.set(value);
        }
    };

    public static PixelResponseHandler get() {
        return factoryCache.get();
    }
}


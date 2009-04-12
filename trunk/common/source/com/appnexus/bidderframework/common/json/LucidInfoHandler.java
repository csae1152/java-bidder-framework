package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.dataobjects.LucidInfo;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 12, 2009
 * Time: 12:35:33 AM
 */
public class LucidInfoHandler extends AbstractHandler<LucidInfo> {
    
    public void write(Writer out) throws IOException {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {

    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }

    private static ThreadLocal<LucidInfoHandler> factoryCache = new ThreadLocal<LucidInfoHandler>() {
        public synchronized LucidInfoHandler initialValue() {
            return new LucidInfoHandler();
        }

        public synchronized LucidInfoHandler get() {
            return super.get();
        }

        public synchronized void set(LucidInfoHandler value) {
            super.set(value);
        }
    };

    public static LucidInfoHandler get() {
        return factoryCache.get();
    }
}

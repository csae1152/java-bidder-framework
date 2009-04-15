package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.dataobjects.CustomMacro;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:17:26 PM
 */

public class CustomMacroHandler extends AbstractHandler<CustomMacro>{
    public void write(Writer writer) throws IOException {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {

    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }
    private static ThreadLocal<CustomMacroHandler> factoryCache = new ThreadLocal<CustomMacroHandler>() {
        public synchronized CustomMacroHandler initialValue() {
            return new CustomMacroHandler();
        }

        public synchronized CustomMacroHandler get() {
            return super.get();
        }

        public synchronized void set(CustomMacroHandler value) {
            super.set(value);
        }
    };

    public static CustomMacroHandler get() {
        return factoryCache.get();
    }
}

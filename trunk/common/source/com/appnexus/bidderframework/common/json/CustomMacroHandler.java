package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.utils.IOUtils;
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

    private CustomMacroHandler() {
    }

    public void write(Writer writer) throws IOException {
        writer.append("\"name\":\"").append(getDataObject().getName()).append("\"");
        writer.append(",").append(IOUtils.LS);
        writer.append("\"value\":\"").append(getDataObject().getValue()).append("\"");
    }

    public void startArray(String arrayName) {

    }

    public void startObject(String objectName) {

    }

    public void startObjectInArray(String arrayName) {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {
        if ("name".equals(fieldName)) {
            getDataObject().setName(value);
        } else if ("value".equals(fieldName)) {
            getDataObject().setValue(value);
        }
    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }

    public void readValue(String fieldName, boolean value) {

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

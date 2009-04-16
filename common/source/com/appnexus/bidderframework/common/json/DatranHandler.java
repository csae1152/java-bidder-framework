package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.Datran;
import com.appnexus.bidderframework.common.ImpBusFormatException;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 13, 2009
 * Time: 11:44:11 AM
 * @deprecated
 */
public class DatranHandler extends AbstractHandler<Datran> {
    public void write(Writer writer) throws IOException {
    }

    public void startArray(String arrayName) {

    }

    public void startObject(String objectName) {

    }

    public void startObjectInArray(String arrayName) {

    }

    public void readValue(String fieldName, int value) {
    }

    public void readValue(String fieldName, float value) {
    }

    public void readValue(String fieldName, boolean value) {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {
    }

    private static ThreadLocal<DatranHandler> factoryCache = new ThreadLocal<DatranHandler>() {
        public synchronized DatranHandler initialValue() {
            return new DatranHandler();
        }

        public synchronized DatranHandler get() {
            return super.get();
        }

        public synchronized void set(DatranHandler value) {
            super.set(value);
        }
    };

    public static DatranHandler get() {
        return factoryCache.get();
    }
}

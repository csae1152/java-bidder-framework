package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.Bid;

import java.io.OutputStream;
import java.io.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:26:35 PM
 */
public class BidHandler extends AbstractHandler<Bid> {
    
    public void write(Writer writer) {
        
    }

    public void startArray(String currentArrayName) {

    }

    public void startObject(String currentObjectName) {

    }

    public void readValue(String currentName, String text) {

    }

    public void startObjectInArray(String fieldName) {

    }

    public void readValue(String fieldName, int intValue) {

    }

    public void readValue(String fieldName, float floatValue) {

    }

    public void readValue(String fieldName, boolean value) {

    }

    private static ThreadLocal<BidHandler> factoryCache = new ThreadLocal<BidHandler>() {
        public synchronized BidHandler initialValue() {
            return new BidHandler();
        }

        public synchronized BidHandler get() {
            return super.get();
        }

        public synchronized void set(BidHandler value) {
            super.set(value);
        }
    };

    public static BidHandler get() {
        return factoryCache.get();
    }
}

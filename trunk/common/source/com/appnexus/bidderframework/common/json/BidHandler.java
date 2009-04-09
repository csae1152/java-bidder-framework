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
public class BidHandler implements IJSonHandler<Bid> {

    public void write(Bid dataObject, Writer writer) {

    }

    public void startArray(String currentArrayName) {

    }

    public void endArray(String currentArrayName) {

    }

    public void startObject(String currentObjectName) {

    }

    public void endObject(String currentObjectName) {

    }

    public void readValue(String currentName, String text) {

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

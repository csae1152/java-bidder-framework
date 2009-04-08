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

    public void write(Bid dataObject, Writer writer) {

    }
}

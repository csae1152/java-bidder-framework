package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.dataobjects.NotifyTag;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:15:35 PM
 */

public class NotifyTagHandler extends AbstractHandler<NotifyTag>{
    public void write(Writer writer) throws IOException {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {

    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }
    private static ThreadLocal<NotifyTagHandler> factoryCache = new ThreadLocal<NotifyTagHandler>() {
        public synchronized NotifyTagHandler initialValue() {
            return new NotifyTagHandler();
        }

        public synchronized NotifyTagHandler get() {
            return super.get();
        }

        public synchronized void set(NotifyTagHandler value) {
            super.set(value);
        }
    };

    public static NotifyTagHandler get() {
        return factoryCache.get();
    }
}


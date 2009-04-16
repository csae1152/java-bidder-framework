package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.dataobjects.Member;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 14, 2009
 * Time: 2:51:21 PM
 */
public class MemberHandler extends AbstractHandler<Member> {

    private MemberHandler() {
    }

    public void write(Writer writer) throws IOException {
        int memberID = getDataObject().getMemberID();
        writer.append("\"id:\"").append(String.valueOf(memberID));
    }

    public void startArray(String arrayName) {

    }

    public void startObject(String objectName) {

    }

    public void startObjectInArray(String arrayName) {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {

    }

    public void readValue(String fieldName, int value) {
        if ("id".equals(fieldName)) {
            getDataObject().setMemberID(value);
        }
    }

    public void readValue(String fieldName, float value) {

    }

    public void readValue(String fieldName, boolean value) {

    }

    private static ThreadLocal<MemberHandler> factoryCache = new ThreadLocal<MemberHandler>() {
        public synchronized MemberHandler initialValue() {
            return new MemberHandler();
        }

        public synchronized MemberHandler get() {
            return super.get();
        }

        public synchronized void set(MemberHandler value) {
            super.set(value);
        }
    };

    public static MemberHandler get() {
        return factoryCache.get();
    }
    
}

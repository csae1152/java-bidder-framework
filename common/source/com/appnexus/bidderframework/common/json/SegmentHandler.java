package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.Segment;
import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.utils.IOUtils;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 13, 2009
 * Time: 12:23:45 PM
 */
public class SegmentHandler extends AbstractHandler<Segment> {

    private SegmentHandler() {
    }

    public void write(Writer writer) throws IOException {
        Segment seg = getDataObject();
        writer.append("\"id\":").append(String.valueOf(seg.getSegmentID())).append(",").append(IOUtils.LS);
        writer.append("\"price\":").append(String.valueOf(seg.getPrice())).append(",").append(IOUtils.LS);
        writer.append("\"short_name\":\"").append(seg.getShortname()).append("\",").append(IOUtils.LS);
        if (seg.getMemberID() > 0) {
            writer.append("\"member_id\":").append(String.valueOf(seg.getMemberID())).append(",").append(IOUtils.LS);
        }
        if (seg.getCode() != null && seg.getCode().trim().length() != 0) {
            writer.append("\"code\":\"").append(seg.getCode()).append("\",").append(IOUtils.LS);
        }
        writer.append("\"provider\":\"").append(seg.getProvider()).append("\"").append(IOUtils.LS);
    }

    public void startArray(String arrayName) {

    }

    public void startObject(String objectName) {

    }

    public void startObjectInArray(String arrayName) {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {
        if ("short_name".equals(fieldName)) {
            getDataObject().setShortname(value);
        } else if ("code".equals(fieldName)) {
            getDataObject().setCode(value);
        } else if ("provider".equals(fieldName)) {
            getDataObject().setProvider(value);
        }
    }

    public void readValue(String fieldName, int value) {
        if ("id".equals(fieldName)) {
            getDataObject().setSegmentID(value);
        } else if ("member_id".equals(fieldName)) {
            getDataObject().setMemberID(value);
        }
    }

    public void readValue(String fieldName, float value) {
        if ("price".equals(fieldName)) {
            getDataObject().setPrice(value);
        }
    }

    public void readValue(String fieldName, boolean value) {

    }

    private static ThreadLocal<SegmentHandler> factoryCache = new ThreadLocal<SegmentHandler>() {
        public synchronized SegmentHandler initialValue() {
            return new SegmentHandler();
        }

        public synchronized SegmentHandler get() {
            return super.get();
        }

        public synchronized void set(SegmentHandler value) {
            super.set(value);
        }
    };

    public static SegmentHandler get() {
        return factoryCache.get();
    }
}

package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.utils.IOUtils;
import com.appnexus.bidderframework.common.dataobjects.NotifyRequest;
import com.appnexus.bidderframework.common.dataobjects.Bid;
import com.appnexus.bidderframework.common.dataobjects.NotifyTag;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:14:44 PM
 */

public class NotifyRequestHandler extends AbstractHandler<NotifyRequest>{

    private NotifyRequestHandler() {
        
    }

    public void write(Writer writer) throws IOException {
        writer.append("\"timestamp\":\"").append(IOUtils.getFormattedDate(getDataObject().getTimestamp())).append("\"");
        writer.append(",").append(IOUtils.LS);
        writer.append("\"fail\":").append(String.valueOf(getDataObject().isFail()));
        if (getDataObject().getError() != null && getDataObject().getError().trim().length() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"error\":\"").append(getDataObject().getError()).append("\"");
        }
        writer.append(",").append(IOUtils.LS);
        writer.append("\"response_time_ms\":").append(String.valueOf(getDataObject().getResponseTime()));
        if (getDataObject().getBid() != null && getDataObject().getBid().getUserID() != null && getDataObject().getBid().getUserID().trim().length() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"bid_info \"{:").append(IOUtils.LS);
            BidHandler bh = BidHandler.get();
            bh.setDataObject(getDataObject().getBid());
            bh.write(writer);
            writer.append("}");
        }
        writer.append(",").append(IOUtils.LS);
        writer.append("\"tags \"[:").append(IOUtils.LS);
        for (int i = 0; i < getDataObject().getNotifyTags().size(); i++) {
            if (i > 0) {
                writer.append(",").append(IOUtils.LS);
            }
            writer.append("{");
            NotifyTag nt = getDataObject().getNotifyTags().get(i);
            NotifyTagHandler nth = NotifyTagHandler.get();
            nth.setDataObject(nt);
            nth.write(writer);
            writer.append("}");
        }
        writer.append("]");
    }

    public void startArray(String arrayName) {
        if ("tags".equals(arrayName)) {
            getDataObject().setNotifyTags(new ArrayList<NotifyTag>());
        }
    }

    public void startObject(String objectName) {
        if ("bid_info".equals(objectName)) {
            transferControlToNested(this, BidHandler.get(), new Bid());
        }
    }

    public void startObjectInArray(String arrayName) {
        if ("tags".equals(arrayName)) {
            NotifyTag tag = new NotifyTag();
            getDataObject().getNotifyTags().add(tag);
            transferControlToNested(this, NotifyTagHandler.get(), tag);
        }
    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {
        if ("timestamp".equals(fieldName)) {
            try {
                getDataObject().setTimestamp(IOUtils.parseDate(value));
            } catch (ParseException e) {
                throw new ImpBusFormatException("Couldn't parse the Notify Request: " +
                        "the timestamp field was incorrectly formatted msg:" + e.getMessage(), e);
            }
        } else if ("error".equals(fieldName)) {
            getDataObject().setError(value);
        }
    }

    public void readValue(String fieldName, int value) {
        if ("response_time_ms".equals(fieldName)) {
            getDataObject().setResponseTime(value);
        }
    }

    public void readValue(String fieldName, float value) {

    }

    public void readValue(String fieldName, boolean value) {
        if ("fail".equals(fieldName)) {
            getDataObject().setFail(value);
        }
    }

    @Override
    public void endArray(String currentArrayName) {
    }

    @Override
    public void endObject(String currentObjectName) {
    }

    private static ThreadLocal<NotifyRequestHandler> factoryCache = new ThreadLocal<NotifyRequestHandler>() {
        public synchronized NotifyRequestHandler initialValue() {
            return new NotifyRequestHandler();
        }

        public synchronized NotifyRequestHandler get() {
            return super.get();
        }

        public synchronized void set(NotifyRequestHandler value) {
            super.set(value);
        }
    };

    public static NotifyRequestHandler get() {
        return factoryCache.get();
    }
}

package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.utils.IOUtils;
import com.appnexus.bidderframework.common.dataobjects.ClickRequest;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:13:23 PM
 */

public class ClickRequestHandler extends AbstractHandler<ClickRequest>{

    private ClickRequestHandler() {
    }

    public void write(Writer writer) throws IOException {
        writer.append("\"timestamp\":\"").append(IOUtils.getFormattedDate(getDataObject().getTimestamp())).append("\"");
        writer.append(",").append(IOUtils.LS);
        writer.append("\"auction_id\":\"").append(getDataObject().getAuctionID()).append("\"");
        writer.append(",").append(IOUtils.LS);
        writer.append("\"member_id\":").append(String.valueOf(getDataObject().getMemberID()));
        writer.append(",").append(IOUtils.LS);
        writer.append("\"user_id\":\"").append(getDataObject().getUserID()).append("\"");
        if (getDataObject().getReferrerURL() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"referrer_url\":\"").append(IOUtils.encodeEscapeChars(getDataObject().getReferrerURL())).append("\"");
        }
        if (getDataObject().getUserAgent() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"user_agent\":\"").append(IOUtils.encodeEscapeChars(getDataObject().getUserAgent())).append("\"");
        }
        if (getDataObject().getUserData() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"user_data\":\"").append(getDataObject().getUserData()).append("\"");
        }
        if (getDataObject().getUserDataJson() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"user_data_json\":\"").append(getDataObject().getUserDataJson()).append("\"");
        }
        if (getDataObject().getCustomNotifyData() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"custom_notify_data\":\"").append(IOUtils.encodeEscapeChars(getDataObject().getCustomNotifyData())).append("\"");
        }
    }

    public void startArray(String arrayName) {

    }

    public void startObject(String objectName) {

    }

    public void startObjectInArray(String arrayName) {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {
        if ("timestamp".equals(fieldName)) {
            try {
                getDataObject().setTimestamp(IOUtils.parseDate(value));
            } catch (Exception e) {
                throw new ImpBusFormatException("The timestamp in the ClickRequestHandler was not formatted in the yyyy-MM-dd HH:mm:ss format");
            }
        } else if ("auction_id".equals(fieldName)) {
            getDataObject().setAuctionID(value);
        } else if ("user_id".equals(fieldName)) {
            getDataObject().setUserID(value);
        } else if ("referrer_url".equals(fieldName)) {
            getDataObject().setReferrerURL(value);
        } else if ("user_agent".equals(fieldName)) {
            getDataObject().setUserAgent(value);
        } else if ("user_data".equals(fieldName)) {
            getDataObject().setUserData(value);
        } else if ("user_data_json".equals(fieldName)) {
            getDataObject().setUserDataJson(value);
        } else if ("custom_notify_data".equals(fieldName)) {
            getDataObject().setCustomNotifyData(value);
        }
    }

    public void readValue(String fieldName, int value) {
        if ("member_id".equals(fieldName)) {
            getDataObject().setMemberID(value);
        }
    }

    public void readValue(String fieldName, float value) {

    }

    public void readValue(String fieldName, boolean value) {

    }

    private static ThreadLocal<ClickRequestHandler> factoryCache = new ThreadLocal<ClickRequestHandler>() {
        public synchronized ClickRequestHandler initialValue() {
            return new ClickRequestHandler();
        }

        public synchronized ClickRequestHandler get() {
            return super.get();
        }

        public synchronized void set(ClickRequestHandler value) {
            super.set(value);
        }
    };

    public static ClickRequestHandler get() {
        return factoryCache.get();
    }
}

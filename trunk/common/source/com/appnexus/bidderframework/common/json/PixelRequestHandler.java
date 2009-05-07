package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.PixelRequest;
import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.utils.IOUtils;

import java.io.Writer;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:11:29 PM
 */
public class PixelRequestHandler extends AbstractHandler<PixelRequest>{

    private PixelRequestHandler() {
    }

    public void write(Writer writer) throws IOException {
        writer.append("\"timestamp\":\"").append(IOUtils.getFormattedDate(getDataObject().getTimestamp())).append("\"");
        writer.append(",").append(IOUtils.LS);
        writer.append("\"user_id\":\"").append(getDataObject().getUserID()).append("\"");
        if (getDataObject().getUserData() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"user_data\":\"").append(getDataObject().getUserData()).append("\"");
        }
        if (getDataObject().getQueryString() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"query_string\":\"").append(IOUtils.encodeEscapeChars(getDataObject().getQueryString())).append("\"");
        }
        if (getDataObject().getMemberID() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"member_id\":").append(String.valueOf(getDataObject().getMemberID()));
        }
        if (getDataObject().getPixelID() != 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"pixel_id\":").append(String.valueOf(getDataObject().getPixelID()));
        }
        if (getDataObject().getIpAddress() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"ip_address\":\"").append(getDataObject().getIpAddress()).append("\"");
        }
        if (getDataObject().getUserAgent() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"user_agent\":\"").append(IOUtils.encodeEscapeChars(getDataObject().getUserAgent())).append("\"");
        }
        if (getDataObject().getRedirectURL() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"redirect_url\":\"").append(IOUtils.encodeEscapeChars(getDataObject().getRedirectURL())).append("\"");
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
            } catch (ParseException e) {
                throw new ImpBusFormatException("The timestamp value=[" + value + "] could not be parsed because: msg=[" + e.getMessage(), e);
            }
        } else if ("user_id".equals(fieldName)) {
            getDataObject().setUserID(value);
        } else if ("user_data".equals(fieldName)) {
            getDataObject().setUserData(value);
        } else if ("query_string".equals(fieldName)) {
            getDataObject().setQueryString(value);
        } else if ("ip_address".equals(fieldName)) {
            getDataObject().setIpAddress(value);
        } else if ("user_agent".equals(fieldName)) {
            getDataObject().setUserAgent(value);
        } else if ("redirect_url".equals(fieldName)) {
            getDataObject().setRedirectURL(value);
        }

    }

    public void readValue(String fieldName, int value) {
        if ("member_id".equals(fieldName)) {
            getDataObject().setMemberID(value);
        } else if ("pixel_id".equals(fieldName)) {
            getDataObject().setPixelID(value);
        }
    }

    public void readValue(String fieldName, float value) {

    }

    public void readValue(String fieldName, boolean value) {

    }


    @Override
    public void endArray(String currentArrayName) {
    }

    @Override
    public void endObject(String currentObjectName) {
    }
    private static ThreadLocal<PixelRequestHandler> factoryCache = new ThreadLocal<PixelRequestHandler>() {
        public synchronized PixelRequestHandler initialValue() {
            return new PixelRequestHandler();
        }

        public synchronized PixelRequestHandler get() {
            return super.get();
        }

        public synchronized void set(PixelRequestHandler value) {
            super.set(value);
        }
    };

    public static PixelRequestHandler get() {
        return factoryCache.get();
    }
}

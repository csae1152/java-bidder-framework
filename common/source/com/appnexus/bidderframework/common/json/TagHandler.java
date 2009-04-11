package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.Tag;
import com.appnexus.bidderframework.common.utils.IOUtils;
import com.appnexus.bidderframework.common.ImpBusFormatException;

import java.io.Writer;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonLocation;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:49:17 PM
 */
public class TagHandler extends AbstractHandler<Tag> {


    public void write(Writer writer) throws IOException {
        writer.append("\"id\":").append(String.valueOf(getDataObject().getTagID())).append(",").append(IOUtils.LS);
        writer.append("\"auction_id\":\"").append(getDataObject().getAuctionID()).append("\",").append(IOUtils.LS);
        writer.append("\"size\":\"").append(String.valueOf(getDataObject().getWidth())).append('x').append(String.valueOf(getDataObject().getHeight())).append("\"").append(IOUtils.LS);
    }

    public void readValue(String fieldName, int intValue) {
        if ("id".equals(fieldName)) {
            getDataObject().setTagID(intValue);
        }
    }

    public void readValue(String fieldName, float floatValue) {

    }

    public void readValue(String fieldName, boolean value) {

    }

    public void readValue(String fieldName, String text) throws ImpBusFormatException {
        if ("auction_id".equals(fieldName)) {
            getDataObject().setAuctionID(text);
        } else if ("size".equals(fieldName)) {
            int c = text.indexOf('x');
            if (c == -1) {
                throw new ImpBusFormatException("The Json size for TAG must be expressed as <integer>x<integer>");
            }
            try {
                getDataObject().setWidth(Integer.parseInt(text.substring(0, c)));
                getDataObject().setHeight(Integer.parseInt(text.substring(c + 1)));
            } catch (NumberFormatException e) {
                throw new ImpBusFormatException("The Json size for TAG must be expressed as <integer>x<integer>", e);
            }
        }
    }

    public void startArray(String currentArrayName) {

    }

    public void startObject(String currentObjectName) {

    }


    public void startObjectInArray(String fieldName) {

    }

    private static ThreadLocal<TagHandler> factoryCache = new ThreadLocal<TagHandler>() {
        public synchronized TagHandler initialValue() {
            return new TagHandler();
        }

        public synchronized TagHandler get() {
            return super.get();
        }

        public synchronized void set(TagHandler value) {
            super.set(value);
        }
    };

    public static TagHandler get() {
        return factoryCache.get();
    }
}

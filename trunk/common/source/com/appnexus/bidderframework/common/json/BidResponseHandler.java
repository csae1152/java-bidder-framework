package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.utils.IOUtils;
import com.appnexus.bidderframework.common.dataobjects.BidResponse;
import com.appnexus.bidderframework.common.dataobjects.TagResponse;

import java.io.Writer;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:15:35 PM
 */

public class BidResponseHandler extends AbstractHandler<BidResponse>{

    private BidResponseHandler() {
    }
    
    public void write(Writer writer) throws IOException {
        BidResponse br = getDataObject();
        if (br.getDebugText() != null) {
            writer.append("\"debug_text\":\"").append(br.getDebugText()).append("\"");
        }
        writer.append(",").append(IOUtils.LS);
        writer.append("\"no_notify\":").append(String.valueOf(br.getDebugText()));
        writer.append(",").append(IOUtils.LS);
        writer.append("\"user_id_unknown\":").append(String.valueOf(br.isUserIDUnknown()));
        writer.append("\"responses\":[").append(IOUtils.LS);
        for (int i = 0; i < br.getBidResponseItems().size(); i++) {
            if (i > 0) {
                writer.append(",").append(IOUtils.LS);
            }
            writer.append("{").append(IOUtils.LS);
            TagResponse item = br.getBidResponseItems().get(i);
            TagResponseHandler trh = TagResponseHandler.get();
            trh.setDataObject(item);
            trh.write(writer);
            writer.append("}").append(IOUtils.LS);
        }
        writer.append("]");
    }

    public void startArray(String arrayName) {
        if ("responses".equals(arrayName)) {
            getDataObject().setBidResponseItems(new ArrayList<TagResponse>());
        }
    }

    public void startObject(String objectName) {

    }

    public void startObjectInArray(String arrayName) {
        if ("responses".equals(arrayName)) {
            TagResponse tagResponse = new TagResponse();
            getDataObject().getBidResponseItems().add(tagResponse);
            transferControlToNested(this, TagResponseHandler.get(), tagResponse);
        }
    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {
        if ("debug_text".equals(fieldName)) {
            getDataObject().setDebugText(value);
        }
    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }

    public void readValue(String fieldName, boolean value) {
        if ("no_notify".equals(fieldName)) {
            getDataObject().setNoNotify(value);
        } else if ("user_id_unknown".equals(fieldName)) {
            getDataObject().setUserIDUnknown(value);
        }
    }

    private static ThreadLocal<BidResponseHandler> factoryCache = new ThreadLocal<BidResponseHandler>() {
        public synchronized BidResponseHandler initialValue() {
            return new BidResponseHandler();
        }

        public synchronized BidResponseHandler get() {
            return super.get();
        }

        public synchronized void set(BidResponseHandler value) {
            super.set(value);
        }
    };

    public static BidResponseHandler get() {
        return factoryCache.get();
    }
}

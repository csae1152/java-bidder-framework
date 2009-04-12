package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.dataobjects.Tag;
import com.appnexus.bidderframework.common.dataobjects.Bid;
import com.appnexus.bidderframework.common.utils.IOUtils;

import java.io.Writer;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:16:19 PM
 *
 * This is the top level class which handles serialization of JSON Objects
 */
public class BidRequestHandler extends AbstractHandler<BidRequest> {
    
    public void write(Writer writer) throws IOException {
        boolean commaNeeded = false;

        writer.append("{").append(IOUtils.LS);
        if (getDataObject().getBid() != null) {
            writer.append("\"bid_info\": {").append(IOUtils.LS);
            BidHandler bh = BidHandler.get();
            bh.setDataObject(getDataObject().getBid());
            bh.write(writer);
            writer.append("}").append(IOUtils.LS);
            commaNeeded = true;
        }

        if (getDataObject().getTags() != null && getDataObject().getTags().size() > 0) {
            if (commaNeeded) {
                writer.append(",");
            }
            writer.append("\"tags\": [").append(IOUtils.LS);
            TagHandler th = TagHandler.get();
            List<Tag> tags = getDataObject().getTags();
            for (int i = 0; i < tags.size(); i++) {
                if (i > 0) {
                    writer.append(',').append(IOUtils.LS);
                }
                th.setDataObject(tags.get(i));
                writer.append('{');
                th.write(writer);
                writer.append('}');
            }
            writer.append("]").append(IOUtils.LS);
            commaNeeded = true;
        }
        if (commaNeeded) {
            writer.append(",");
        }
        writer.append("\"allow_exclusive\":").append(String.valueOf(getDataObject().isAllowExclusive())).append(",").append(IOUtils.LS);
        writer.append("\"debug_requested\":").append(String.valueOf(getDataObject().isDebugRequested())).append(IOUtils.LS);

        writer.append("}").append(IOUtils.LS);
    }

    public void startArray(String arrayName) {
        if ("tags".equals(arrayName)) {
            System.out.println("Bid Request Handler: starting tags");
            getDataObject().setTags(new ArrayList <Tag>());
        }
    }

    public void startObject(String objectName) {
        if ("bid_info".equals(objectName)) {
            transferControlToNested(this, BidHandler.get(), new Bid());
        }
    }
    
    public void readValue(String fieldName, float value) {
    }

    public void readValue(String fieldName, String value) {
    }

    public void readValue(String fieldName, int value) {
    }

    public void readValue(String fieldName, boolean value) {
        if ("allow_exclusive".equals(fieldName)) {
            getDataObject().setAllowExclusive(value);
        } else if ("debug_requested".equals(fieldName)) {
            getDataObject().setDebugRequested(value);
        }
    }

    public void startObjectInArray(String arrayName) {
        if ("tags".equals(arrayName)) {
            Tag tag = new Tag();
            getDataObject().getTags().add(tag);
            transferControlToNested(this, TagHandler.get(), tag);
        }
    }

    private static ThreadLocal<BidRequestHandler> factoryCache = new ThreadLocal<BidRequestHandler>() {
        public synchronized BidRequestHandler initialValue() {
            return new BidRequestHandler();
        }

        public synchronized BidRequestHandler get() {
            return super.get();
        }

        public synchronized void set(BidRequestHandler value) {
            super.set(value);
        }
    };

    public static BidRequestHandler get() {
        return factoryCache.get();
    }
}

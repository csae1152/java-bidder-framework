package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.utils.IOUtils;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:16:19 PM
 *
 * This is the top level class which handles serialization of JSON Objects
 */
public class BidRequestHandler implements IJSonHandler<BidRequest> {

    public void write(BidRequest dataObject, Writer writer) throws IOException {
        writer.append("\"allow_exclusive\":").append(dataObject.isAllowExclusive() ? "true" : "false").append(",").append(IOUtils.LS);
        writer.append("\"debug_requested\":").append(dataObject.isDebugRequested() ? "true" : "false").append(",").append(IOUtils.LS);

        if (dataObject.getBid() != null) {
            writer.append("\"bid_info\": {").append(IOUtils.LS);
            BidHandler bh = BidHandler.get();
            bh.write(dataObject.getBid(), writer);
            writer.append("}").append(IOUtils.LS);
        }

        if (dataObject.getTags() != null && dataObject.getTags().size() > 0) {
            writer.append("\"tags\": [").append(IOUtils.LS);
            TagHandler th = TagHandler.get();
            for (int i = 0; i < dataObject.getTags().size(); i++) {
                if (i > 0) {
                    writer.append(',').append(IOUtils.LS);
                }
                writer.append('{');
                th.write(dataObject.getTags().get(i), writer);
                writer.append('}');
            }
            writer.append("]").append(IOUtils.LS);
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

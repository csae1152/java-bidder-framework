package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.Tag;
import com.appnexus.bidderframework.common.utils.IOUtils;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:49:17 PM
 */
public class TagHandler implements IJSonHandler<Tag> {
    public void write(Tag dataObject, Writer writer) throws IOException {
        writer.append("\"id\":").append(String.valueOf(dataObject.getTagID())).append(",").append(IOUtils.LS);
        writer.append("\"auction_id\":").append(String.valueOf(dataObject.getAuctionID())).append(",").append(IOUtils.LS);
        writer.append("\"size\":").append(String.valueOf(dataObject.getWidth())).append('x').append(String.valueOf(dataObject.getHeight())).append(",").append(IOUtils.LS);
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

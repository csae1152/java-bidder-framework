package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.utils.IOUtils;
import com.appnexus.bidderframework.common.dataobjects.LucidData;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 12, 2009
 * Time: 12:35:33 AM
 */
public class LucidDataHandler extends AbstractHandler<LucidData> {

    private LucidDataHandler() {
    }

    public void write(Writer writer) throws IOException {
        LucidData ld = getDataObject();
        writer.append("\"categories\":[").append(IOUtils.LS);
        long[] dc = ld.getDc();
        String[] categories = ld.getCategories();
        for (int i = 0; i <= ld.getLucidLevel(); i++) {
            if (dc[i] <= 0) {
                break; // no more subcategories
            }
            if (i > 0) {
                writer.append(",").append(IOUtils.LS);
            }
            writer.append("{").append(IOUtils.LS);
            writer.append("\"level\": ").append(String.valueOf(i)).append(",").append(IOUtils.LS);
            writer.append("\"id\":").append(String.valueOf(dc[i])).append(",").append(IOUtils.LS);
            writer.append("\"name\":\"").append(categories[i]).append("\"").append(IOUtils.LS);
            writer.append("}").append(IOUtils.LS);
        }
        writer.append("]").append(IOUtils.LS);
    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {

    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }

    private static ThreadLocal<LucidDataHandler> factoryCache = new ThreadLocal<LucidDataHandler>() {
        public synchronized LucidDataHandler initialValue() {
            return new LucidDataHandler();
        }

        public synchronized LucidDataHandler get() {
            return super.get();
        }

        public synchronized void set(LucidDataHandler value) {
            super.set(value);
        }
    };

    public static LucidDataHandler get() {
        return factoryCache.get();
    }
}

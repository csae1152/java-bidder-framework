package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.LucidLevelData;
import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.utils.IOUtils;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 5:27:35 PM
 */
public class LucidLevelDataHandler extends AbstractHandler<LucidLevelData> {

    private LucidLevelDataHandler() {
    }

    public void write(Writer writer) throws IOException {
        writer.append("\"level\": ").append(String.valueOf(getDataObject().getLevel())).append(",").append(IOUtils.LS);
        writer.append("\"id\":").append(String.valueOf(getDataObject().getDc())).append(",").append(IOUtils.LS);
        writer.append("\"name\":\"").append(getDataObject().getCategory()).append("\"").append(IOUtils.LS);
    }

    public void startArray(String arrayName) {

    }

    public void startObject(String objectName) {

    }

    public void startObjectInArray(String arrayName) {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {
        if ("name".equals(fieldName)) {
            getDataObject().setCategory(value);
        }
    }

    public void readValue(String fieldName, int value) {
        if ("level".equals(fieldName)) {
            getDataObject().setLevel(value);
        } else if ("id".equals(fieldName)) {
            getDataObject().setDc(value);
        }
    }

    public void readValue(String fieldName, float value) {

    }

    public void readValue(String fieldName, boolean value) {

    }

    private static ThreadLocal<LucidLevelDataHandler> factoryCache = new ThreadLocal<LucidLevelDataHandler>() {
        public synchronized LucidLevelDataHandler initialValue() {
            return new LucidLevelDataHandler();
        }

        public synchronized LucidLevelDataHandler get() {
            return super.get();
        }

        public synchronized void set(LucidLevelDataHandler value) {
            super.set(value);
        }
    };

    public static LucidLevelDataHandler get() {
        return factoryCache.get();
    }
}

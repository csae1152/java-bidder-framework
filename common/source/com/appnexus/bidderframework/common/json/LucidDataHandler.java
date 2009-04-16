package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.utils.IOUtils;
import com.appnexus.bidderframework.common.dataobjects.LucidData;
import com.appnexus.bidderframework.common.dataobjects.LucidLevelData;

import java.io.Writer;
import java.io.IOException;
import java.util.ArrayList;

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
        for (int i = 0; i <= ld.getLucidLevels().size(); i++) {
            LucidLevelData data = ld.getLucidLevels().get(i);
            if (data.getDc() <= 0) {
                break; // no more subcategories
            }
            if (i > 0) {
                writer.append(",").append(IOUtils.LS);
            }
            writer.append("{").append(IOUtils.LS);
            LucidLevelDataHandler lldh = LucidLevelDataHandler.get();
            lldh.setDataObject(data);
            lldh.write(writer);
            writer.append("}").append(IOUtils.LS);
        }
        writer.append("]").append(IOUtils.LS);
    }

    public void startArray(String arrayName) {
        if ("categories".equals(arrayName)) {
            getDataObject().setLucidLevels(new ArrayList<LucidLevelData>());
        }
    }
    
    public void startObjectInArray(String arrayName) {
        if ("categories".equals(arrayName)) {
            LucidLevelData data = new LucidLevelData();
            getDataObject().getLucidLevels().add(data);
            transferControlToNested(this, LucidLevelDataHandler.get(), data);
        }
    }


    public void readValue(String fieldName, int value) {
        if ("level".equals(fieldName)) {
            getDataObject().setLucidLevel(value);
        }
    }


    @Override
    public void endObject(String objectName) {
        if (!"categories".equals(objectName)) {
            super.endObject(objectName);
        }
    }

    @Override
    public void endArray(String arrayName) {
        if (!"categories".equals(arrayName)) {
            super.endArray(arrayName);
        }
    }

    public void startObject(String objectName) {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {

    }

    public void readValue(String fieldName, float value) {

    }

    public void readValue(String fieldName, boolean value) {

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

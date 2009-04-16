package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.PixelResponse;
import com.appnexus.bidderframework.common.dataobjects.Segment;
import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.utils.IOUtils;

import java.io.Writer;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:11:29 PM
 */
public class PixelResponseHandler extends AbstractHandler<PixelResponse>{

    private PixelResponseHandler() {
    }

    /**
     * This is a tricky one... Please read...
     *
     * All fields here are optional, so for that reason we use the new java feature called "boolean" and assign
     * true or false to a variable named "useComma"...
     * @param writer
     * @throws IOException
     */
    public void write(Writer writer) throws IOException {
        boolean useComma = false;
        if (getDataObject().getUserData() != null) {
            useComma = true;
            writer.append("\"userdata\":").append(getDataObject().getUserData()).append("\"");
        }
        if (getDataObject().getUserDataJS() != null) {
            if (useComma) {
                writer.append(",").append(IOUtils.LS);
            }
            useComma = true;
            writer.append("\"userdata_js\":").append(getDataObject().getUserData()).append("\"");
        }
        if (getDataObject().getRedirectURL() != null) {
            if (useComma) {
                writer.append(",").append(IOUtils.LS);
            }
            useComma = true;
            writer.append("\"redirect_url\":").append(getDataObject().getRedirectURL()).append("\"");
        }
        if (getDataObject().getSegmentsAdd().size() > 0) {
            if (useComma) {
                writer.append(",").append(IOUtils.LS);
            }
            useComma = true;
            writer.append("\"segments_add\":[").append(IOUtils.LS);
            for (int i = 0; i < getDataObject().getSegmentsAdd().size(); i++) {
                if (i > 0) {
                    writer.append(",").append(IOUtils.LS);
                }
                writer.append("{").append(IOUtils.LS);
                SegmentHandler sh = SegmentHandler.get();
                sh.setDataObject(getDataObject().getSegmentsAdd().get(i));
                sh.write(writer);
                writer.append("}").append(IOUtils.LS);
            }
            writer.append("]").append(IOUtils.LS);
        }
        if (getDataObject().getSegmentsRemove().size() > 0) {
            if (useComma) {
                writer.append(",").append(IOUtils.LS);
            }
            writer.append("\"segments_remove\":[").append(IOUtils.LS);
            for (int i = 0; i < getDataObject().getSegmentsRemove().size(); i++) {
                if (i > 0) {
                    writer.append(",").append(IOUtils.LS);
                }
                writer.append("{").append(IOUtils.LS);
                SegmentHandler sh = SegmentHandler.get();
                sh.setDataObject(getDataObject().getSegmentsRemove().get(i));
                sh.write(writer);
                writer.append("}").append(IOUtils.LS);
            }
            writer.append("]").append(IOUtils.LS);
        }
    }

    public void startArray(String arrayName) {
        if ("segments_add".equals(arrayName)) {
            getDataObject().setSegmentsAdd(new ArrayList<Segment>());
        } else if ("segments_remove".equals(arrayName)) {
            getDataObject().setSegmentsRemove(new ArrayList<Segment>());
        }
    }

    public void startObject(String objectName) {

    }

    public void startObjectInArray(String arrayName) {
        if ("segments_add".equals(arrayName)) {
            Segment segment = new Segment();
            getDataObject().getSegmentsAdd().add(segment);
            transferControlToNested(this, SegmentHandler.get(), segment);
        } else if ("segments_remove".equals(arrayName)) {
            Segment segment = new Segment();
            getDataObject().getSegmentsRemove().add(segment);
            transferControlToNested(this, SegmentHandler.get(), segment);
        }
    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {
        if ("userdata".equals(fieldName)) {
            getDataObject().setUserData(value);
        } else if ("userdata_js".equals(fieldName)) {
            getDataObject().setUserDataJS(value);
        } else if ("redirect_url".equals(fieldName)) {
            getDataObject().setRedirectURL(value);
        }
    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }

    public void readValue(String fieldName, boolean value) {

    }

    private static ThreadLocal<PixelResponseHandler> factoryCache = new ThreadLocal<PixelResponseHandler>() {
        public synchronized PixelResponseHandler initialValue() {
            return new PixelResponseHandler();
        }

        public synchronized PixelResponseHandler get() {
            return super.get();
        }

        public synchronized void set(PixelResponseHandler value) {
            super.set(value);
        }
    };

    public static PixelResponseHandler get() {
        return factoryCache.get();
    }
}


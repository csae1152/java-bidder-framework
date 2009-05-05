package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.ImpBusInvalidDataException;
import com.appnexus.bidderframework.common.utils.IOUtils;
import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.dataobjects.BidResponse;
import com.appnexus.bidderframework.common.dataobjects.ClickRequest;
import com.appnexus.bidderframework.common.dataobjects.NotifyRequest;
import com.appnexus.bidderframework.common.dataobjects.PixelRequest;
import com.appnexus.bidderframework.common.dataobjects.PixelResponse;

import java.io.Writer;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:32:17 AM
 */
public class RootHandler extends AbstractHandler {

    private static final Logger LOG = Logger.getLogger(RootHandler.class);

    private RootHandler() {
    }

    @SuppressWarnings({"unchecked"})
    public void write(Writer writer) throws IOException, ImpBusInvalidDataException {
        Object root = getDataObject();
        String name;
        AbstractHandler ah;
        if (root == null) {
            throw new ImpBusInvalidDataException("The data object is null. It can't be null.");
        }
        if (root instanceof BidRequest) {
            name = "bid_request: {";
            ah = BidRequestHandler.get();
            ah.setDataObject(root);
        } else if (root instanceof BidResponse) {
            name = "bid_response: {";
            ah = BidResponseHandler.get();
            ah.setDataObject(root);
        } else if (root instanceof ClickRequest) {
            name = "click_request: {";
            ah = ClickRequestHandler.get();
            ah.setDataObject(root);
        } else if (root instanceof NotifyRequest) {
            name = "notify_request: {";
            ah = NotifyRequestHandler.get();
            ah.setDataObject(root);
        } else if (root instanceof PixelRequest) {
            name = "pixel_request: {";
            ah = PixelRequestHandler.get();
            ah.setDataObject(root);
        } else if (root instanceof PixelResponse) {
            name = "pixel_response: {";
            ah = PixelResponseHandler.get();
            ah.setDataObject(root);
        } else {
            throw new ImpBusInvalidDataException("The data object of type=" + root.getClass() + " is not supported.");
        }
        writer.append(name).append(IOUtils.LS);
        ah.write(writer);
        writer.append("}");
    }

    public void startArray(String arrayName) {

    }

    @SuppressWarnings({"unchecked"})
    public void startObject(String objectName) {
        if ("bid_request".equals(objectName)) {
            LOG.info("Starting bid_request");
            setDataObject(new BidRequest());
            transferControlToNested(this, BidRequestHandler.get(), getDataObject());
        } else if ("bid_response".equals(objectName)) {
            setDataObject(new BidResponse());
            transferControlToNested(this, BidResponseHandler.get(), getDataObject());
        } else if ("click_request".equals(objectName)) {
            LOG.info("Starting click_request");
            setDataObject(new ClickRequest());
            transferControlToNested(this, ClickRequestHandler.get(), getDataObject());
        } else if ("notify_request".equals(objectName)) {
            LOG.info("Starting notify_request");
            setDataObject(new NotifyRequest());
            transferControlToNested(this, NotifyRequestHandler.get(), getDataObject());
        } else if ("pixel_request".equals(objectName)) {
            LOG.info("Starting pixel_request");
            setDataObject(new PixelRequest());
            transferControlToNested(this, PixelRequestHandler.get(), getDataObject());
        } else if ("pixel_response".equals(objectName)) {
            setDataObject(new PixelResponse());
            transferControlToNested(this, PixelResponseHandler.get(), getDataObject());
        }
    }

    public void startObjectInArray(String arrayName) {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {

    }

    public void readValue(String fieldName, int value) {

    }

    public void readValue(String fieldName, float value) {

    }

    public void readValue(String fieldName, boolean value) {

    }

    private static ThreadLocal<RootHandler> factoryCache = new ThreadLocal<RootHandler>() {
        public synchronized RootHandler initialValue() {
            return new RootHandler();
        }

        public synchronized RootHandler get() {
            return super.get();
        }

        public synchronized void set(RootHandler value) {
            super.set(value);
        }
    };

    public static RootHandler get() {
        return factoryCache.get();
    }
}

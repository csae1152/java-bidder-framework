/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:28:48 AM
 * 
 * @updated by @author Helmut Steiner
 * 
 */
package com.appnexus.bidderframework.common.runtime.framework;

import com.appnexus.bidderframework.common.json.JSonStAXReaderParserFactory;
import com.appnexus.bidderframework.common.json.RootHandler;
import com.appnexus.bidderframework.common.json.JSonStAXReader;
import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.BidderFrameworkActionException;
import com.appnexus.bidderframework.common.ImpBusInvalidDataException;
import com.appnexus.bidderframework.common.runtime.actions.IBidRequestAction;
import com.appnexus.bidderframework.common.runtime.actions.IBidResponseAction;
import com.appnexus.bidderframework.common.runtime.actions.IClickRequestAction;
import com.appnexus.bidderframework.common.runtime.actions.INotifyRequestAction;
import com.appnexus.bidderframework.common.runtime.actions.IPixelRequestAction;
import com.appnexus.bidderframework.common.runtime.actions.IPixelResponseAction;
import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.dataobjects.PixelResponse;
import com.appnexus.bidderframework.common.dataobjects.PixelRequest;
import com.appnexus.bidderframework.common.dataobjects.NotifyRequest;
import com.appnexus.bidderframework.common.dataobjects.ClickRequest;
import com.appnexus.bidderframework.common.dataobjects.BidResponse;

import java.io.InputStream;
import java.io.Writer;
import java.io.IOException;

import org.apache.log4j.Logger;

public class ActionRouter {
    private static final Logger LOG = Logger.getLogger(ActionRouter.class);
    private static final ActionRouter INSTANCE = new ActionRouter();
    
    private ActionRouter() {
    }

    public static ActionRouter getInstance() {
        return INSTANCE;
    }

    @SuppressWarnings({"unchecked"})
    public void routeHttpRequestToAction(InputStream inputStream, Writer writer) throws IOException, ImpBusFormatException,
            BidderFrameworkActionException, ImpBusInvalidDataException {
        JSonStAXReaderParserFactory factory = new JSonStAXReaderParserFactory();
        RootHandler handler = RootHandler.get();
        JSonStAXReader reader = factory.createReader(inputStream, handler);
        handler.setReader(reader);
        reader.parse();
        Object requestData = handler.getDataObject();
        if (requestData instanceof BidRequest) {
            IBidRequestAction action = ActionManager.getInstance().getBidRequestAction();
            LOG.info("routing bid_request to action-handler=[" + action.getClass() + "]");
            BidResponse responseData = action.handleBidRequest((BidRequest) requestData);
            handler.setDataObject(responseData);
            handler.write(writer);
        } else if (requestData instanceof BidResponse) {
            IBidResponseAction action = ActionManager.getInstance().getBidResponseAction();
            action.handleBidResponse((BidResponse) requestData);
        } else if (requestData instanceof ClickRequest) {
            IClickRequestAction action = ActionManager.getInstance().getClickRequestAction();
            LOG.warn("routing click_request to action-handler=[" + action.getClass() + "]");
            action.handleClickRequest((ClickRequest) requestData);
        } else if (requestData instanceof NotifyRequest) {
            INotifyRequestAction action = ActionManager.getInstance().getNotifyRequestAction();
            LOG.warn("routing notify_request to action-handler=[" + action.getClass() + "]");
            action.handleNotifyRequest((NotifyRequest) requestData);
        } else if (requestData instanceof PixelRequest) {
            IPixelRequestAction action = ActionManager.getInstance().getPixelRequestAction();
            LOG.warn("routing pixel_request to action-handler=[" + action.getClass() + "]");
            PixelResponse responseData = action.handlePixelRequest((PixelRequest) requestData);
            handler.setDataObject(responseData);
            handler.write(writer);
        } else if (requestData instanceof PixelResponse) {
            IPixelResponseAction action = ActionManager.getInstance().getPixelResponseAction();
            action.handlePixelResponse((PixelResponse) requestData);
        } else {
            action.handleIsoDevice((IsoDevice) isoDevise);  
          }
    }
}

package com.appnexus.integration.servlet;

import com.appnexus.bidderframework.common.runtime.framework.ActionManager;
import com.appnexus.bidderframework.common.runtime.framework.ActionRouter;
import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.BidderFrameworkActionException;
import com.appnexus.bidderframework.common.ImpBusInvalidDataException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 20, 2009
 * Time: 7:29:01 PM
 */
public class RequestHandlerServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(RequestHandlerServlet.class);
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        LOG.info("initing");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        LOG.info("initing");
        ActionManager.getInstance().registerBidRequestAction("com.appnexus.bidderactions.DefaultBidRequestAction");
        ActionManager.getInstance().registerBidResponseAction("com.appnexus.bidderactions.DefaultBidResponseAction");
        ActionManager.getInstance().registerClickRequestActionClassName("com.appnexus.bidderactions.DefaultClickRequestAction");
        ActionManager.getInstance().registerNotifyRequestActionClassName("com.appnexus.bidderactions.DefaultNotifyRequestAction");
        ActionManager.getInstance().registerPixelRequestActionClassName("com.appnexus.bidderactions.DefaultPixelRequestAction");
        ActionManager.getInstance().registerPixelResponseActionClassName("com.appnexus.bidderactions.DefaultPixelResponseAction");

    }

    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        LOG.debug("routing to actions");
        try {
            ActionRouter.getInstance().routeHttpRequestToAction(httpServletRequest.getInputStream(), httpServletResponse.getWriter());
            httpServletResponse.getWriter().flush();
        } catch (ImpBusFormatException e) {
            e.printStackTrace();
            LOG.fatal("There was an issue routing the request to the action: [" + e.getMessage() + "]", e);
            throw new ServletException("There was an issue routing the request to the action: [" + e.getMessage() + "]", e);
        } catch (BidderFrameworkActionException e) {
            e.printStackTrace();
            LOG.fatal("There was an issue routing the request to the action: [" + e.getMessage() + "]", e);
            throw new ServletException("There was an issue routing the request to the action: [" + e.getMessage() + "]", e);
        } catch (ImpBusInvalidDataException e) {
            e.printStackTrace();
            LOG.fatal("There was an issue routing the request to the action: [" + e.getMessage() + "]", e);
            throw new ServletException("There was an issue routing the request to the action: [" + e.getMessage() + "]", e);
        }
    }
}

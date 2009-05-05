package com.appnexus.integration.servlet;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 28, 2009
 * Time: 4:05:15 PM
 *
 * // returns 1 when called
 */
public class ReadyHandlerServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ReadyHandlerServlet.class);
    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        System.out.println("from sout ready handler is called");
        LOG.info("ready handler is being called");
        httpServletResponse.getWriter().write("1");
    }
}

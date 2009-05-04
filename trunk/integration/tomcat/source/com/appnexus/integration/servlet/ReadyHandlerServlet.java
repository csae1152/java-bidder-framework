package com.appnexus.integration.servlet;

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

    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.getWriter().write(1);
        httpServletResponse.getWriter().write("1");
    }
}

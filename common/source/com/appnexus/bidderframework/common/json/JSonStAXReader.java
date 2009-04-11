package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 9, 2009
 * Time: 1:33:36 PM
 */
public interface JSonStAXReader {

    /**
     * Call this method when it's time to start parsing.
     *
     * Throws IllegalStateException if the handler is not set
     * Throws IOException depending on the parser's underlying implementation
     * @throws IOException
     */
    public void parse() throws IOException, ImpBusFormatException;


    /**
     * Call this initially with the top level reader: let's say, A BidRequestHandler
     * @param currentHandler
     */
    public void setCurrentHandler(IJSonHandler currentHandler);

}

package com.appnexus.bidderframework.common.json;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParseException;

import java.io.InputStream;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 9, 2009
 * Time: 1:36:59 PM
 *
 * This will manufacture the default instance of a JSon StAX reader.
 *
 * Instantiate this factory ONLY once. This instance is thread safe 
 *
 * Then call create a new reader for each new reader you need
 *
 * you need a new reader each time because the stream will be new.
 *
 * readers are not thread safe, the notion is not even rational
 *
 */
public class JSonStAXReaderParserFactory {

    private final JsonFactory factory;

    public JSonStAXReaderParserFactory() {
        factory = new JsonFactory();
    }

    /**
     * This instantiates the reader that uses an event based like system.
     *
     * To start this puppy up, please invoke the parse() on the reader.
     *
     * Please only use this once, don't hold onto it...
     *
     * @param stream
     * @return
     * @throws IOException
     * @throws IllegalArgumentException if the initialHandler is null
     */
    public JSonStAXReader createReader(InputStream stream, IJSonHandler initialHandler) throws IOException {
        if (initialHandler == null) {
            throw new IllegalArgumentException("The initial handler cannot be null");
        }
        JsonParser parser = factory.createJsonParser(stream);
        JSonJacksonStAXReader reader = new JSonJacksonStAXReader(parser);
        reader.setCurrentHandler(initialHandler);
        return reader;
    }
    
}

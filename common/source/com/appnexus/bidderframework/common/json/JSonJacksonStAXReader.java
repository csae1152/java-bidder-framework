package com.appnexus.bidderframework.common.json;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 9, 2009
 * Time: 1:03:30 PM
 *
 * Don't instantiate this please on your own... Use the JSonStAXReaderParserFactory
 * In fact we won't let you that's why it's protected
 */
public class JSonJacksonStAXReader implements JSonStAXReader {

    private final JsonParser parser;

    private IJSonHandler currentHandler;

    protected JSonJacksonStAXReader(JsonParser parser) {
        this.parser = parser;
    }

    public void parse() throws IOException {
        if (currentHandler == null) {
            throw new IllegalStateException("The IJSonHandler cannot be null, please ensure this is set before parsing");
        }
        JsonToken token; // will return JsonToken.START_OBJECT
        parser.nextToken();
        String currentArrayName = null;
        String currentObjectName = null;
        while ((token = parser.nextToken()) != null) {
            if (token == JsonToken.START_ARRAY) {
                currentArrayName = parser.getCurrentName();
                currentHandler.startArray(currentArrayName);
                continue;
            }
            if (token == JsonToken.END_ARRAY) {
                currentHandler.endArray(currentArrayName);
                currentArrayName = null;
                continue;
            }
            if (token == JsonToken.START_OBJECT) {
                currentObjectName = parser.getCurrentName();
                currentHandler.startObject(currentObjectName);
                continue;
            }
            if (token == JsonToken.END_OBJECT) {
                currentHandler.endObject(currentObjectName);
                currentObjectName = null;
                continue;
            }
            currentHandler.readValue(parser.getCurrentName(), parser.getText());
        }
    }

    public void setCurrentHandler(IJSonHandler currentHandler) {
        this.currentHandler = currentHandler;
    }
}

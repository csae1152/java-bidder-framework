package com.appnexus.bidderframework.common.json;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.apache.log4j.Logger;

import java.io.IOException;

import com.appnexus.bidderframework.common.ImpBusFormatException;

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

    private static final Logger LOG = Logger.getLogger(JSonJacksonStAXReader.class);

    private final JsonParser parser;

    private IJSonHandler currentHandler;

    protected JSonJacksonStAXReader(JsonParser parser) {
        this.parser = parser;
    }

    public void parseRecursively(String fieldName, String parentObjectName, boolean isArray) throws IOException, ImpBusFormatException {
        if (currentHandler == null) {
            throw new IllegalStateException("The IJSonHandler cannot be null, please ensure this is set before parsing");
        }
        JsonToken token;
        while ((token = parser.nextToken()) != null) {

            switch (token) {
                case START_ARRAY: {
                    currentHandler.startArray(fieldName);
                    LOG.debug("Jackson StAX Reader: start array[" + fieldName + "]");
                    parseRecursively(fieldName, null, true);
                    continue;
                }
                case START_OBJECT: {
                    if (isArray) {
                        currentHandler.startObjectInArray(fieldName);
                        LOG.debug("Jackson StAX Reader: start array object: in array [" + fieldName + "]");
                    } else {
                        parser.nextToken();
                        parentObjectName = fieldName;
                        currentHandler.startObject(fieldName);
                        LOG.debug("Jackson StAX Reader: start object:[" + fieldName + "]");
                        fieldName = parser.getCurrentName();
                    }
                    parseRecursively(fieldName, parentObjectName, false);
                    continue;
                }
                case END_OBJECT: {
                    currentHandler.endObject(parentObjectName);
                    LOG.debug("Jackson StAX Reader: end object:[" + parentObjectName + "]");
                    return;
                }
                case END_ARRAY: {
                    currentHandler.endArray(fieldName);
                    LOG.debug("Jackson StAX Reader: end array[" + fieldName + "]");
                    return;
                }
                case FIELD_NAME: {
                    fieldName = parser.getCurrentName();
                    continue;
                }
                case VALUE_STRING: {
                    if (isArray) {
                        currentHandler.readValue(fieldName, parser.getText());
                        LOG.debug("Jackson StAX Reader: string=value:[" + parser.getText() + "] in array[" + fieldName + "]");
                    } else {
                        currentHandler.readValue(parser.getCurrentName(), parser.getText());
                        LOG.debug("Jackson StAX Reader: string=field name:[" + parser.getCurrentName() + "] value:[" + parser.getText() + "]");
                    }
                    continue;
                }
                case VALUE_NUMBER_INT: {
                    if (isArray) {
                        currentHandler.readValue(fieldName, parser.getIntValue());
                        LOG.debug("Jackson StAX Reader: int=value:[" + parser.getText() + "] in array[" + fieldName + "]");
                    } else {
                        currentHandler.readValue(parser.getCurrentName(), parser.getIntValue());
                        LOG.debug("Jackson StAX Reader: int=field name:[" + parser.getCurrentName() + "] value:[" + parser.getIntValue() + "]");
                    }
                    continue;
                }
                case VALUE_NUMBER_FLOAT: {
                    if (isArray) {
                        currentHandler.readValue(fieldName, parser.getFloatValue());
                        LOG.debug("Jackson StAX Reader: float=value:[" + parser.getText() + "] in array[" + fieldName + "]");
                    } else {
                        currentHandler.readValue(parser.getCurrentName(), parser.getFloatValue());
                        LOG.debug("Jackson StAX Reader: float=field name:[" + parser.getCurrentName() + "] value:[" + parser.getFloatValue() + "]");
                    }
                    continue;
                }
                case VALUE_TRUE: {
                    if (isArray) {
                        currentHandler.readValue(fieldName, true);
                        LOG.debug("Jackson StAX Reader: boolean=value:[true] in array[" + fieldName + "]");
                    } else {
                        currentHandler.readValue(parser.getCurrentName(), true);
                        LOG.debug("Jackson StAX Reader: boolean=field name:[" + parser.getCurrentName() + "] value:[true]");
                    }
                    continue;
                }
                case VALUE_FALSE: {
                    if (isArray) {
                        currentHandler.readValue(fieldName, false);
                        LOG.debug("Jackson StAX Reader: boolean=value:[false] in array[" + fieldName + "]");
                    } else {
                        currentHandler.readValue(parser.getCurrentName(), false);
                        LOG.debug("Jackson StAX Reader: boolean=field name:[" + parser.getCurrentName() + "] value:[false]");
                    }
                    continue;
                }
            }
        }
    }

    public void parse() throws IOException, ImpBusFormatException {
        parseRecursively("start", "start", false);
    }

    public void setCurrentHandler(IJSonHandler currentHandler) {
        this.currentHandler = currentHandler;
    }
}

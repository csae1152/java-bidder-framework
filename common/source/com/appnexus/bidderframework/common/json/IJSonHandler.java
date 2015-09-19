package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.ImpBusInvalidDataException;

import java.io.OutputStream;
import java.io.Writer;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:16:53 PM
 */
public interface IJSonHandler<T> {

    public JSonStAXReader getReader();

    public void setReader(JSonStAXReader reader);

    public void setParentHandler(IJSonHandler<?> parentHandler);
    
    public void setDataObject(T dataObject);

    public T getDataObject();

    public void write(Writer out) throws IOException, ImpBusInvalidDataException;

    public void startArray(String arrayName);

    void endArray(String arrayName);

    void startObject(String objectName);

    void endObject(String objectName);

    void startObjectInArray(String arrayName);

    void readValue(String fieldName, String value) throws ImpBusFormatException;

    void readValue(String fieldName, int value);

    void readValue(String fieldName, float value);

    void readValue(String fieldName, boolean value);
    
    void readTractorData(String tractorName, float distance);
}

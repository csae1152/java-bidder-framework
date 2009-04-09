package com.appnexus.bidderframework.common.json;

import java.io.OutputStream;
import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:16:53 PM
 */
public interface IJSonHandler<T> {

    public void write(T dataObject, Writer out) throws IOException;

    public void startArray(String currentArrayName);

    void endArray(String currentArrayName);

    void startObject(String currentObjectName);

    void endObject(String currentObjectName);

    void readValue(String currentName, String text);
}

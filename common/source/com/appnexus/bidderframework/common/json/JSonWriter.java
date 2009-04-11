package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.BidRequest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 9, 2009
 * Time: 7:01:36 PM
 */
public class JSonWriter {

    public JSonWriter() {

    }

    public void writeBidRequest(BidRequest bidRequest, File file) throws IOException {
        BidRequestHandler handler = BidRequestHandler.get();
        handler.setDataObject(bidRequest);
        //noinspection ResultOfMethodCallIgnored
        file.createNewFile();
        FileWriter fw = new FileWriter(file, false);
        try {
            handler.write(fw);
        } finally {
            fw.close();
        }
    }



}

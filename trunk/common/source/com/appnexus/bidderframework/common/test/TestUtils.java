package com.appnexus.bidderframework.common.test;

import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.json.JSonStAXReaderParserFactory;
import com.appnexus.bidderframework.common.json.IJSonHandler;
import com.appnexus.bidderframework.common.json.BidRequestHandler;
import com.appnexus.bidderframework.common.json.JSonStAXReader;
import com.appnexus.bidderframework.common.json.JSonWriter;

import java.io.IOException;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: May 8, 2009
 * Time: 10:13:58 AM
 */
public class TestUtils {

    private TestUtils() {
    }


    public static BidRequest[] getOriginalAndMirroredBidRequest(String fileName) throws IOException, ImpBusFormatException {
        BidRequest obr = getBidRequest(fileName);
        writeBidRequest(obr, fileName + ".mirrored", false);
        BidRequest nbr = getBidRequest(fileName + ".mirrored");
        return new BidRequest[] {obr, nbr};
    }

    public static BidRequest getBidRequest(String fileName) throws IOException, ImpBusFormatException {
        JSonStAXReaderParserFactory factory = new JSonStAXReaderParserFactory();
        IJSonHandler<BidRequest> handler = BidRequestHandler.get();
        BidRequest dataObject = new BidRequest();
        handler.setDataObject(dataObject);
        JSonStAXReader reader = factory.createReader(new File(fileName), handler);
        handler.setReader(reader);
        reader.parse();
        return dataObject;
    }

    @SuppressWarnings({"ResultOfMethodCallIgnored"})
    public static void writeBidRequest(BidRequest dataObject, String fileName, boolean deleteOnExit) throws IOException {
        JSonWriter writer = new JSonWriter();
        File fileToWrite = new File(fileName);
        fileToWrite.createNewFile();
        writer.writeBidRequest(dataObject, fileToWrite);
        if (deleteOnExit) {
            fileToWrite.deleteOnExit();
        }
    }
}

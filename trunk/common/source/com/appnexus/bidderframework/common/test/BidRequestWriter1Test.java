package com.appnexus.bidderframework.common.test;

import org.junit.Test;
import org.junit.Assert;
import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.dataobjects.Tag;
import com.appnexus.bidderframework.common.dataobjects.Bid;
import com.appnexus.bidderframework.common.dataobjects.LucidData;
import com.appnexus.bidderframework.common.json.JSonWriter;
import com.appnexus.bidderframework.common.json.JSonStAXReaderParserFactory;
import com.appnexus.bidderframework.common.json.IJSonHandler;
import com.appnexus.bidderframework.common.json.BidRequestHandler;
import com.appnexus.bidderframework.common.json.JSonStAXReader;
import com.appnexus.bidderframework.common.ImpBusFormatException;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 9, 2009
 * Time: 7:08:33 PM
 */
public class BidRequestWriter1Test {

    @Test
    public void testMirroringBidRequests() throws IOException, ImpBusFormatException {
        BidRequest[] brs = getOriginalAndMirroredBidRequest("test/bid_request.json.txt");
        Assert.assertEquals("bid_request.json.txt failed", brs[0], brs[1]);

        brs = getOriginalAndMirroredBidRequest("test/bid_request2.json.txt");
        Assert.assertEquals("bid_request2.json.txt failed", brs[0], brs[1]);
    }
    
    private BidRequest[] getOriginalAndMirroredBidRequest(String fileName) throws IOException, ImpBusFormatException {
        BidRequest obr = getBidRequest(fileName);
        writeBidRequest(obr, fileName + ".mirrored", false);
        BidRequest nbr = getBidRequest(fileName + ".mirrored");
        return new BidRequest[] {obr, nbr};
    }

    private BidRequest getBidRequest(String fileName) throws IOException, ImpBusFormatException {
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
    private void writeBidRequest(BidRequest dataObject, String fileName, boolean deleteOnExit) throws IOException {
        JSonWriter writer = new JSonWriter();
        File fileToWrite = new File(fileName);
        fileToWrite.createNewFile();
        writer.writeBidRequest(dataObject, fileToWrite);
        if (deleteOnExit) {
            fileToWrite.deleteOnExit();
        }
    }
    
}

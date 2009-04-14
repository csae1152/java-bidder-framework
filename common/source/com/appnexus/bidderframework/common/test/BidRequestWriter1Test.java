package com.appnexus.bidderframework.common.test;

import org.junit.Test;
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
    public void testWriting() throws IOException {
        BidRequest bidRequest = new BidRequest();
        bidRequest.setAllowExclusive(true);
        bidRequest.setDebugRequested(false);
        List<Tag> tags = new ArrayList<Tag>();
        bidRequest.setTags(tags);
        Tag tag = new Tag();
        tags.add(tag);
        tag.setAuctionID("going once, going twice sold to the lady in the purple dress");
        tag.setTagID(42);
        tag.setWidth(3700);
        tag.setHeight(100);
        tag = new Tag();
        tags.add(tag);
        tag.setAuctionID("going thrice, going frice sold to the gentlemen in the black overcoat");
        tag.setTagID(24);
        tag.setWidth(100);
        tag.setHeight(3700);
        Bid bid = new Bid();
        bidRequest.setBid(bid);
        bid.setAcceptedLanguages("EN");
        bid.setAge(21);
        bid.setCity("New Rochelle");
        bid.setUserID("Samuel L. Bronkowitz");
        bid.setLucidData(new LucidData());

        JSonWriter writer = new JSonWriter();
        writer.writeBidRequest(bidRequest, new File("BidRequestWriter1.jsn"));
    }

    @Test
    public void testReading() throws IOException, ImpBusFormatException {
        JSonStAXReaderParserFactory factory = new JSonStAXReaderParserFactory();
        IJSonHandler<BidRequest> handler = BidRequestHandler.get();
        BidRequest dataObject = new BidRequest();
        handler.setDataObject(dataObject);
        JSonStAXReader reader = factory.createReader(new File("BidRequestWriter1.jsn"), handler);
        handler.setReader(reader);
        reader.parse();

        JSonWriter writer = new JSonWriter();
        writer.writeBidRequest(dataObject, new File("BidRequestWriterMirrored.jsn"));

    }
}

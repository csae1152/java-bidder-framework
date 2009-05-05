package com.appnexus.bidderactions;

import com.appnexus.bidderframework.common.runtime.actions.IBidRequestAction;
import com.appnexus.bidderframework.common.dataobjects.BidResponse;
import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.dataobjects.TagResponse;
import com.appnexus.bidderframework.common.dataobjects.Tag;
import com.appnexus.bidderframework.common.dataobjects.CustomMacro;
import com.appnexus.bidderframework.common.json.JSonWriter;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:30:57 AM
 */
public class DefaultBidRequestAction implements IBidRequestAction {
    private static final Logger LOG = Logger.getLogger(DefaultBidRequestAction.class);
    public BidResponse handleBidRequest(BidRequest bidRequest) {
        LOG.info("Start Handling BidRequest");
//        System.out.println("start handling bid request");
//        String fileName = "BidRequest." + System.currentTimeMillis() + ".json";
//        System.out.println("BidRequest." + System.currentTimeMillis() + ".json");
//        File file = new File(fileName);
//        try {
//            boolean nf = file.createNewFile();
//            LOG.debug("file is ready for writing [" + file.getAbsolutePath() + ", created=" + nf + "]");
//            System.out.println("file is ready for writing [" + file.getAbsolutePath() + ", created=" + nf + "]");
//            JSonWriter jsw = new JSonWriter();
//            jsw.writeBidRequest(bidRequest, file);
//            LOG.debug("file has been written [" + file.getAbsolutePath() + ", created=" + nf + "]");
//            System.out.println("file has been written [" + file.getAbsolutePath() + ", created=" + nf + "]");
//        } catch (IOException e) {
//            LOG.error("couldn't create the file: " + file.getAbsolutePath() + " was an error: " + e.getMessage(), e);
//            System.err.println("couldn't create the file: " + file.getAbsolutePath() + " was an error: " + e.getMessage());
//        }
        int requestCount = bidRequest.getTags().size();
        BidResponse response = new BidResponse();
        response.setBidResponseItems(new ArrayList<TagResponse>(requestCount));
        for (int i = 0; i < requestCount; i++) {
            Tag tag = bidRequest.getTags().get(i);
            TagResponse tr = new TagResponse();
            tr.setAuctionID(tag.getAuctionID());
            tr.setCustomMacros(new ArrayList<CustomMacro>(1));
            response.getBidResponseItems().add(tr);
        }
        return response;
    }
}

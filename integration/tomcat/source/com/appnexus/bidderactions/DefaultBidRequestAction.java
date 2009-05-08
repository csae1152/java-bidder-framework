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
        LOG.debug("Start Handling BidRequest");
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

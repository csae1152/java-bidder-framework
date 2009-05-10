package com.appnexus.bidderactions;

import com.appnexus.bidderframework.common.runtime.actions.IBidRequestAction;
import com.appnexus.bidderframework.common.dataobjects.Bid;
import com.appnexus.bidderframework.common.dataobjects.BidResponse;
import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.dataobjects.Segment;
import com.appnexus.bidderframework.common.dataobjects.InventoryClass;
import com.appnexus.bidderframework.common.dataobjects.LucidData;
import com.appnexus.bidderframework.common.dataobjects.LucidLevelData;
import com.appnexus.bidderframework.common.dataobjects.TagResponse;
import com.appnexus.bidderframework.common.dataobjects.Tag;
import com.appnexus.bidderframework.common.dataobjects.CustomMacro;
import com.appnexus.bidderframework.common.json.JSonWriter;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:30:57 AM
 */
public class DefaultBidRequestAction implements IBidRequestAction {
    private static final Logger LOG = Logger.getLogger(DefaultBidRequestAction.class);
	private static final int ARTS_AND_ENTERTAINMENT = 65792;
	private static final int DESIRED_SEGEMENT = 1;

	private static boolean meetsBidConditions(Bid bidInfo) {
		if (bidInfo.getTotalImpressionCount() > 3) {
			return false;
		}
		if (bidInfo.getMinutesSinceLastImpression() < 20) {
			return false;
		}
		if (bidInfo.getAge() > 0 && bidInfo.getAge() < 18) {
			return false;
		}
		InventoryClass invClass = bidInfo.getInventoryClass();
		if (invClass == null || (invClass != InventoryClass.CLASS_2_URL && invClass != InventoryClass.CLASS_3_URL)) {
			return false;
		}
    	LucidData lucidData = bidInfo.getLucidData();  
		if (lucidData == null) {
			return false;
		}
		List<LucidLevelData> lucidDataLevels = lucidData.getLucidLevels();
		if (lucidDataLevels == null || lucidDataLevels.size() < 1) {
			return false;
		}
		if (lucidDataLevels.get(0).getDc() != ARTS_AND_ENTERTAINMENT) {
			return false;
		}
		return true;
	}

    public BidResponse handleBidRequest(BidRequest bidRequest) {
        LOG.debug("Start Handling BidRequest");
        /* Sample bidding logic:
			For each response set recency/frequency using userdata js
			1. Always bid the ECP + .05 at minimum
			2. Only bid on class_2/3 inventory with Lucid category 65792 (Arts and Entertainment), never bid on unaudited
			3. If segment pixel X exists at which point bid $4.00
			4. Only bid on frequency 1-3 impressions per 20 minutes.
			5. Only bid on users who are known to not be below age of 18
		*/

		// Get the BidRequqest's principle objects
		BidResponse response = new BidResponse();
		Bid bidInfo = bidRequest.getBid();
		if (bidInfo == null) {
			LOG.error("We should never receive a null Bid in the BidRequest");
			response.setBidResponseItems(new ArrayList<TagResponse>(1));
			TagResponse tagResponse = new TagResponse();
			tagResponse.setNoBid(true);
			response.getBidResponseItems().add(tagResponse);
			return response;
		}	
	 
		// Populate BidResponse with the correct number of TagResponses
		int requestCount = bidRequest.getTags().size();
        response.setBidResponseItems(new ArrayList<TagResponse>(requestCount));
        for (int i = 0; i < requestCount; i++) {
			// Get a Tag in the BidRequest
			Tag tag = bidRequest.getTags().get(i);
			TagResponse tagResponse = new TagResponse();
            
			if (!meetsBidConditions(bidInfo)) {
				LOG.info("BidRequest does not meet bid conditions--no bid");
				tagResponse.setNoBid(true);
				continue;
			}

            tagResponse.setAuctionID(tag.getAuctionID());
            tagResponse.setCustomMacros(new ArrayList<CustomMacro>(1));
            tagResponse.setMemberID(212);
            tagResponse.setCreativeID(1745);
            tagResponse.setPrice(tag.getEstimatedMinimumPrice() + 0.05);
            
			// Override price if we have the desired segment 1 
            // Obviously it would be good to add a containsSegmentID() 
            // method to the Bid class
            if (bidRequest.getBid().getSegments() != null) {
                for (Segment segment : bidRequest.getBid().getSegments()) {
                    if (segment.getSegmentID() == DESIRED_SEGEMENT) {
                        tagResponse.setPrice(4.00);
                    }
                }
            }
        
            response.getBidResponseItems().add(tagResponse);
        }
        return response;
    }
}

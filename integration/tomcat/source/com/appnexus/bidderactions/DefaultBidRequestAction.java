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
import java.lang.StringBuilder;
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
	private static final int DESIRED_LUCID = 73472; // myspace.com is 73472
	private static final int DESIRED_SEGEMENT = 1;

	private static boolean meetsBidConditions(Bid bidInfo) {
		int totalImpCount = bidInfo.getTotalImpressionCount();
		if (totalImpCount > 3) {
			LOG.info("BidRequest does not meet bid conditions:\n total impression count > 3:  " + totalImpCount);
			return false;
		}
		int minutesSinceLastImp = bidInfo.getMinutesSinceLastImpression();
		if (minutesSinceLastImp >= 0 && minutesSinceLastImp < 20) {
			LOG.info("BidRequest does not meet bid conditions:\n minutes since last impression < 20:  " + minutesSinceLastImp);
			return false;
		}
		int age = bidInfo.getAge();
		if (age > 0 && age < 18) {
			LOG.info("BidRequest does not meet bid conditions:\n age defined and < 18:  " + age);
			return false;
		}
		InventoryClass invClass = bidInfo.getInventoryClass();
		if (invClass == null || (invClass != InventoryClass.CLASS_2_URL && invClass != InventoryClass.CLASS_3_URL)) {
			LOG.info("BidRequest does not meet bid conditions:\n inventory category is not class_2 or class_3:  " + invClass);
			return false;
		}
    	LucidData lucidData = bidInfo.getLucidData();  
		if (lucidData == null) {
			LOG.info("BidRequest does not meet bid conditions:\n no Lucid data");
			return false;
		}
		List<LucidLevelData> lucidDataLevels = lucidData.getLucidLevels();
		if (lucidDataLevels == null || lucidDataLevels.size() < 1) {
			LOG.info("BidRequest does not meet bid conditions:\n no Lucid level");
			return false;
		}
		int dc = lucidDataLevels.get(0).getDc();
		if (dc != DESIRED_LUCID) {
			LOG.info("BidRequest does not meet bid conditions:\n Lucid level is not " + DESIRED_LUCID + ":  " + dc);
			return false;
		}
		return true;
	}

    public BidResponse handleBidRequest(BidRequest bidRequest) {
        LOG.debug("Start Handling BidRequest");
        /* Sample bidding logic:
			For each response set recency/frequency using userdata js
			1. Always bid the ECP + .05 at minimum
			2. Only bid on class_2/3 inventory with Lucid category 73472, never bid on unaudited
			3. If segment pixel X exists at which point bid $60.00
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
				tagResponse.setNoBid(true);
				continue;
			}

            tagResponse.setAuctionID(tag.getAuctionID());
            tagResponse.setCustomMacros(new ArrayList<CustomMacro>(1));
            tagResponse.setMemberID(212);
            tagResponse.setCreativeID(1745);
            tagResponse.setPrice(tag.getEstimatedMinimumPrice() + 0.05);
          	tagResponse.setUserDataJS("incr_frequency();");
  
			// Override price if we have the desired segment 1 
            // Obviously it would be good to add a containsSegmentID() 
            // method to the Bid class
            if (bidRequest.getBid().getSegments() != null) {
                for (Segment segment : bidRequest.getBid().getSegments()) {
                    if (segment.getSegmentID() == DESIRED_SEGEMENT) {
                        tagResponse.setPrice(60.00);
                    }
                }
            }
        
            response.getBidResponseItems().add(tagResponse);
        }
        return response;
    }
}

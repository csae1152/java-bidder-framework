package com.appnexus.bidderactions;

import com.appnexus.bidderframework.common.runtime.actions.IBidRequestAction;
import com.appnexus.bidderframework.common.dataobjects.BidResponse;
import com.appnexus.bidderframework.common.dataobjects.BidRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:30:57 AM
 */
public class DefaultBidRequestAction implements IBidRequestAction {
    public BidResponse handleBidRequest(BidRequest bidRequest) {
        return new BidResponse();
    }
}

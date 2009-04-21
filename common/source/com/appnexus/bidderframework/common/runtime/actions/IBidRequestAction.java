package com.appnexus.bidderframework.common.runtime.actions;

import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.dataobjects.BidResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 9:56:17 AM
 */
public interface IBidRequestAction {
    public BidResponse handleBidRequest(BidRequest bidRequest);
}

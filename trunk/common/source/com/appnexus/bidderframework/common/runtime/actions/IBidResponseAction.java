package com.appnexus.bidderframework.common.runtime.actions;

import com.appnexus.bidderframework.common.dataobjects.BidResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:06:25 AM
 */
public interface IBidResponseAction {
    void handleBidResponse(BidResponse bidResponse);
}

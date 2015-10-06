package com.appnexus.bidderframework.common.runtime.actions;

import com.appnexus.bidderframework.common.dataobjects.PixelResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:07:22 AM
 * 
 * updated by @author Helmut Steiner
 * 
 */
public interface IPixelResponseAction {
    void handlePixelResponse(PixelResponse pixelResponse);
    public String getBidderInfo(String bidderInfo);
    public int calculateTimeout(int bidderPlatformTimeout);
}

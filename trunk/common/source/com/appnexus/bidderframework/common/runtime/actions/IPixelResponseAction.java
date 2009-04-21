package com.appnexus.bidderframework.common.runtime.actions;

import com.appnexus.bidderframework.common.dataobjects.PixelResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:07:22 AM
 */
public interface IPixelResponseAction {
    void handlePixelResponse(PixelResponse pixelResponse);
}

package com.appnexus.bidderactions;

import com.appnexus.bidderframework.common.runtime.actions.IPixelRequestAction;
import com.appnexus.bidderframework.common.dataobjects.PixelResponse;
import com.appnexus.bidderframework.common.dataobjects.PixelRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 12:18:16 PM
 */
public class DefaultPixelRequestAction implements IPixelRequestAction {
    public PixelResponse handlePixelRequest(PixelRequest pixelRequest) {
        return new PixelResponse();
    }
}

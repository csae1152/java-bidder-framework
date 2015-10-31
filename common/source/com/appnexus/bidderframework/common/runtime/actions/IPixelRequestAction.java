package com.appnexus.bidderframework.common.runtime.actions;

import com.appnexus.bidderframework.common.dataobjects.PixelRequest;
import com.appnexus.bidderframework.common.dataobjects.PixelResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:07:12 AM
 * 
 * updated by @author Helmut Steiner
 * 
 */
public interface IPixelRequestAction {
   IsoBus isoBus(IsoBusDeviceId deviceId);
}

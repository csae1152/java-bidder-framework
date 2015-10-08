package com.appnexus.bidderactions;

import com.appnexus.bidderframework.common.runtime.actions.INotifyRequestAction;
import com.appnexus.bidderframework.common.dataobjects.NotifyRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 12:17:49 PM
 * 
 * updated @author Helmut Steiner
 * 
 */
public class DefaultNotifyRequestAction implements INotifyRequestAction {
    public void handleNotifyRequest(NotifyRequest clickRequest) {}
    public void handleDeviceReques(TractorRequest tractorRequest){}
}

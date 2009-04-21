package com.appnexus.bidderframework.common.runtime.actions;

import com.appnexus.bidderframework.common.dataobjects.NotifyRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:07:01 AM
 */
public interface INotifyRequestAction {
    void handleNotifyRequest(NotifyRequest clickRequest);
}

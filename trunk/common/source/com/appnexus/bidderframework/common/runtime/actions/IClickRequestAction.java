package com.appnexus.bidderframework.common.runtime.actions;

import com.appnexus.bidderframework.common.dataobjects.ClickRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:06:48 AM
 */
public interface IClickRequestAction {
    void handleClickRequest(ClickRequest clickRequest);
}

package com.appnexus.bidderframework.common.dataobjects;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 11:40:12 AM
 */
public class BidResponse {

    private String debugText;
    private boolean noNotify;
    private boolean userIDUnknown;
    private List<TagResponse> bidResponseItems;

    public String getDebugText() {
        return debugText;
    }

    public void setDebugText(String debugText) {
        this.debugText = debugText;
    }

    public boolean isNoNotify() {
        return noNotify;
    }

    public void setNoNotify(boolean noNotify) {
        this.noNotify = noNotify;
    }

    public boolean isUserIDUnknown() {
        return userIDUnknown;
    }

    public void setUserIDUnknown(boolean userIDUnknown) {
        this.userIDUnknown = userIDUnknown;
    }

    public List<TagResponse> getBidResponseItems() {
        return bidResponseItems;
    }

    public void setBidResponseItems(List<TagResponse> bidResponseItems) {
        this.bidResponseItems = bidResponseItems;
    }
}

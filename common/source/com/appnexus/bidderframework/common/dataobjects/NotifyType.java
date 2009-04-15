package com.appnexus.bidderframework.common.dataobjects;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:00:35 PM
 */
public enum NotifyType {

    NOTIFY_KEPT("kept"), NOTIFY_SOLD("sold"), NOTIFY_WON("won"), NOTIFY_PENDING("pending"),
    NOTIFY_LOST("lost"), NOTIFY_ERROR("error"), NOTIFY_NO_BID("no-bid");
    private final String value;
    private static Map<String, NotifyType> STRING_TO_NOTIFY_TYPE = new HashMap<String, NotifyType>(7);

    static {
        STRING_TO_NOTIFY_TYPE.put("kept", NOTIFY_KEPT);
        STRING_TO_NOTIFY_TYPE.put("sold", NOTIFY_SOLD);
        STRING_TO_NOTIFY_TYPE.put("won", NOTIFY_WON);
        STRING_TO_NOTIFY_TYPE.put("pending", NOTIFY_PENDING);
        STRING_TO_NOTIFY_TYPE.put("lost", NOTIFY_LOST);
        STRING_TO_NOTIFY_TYPE.put("error", NOTIFY_ERROR);
        STRING_TO_NOTIFY_TYPE.put("no-bid", NOTIFY_NO_BID);
    }

    NotifyType(String value) {
        this.value = value;
    }

    public static NotifyType getFromString(String value) {
        return STRING_TO_NOTIFY_TYPE.get(value);
    }

    @Override
    public String toString() {
        return value;
    }
}

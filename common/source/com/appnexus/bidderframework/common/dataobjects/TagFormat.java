package com.appnexus.bidderframework.common.dataobjects;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 3:20:57 PM
 */
public enum TagFormat {

    TAG_IFRAME("iframe"), TAG_JS("javascript");
    private final String value;

    TagFormat(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

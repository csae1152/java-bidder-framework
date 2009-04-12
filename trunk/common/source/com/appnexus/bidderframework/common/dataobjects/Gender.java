package com.appnexus.bidderframework.common.dataobjects;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 3:46:59 PM
 */
public enum Gender {
    FEMALE("female"), MALE("male"), GENDER_UNKNOWN("unknown");
    private final String value;

    Gender(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

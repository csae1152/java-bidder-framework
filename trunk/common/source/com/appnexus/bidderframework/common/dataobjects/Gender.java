package com.appnexus.bidderframework.common.dataobjects;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 3:46:59 PM
 */
public enum Gender {
    FEMALE("female"), MALE("male"), GENDER_UNKNOWN("unknown");
    private final String value;
    private static Map<String, Gender> STRING_GENDER_MAP = new HashMap<String, Gender>();
    static {
        STRING_GENDER_MAP.put("female", FEMALE);
        STRING_GENDER_MAP.put("male", MALE);
        STRING_GENDER_MAP.put("unknown", GENDER_UNKNOWN);
    }

    Gender(String value) {
        this.value = value;
    }

    public static Gender getForString(String value) {
        return STRING_GENDER_MAP.get(value);
    }

    @Override
    public String toString() {
        return value;
    }
}

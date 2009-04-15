package com.appnexus.bidderframework.common.dataobjects;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 11:47:32 AM
 */
public enum PixelType {
    PIXEL_JS ("javascript"), PIXEL_IMAGE("image");
    private final String value;
    private static final Map<String, PixelType> STRING_TO_PIXEL_MAP = new HashMap<String, PixelType>(2);
    static {
        STRING_TO_PIXEL_MAP.put("javascript", PIXEL_JS);
        STRING_TO_PIXEL_MAP.put("image", PIXEL_IMAGE);
    }

    PixelType(String value) {
        this.value = value;
    }

    public static PixelType getFromString(String value) {
        return STRING_TO_PIXEL_MAP.get(value);
    }

    @Override
    public String toString() {
        return value;
    }
}

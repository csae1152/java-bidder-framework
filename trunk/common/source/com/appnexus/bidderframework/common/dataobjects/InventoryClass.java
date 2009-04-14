package com.appnexus.bidderframework.common.dataobjects;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 3:51:05 PM
 */
public enum InventoryClass {
    
    BLACKLIST_URL("blacklist"), CLASS_1_URL("class_1"), CLASS_2_URL("class_2"), CLASS_3_URL("class_3");

    private static Map<String, InventoryClass> STRING_TO_INVENTORY_MAP = new HashMap<String, InventoryClass>();
    static {
        STRING_TO_INVENTORY_MAP.put("blacklist", BLACKLIST_URL);
        STRING_TO_INVENTORY_MAP.put("class_1", CLASS_1_URL);
        STRING_TO_INVENTORY_MAP.put("class_2", CLASS_2_URL);
        STRING_TO_INVENTORY_MAP.put("class_3", CLASS_3_URL);
    }

    private final String value;
    
    private InventoryClass(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static InventoryClass getForString(String value) {
        return STRING_TO_INVENTORY_MAP.get(value);
    }
}

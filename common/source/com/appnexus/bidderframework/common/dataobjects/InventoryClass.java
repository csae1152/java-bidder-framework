package com.appnexus.bidderframework.common.dataobjects;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 3:51:05 PM
 */
public enum InventoryClass {
    
    BLACKLIST_URL("blacklist"), CLASS_1_URL("class_1"), CLASS_2_URL("class_2"), CLASS_3_URL("class_3");

    private final String value;
    
    private InventoryClass(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

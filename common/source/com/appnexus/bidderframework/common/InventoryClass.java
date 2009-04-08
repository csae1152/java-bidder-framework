package com.appnexus.bidderframework.common;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 3:51:05 PM
 */
public enum InventoryClass {
    BLACKLIST_URL("blacklist"), CLASS_1_URL("class1"), CLASS_2_URL("class2"), CLASS_3_URL("class3");

    private String name;
    private InventoryClass(String name) {
        this.name = name;
    }
}

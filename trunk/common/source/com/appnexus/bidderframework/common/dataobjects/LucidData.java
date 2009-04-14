package com.appnexus.bidderframework.common.dataobjects;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 3:52:55 PM
 */
public class LucidData {

    public static final String LUCID_ID_PREFIX = "dc";
    public static final int LUCID_NUMBER_CATEGORIES = 5;
    private int lucidLevel;
    private long[] dc;
    private String[] categories;

    public long[] getDc() {
        return dc;
    }

    public void setDc(long[] dc) {
        this.dc = dc;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public int getLucidLevel() {
        return lucidLevel;
    }

    public void setLucidLevel(int lucidLevel) {
        this.lucidLevel = lucidLevel;
    }
}

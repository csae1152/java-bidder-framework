package com.appnexus.bidderframework.common.dataobjects;

import java.util.List;

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

    public List<LucidLevelData> getLucidLevels() {
        return lucidLevels;
    }

    public void setLucidLevels(List<LucidLevelData> lucidLevels) {
        this.lucidLevels = lucidLevels;
    }

    private List<LucidLevelData> lucidLevels;

    public int getLucidLevel() {
        return lucidLevel;
    }

    public void setLucidLevel(int lucidLevel) {
        this.lucidLevel = lucidLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LucidData)) return false;

        LucidData lucidData = (LucidData) o;

        if (lucidLevel != lucidData.lucidLevel) return false;
        if (lucidLevels != null ? !lucidLevels.equals(lucidData.lucidLevels) : lucidData.lucidLevels != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lucidLevel;
        result = 31 * result + (lucidLevels != null ? lucidLevels.hashCode() : 0);
        return result;
    }
}

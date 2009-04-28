package com.appnexus.bidderframework.common.dataobjects;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 5:26:59 PM
 */
public class LucidLevelData {

    private int dc;
    private String category;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDc() {
        return dc;
    }

    public void setDc(int dc) {
        this.dc = dc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LucidLevelData)) return false;

        LucidLevelData that = (LucidLevelData) o;

        if (dc != that.dc) return false;
        if (level != that.level) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dc;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + level;
        return result;
    }
}

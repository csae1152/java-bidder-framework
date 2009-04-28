package com.appnexus.bidderframework.common.dataobjects;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 4:32:21 PM
 */
public class Segment {

    private int segmentID;
    private int memberID;
    private int other;
    private String code; //32 chars
    private String shortname; //32 chars
    private String provider; //32 chars
    private float price;
    private int expireMinutes;
    private boolean active;

    public int getSegmentID() {
        return segmentID;
    }

    public void setSegmentID(int segmentID) {
        this.segmentID = segmentID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getExpireMinutes() {
        return expireMinutes;
    }

    public void setExpireMinutes(int expireMinutes) {
        this.expireMinutes = expireMinutes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "segmentID=" + segmentID +
                ", memberID=" + memberID +
                ", other=" + other +
                ", code='" + code + '\'' +
                ", shortname='" + shortname + '\'' +
                ", provider='" + provider + '\'' +
                ", price=" + price +
                ", expireMinutes=" + expireMinutes +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Segment)) return false;

        Segment segment = (Segment) o;

        if (active != segment.active) return false;
        if (expireMinutes != segment.expireMinutes) return false;
        if (memberID != segment.memberID) return false;
        if (other != segment.other) return false;
        if (Float.compare(segment.price, price) != 0) return false;
        if (segmentID != segment.segmentID) return false;
        if (code != null ? !code.equals(segment.code) : segment.code != null) return false;
        if (provider != null ? !provider.equals(segment.provider) : segment.provider != null) return false;
        if (shortname != null ? !shortname.equals(segment.shortname) : segment.shortname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = segmentID;
        result = 31 * result + memberID;
        result = 31 * result + other;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (shortname != null ? shortname.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + expireMinutes;
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}

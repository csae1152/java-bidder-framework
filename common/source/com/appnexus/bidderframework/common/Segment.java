package com.appnexus.bidderframework.common;

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
}

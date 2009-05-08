package com.appnexus.bidderframework.common.dataobjects;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 11:52:46 AM
 */
public class ClickRequest {

    private Date timestamp;
    private String auctionID;
    private String userID;
    private int memberID;
    private String referrerURL;
    private String userAgent;
    private String userData;
    private String userDataJson;
    private String customNotifyData;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getReferrerURL() {
        return referrerURL;
    }

    public void setReferrerURL(String referrerURL) {
        this.referrerURL = referrerURL;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public String getUserDataJson() {
        return userDataJson;
    }

    public void setUserDataJson(String userDataJson) {
        this.userDataJson = userDataJson;
    }

    public String getCustomNotifyData() {
        return customNotifyData;
    }

    public void setCustomNotifyData(String customNotifyData) {
        this.customNotifyData = customNotifyData;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClickRequest)) return false;

        ClickRequest that = (ClickRequest) o;

        if (memberID != that.memberID) return false;
        if (auctionID != null ? !auctionID.equals(that.auctionID) : that.auctionID != null) return false;
        if (customNotifyData != null ? !customNotifyData.equals(that.customNotifyData) : that.customNotifyData != null)
            return false;
        if (referrerURL != null ? !referrerURL.equals(that.referrerURL) : that.referrerURL != null) return false;
        if (userAgent != null ? !userAgent.equals(that.userAgent) : that.userAgent != null) return false;
        if (userData != null ? !userData.equals(that.userData) : that.userData != null) return false;
        if (userDataJson != null ? !userDataJson.equals(that.userDataJson) : that.userDataJson != null) return false;
        if (userID != null ? !userID.equals(that.userID) : that.userID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = auctionID != null ? auctionID.hashCode() : 0;
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        result = 31 * result + memberID;
        result = 31 * result + (referrerURL != null ? referrerURL.hashCode() : 0);
        result = 31 * result + (userAgent != null ? userAgent.hashCode() : 0);
        result = 31 * result + (userData != null ? userData.hashCode() : 0);
        result = 31 * result + (userDataJson != null ? userDataJson.hashCode() : 0);
        result = 31 * result + (customNotifyData != null ? customNotifyData.hashCode() : 0);
        return result;
    }
}

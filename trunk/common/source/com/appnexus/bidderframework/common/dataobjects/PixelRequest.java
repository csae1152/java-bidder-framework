package com.appnexus.bidderframework.common.dataobjects;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 11:38:01 AM
 */
public class PixelRequest {

    private Date timestamp;
    private String queryString;
    private int memberID;
    private String userID;
    private String userData;
    private int pixelID;
    private String ipAddress;
    private String userAgent;
    private String redirectURL;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getPixelID() {
        return pixelID;
    }

    public void setPixelID(int pixelID) {
        this.pixelID = pixelID;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PixelRequest)) return false;

        PixelRequest that = (PixelRequest) o;

        if (memberID != that.memberID) return false;
        if (pixelID != that.pixelID) return false;
        if (ipAddress != null ? !ipAddress.equals(that.ipAddress) : that.ipAddress != null) return false;
        if (queryString != null ? !queryString.equals(that.queryString) : that.queryString != null) return false;
        if (redirectURL != null ? !redirectURL.equals(that.redirectURL) : that.redirectURL != null) return false;
        if (userAgent != null ? !userAgent.equals(that.userAgent) : that.userAgent != null) return false;
        if (userData != null ? !userData.equals(that.userData) : that.userData != null) return false;
        if (userID != null ? !userID.equals(that.userID) : that.userID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = queryString != null ? queryString.hashCode() : 0;
        result = 31 * result + memberID;
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        result = 31 * result + (userData != null ? userData.hashCode() : 0);
        result = 31 * result + pixelID;
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        result = 31 * result + (userAgent != null ? userAgent.hashCode() : 0);
        result = 31 * result + (redirectURL != null ? redirectURL.hashCode() : 0);
        return result;
    }
}

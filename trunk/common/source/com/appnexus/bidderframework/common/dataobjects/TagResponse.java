package com.appnexus.bidderframework.common.dataobjects;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 11:41:13 AM
 */
public class TagResponse {

    private int memberID;
    private boolean exclusive;
    private boolean noBid;
    private boolean noPriceReduction;
    private double price;
    private double bidderRevShare;
    private double bidderMinimumCPM;
    private int creativeID;
    private List<CustomMacro> customMacros;
    private String userData;
    private String userDataJS;
    private String defaultMediaURL;
    private String buyerCurrency;
    private String creativeCode;
    private String auctionID;
    private String customNotifyData;
    private String clickURL;
    private String pixelURL;
    private PixelType pixelType;

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public boolean isNoBid() {
        return noBid;
    }

    public void setNoBid(boolean noBid) {
        this.noBid = noBid;
    }

    public boolean isNoPriceReduction() {
        return noPriceReduction;
    }

    public void setNoPriceReduction(boolean noPriceReduction) {
        this.noPriceReduction = noPriceReduction;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBidderRevShare() {
        return bidderRevShare;
    }

    public void setBidderRevShare(double bidderRevShare) {
        this.bidderRevShare = bidderRevShare;
    }

    public double getBidderMinimumCPM() {
        return bidderMinimumCPM;
    }

    public void setBidderMinimumCPM(double bidderMinimumCPM) {
        this.bidderMinimumCPM = bidderMinimumCPM;
    }

    public int getCreativeID() {
        return creativeID;
    }

    public void setCreativeID(int creativeID) {
        this.creativeID = creativeID;
    }

    public List<CustomMacro> getCustomMacros() {
        return customMacros;
    }

    public void setCustomMacros(List<CustomMacro> customMacros) {
        this.customMacros = customMacros;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public String getUserDataJS() {
        return userDataJS;
    }

    public void setUserDataJS(String userDataJS) {
        this.userDataJS = userDataJS;
    }

    public String getDefaultMediaURL() {
        return defaultMediaURL;
    }

    public void setDefaultMediaURL(String defaultMediaURL) {
        this.defaultMediaURL = defaultMediaURL;
    }

    public String getBuyerCurrency() {
        return buyerCurrency;
    }

    public void setBuyerCurrency(String buyerCurrency) {
        this.buyerCurrency = buyerCurrency;
    }

    public String getCreativeCode() {
        return creativeCode;
    }

    public void setCreativeCode(String creativeCode) {
        this.creativeCode = creativeCode;
    }

    public String getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }

    public String getCustomNotifyData() {
        return customNotifyData;
    }

    public void setCustomNotifyData(String customNotifyData) {
        this.customNotifyData = customNotifyData;
    }

    public String getClickURL() {
        return clickURL;
    }

    public void setClickURL(String clickURL) {
        this.clickURL = clickURL;
    }

    public String getPixelURL() {
        return pixelURL;
    }

    public void setPixelURL(String pixelURL) {
        this.pixelURL = pixelURL;
    }

    public PixelType getPixelType() {
        return pixelType;
    }

    public void setPixelType(PixelType pixelType) {
        this.pixelType = pixelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TagResponse)) return false;

        TagResponse that = (TagResponse) o;

        if (Double.compare(that.bidderMinimumCPM, bidderMinimumCPM) != 0) return false;
        if (Double.compare(that.bidderRevShare, bidderRevShare) != 0) return false;
        if (creativeID != that.creativeID) return false;
        if (exclusive != that.exclusive) return false;
        if (memberID != that.memberID) return false;
        if (noBid != that.noBid) return false;
        if (noPriceReduction != that.noPriceReduction) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (auctionID != null ? !auctionID.equals(that.auctionID) : that.auctionID != null) return false;
        if (buyerCurrency != null ? !buyerCurrency.equals(that.buyerCurrency) : that.buyerCurrency != null)
            return false;
        if (clickURL != null ? !clickURL.equals(that.clickURL) : that.clickURL != null) return false;
        if (creativeCode != null ? !creativeCode.equals(that.creativeCode) : that.creativeCode != null) return false;
        if (customMacros != null ? !customMacros.equals(that.customMacros) : that.customMacros != null) return false;
        if (customNotifyData != null ? !customNotifyData.equals(that.customNotifyData) : that.customNotifyData != null)
            return false;
        if (defaultMediaURL != null ? !defaultMediaURL.equals(that.defaultMediaURL) : that.defaultMediaURL != null)
            return false;
        if (pixelType != that.pixelType) return false;
        if (pixelURL != null ? !pixelURL.equals(that.pixelURL) : that.pixelURL != null) return false;
        if (userData != null ? !userData.equals(that.userData) : that.userData != null) return false;
        if (userDataJS != null ? !userDataJS.equals(that.userDataJS) : that.userDataJS != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = memberID;
        result = 31 * result + (exclusive ? 1 : 0);
        result = 31 * result + (noBid ? 1 : 0);
        result = 31 * result + (noPriceReduction ? 1 : 0);
        temp = price != +0.0d ? Double.doubleToLongBits(price) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = bidderRevShare != +0.0d ? Double.doubleToLongBits(bidderRevShare) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = bidderMinimumCPM != +0.0d ? Double.doubleToLongBits(bidderMinimumCPM) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + creativeID;
        result = 31 * result + (customMacros != null ? customMacros.hashCode() : 0);
        result = 31 * result + (userData != null ? userData.hashCode() : 0);
        result = 31 * result + (userDataJS != null ? userDataJS.hashCode() : 0);
        result = 31 * result + (defaultMediaURL != null ? defaultMediaURL.hashCode() : 0);
        result = 31 * result + (buyerCurrency != null ? buyerCurrency.hashCode() : 0);
        result = 31 * result + (creativeCode != null ? creativeCode.hashCode() : 0);
        result = 31 * result + (auctionID != null ? auctionID.hashCode() : 0);
        result = 31 * result + (customNotifyData != null ? customNotifyData.hashCode() : 0);
        result = 31 * result + (clickURL != null ? clickURL.hashCode() : 0);
        result = 31 * result + (pixelURL != null ? pixelURL.hashCode() : 0);
        result = 31 * result + (pixelType != null ? pixelType.hashCode() : 0);
        return result;
    }
}

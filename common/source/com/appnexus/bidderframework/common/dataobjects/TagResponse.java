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
}

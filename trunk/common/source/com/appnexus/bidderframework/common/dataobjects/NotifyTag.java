package com.appnexus.bidderframework.common.dataobjects;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 11:58:36 AM
 */
public class NotifyTag {

    private int tagID;
    private String auctionID;
    private boolean validBid;
    private String error;
    private int memberID;
    private double priceToWin;
    private double priceBid;
    private double pricePaid;
    private double bidderFees;
    private double priceSoldFor;
    private String customNotifyData;
    private NotifyType notifyType;
    private Tag tag;

    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

    public String getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(String auctionID) {
        this.auctionID = auctionID;
    }

    public boolean isValidBid() {
        return validBid;
    }

    public void setValidBid(boolean validBid) {
        this.validBid = validBid;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public double getPriceToWin() {
        return priceToWin;
    }

    public void setPriceToWin(double priceToWin) {
        this.priceToWin = priceToWin;
    }

    public double getPriceBid() {
        return priceBid;
    }

    public void setPriceBid(double priceBid) {
        this.priceBid = priceBid;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public double getBidderFees() {
        return bidderFees;
    }

    public void setBidderFees(double bidderFees) {
        this.bidderFees = bidderFees;
    }

    public double getPriceSoldFor() {
        return priceSoldFor;
    }

    public void setPriceSoldFor(double priceSoldFor) {
        this.priceSoldFor = priceSoldFor;
    }

    public String getCustomNotifyData() {
        return customNotifyData;
    }

    public void setCustomNotifyData(String customNotifyData) {
        this.customNotifyData = customNotifyData;
    }

    public NotifyType getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(NotifyType notifyType) {
        this.notifyType = notifyType;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}

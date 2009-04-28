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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotifyTag)) return false;

        NotifyTag notifyTag = (NotifyTag) o;

        if (Double.compare(notifyTag.bidderFees, bidderFees) != 0) return false;
        if (memberID != notifyTag.memberID) return false;
        if (Double.compare(notifyTag.priceBid, priceBid) != 0) return false;
        if (Double.compare(notifyTag.pricePaid, pricePaid) != 0) return false;
        if (Double.compare(notifyTag.priceSoldFor, priceSoldFor) != 0) return false;
        if (Double.compare(notifyTag.priceToWin, priceToWin) != 0) return false;
        if (tagID != notifyTag.tagID) return false;
        if (validBid != notifyTag.validBid) return false;
        if (auctionID != null ? !auctionID.equals(notifyTag.auctionID) : notifyTag.auctionID != null) return false;
        if (customNotifyData != null ? !customNotifyData.equals(notifyTag.customNotifyData) : notifyTag.customNotifyData != null)
            return false;
        if (error != null ? !error.equals(notifyTag.error) : notifyTag.error != null) return false;
        if (notifyType != notifyTag.notifyType) return false;
        if (tag != null ? !tag.equals(notifyTag.tag) : notifyTag.tag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = tagID;
        result = 31 * result + (auctionID != null ? auctionID.hashCode() : 0);
        result = 31 * result + (validBid ? 1 : 0);
        result = 31 * result + (error != null ? error.hashCode() : 0);
        result = 31 * result + memberID;
        temp = priceToWin != +0.0d ? Double.doubleToLongBits(priceToWin) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = priceBid != +0.0d ? Double.doubleToLongBits(priceBid) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = pricePaid != +0.0d ? Double.doubleToLongBits(pricePaid) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = bidderFees != +0.0d ? Double.doubleToLongBits(bidderFees) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = priceSoldFor != +0.0d ? Double.doubleToLongBits(priceSoldFor) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (customNotifyData != null ? customNotifyData.hashCode() : 0);
        result = 31 * result + (notifyType != null ? notifyType.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}

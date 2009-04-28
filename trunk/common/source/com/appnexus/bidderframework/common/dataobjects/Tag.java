package com.appnexus.bidderframework.common.dataobjects;
/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 2:55:08 PM
 */
public class Tag {

    private int tagID;
    private String auctionID; // 37 letter long auction-id
    private int width;
    private int height;
    private String position;
    private TagFormat tagFormat;
    private int adProfileID;
    private double reservePrice;
    private double estimatedMinimumPrice;
    private int defaultCreativeID;
    private String campaign;
    private String placement;
    private String tagData;

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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public TagFormat getTagFormat() {
        return tagFormat;
    }

    public void setTagFormat(TagFormat tagFormat) {
        this.tagFormat = tagFormat;
    }

    public int getAdProfileID() {
        return adProfileID;
    }

    public void setAdProfileID(int adProfileID) {
        this.adProfileID = adProfileID;
    }

    public double getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(double reservePrice) {
        this.reservePrice = reservePrice;
    }

    public double getEstimatedMinimumPrice() {
        return estimatedMinimumPrice;
    }

    public void setEstimatedMinimumPrice(double estimatedMinimumPrice) {
        this.estimatedMinimumPrice = estimatedMinimumPrice;
    }

    public int getDefaultCreativeID() {
        return defaultCreativeID;
    }

    public void setDefaultCreativeID(int defaultCreativeID) {
        this.defaultCreativeID = defaultCreativeID;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getTagData() {
        return tagData;
    }

    public void setTagData(String tagData) {
        this.tagData = tagData;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagID=" + tagID +
                ", auctionID='" + auctionID + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", position='" + position + '\'' +
                ", tagFormat=" + tagFormat +
                ", adProfileID=" + adProfileID +
                ", reservePrice=" + reservePrice +
                ", estimatedMinimumPrice=" + estimatedMinimumPrice +
                ", defaultCreativeID=" + defaultCreativeID +
                ", campaign='" + campaign + '\'' +
                ", placement='" + placement + '\'' +
                ", otherData='" + tagData + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;

        Tag tag = (Tag) o;

        if (adProfileID != tag.adProfileID) return false;
        if (defaultCreativeID != tag.defaultCreativeID) return false;
        if (Double.compare(tag.estimatedMinimumPrice, estimatedMinimumPrice) != 0) return false;
        if (height != tag.height) return false;
        if (Double.compare(tag.reservePrice, reservePrice) != 0) return false;
        if (tagID != tag.tagID) return false;
        if (width != tag.width) return false;
        if (auctionID != null ? !auctionID.equals(tag.auctionID) : tag.auctionID != null) return false;
        if (campaign != null ? !campaign.equals(tag.campaign) : tag.campaign != null) return false;
        if (placement != null ? !placement.equals(tag.placement) : tag.placement != null) return false;
        if (position != null ? !position.equals(tag.position) : tag.position != null) return false;
        if (tagData != null ? !tagData.equals(tag.tagData) : tag.tagData != null) return false;
        if (tagFormat != tag.tagFormat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = tagID;
        result = 31 * result + (auctionID != null ? auctionID.hashCode() : 0);
        result = 31 * result + width;
        result = 31 * result + height;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (tagFormat != null ? tagFormat.hashCode() : 0);
        result = 31 * result + adProfileID;
        temp = reservePrice != +0.0d ? Double.doubleToLongBits(reservePrice) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = estimatedMinimumPrice != +0.0d ? Double.doubleToLongBits(estimatedMinimumPrice) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + defaultCreativeID;
        result = 31 * result + (campaign != null ? campaign.hashCode() : 0);
        result = 31 * result + (placement != null ? placement.hashCode() : 0);
        result = 31 * result + (tagData != null ? tagData.hashCode() : 0);
        return result;
    }
}

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
}

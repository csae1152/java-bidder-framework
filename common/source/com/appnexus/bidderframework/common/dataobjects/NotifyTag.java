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
}

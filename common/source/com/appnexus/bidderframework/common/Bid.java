package com.appnexus.bidderframework.common;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 2:57:13 PM
 */
public class Bid {

    private String userID;
    private String userAgent;
    private List<String> acceptedLanguages;
    private boolean noFlash;
    private boolean noCookies;
    private Gender gender;
    private int age;
    private String otherQSData;
    private String ipAddress;
    private String country;
    private String region;
    private String city;
    private String postalCode;
    private int dma;
    private String timeZone;

    // only if tag.hide_referrer is false [to be implemented in writer not here]
    private String url;

    private InventoryClass inventoryClass;
    private boolean withinIFrame;
    private int lucidLevel;
    private LucidInfo lucidInfo;
    private String dataranJSON;
    private IXIData ixiData;
    private List<Segment> segments;

    private String userData;
    private String userDataJSON;
    private int totalImpressionCount;
    private int sessionImpressionCount;
    private int totalClickCount;
    private int minutesSinceLastImpression;

}

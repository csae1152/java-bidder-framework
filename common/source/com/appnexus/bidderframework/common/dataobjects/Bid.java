package com.appnexus.bidderframework.common.dataobjects;

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
    private String acceptedLanguages;
    private boolean noFlash;
    private boolean noCookies;
    private Gender gender;
    private int age;
    private String qsData;
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
    private LucidData lucidData;
    private String dataranJSON;
    private IXIData ixiData;
    private List<Segment> segments;

    private String userData;
    private String userDataJSON;
    private int totalImpressionCount;
    private int sessionImpressionCount;
    private int totalClickCount;
    private int minutesSinceLastImpression;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getAcceptedLanguages() {
        return acceptedLanguages;
    }

    public void setAcceptedLanguages(String acceptedLanguages) {
        this.acceptedLanguages = acceptedLanguages;
    }

    public boolean isNoFlash() {
        return noFlash;
    }

    public void setNoFlash(boolean noFlash) {
        this.noFlash = noFlash;
    }

    public boolean isNoCookies() {
        return noCookies;
    }

    public void setNoCookies(boolean noCookies) {
        this.noCookies = noCookies;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQsData() {
        return qsData;
    }

    public void setQsData(String qsData) {
        this.qsData = qsData;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getDma() {
        return dma;
    }

    public void setDma(int dma) {
        this.dma = dma;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public InventoryClass getInventoryClass() {
        return inventoryClass;
    }

    public void setInventoryClass(InventoryClass inventoryClass) {
        this.inventoryClass = inventoryClass;
    }

    public boolean isWithinIFrame() {
        return withinIFrame;
    }

    public void setWithinIFrame(boolean withinIFrame) {
        this.withinIFrame = withinIFrame;
    }

    public LucidData getLucidData() {
        return lucidData;
    }

    public void setLucidData(LucidData lucidData) {
        this.lucidData = lucidData;
    }

    public String getDataranJSON() {
        return dataranJSON;
    }

    public void setDataranJSON(String dataranJSON) {
        this.dataranJSON = dataranJSON;
    }

    public IXIData getIxiData() {
        return ixiData;
    }

    public void setIxiData(IXIData ixiData) {
        this.ixiData = ixiData;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public String getUserDataJSON() {
        return userDataJSON;
    }

    public void setUserDataJSON(String userDataJSON) {
        this.userDataJSON = userDataJSON;
    }

    public int getTotalImpressionCount() {
        return totalImpressionCount;
    }

    public void setTotalImpressionCount(int totalImpressionCount) {
        this.totalImpressionCount = totalImpressionCount;
    }

    public int getSessionImpressionCount() {
        return sessionImpressionCount;
    }

    public void setSessionImpressionCount(int sessionImpressionCount) {
        this.sessionImpressionCount = sessionImpressionCount;
    }

    public int getTotalClickCount() {
        return totalClickCount;
    }

    public void setTotalClickCount(int totalClickCount) {
        this.totalClickCount = totalClickCount;
    }

    public int getMinutesSinceLastImpression() {
        return minutesSinceLastImpression;
    }

    public void setMinutesSinceLastImpression(int minutesSinceLastImpression) {
        this.minutesSinceLastImpression = minutesSinceLastImpression;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "userID='" + userID + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", acceptedLanguages=" + acceptedLanguages +
                ", noFlash=" + noFlash +
                ", noCookies=" + noCookies +
                ", gender=" + gender +
                ", age=" + age +
                ", otherQSData='" + qsData + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", dma=" + dma +
                ", timeZone='" + timeZone + '\'' +
                ", url='" + url + '\'' +
                ", inventoryClass=" + inventoryClass +
                ", withinIFrame=" + withinIFrame +
                ", lucidInfo=" + lucidData +
                ", dataranJSON='" + dataranJSON + '\'' +
                ", ixiData=" + ixiData +
                ", segments=" + segments +
                ", userData='" + userData + '\'' +
                ", userDataJSON='" + userDataJSON + '\'' +
                ", totalImpressionCount=" + totalImpressionCount +
                ", sessionImpressionCount=" + sessionImpressionCount +
                ", totalClickCount=" + totalClickCount +
                ", minutesSinceLastImpression=" + minutesSinceLastImpression +
                '}';
    }
}

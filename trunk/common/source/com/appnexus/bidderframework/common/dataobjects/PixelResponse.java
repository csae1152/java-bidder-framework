package com.appnexus.bidderframework.common.dataobjects;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:08:35 PM
 */
public class PixelResponse {

    private String userData;
    private String userDataJS;
    private String redirectURL;
    private List<Segment> segmentsAdd;
    private List<Segment> segmentsRemove;

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

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    public List<Segment> getSegmentsAdd() {
        return segmentsAdd;
    }

    public void setSegmentsAdd(List<Segment> segmentsAdd) {
        this.segmentsAdd = segmentsAdd;
    }

    public List<Segment> getSegmentsRemove() {
        return segmentsRemove;
    }

    public void setSegmentsRemove(List<Segment> segmentsRemove) {
        this.segmentsRemove = segmentsRemove;
    }
}

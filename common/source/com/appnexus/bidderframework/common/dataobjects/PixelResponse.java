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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PixelResponse)) return false;

        PixelResponse that = (PixelResponse) o;

        if (redirectURL != null ? !redirectURL.equals(that.redirectURL) : that.redirectURL != null) return false;
        if (segmentsAdd != null ? !segmentsAdd.equals(that.segmentsAdd) : that.segmentsAdd != null) return false;
        if (segmentsRemove != null ? !segmentsRemove.equals(that.segmentsRemove) : that.segmentsRemove != null)
            return false;
        if (userData != null ? !userData.equals(that.userData) : that.userData != null) return false;
        if (userDataJS != null ? !userDataJS.equals(that.userDataJS) : that.userDataJS != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userData != null ? userData.hashCode() : 0;
        result = 31 * result + (userDataJS != null ? userDataJS.hashCode() : 0);
        result = 31 * result + (redirectURL != null ? redirectURL.hashCode() : 0);
        result = 31 * result + (segmentsAdd != null ? segmentsAdd.hashCode() : 0);
        result = 31 * result + (segmentsRemove != null ? segmentsRemove.hashCode() : 0);
        return result;
    }
}

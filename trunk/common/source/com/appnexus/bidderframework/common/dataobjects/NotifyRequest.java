package com.appnexus.bidderframework.common.dataobjects;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 11:55:53 AM
 */
public class NotifyRequest {

    private Date timestamp;
    private boolean fail;
    private String error;
    private int responseTime; // milliseconds
    private Bid bid; // only for full notify
    private List<NotifyTag> notifyTags;
    private Tag tag; // only in full notify

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isFail() {
        return fail;
    }

    public void setFail(boolean fail) {
        this.fail = fail;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public List<NotifyTag> getNotifyTags() {
        return notifyTags;
    }

    public void setNotifyTags(List<NotifyTag> notifyTags) {
        this.notifyTags = notifyTags;
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
        if (!(o instanceof NotifyRequest)) return false;

        NotifyRequest that = (NotifyRequest) o;

        if (fail != that.fail) return false;
        if (responseTime != that.responseTime) return false;
        if (bid != null ? !bid.equals(that.bid) : that.bid != null) return false;
        if (error != null ? !error.equals(that.error) : that.error != null) return false;
        if (notifyTags != null ? !notifyTags.equals(that.notifyTags) : that.notifyTags != null) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fail ? 1 : 0;
        result = 31 * result + (error != null ? error.hashCode() : 0);
        result = 31 * result + responseTime;
        result = 31 * result + (bid != null ? bid.hashCode() : 0);
        result = 31 * result + (notifyTags != null ? notifyTags.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}

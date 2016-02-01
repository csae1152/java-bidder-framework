package com.appnexus.bidderframework.common.dataobjects;
/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 2:54:12 PM
 * 
 * updated by @author Helmut Steiner
 * 
 */
public class TractorId {

    private int tractorId;

    public int getTractorId() {
        return tractorId;
    }

    public void setTractorId(int tractorId) {
        this.tractorId = tractorId;
    }

    @Override
    public String toString() {
        return "Tractor{" +
                "tractorID=" + tractorID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;

        Member member = (Member) o;

        if (memberID != member.memberID) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return memberID;
    }
}

package com.appnexus.bidderframework.common.dataobjects;
/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 2:54:12 PM
 */
public class Member {

    private int memberID;

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +
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

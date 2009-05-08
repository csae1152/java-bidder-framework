package com.appnexus.bidderframework.common.test;

import org.junit.Test;
import org.junit.Assert;
import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.dataobjects.Bid;
import com.appnexus.bidderframework.common.dataobjects.Segment;
import com.appnexus.bidderframework.common.dataobjects.Member;
import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.ImpBusInvalidDataException;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: May 8, 2009
 * Time: 10:04:09 AM
 */
public class BidRequestSegmentTest {

    @Test
    public void segmentTest() throws IOException, ImpBusFormatException, ImpBusInvalidDataException {
        BidRequest bidRequestOriginal = new BidRequest();
        Bid bid = new Bid();
        bid.setUserID("33_tester");
        bidRequestOriginal.setBid(bid);
        bidRequestOriginal.setTimestamp(new Date());
        List<Member> members = new ArrayList<Member>();
        bidRequestOriginal.setMembers(members);
        List<Segment> segments = new ArrayList<Segment>();
        bid.setSegments(segments);
        int memberID = (int) (Math.random() * 1000);
        segments.add(createSegment("code1", "cnn", "shorty1", memberID));
        members.add(createMember(memberID));
        memberID = (int) (Math.random() * 1000);
        segments.add(createSegment("code2", "yahoo", "shorty2", memberID));
        members.add(createMember(memberID));
        memberID = (int) (Math.random() * 1000);
        segments.add(createSegment("code3", "google", "shorty3", memberID));
        members.add(createMember(memberID));
        memberID = (int) (Math.random() * 1000);
        segments.add(createSegment("code4", "appnexus", "shorty4", memberID));
        members.add(createMember(memberID));

        TestUtils.writeRequest(bidRequestOriginal, "common/test/test1.original.json", false);
        BidRequest bidRequestMirrored = (BidRequest) TestUtils.getDataObject("common/test/test1.original.json");
        TestUtils.writeRequest(bidRequestMirrored, "common/test/test1.mirrored.json", false);
        Assert.assertEquals(bidRequestOriginal, bidRequestMirrored);
    }

    private Member createMember(int memberID) {
        Member member = new Member();
        member.setMemberID(memberID);
        return member;
    }


    private Segment createSegment(String code, String provider, String shortname, int memberID) {
        Segment seg = new Segment();
        seg.setSegmentID((int) (Math.random() * 1000));
        seg.setCode(code);
        seg.setMemberID(memberID);
        seg.setPrice((float) (Math.random() + 3));
        seg.setProvider(provider);
        seg.setSegmentID((int) (Math.random() * 234234));
        seg.setShortname(shortname);
        return seg;
    }
}

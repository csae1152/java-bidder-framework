package com.appnexus.bidderframework.common.test;

import org.junit.Test;
import org.junit.Assert;
import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.ImpBusFormatException;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 9, 2009
 * Time: 7:08:33 PM
 */
public class BidRequestWriter1Test {

    @Test
    public void testMirroringBidRequests() throws IOException, ImpBusFormatException {
        BidRequest[] brs = TestUtils.getOriginalAndMirroredBidRequest("test/bid_request.json.txt");
        Assert.assertEquals("bid_request.json.txt failed", brs[0], brs[1]);

        brs = TestUtils.getOriginalAndMirroredBidRequest("test/bid_request2.json.txt");
        Assert.assertEquals("bid_request2.json.txt failed", brs[0], brs[1]);
    }

}

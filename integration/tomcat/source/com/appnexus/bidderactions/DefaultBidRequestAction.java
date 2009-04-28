package com.appnexus.bidderactions;

import com.appnexus.bidderframework.common.runtime.actions.IBidRequestAction;
import com.appnexus.bidderframework.common.dataobjects.BidResponse;
import com.appnexus.bidderframework.common.dataobjects.BidRequest;
import com.appnexus.bidderframework.common.json.JSonWriter;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 21, 2009
 * Time: 10:30:57 AM
 */
public class DefaultBidRequestAction implements IBidRequestAction {
    private static final Logger LOG = Logger.getLogger(DefaultBidRequestAction.class);
    public BidResponse handleBidRequest(BidRequest bidRequest) {
        LOG.info("Start Handling BidRequest");
        String fileName = "BidRequest." + System.currentTimeMillis() + ".json";
        File file = new File(fileName);
        try {
            boolean nf = file.createNewFile();
            LOG.debug("file is ready for writing [" + file.getAbsolutePath() + ", created=" + nf + "]");
            JSonWriter jsw = new JSonWriter();
            jsw.writeBidRequest(bidRequest, file);
            LOG.debug("file has been written [" + file.getAbsolutePath() + ", created=" + nf + "]");
        } catch (IOException e) {
            LOG.error("couldn't create the file: " + file.getAbsolutePath() + " was an error: " + e.getMessage(), e);
        }
        LOG.info("Done Handling BidRequest");
        return new BidResponse();
    }
}

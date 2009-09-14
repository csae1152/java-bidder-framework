package com.appnexus.bidderframework.common.json;

import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.dataobjects.NotifyTag;
import com.appnexus.bidderframework.common.dataobjects.NotifyType;
import com.appnexus.bidderframework.common.utils.IOUtils;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:15:35 PM
 */

public class NotifyTagHandler extends AbstractHandler<NotifyTag>{

    private final NumberFormat FORMAT_3_PLACES;

    private NotifyTagHandler() {
        FORMAT_3_PLACES = NumberFormat.getInstance();
        FORMAT_3_PLACES.setMaximumFractionDigits(3);
    }

    public void write(Writer writer) throws IOException {
        writer.append("\"id\":").append(String.valueOf(getDataObject().getTagID()));
        writer.append(",").append(IOUtils.LS);
        writer.append("\"auction_id\":\"").append(getDataObject().getAuctionID()).append("\"");
        writer.append(",").append(IOUtils.LS);
        writer.append("\"valid_bid\":").append(String.valueOf(getDataObject().isValidBid()));
        writer.append(",").append(IOUtils.LS);
        if (getDataObject().getMemberID() > 0) {
            writer.append("\"member_id\":").append(String.valueOf(getDataObject().getMemberID()));
            writer.append(",").append(IOUtils.LS);
        }
        if (getDataObject().getPriceToWin() >= 0) {
            writer.append("\"price_to_win\":").append(FORMAT_3_PLACES.format(getDataObject().getPriceToWin()));
            writer.append(",").append(IOUtils.LS);
        }
        if (getDataObject().getMemberID() >= 0) {
            writer.append("\"price_bid\":").append(FORMAT_3_PLACES.format(getDataObject().getPriceBid()));
            writer.append(",").append(IOUtils.LS);
        }
        if (getDataObject().getPricePaid() >= 0) {
            writer.append("\"price_paid\":").append(FORMAT_3_PLACES.format(getDataObject().getPricePaid()));
            writer.append(",").append(IOUtils.LS);
        }
        if (getDataObject().getBidderFees() >= 0) {
            writer.append("\"bidder_fees\":").append(FORMAT_3_PLACES.format(getDataObject().getBidderFees()));
            writer.append(",").append(IOUtils.LS);
        }
        if (getDataObject().getPriceSoldFor() >= 0) {
            writer.append("\"price_sold_for\":").append(FORMAT_3_PLACES.format(getDataObject().getPriceSoldFor()));
            writer.append(",").append(IOUtils.LS);
        }
        if (getDataObject().getCustomNotifyData() != null) {
            writer.append("\"custom_notify_data\":\"").append(IOUtils.encodeEscapeChars(getDataObject().getCustomNotifyData())).append("\"");
            writer.append(",").append(IOUtils.LS);
        }
        writer.append("\"notify_type\":\"").append(String.valueOf(getDataObject().getNotifyType())).append("\"");
        writer.append(",").append(IOUtils.LS);
        if (getDataObject().getTagID() > 0) {
            writer.append("\"full_tag_info\":{");
            TagHandler th = TagHandler.get();
            th.setDataObject(getDataObject().getTag());
            th.write(writer);
            writer.append("}");
        }
        writer.append(IOUtils.LS);
    }

    public void startArray(String arrayName) {
    }

    public void startObject(String objectName) {
        if ("notify_type".equals(objectName)) {
            transferControlToNested(this, TagHandler.get(), getDataObject().getTag());
        }
    }

    public void startObjectInArray(String arrayName) {
    }


    
    public void readValue(String fieldName, String value) throws ImpBusFormatException {
        if ("auction_id".equals(fieldName)) {
            getDataObject().setAuctionID(value);
        } else if ("custom_notify_data".equals(fieldName)) {
            getDataObject().setCustomNotifyData(value);
        } else if ("notify_type".equals(fieldName)) {
            getDataObject().setNotifyType(NotifyType.getFromString(value));
        }
    }

    public void readValue(String fieldName, int value) {
        if ("id".equals(fieldName)) {
            getDataObject().setTagID(value);
        } else if ("member_id".equals(fieldName)) {
            getDataObject().setMemberID(value);
        }

    }

    public void readValue(String fieldName, float value) {
        if ("price_to_win".equals(fieldName)) {
            getDataObject().setPriceToWin(value);
        } else if ("price_bid".equals(fieldName)) {
            getDataObject().setPriceBid(value);
        } else if ("price_paid".equals(fieldName)) {
            getDataObject().setPricePaid(value);
        } else if ("bidder_fees".equals(fieldName)) {
            getDataObject().setBidderFees(value);
        } else if ("price_sold_for".equals(fieldName)) {
            getDataObject().setPriceSoldFor(value);
        }
    }

    public void readValue(String fieldName, boolean value) {
        if ("valid_bid".equals(fieldName)) {
            getDataObject().setValidBid(value);
        }
    }

    private static ThreadLocal<NotifyTagHandler> factoryCache = new ThreadLocal<NotifyTagHandler>() {
        public synchronized NotifyTagHandler initialValue() {
            return new NotifyTagHandler();
        }

        public synchronized NotifyTagHandler get() {
            return super.get();
        }

        public synchronized void set(NotifyTagHandler value) {
            super.set(value);
        }
    };

    public static NotifyTagHandler get() {
        return factoryCache.get();
    }
}


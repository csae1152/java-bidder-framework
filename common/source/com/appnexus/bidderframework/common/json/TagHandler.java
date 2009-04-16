package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.Tag;
import com.appnexus.bidderframework.common.dataobjects.TagFormat;
import com.appnexus.bidderframework.common.utils.IOUtils;
import com.appnexus.bidderframework.common.ImpBusFormatException;

import java.io.Writer;
import java.io.IOException;
import java.text.NumberFormat;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:49:17 PM
 */
public class TagHandler extends AbstractHandler<Tag> {

    private final NumberFormat FORMAT_3_PLACES;
    private final NumberFormat FORMAT_4_PLACES;

    private TagHandler() {
        FORMAT_3_PLACES = NumberFormat.getInstance();
        FORMAT_3_PLACES.setMaximumFractionDigits(3);
        FORMAT_4_PLACES = NumberFormat.getInstance();
        FORMAT_4_PLACES.setMaximumFractionDigits(4);
    }

    public void write(Writer writer) throws IOException {
        Tag tag = getDataObject();
        writer.append("\"id\":").append(String.valueOf(tag.getTagID())).append(",").append(IOUtils.LS);
        writer.append("\"auction_id\":\"").append(tag.getAuctionID()).append("\",").append(IOUtils.LS);
        writer.append("\"size\":\"").append(String.valueOf(tag.getWidth())).append('x').append(String.valueOf(tag.getHeight())).append("\",").append(IOUtils.LS);
        writer.append("\"position\":\"").append(tag.getPosition()).append("\",").append(IOUtils.LS);
        writer.append("\"tag_format\":\"").append(String.valueOf(tag.getTagFormat())).append("\"");
        if (tag.getAdProfileID() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"ad_profile_id\":").append(String.valueOf(tag.getAdProfileID()));
        }
        if (tag.getReservePrice() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"reserve_price\":").append(FORMAT_3_PLACES.format(tag.getReservePrice()));
        }
        if (tag.getEstimatedMinimumPrice() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"estimated_minimum_price\":").append(FORMAT_4_PLACES.format(tag.getEstimatedMinimumPrice()));
        }
        if (tag.getDefaultCreativeID() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"default_creative_id\":").append(String.valueOf(tag.getDefaultCreativeID()));
        }
        if (tag.getCampaign() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"campaign\":\"").append(String.valueOf(tag.getCampaign())).append("\"");
        }
        if (tag.getPlacement() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"placement\":\"").append(String.valueOf(tag.getPlacement())).append("\"");
        }
        if (tag.getTagData() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"tag_data\":\"").append(String.valueOf(tag.getTagData())).append("\"");
        }
    }

    public void startArray(String arrayName) {

    }

    public void startObject(String objectName) {

    }

    public void startObjectInArray(String arrayName) {

    }

    public void readValue(String fieldName, int value) {
        if ("id".equals(fieldName)) {
            getDataObject().setTagID(value);
        } else if ("ad_profile_id".equals(fieldName)) {
            getDataObject().setAdProfileID(value);
        } else if ("default_creative_id".equals(fieldName)) {
            getDataObject().setDefaultCreativeID(value);
        }
    }

    public void readValue(String fieldName, float value) {
        if ("reserve_price".equals(fieldName)) {
            getDataObject().setReservePrice(value);
        } else if ("estimated_minimum_price".equals(fieldName)) {
            getDataObject().setEstimatedMinimumPrice(value);
        }
    }

    public void readValue(String fieldName, boolean value) {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {
        if ("auction_id".equals(fieldName)) {
            getDataObject().setAuctionID(value);
        } else if ("size".equals(fieldName)) {
            int c = value.indexOf('x');
            if (c == -1) {
                throw new ImpBusFormatException("The Json size for TAG must be expressed as <integer>x<integer>");
            }
            try {
                getDataObject().setWidth(Integer.parseInt(value.substring(0, c)));
                getDataObject().setHeight(Integer.parseInt(value.substring(c + 1)));
            } catch (NumberFormatException e) {
                throw new ImpBusFormatException("The Json size for TAG must be expressed as <integer>x<integer>", e);
            }
        } else if ("position".equals(fieldName)) {
            getDataObject().setPosition(value);
        } else if ("campain".equals(fieldName)) {
            getDataObject().setCampaign(value);
        } else if ("placement".equals(fieldName)) {
            getDataObject().setPlacement(value);
        } else if ("tag_data".equals(fieldName)) {
            getDataObject().setTagData(value);
        } else if ("tag_format".equals(fieldName)) {
            if ("iframe".equals(value)) {
                getDataObject().setTagFormat(TagFormat.TAG_IFRAME);
            } else if ("javascript".equals(value)) {
                getDataObject().setTagFormat(TagFormat.TAG_JS);
            }
        }
    }

    private static ThreadLocal<TagHandler> factoryCache = new ThreadLocal<TagHandler>() {
        public synchronized TagHandler initialValue() {
            return new TagHandler();
        }

        public synchronized TagHandler get() {
            return super.get();
        }

        public synchronized void set(TagHandler value) {
            super.set(value);
        }
    };

    public static TagHandler get() {
        return factoryCache.get();
    }
}

package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.utils.IOUtils;
import com.appnexus.bidderframework.common.dataobjects.TagResponse;
import com.appnexus.bidderframework.common.dataobjects.CustomMacro;
import com.appnexus.bidderframework.common.dataobjects.PixelType;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 15, 2009
 * Time: 12:17:26 PM
 */

public class TagResponseHandler extends AbstractHandler<TagResponse>{

    private TagResponseHandler() {

    }
    
    public void write(Writer writer) throws IOException {
        writer.append("\"member_id\":").append(String.valueOf(getDataObject().getMemberID()));
        writer.append(",").append(IOUtils.LS);
        writer.append("\"exclusive\":").append(String.valueOf(getDataObject().isExclusive()));
        writer.append(",").append(IOUtils.LS);
        writer.append("\"no_bid\":").append(String.valueOf(getDataObject().isNoBid()));
        writer.append(",").append(IOUtils.LS);
        writer.append("\"no_price_reduction\":").append(String.valueOf(getDataObject()));
        writer.append(",").append(IOUtils.LS);
        writer.append("\"price\":").append(String.valueOf(getDataObject().getPrice()));
        writer.append(",").append(IOUtils.LS);
        writer.append("\"bidder_revshare\":").append(String.valueOf(getDataObject().getBidderRevShare()));
        writer.append(",").append(IOUtils.LS);
        writer.append("\"bidder_minimum_cpm\":").append(String.valueOf(getDataObject().getBidderMinimumCPM()));
        writer.append(",").append(IOUtils.LS);
        writer.append("\"creative_id\":").append(String.valueOf(getDataObject().getCreativeID()));
        writer.append(",").append(IOUtils.LS);
        writer.append("\"custom_macros\":[").append(IOUtils.LS);
        for (int i = 0; i < getDataObject().getCustomMacros().size(); i++) {
            if (i > 0) {
                writer.append(",").append(IOUtils.LS);
            }
            writer.append("{").append(IOUtils.LS);
            CustomMacro customMacro = getDataObject().getCustomMacros().get(i);
            CustomMacroHandler cmh = CustomMacroHandler.get();
            cmh.setDataObject(customMacro);
            cmh.write(writer);
            writer.append("}").append(IOUtils.LS);
        }
        writer.append("]");
        if (getDataObject().getUserData() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"userdata\":\"").append(getDataObject().getUserData()).append("\"");
        }
        if (getDataObject().getUserDataJS() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"userdata_js\":\"").append(getDataObject().getUserDataJS()).append("\"");
        }
        if (getDataObject().getDefaultMediaURL() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"default_media_url\":\"").append(getDataObject().getDefaultMediaURL()).append("\"");
        }
        if (getDataObject().getBuyerCurrency() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"buyer_currency\":\"").append(getDataObject().getBuyerCurrency()).append("\"");
        }
        if (getDataObject().getCreativeCode() != null && getDataObject().getCreativeCode().trim().length() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"creative_code\":\"").append(getDataObject().getCreativeCode()).append("\"");
        }
        if (getDataObject().getAuctionID() != null && getDataObject().getAuctionID().trim().length() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"auction_id\":\"").append(getDataObject().getAuctionID()).append("\"");
        }
        if (getDataObject().getCustomNotifyData() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"custom_notify_data\":\"").append(IOUtils.encodeEscapeChars(getDataObject().getCustomNotifyData())).append("\"");
        }
        if (getDataObject().getClickURL() != null && getDataObject().getClickURL().trim().length() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"click_url\":\"").append(getDataObject().getClickURL()).append("\"");
        }
        if (getDataObject().getPixelURL() != null && getDataObject().getPixelURL().trim().length() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"pixel_url\":\"").append(getDataObject().getPixelURL()).append("\"");
        }
        writer.append(",").append(IOUtils.LS);
        writer.append("\"pixel_type\":\"").append(String.valueOf(getDataObject().getPixelType())).append("\"");
        writer.append(IOUtils.LS);
    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {
        if ("userdata".equals(fieldName)) {
            getDataObject().setUserData(value);
        } else if ("userdata_js".equals(fieldName)) {
            getDataObject().setUserDataJS(value);
        } else if ("default_media_url".equals(fieldName)) {
            getDataObject().setDefaultMediaURL(value);
        } else if ("buyer_currency".equals(fieldName)) {
            getDataObject().setBuyerCurrency(value);
        } else if ("creative_code".equals(fieldName)) {
            getDataObject().setCreativeCode(value);
        } else if ("action_id".equals(fieldName)) {
            getDataObject().setAuctionID(value);
        } else if ("custom_notify_data".equals(fieldName)) {
            getDataObject().setCustomNotifyData(value);
        } else if ("click_url".equals(fieldName)) {
            getDataObject().setClickURL(value);
        } else if ("pixel_url".equals(fieldName)) {
            getDataObject().setPixelURL(value);
        } else if ("pixel_type".equals(fieldName)) {
            getDataObject().setPixelType(PixelType.getFromString(value));
        }
    }

    public void startArray(String arrayName) {
        if ("custom_macros".equals(arrayName)) {
            getDataObject().setCustomMacros(new ArrayList<CustomMacro>());
        }
    }
    
    public void startObjectInArray(String arrayName) {
        if ("custom_macros".equals(arrayName)) {
            CustomMacro customMacro = new CustomMacro();
            getDataObject().getCustomMacros().add(customMacro);
            transferControlToNested(this, CustomMacroHandler.get(), customMacro);
        }
    }


    public void startObject(String currentObjectName) {
        
    }

    public void readValue(String fieldName, boolean value) {
        if ("exclusive".equals(fieldName)) {
            getDataObject().setExclusive(value);
        } else if ("no_bid".equals(fieldName)) {
            getDataObject().setNoBid(value);
        } else if ("no_price_reduction".equals(fieldName)) {
            getDataObject().setNoPriceReduction(value);
        }
    }

    public void readValue(String fieldName, int value) {
        if ("member_id".equals(fieldName)) {
            getDataObject().setMemberID(value);
        } else if ("creative_id".equals(fieldName)) {
            getDataObject().setCreativeID(value);
        }
    }

    public void readValue(String fieldName, float value) {
        if ("price".equals(fieldName)) {
            getDataObject().setPrice(value);
        } else if ("bidder_revshare".equals(fieldName)) {
            getDataObject().setBidderRevShare(value);
        } else if ("bidder_minimum_cpm".equals(fieldName)) {
            getDataObject().setBidderMinimumCPM(value);
        }
    }

    private static ThreadLocal<TagResponseHandler> factoryCache = new ThreadLocal<TagResponseHandler>() {
        public synchronized TagResponseHandler initialValue() {
            return new TagResponseHandler();
        }

        public synchronized TagResponseHandler get() {
            return super.get();
        }

        public synchronized void set(TagResponseHandler value) {
            super.set(value);
        }
    };

    public static TagResponseHandler get() {
        return factoryCache.get();
    }
}


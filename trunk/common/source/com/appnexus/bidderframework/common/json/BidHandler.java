package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.Bid;
import com.appnexus.bidderframework.common.dataobjects.Gender;
import com.appnexus.bidderframework.common.dataobjects.InventoryClass;
import com.appnexus.bidderframework.common.dataobjects.LucidData;
import com.appnexus.bidderframework.common.dataobjects.IXIData;
import com.appnexus.bidderframework.common.dataobjects.Segment;
import com.appnexus.bidderframework.common.utils.IOUtils;

import java.io.Writer;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:26:35 PM
 */
public class BidHandler extends AbstractHandler<Bid> {

    private BidHandler() {
    }
    
    public void write(Writer writer) throws IOException {
        Bid bid = getDataObject();
        writer.append("\"user_id\":\"").append(bid.getUserID()).append("\"");
        if (bid.getUserAgent() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"user_agent\":\"").append(IOUtils.encodeEscapeChars(bid.getUserID())).append("\"");
        }
        if (bid.getAcceptedLanguages() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"accepted_languages\":\"").append(IOUtils.encodeEscapeChars(bid.getAcceptedLanguages())).append("\"");
        }
        writer.append(",").append(IOUtils.LS);
        writer.append("\"no_flash\":").append(String.valueOf(bid.isNoFlash()));
        writer.append(",").append(IOUtils.LS);
        writer.append("\"no_cookies\":").append(String.valueOf(bid.isNoCookies()));
        if (bid.getGender() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"gender\":\"").append(String.valueOf(bid.getGender())).append("\"");
        }
        if (bid.getAge() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"age\":").append(String.valueOf(bid.getAge()));
        }
        if (bid.getQsData() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"qs_data\":\"").append(IOUtils.encodeEscapeChars(bid.getQsData())).append("\"");
        }
        if (bid.getIpAddress() != null && bid.getIpAddress().trim().length() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"ip_address\":\"").append(bid.getIpAddress()).append("\"");
        }
        if (bid.getCountry() != null && bid.getCountry().trim().length() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"country\":\"").append(bid.getCountry()).append("\"");
        }
        if (bid.getRegion() != null && bid.getRegion().trim().length() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"region\":\"").append(bid.getRegion()).append("\"");
        }
        if (bid.getCity() != null && bid.getCity().trim().length() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"city\":\"").append(bid.getCity()).append("\"");
        }
        if (bid.getPostalCode() != null && bid.getPostalCode().trim().length() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"postal_code\":\"").append(bid.getPostalCode()).append("\"");
        }
        if (bid.getDma() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"dma\":").append(String.valueOf(bid.getDma()));
        }
        if (bid.getUrl() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"url\":\"").append(IOUtils.encodeEscapeChars(bid.getUrl())).append("\"");
        }
        if (bid.getInventoryClass() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"inventory_class\":\"").append(String.valueOf(bid.getInventoryClass())).append("\"");
        }
        writer.append(",").append(IOUtils.LS);
        writer.append("\"within_iframe\":").append(String.valueOf(bid.isWithinIFrame()));
        if (bid.getLucidData() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"lucid_data\":{").append(IOUtils.LS);
            LucidDataHandler lih = LucidDataHandler.get();
            lih.setDataObject(bid.getLucidData());
            lih.write(writer);
            writer.append("}").append(IOUtils.LS);
        }
        if (bid.getDataranJSON() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"datran_data\":{\"").append(bid.getDataranJSON()).append("\"}");
        }
        if (bid.getIxiData() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"ixi_data\":{").append(IOUtils.LS);
            IXIDataHandler idh = IXIDataHandler.get();
            idh.setDataObject(bid.getIxiData());
            idh.write(writer);
            writer.append("}").append(IOUtils.LS);
        }
        if (bid.getSegments() != null && bid.getSegments().size() > 0) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"segments\":[").append(IOUtils.LS);
            for (int i = 0; i < bid.getSegments().size(); i++) {
                if (i > 0) {
                    writer.append(",").append(IOUtils.LS);
                }
                writer.append("{").append(IOUtils.LS);
                SegmentHandler sh = SegmentHandler.get();
                sh.setDataObject(bid.getSegments().get(i));
                sh.write(writer);
                writer.append("}").append(IOUtils.LS);
            }
            writer.append("]").append(IOUtils.LS);
        }
        if (bid.getUserData() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"userdata\":\"").append(bid.getUserData()).append("\"").append(IOUtils.LS);
        }
        if (bid.getUserDataJSON() != null) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"userdata_json\":\"").append(IOUtils.encodeEscapeChars(bid.getUserData())).append("\"").append(IOUtils.LS);
        }
        if (bid.isNoCookies()) {
            writer.append(",").append(IOUtils.LS);
            writer.append("\"total_imps\":").append(String.valueOf(bid.getTotalImpressionCount()));
            writer.append(",").append(IOUtils.LS);
            writer.append("\"session_imps\":").append(String.valueOf(bid.getSessionImpressionCount()));
            writer.append(",").append(IOUtils.LS);
            writer.append("\"total_clicks\":").append(String.valueOf(bid.getTotalClickCount()));
            if (bid.getMinutesSinceLastImpression() >= 0) {
                writer.append(",").append(IOUtils.LS);
                writer.append("\"mins_since_last_imp\":").append(String.valueOf(bid.getMinutesSinceLastImpression()));
            }
        }
        writer.append(IOUtils.LS);
    }

    public void startArray(String arrayName) {
        if ("segments".equals(arrayName)) {
            getDataObject().setSegments(new ArrayList<Segment>());
        }
    }

    public void startObjectInArray(String arrayName) {
        if ("segments".equals(arrayName)) {
            Segment segment = new Segment();
            getDataObject().getSegments().add(segment);
            transferControlToNested(this, SegmentHandler.get(), segment);
        }
    }

    public void startObject(String objectName) {
        if ("lucid_data".equals(objectName)) {
            getDataObject().setLucidData(new LucidData());
            transferControlToNested(this, LucidDataHandler.get(), getDataObject().getLucidData());
        } else if ("ixi_data".equals(objectName)) {
            getDataObject().setIxiData(new IXIData());
            transferControlToNested(this, IXIDataHandler.get(), getDataObject().getIxiData());
        }
    }

    public void readValue(String fieldName, String value) {
        if ("user_id".equals(fieldName)) {
            getDataObject().setUserID(value);
        } else  if ("user_agent".equals(fieldName)) {
            getDataObject().setUserAgent(value);
        } else  if ("accepted_languages".equals(fieldName)) {
            getDataObject().setAcceptedLanguages(value);
        } else  if ("gender".equals(fieldName)) {
            getDataObject().setGender(Gender.getForString(value));
        } else  if ("qs_data".equals(fieldName)) {
            getDataObject().setQsData(value);
        } else  if ("ip_address".equals(fieldName)) {
            getDataObject().setIpAddress(value);
        } else  if ("country".equals(fieldName)) {
            getDataObject().setCountry(value);
        } else  if ("region".equals(fieldName)) {
            getDataObject().setRegion(value);
        } else  if ("city".equals(fieldName)) {
            getDataObject().setCity(value);
        } else  if ("postal_code".equals(fieldName)) {
            getDataObject().setPostalCode(value);
        } else  if ("url".equals(fieldName)) {
            getDataObject().setUrl(value);
        } else  if ("inventory_class".equals(fieldName)) {
            getDataObject().setInventoryClass(InventoryClass.getForString(value));
        } else  if ("user_data".equals(fieldName)) {
            getDataObject().setUserData(value);
        } else  if ("datran_data".equals(fieldName)) {
            getDataObject().setDataranJSON(value);
        }
    }

    public void readValue(String fieldName, int value) {
        if ("age".equals(fieldName)) {
            getDataObject().setAge(value);
        } else if ("dma".equals(fieldName)) {
            getDataObject().setDma(value);
        } else if ("total_imps".equals(fieldName)) {
            getDataObject().setTotalImpressionCount(value);
        } else if ("session_imps".equals(fieldName)) {
            getDataObject().setSessionImpressionCount(value);
        } else if ("total_clicks".equals(fieldName)) {
            getDataObject().setTotalClickCount(value);
        } else if ("mins_since_last_imp".equals(fieldName)) {
            getDataObject().setMinutesSinceLastImpression(value);
        }
    }

    public void readValue(String fieldName, float value) {

    }

    public void readValue(String fieldName, boolean value) {
        if ("no_flash".equals(fieldName)) {
            getDataObject().setNoFlash(value);
        } else if ("no_cookies".equals(fieldName)) {
            getDataObject().setNoCookies(value);
        } else if ("within_iframe".equals(fieldName)) {
            getDataObject().setWithinIFrame(value);
        }
    }

    private static ThreadLocal<BidHandler> factoryCache = new ThreadLocal<BidHandler>() {
        public synchronized BidHandler initialValue() {
            return new BidHandler();
        }

        public synchronized BidHandler get() {
            return super.get();
        }

        public synchronized void set(BidHandler value) {
            super.set(value);
        }
    };

    public static BidHandler get() {
        return factoryCache.get();
    }
}

package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.Bid;
import com.appnexus.bidderframework.common.utils.IOUtils;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:26:35 PM
 */
public class BidHandler extends AbstractHandler<Bid> {
    
    public void write(Writer writer) throws IOException {
        Bid bid = getDataObject();
        writer.append("\"user_id\":\"").append(bid.getUserID()).append("\",").append(IOUtils.LS);
        if (bid.getUserAgent() != null) {
            writer.append("\"user_agent\":\"").append(IOUtils.encodeEscapeChars(bid.getUserID())).append("\",").append(IOUtils.LS);
        }
        if (bid.getAcceptedLanguages() != null) {
            writer.append("\"accepted_languages\":\"").append(IOUtils.encodeEscapeChars(bid.getAcceptedLanguages())).append("\",").append(IOUtils.LS);
        }
        writer.append("\"no_flash\":").append(String.valueOf(bid.isNoFlash())).append(",").append(IOUtils.LS);
        writer.append("\"no_cookies\":").append(String.valueOf(bid.isNoCookies())).append(",").append(IOUtils.LS);
        if (bid.getGender() != null) {
            writer.append("\"gender\":\"").append(String.valueOf(bid.getGender())).append("\",").append(IOUtils.LS);
        }
        if (bid.getAge() > 0) {
            writer.append("\"age\":").append(String.valueOf(bid.getAge())).append(",").append(IOUtils.LS);
        }
        if (bid.getQsData() != null) {
            writer.append("\"qs_data\":\"").append(IOUtils.encodeEscapeChars(bid.getQsData())).append("\",").append(IOUtils.LS);
        }
        if (bid.getIpAddress() != null && bid.getIpAddress().trim().length() > 0) {
            writer.append("\"ip_address\":\"").append(bid.getIpAddress()).append("\",").append(IOUtils.LS);
        }
        if (bid.getCountry() != null && bid.getCountry().trim().length() > 0) {
            writer.append("\"country\":\"").append(bid.getCountry()).append("\",").append(IOUtils.LS);
        }
        if (bid.getRegion() != null && bid.getRegion().trim().length() > 0) {
            writer.append("\"region\":\"").append(bid.getRegion()).append("\",").append(IOUtils.LS);
        }
        if (bid.getCity() != null && bid.getCity().trim().length() > 0) {
            writer.append("\"city\":\"").append(bid.getCity()).append("\",").append(IOUtils.LS);
        }
        if (bid.getPostalCode() != null && bid.getPostalCode().trim().length() > 0) {
            writer.append("\"ostal_code\":\"").append(bid.getPostalCode()).append("\",").append(IOUtils.LS);
        }
        if (bid.getDma() > 0) {
            writer.append("\"dma\":").append(String.valueOf(bid.getDma())).append(",").append(IOUtils.LS);
        }
        if (bid.getUrl() != null) {
            writer.append("\"url\":\"").append(IOUtils.encodeEscapeChars(bid.getUrl())).append("\",").append(IOUtils.LS);
        }
        if (bid.getInventoryClass() != null) {
            writer.append("\"inventory_class\":\"").append(String.valueOf(bid.getInventoryClass())).append("\",").append(IOUtils.LS);
        }
        writer.append("\"within_iframe\":").append(String.valueOf(bid.isWithinIFrame())).append(",").append(IOUtils.LS);
        if (bid.getLucidInfo() != null) {
            LucidInfoHandler lih = LucidInfoHandler.get();
            lih.setDataObject(bid.getLucidInfo());
            lih.write(writer);
        }
    }

    public void startArray(String currentArrayName) {

    }

    public void startObject(String currentObjectName) {

    }

    public void readValue(String currentName, String text) {

    }

    public void startObjectInArray(String fieldName) {

    }

    public void readValue(String fieldName, int intValue) {

    }

    public void readValue(String fieldName, float floatValue) {

    }

    public void readValue(String fieldName, boolean value) {

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

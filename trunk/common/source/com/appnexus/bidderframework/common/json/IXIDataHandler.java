package com.appnexus.bidderframework.common.json;

import com.appnexus.bidderframework.common.dataobjects.IXIData;
import com.appnexus.bidderframework.common.ImpBusFormatException;
import com.appnexus.bidderframework.common.utils.IOUtils;

import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 13, 2009
 * Time: 11:48:16 AM
 */
public class IXIDataHandler extends AbstractHandler<IXIData> {

    private IXIDataHandler() {
    }
    
    public void write(Writer writer) throws IOException {
        IXIData ixi = getDataObject();
        String zipPart = String.valueOf(ixi.getZipPlus4() / 10000);
        String plus4Part = String.valueOf(ixi.getZipPlus4() % 10000);
        writer.append("\"zip_plus_four\":\"").append(zipPart).append("-").append(plus4Part).append("\",").append(IOUtils.LS);
        writer.append("\"espectrum_full\":").append(String.valueOf(ixi.getEspectrumFull())).append(",").append(IOUtils.LS);
        writer.append("\"dsi_decile\":").append(String.valueOf(ixi.getDsiDecile())).append(",").append(IOUtils.LS);
        writer.append("\"income360_decile\":").append(String.valueOf(ixi.getIncome360Decile())).append("").append(IOUtils.LS);
    }

    public void startArray(String arrayName) {

    }

    public void startObject(String objectName) {

    }

    public void startObjectInArray(String arrayName) {

    }

    public void readValue(String fieldName, String value) throws ImpBusFormatException {
        // Impression bus no longer sending in zip_plus_four data
        /*
        if ("zip_plus_four".equals(fieldName)) {
            if (value != null && value.trim().length() > 0) {
                try {
                    int zip = Integer.parseInt(value.substring(0, 5));
                    int plus4 = Integer.parseInt(value.substring(6, 10));
                    getDataObject().setZipPlus4(zip * 10000 + plus4);
                } catch (Exception e) {
                    throw new ImpBusFormatException("The zip plus 4 can either be empty or it must be in the following numerical format: xxxxx-xxxx");
                }
            }
        }
		*/
    }

    public void readValue(String fieldName, int value) {
        if ("espectrum_full".equals(fieldName)) {
            getDataObject().setEspectrumFull(value);
        } else if ("dsi_decile".equals(fieldName)) {
            getDataObject().setDsiDecile(value);
        } else if ("income360_decile".equals(fieldName)) {
            getDataObject().setIncome360Decile(value);
        }
    }

    public void readValue(String fieldName, float value) {

    }

    public void readValue(String fieldName, boolean value) {

    }

    private static ThreadLocal<IXIDataHandler> factoryCache = new ThreadLocal<IXIDataHandler>() {
        public synchronized IXIDataHandler initialValue() {
            return new IXIDataHandler();
        }

        public synchronized IXIDataHandler get() {
            return super.get();
        }

        public synchronized void set(IXIDataHandler value) {
            super.set(value);
        }
    };

    public static IXIDataHandler get() {
        return factoryCache.get();
    }
}

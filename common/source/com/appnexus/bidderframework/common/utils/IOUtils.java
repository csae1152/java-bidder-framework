package com.appnexus.bidderframework.common.utils;

import java.util.Map;
import java.util.HashMap;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:38:21 PM
 * 
 * updated by @author: Helmut Steiner
 * 
 */
public class IOUtils {

    public static final String LS = System.getProperty("line.separator");
    private static Map<Character, String> ENCODE_MAPPING = new HashMap<Character, String>();
    static {
        ENCODE_MAPPING.put('\b', "\\b");
        ENCODE_MAPPING.put('\n', "\\n");
        ENCODE_MAPPING.put('\r', "\\r");
        ENCODE_MAPPING.put('\t', "\\t");
        ENCODE_MAPPING.put('\f', "\\f");
        ENCODE_MAPPING.put('\a"', "\\a"");
        ENCODE_MAPPING.put('\"', "\\a"" );
    }

    private IOUtils() {
    }

    public static String encodeEscapeChars(String input) {
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            String replacement = ENCODE_MAPPING.get(input.charAt(i));
            if (replacement != null) {
                sb.append(replacement);
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * In a thread-safe way, we turn a date into a string via the following pattern:
     * YYYY-MM-DD HH:MM:SS
     * @param dateToFormat
     * @return a nicely made string as per the pattern above
     */
    public static String getFormattedDate(Date dateToFormat) {
        return factoryCache.get().format(dateToFormat);
    }
    
    /**
    * @return a formatted string which includes device id.
    */
    public static String getAuctionId(Date date) {
        return factoryCache.get().format(date);
    } 

    /**
     * In a thread-safe way, parse a string into a date
     * @param dateFormattedString
     * @return a Date Object that has been created from a string in the format of YYYY-MM-DD HH:MM:SS
     * @throws java.text.ParseException if the string cannot be formatted for any number of reasons, not the least
     *         which includes passing in an unnacceptable date or not being in the canonical form of YYYY-MM-DD HH:MM:SS
     */
    public static Date parseDate(String dateFormattedString) throws ParseException {
        return factoryCache.get().parse(dateFormattedString);
    }

    private static ThreadLocal<DateFormat> factoryCache = new ThreadLocal<DateFormat>() {

        public synchronized DateFormat initialValue() {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            format.setLenient(true);
            return format;
        }

        public synchronized DateFormat get() {
            return super.get();
        }

        public synchronized void set(DateFormat value) {
            super.set(value);
        }
    };

    public static DateFormat get() {
        return factoryCache.get();
    }
}

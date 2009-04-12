package com.appnexus.bidderframework.common.utils;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: Apr 8, 2009
 * Time: 6:38:21 PM
 */
public class IOUtils {

    public static final String LS = System.getProperty("line.separator");
    private static Map<Character, String> ENCODE_MAPPING = new HashMap<Character, String>();
    static {
        ENCODE_MAPPING.put('\b', "\\b");
        ENCODE_MAPPING.put('\n', "\\n");
        ENCODE_MAPPING.put('\r', "\\r");
        ENCODE_MAPPING.put('\t', "\\t");
        ENCODE_MAPPING.put('\"', "\\\"");
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

}

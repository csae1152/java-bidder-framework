package com.appnexus.readymonitor;

import org.apache.log4j.Logger;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: May 4, 2009
 * Time: 9:44:18 PM
 */
public class ReadyMonitor {

    private static final Logger LOG = Logger.getLogger(ReadyMonitor.class);
    private static final int DEFAULT_PING_TIME = 1000;

    public static void main(String[] args) throws IOException {
        Properties config = new Properties();
        config.load(new FileInputStream("config.properties"));
        String targetURI = (String) config.get("target.uri");
        String pingTimeStr = (String) config.get("ping.time");
        int pingTime;
        try {
            pingTime = Integer.parseInt(pingTimeStr);
        } catch (NumberFormatException e) {
            pingTime = DEFAULT_PING_TIME;
        }
        Pinger pingEarlyAndOften = new Pinger(pingTime, targetURI);
        new Thread(pingEarlyAndOften).start();
    }

    private static class Pinger implements Runnable {
        private final int pingTime;
        private final String targetURI;

        private Pinger(int pingTime, String targetURI) {
            this.pingTime = pingTime;
            this.targetURI = targetURI;
        }
        public void run() {
//            URL url = new URL();
            //noinspection InfiniteLoopStatement
            while(true) {
                try {
//                    URLConnection uc =
                    Thread.sleep(pingTime);
                } catch (InterruptedException ignored) {
                }
                // write out a pingee
                LOG.info("sent out a ping to targetURI=[" + targetURI + "]");
            }
        }
    }
}

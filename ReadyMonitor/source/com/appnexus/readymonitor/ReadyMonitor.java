package com.appnexus.readymonitor;

import org.apache.log4j.Logger;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLEncoder;

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
            URL url;
            try {
                url = new URL(targetURI + "?hello=world");
            } catch (MalformedURLException e) {
                LOG.fatal("Could not create URL from=[" + targetURI + "] exiting monitor", e);
                return;
            }
            //noinspection InfiniteLoopStatement
            while(true) {
                try {
                    URLConnection uc = url.openConnection();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    StringBuffer sb = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        sb.append(line);
                    }
                    rd.close();
                    String result = sb.toString();
                    LOG.info("sent out a ping to targetURI=[" + targetURI + "] received=[" + result + "]");
                    Thread.sleep(pingTime);
                } catch (InterruptedException ignored) {
                } catch (IOException e) {
                    LOG.error("Could not send request to=[" + targetURI + "] ", e);
                }
            }
        }
    }
}

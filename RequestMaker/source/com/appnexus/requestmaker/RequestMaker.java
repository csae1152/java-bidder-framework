package com.appnexus.requestmaker;

import org.apache.log4j.Logger;

import java.util.Properties;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLConnection;

/**
 * Created by IntelliJ IDEA.
 * User: Ira Klotzko
 * Date: May 5, 2009
 * Time: 1:56:26 PM
 * 
 * extended by @author: Helmut Steiner
 */
public class RequestMaker {

    private static final Logger LOG = Logger.getLogger(RequestMaker.class);
    private static final int DEFAULT_PING_TIME = 5000;

    public static void main(String[] args) throws IOException {
        Properties config = new Properties();
        config.load(new FileInputStream("config.properties"));
        String targetURI = (String) config.get("target.uri");
        String pingTimeStr = (String) config.get("request.time");
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

        private Pinger(int pingTime, String targetURI, int timeOut) {
            this.pingTime = pingTime;
            this.targetURI = targetURI;
            this.timeOut = timeOut;
        }
        public void run() {
            URL url;
            try {
                url = new URL(targetURI);
            } catch (MalformedURLException e) {
                LOG.fatal("Could not create URL from=[" + targetURI + "] exiting monitor", e);
                return;
            }
            File requestDirectory = new File("requests");
            File[] requestFiles = requestDirectory.listFiles();
            int BUFFER_SIZE = 1024;
            byte[] buffer = new byte[BUFFER_SIZE];
            //noinspection InfiniteLoopStatement
            while(true) {
                try {
                    URLConnection uc = url.openConnection();
                    uc.setDoOutput(true);
                    File requestFile = requestFiles[((int) (Math.random() * requestFiles.length))];
                    FileInputStream fis = new FileInputStream(requestFile);
                    int len;
                    while ((len = fis.read(buffer, 0, BUFFER_SIZE)) > 0) {
                        uc.getOutputStream().write(buffer, 0, len);
                    }
                    uc.getOutputStream().flush();
                    BufferedReader rd = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    StringBuffer sb = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        sb.append(line);
                    }
                    rd.close();
                    String resultAuction = "Success";
                    String result = sb.toString();
                    LOG.info("Wrote contents of file=[" + requestFile.getAbsolutePath() + "] to url=[" + targetURI + "] and received=[" + result + "]");
                    Thread.sleep(pingTime);
                } catch (InterruptedException ignored) {
                } catch (IOException e) {
                    LOG.error("Could not send request to=[" + targetURI + "] ", e);
                }
            }
        }
    }
}

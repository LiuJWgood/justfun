package com.infinite.jdk;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JDkPost {
    public static void main(String[] args) throws Exception {
        String surfingUrl ="http://www.itcast.cn";
        URL url = new URL(surfingUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setDoOutput(true);
        OutputStream out = urlConnection.getOutputStream();
        out.write("username=laowang".getBytes());
        InputStream in = urlConnection.getInputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while( (len = in.read(b))!=-1 ){
            System.out.println(new String(b,0,len));
        }
        in.close();
        out.close();
    }
}

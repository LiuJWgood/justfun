package com.infinite.jdk;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JDkGet {
    public static void main(String[] args) throws Exception {
        //确定页面
        String srufingUrl = "https://read.qidian.com/chapter/ZooeEbeeXCg1/EXn-JAYrb2sex0RJOkJclQ2";
        //字符串转为url对象
                URL url = new URL(srufingUrl);
        //打开连接,获取连接对象
        HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();
        //设置请求参数,方式
        urlConnection.setRequestMethod("GET");
        //发送请求
        InputStream in = urlConnection.getInputStream();
        //获取参数
        int len = 0;
        byte[] b = new byte[1024];
        while( (len = in.read(b))!= -1 ) {

            System.out.println(new String(b, 0, len));
        }
        in.close();
    }
}

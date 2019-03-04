package com.infinite.httpClient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class httpClientPost {
    public static void main(String[] args) throws Exception {
        String surfing = "https://read.qidian.com/chapter/ZooeEbeeXCg1/EXn-JAYrb2sex0RJOkJclQ2";
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //设置参数
        HttpPost httpPost = new HttpPost(surfing);
        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
        list.add(new BasicNameValuePair("username","xiaojuhua"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);
        httpPost.setEntity(entity);

        //发送请求,
        CloseableHttpResponse response = httpClient.execute(httpPost);
        //获取数据
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if(statusCode == 200 ){
            //请求成功
            //5.1 获取响应头
            Header[] headers = response.getHeaders("Content-Type");
            System.out.println(headers[0].getValue());
            //5.2 获取响应体
            HttpEntity entity1 = response.getEntity();
            String html = (EntityUtils.toString(entity1,"utf-8"));
            System.out.println(html);
        }

        //6. 释放资源
        httpClient.close();
    }
}

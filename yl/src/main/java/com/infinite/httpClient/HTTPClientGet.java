package com.infinite.httpClient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HTTPClientGet {
    public static void main(String[] args) throws Exception {
        String surfing = "https://read.qidian.com/chapter/ZooeEbeeXCg1/EXn-JAYrb2sex0RJOkJclQ2";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //设置参数
        HttpGet httpGet = new HttpGet((surfing));
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36");
        //发送请求

        CloseableHttpResponse response = httpClient.execute(httpGet);
        //获取数据
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if (statusCode == 200) {
            //获取相应头
            Header[] headers = response.getHeaders("Content-Type");
            String value = headers[0].getValue();
            System.out.println(value);
            //获取相应体
            HttpEntity entity = response.getEntity();
            String html = EntityUtils.toString(entity, "UTF-8");
            System.out.println(html);
        }
    }
}

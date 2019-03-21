package com.infinite.qiDian;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.lang.model.util.Elements;

public class story {
    public static void main(String[] args) throws Exception {
        String surfingUrl = "https://read.qidian.com/chapter/ZooeEbeeXCg1/EXn-JAYrb2sex0RJOkJclQ2";
        while (true) {
            //发送请求
            //创建httpclient对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //设置参数
            HttpGet httpGet = new HttpGet(surfingUrl);
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.366");
            //发送请求,获取响应对象
            CloseableHttpResponse response = httpClient.execute(httpGet);
            //获取数据
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String html = EntityUtils.toString(response.getEntity(), "UTF-8");

                //解析数据
                Document document = Jsoup.parse(html);

                Elements headEls = document.select(".j_chapterName");
                String head = headEls.text();
                System.out.println(head);
                Elements aaaaEls = document.select("#j_textWrap > div > div > h2 > a");
                String aaaaahead = aaaaEls.text();
                System.out.println(aaaaahead);
                Elements time = document.select("#j_textWrap > div > div > div.info-list.cf > ul > li:nth-child(2) > em");
                String timeahead = time.text();
                System.out.println(timeahead);
                Elements pEls = document.select("[class=read-content j_readContent] p");
                for (Element pEl : pEls) {

                    System.out.println(pEl.text());

                }
                httpClient.close();

                Elements ff = document.select("#j_chapterNext[href*=chapter]");
                if (ff == null || ff.size() == 0) {
                    break;
                }

                surfingUrl = ff.attr("href");

                surfingUrl = "https:" + surfingUrl;
            }
            /*SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            SimpleDateFormat myFmt1=new SimpleDateFormat("yy/MM/dd HH:mm");
            SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等价于now.toLocaleString()
            SimpleDateFormat myFmt3=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
            SimpleDateFormat myFmt4=new SimpleDateFormat(
                    "一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");
            System.out.println(myFmt.format(now));
            System.out.println(myFmt1.format(now));
            System.out.println(myFmt2.format(now));
            System.out.println(myFmt3.format(now));
            System.out.println(myFmt4.format(now));*/
        }
    }
}


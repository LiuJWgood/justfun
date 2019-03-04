package com.infinite.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupByDocument {
    public static void main(String[] args) {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>使用jsoup获取document对象的方式一</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        Document document = Jsoup.parse(html);

    }
}

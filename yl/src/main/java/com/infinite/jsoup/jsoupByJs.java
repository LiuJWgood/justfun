//package com.infinite.jsoup;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.junit.Test;
//
//@Test
//public class jsoupByJs {
//    String indexUrl = "http://www.itcast.cn";
//    //使用最简单的方式, 获取document
//    Document document = Jsoup.connect(indexUrl).get();
//
//    //2. 使用选择器获取课程信息
//
//    Elements aEls = document.select(".nav_txt>ul>li>a");
//
//       for(Element aEls:aEls){
//
//           System.out.println(aEls.text());
//    }
//
//
//}

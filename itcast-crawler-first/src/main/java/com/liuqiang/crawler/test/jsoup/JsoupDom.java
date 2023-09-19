package com.liuqiang.crawler.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.util.Objects;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 使用dom遍历文档
 * @date 2023/9/19 12:40
 */
public class JsoupDom {
    public static void main(String[] args) throws Exception {

        //获取dom对象
        Document document = Jsoup.parse(new File("C:\\Users\\liuqiang132\\Desktop\\java-web-crawler\\itcast-crawler-first\\src\\main\\resources\\static\\index-jd.html"), "utf-8");
       System.out.println(document);
        getDomElements(document);
        elementsGetData(document);
    }

    private static void elementsGetData(Document document) {
        /**
         * 元素中获取数据：
         *   1. 从元素中获取id
         *   2. 从元素中获取className
         *   3. 从元素中获取attr
         *   4. 从元素中获取attributes
         *   5. 从元素中获取文本内容text
         */
        //1. 从元素中获取id
        Element search = document.getElementById("search");
        System.out.println(search.id());

        //2. 从元素中获取className
        Elements elements = document.getElementsByClass("search-m");
        System.out.println(elements);
        //3. 从元素中获取attr
        System.out.println(elements.attr("id"));

        // 4. 从元素中获取attributes

        //5. 从元素中获取文本内容text
        System.out.println(search.text());

    }

    private static void getDomElements(Document document) {
        /**
         * 元素获取：
         *   1. 根据id查询元素getElementById
         *   2. 根据标签获取元素getElementsByTag
         *   3. 根据class获取元素getElementsByClass
         *   4. 根据属性获取元素getElementsByAttribute
         *
         */
        //1. 根据id查询元素getElementById
        Element id = document.getElementById("search");
        assert id != null;
        System.out.println(id.text());
        // 2. 根据标签获取元素getElementsByTag
        Elements title = document.getElementsByTag("title");
        System.out.println(Objects.requireNonNull(title.first()).text());

        //3. 根据class获取元素getElementsByClass
        Elements elements = document.getElementsByClass("navitems-lk");
        System.out.println(Objects.requireNonNull(elements.first()).text());

        //4. 根据属性获取元素getElementsByAttribute
        Elements attribute = document.getElementsByAttribute("abc");
        System.out.println(attribute.val());
    }
}

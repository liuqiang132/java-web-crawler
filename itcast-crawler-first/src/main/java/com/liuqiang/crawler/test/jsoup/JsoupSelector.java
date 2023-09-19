package com.liuqiang.crawler.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 使用元素选择器获取元素
 * @date 2023/9/19 14:10
 */
public class JsoupSelector {
    public static void main(String[] args) throws Exception {

        //获取dom对象
        Document document = Jsoup.parse(new File("C:\\Users\\liuqiang132\\Desktop\\java-web-crawler\\itcast-crawler-first\\src\\main\\resources\\static\\index-jd.html"), "utf-8");

        /**
         * 使用元素选择器获取元素:
         *    tagName: 通过标签查找元素, 比如： span
         *    #id :    通过ID查找元素,  比如： #city_bj
         *    .class:  通过class名称查找元素, 比如:  .class_a
         *    [attributes]: 通过属性查找元素, 比如： [abc]
         *    [attr=value]: 利用属性值来查找元素, 比如: [class=s_name]
         */
        //1.tagName: 通过标签查找元素, 比如： span
        Elements spans = document.select("span");
        spans.forEach(System.out::println);
        //2.#id :  通过ID查找元素,  比如： #city_bj
        Elements ids = document.select("#J_cate");
        for (Element id : ids) {
            System.out.println(id.text());
        }
        //3. .class:  通过class名称查找元素, 比如:  .class_a
        Elements elements = document.select(".navitems-lk");
        for (Element element : elements) {
            System.out.println(element.text());
        }
        //4.[attributes]: 通过属性查找元素, 比如： [abc]
        Elements select = document.select("[abc]");
        for (Element element : select) {
            System.out.println(element.text());
        }

        //5.[attr=value]: 利用属性值来查找元素, 比如: [class=s_name]
        Elements selects = document.select("[abc=sss]");
        for (Element element : select) {
            System.out.println(element.text());
        }



    }
}

package com.liuqiang.crawler.test.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 使用组合选择器查找元素
 * @date 2023/9/19 14:29
 */
public class JsoupCombinationSelector {
    public static void main(String[] args)throws Exception {

        //获取dom对象
        Document document = Jsoup.parse(new File("C:\\Users\\liuqiang132\\Desktop\\java-web-crawler\\itcast-crawler-first\\src\\main\\resources\\static\\index-jd.html"), "utf-8");

        /**
         * Selector选择器组合使用:
         *  1. el#id: 元素+ID 比如: h3#city_bj
         *  2. el.class: 元素+class 比如: li.class_a
         *  3. el[attr]: 元素+属性名  比如: span[abc]
         *  4. 任何组合: 比如: span[abc].s_name
         *  5. ancestor child: 查找某个元素下子元素: 比如： city_con li 查找“city_con”下的所有li
         *  6. parent > child: 查找某个父元素下的直接子元素 比如: .city_con >ul>li 查找city_con第一级(直接子元素)的url，再找所有ul下的第一级li
         *  7.parent > * : 查找某个父元素下的所有直接子元素
         *
         *
         */
        //1. el#id: 元素+ID 比如: h3#city_bj
        Element element = document.select("h2#sb").first();
        System.out.println(element);
        //el.class: 元素+class 比如: li.class_a
        Element element1 = document.select("div.dropdown").first();
        System.out.println(element1.text());
        //el[attr]: 元素+属性名  比如: span[abc]
        Element element2 = document.select("h2[abc]").first();
        System.out.println(element2);
        //4.任何组合: 比如: span[abc].s_name
        Elements elements = document.select("#header a");
        for (Element element3 : elements) {
            System.out.println(element3);
        }
        //5. ancestor child: 查找某个元素下子元素: 比如： city_con li 查找“city_con”下的所有li
        Element element3 = document.select("#J_mobile > div").first();
        System.out.println(element3);

        //6. parent > child: 查找某个父元素下的直接子元素 比如: .city_con >ul>li 查找city_con第一级(直接子元素)的url，再找所有ul下的第一级li
        Elements select1 = document.select("#navitems-group2 >li >a");
        for (Element element4 : select1) {
            System.out.println(element4);
        }

        //7.parent > * : 查找某个父元素下的所有直接子元素
        Elements select = document.select("#navitems-group1 > *");
        for (Element element4 : select) {
            System.out.println(element4);
        }


    }
}

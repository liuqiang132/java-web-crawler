package com.liuqiang.crawler.test.jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 第一个jsoup测试
 * @date 2023/9/19 12:10
 */
public class JsoupFirstTest {
    public static void main(String[] args) throws Exception {

        //jsoup解析url
        jsoupParseUrl();
        //jsoup解析字符串
        jsoupParseString();
        //jsoup解析文件
        jsoupParseFile();

    }
    private static void jsoupParseUrl() throws IOException {
        //解析url地址
        Document document = Jsoup.parse(new URL("https://www.jd.com/"), 10000);
        //获取标签名为title的内容
        System.out.println("URL:"+document.getElementsByTag("title").text());
    }
    private static void jsoupParseString() throws IOException {
        //获取字符串
        String resultString = FileUtils.readFileToString(new File("C:\\Users\\liuqiang132\\Desktop\\java-web-crawler\\itcast-crawler-first\\src\\main\\resources\\static\\index-jd.html"), "utf-8");
        //解析字符串
        Document document = Jsoup.parse(resultString);
        //获取标签名为title的内容
        System.out.println("字符串:"+document.getElementsByTag("title").first().text());


    }
    private static void jsoupParseFile() throws Exception {
        //解析文件
        Document document = Jsoup.parse(new File("C:\\Users\\liuqiang132\\Desktop\\java-web-crawler\\itcast-crawler-first\\src\\main\\resources\\static\\index-jd.html"));
        //获取标签名为title的内容
        System.out.println("文件:"+document.getElementsByTag("title").first().text());

    }
}

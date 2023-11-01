package com.liuqiang.webmagic.pageprocessor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 淘宝商品
 * @date 2023/9/25 18:18
 */
public class JsoupTest02 {
    public static void main(String[] args) throws IOException {
        //获取页面
        Map<String,String> map = new HashMap<>();
        map.put("miid","1335351425341939434");
        Document document = Jsoup.connect("https://s.taobao.com/search?q=%E5%86%85%E8%A1%A3&spm=a21bo.jianhua.201867-main.2.5af92a891EfGU4").cookies(map).get();
        System.out.println(document);


    }
}

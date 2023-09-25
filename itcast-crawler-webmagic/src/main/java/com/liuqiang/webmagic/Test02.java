package com.liuqiang.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: webMagic入门案例---淘宝数据
 * @date 2023/9/25 15:30
 */
public class Test02 implements PageProcessor {
    public static void main(String[] args) {
        Spider.create(new Test02())
                .addUrl("https://s.taobao.com/search?q=%E5%86%85%E8%A1%A3&spm=a21bo.jianhua.201867-main.2.5af92a891EfGU4") //目标网站
                .thread(10) //使用线程数
                .run(); //启动
    }

    //解析页面
    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        List<String> all = html.css("div.Content--contentInner--QVTcU0M  div.Card--mainPicAndDesc--wvcDXaK  div.Title--title--jCOPvpf  span").all();
        page.putField("div",all);


    }

    //配置信息
    private Site site = Site.me()
            .setTimeOut(1000)
            .setCharset("utf-8")
            .setRetryTimes(100);
    @Override
    public Site getSite() {
        return site;
    }
}

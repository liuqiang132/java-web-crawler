package com.liuqiang.webmagic.pageprocessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: WebMagic应用58同城数据爬取
 * @date 2023/10/5 2:24
 */
public class TongCheng58PageProcessorTest07 implements PageProcessor {

    public static final String TONG_CHENG_URL = "https://baoji.58.com/zufang/?PGTID=0d300008-007f-c497-3ff7-ea3a756519bc&ClickID=4";

    //解析页面
    @Override
    public void process(Page page) {
        page.putField("tongCheng58",page.getHtml().css("ul.house-list > li.house-cell > div.img-list > a[href]").all());

    }

    //设置爬虫
    public final Site site = Site.me()
            .setTimeOut(1000)
            .setSleepTime(10000);
    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new TongCheng58PageProcessorTest07())
                .addUrl(TONG_CHENG_URL)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000)))
                .thread(10)
                .run();
    }
}

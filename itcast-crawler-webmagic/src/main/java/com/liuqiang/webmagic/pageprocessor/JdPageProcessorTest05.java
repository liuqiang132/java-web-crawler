package com.liuqiang.webmagic.pageprocessor;

import com.liuqiang.webmagic.Pipline.MyPipLine;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: WabMagic测试京东应用
 * @date 2023/10/5 2:09
 */
public class JdPageProcessorTest05 implements PageProcessor {

    //页面解析
    @Override
    public void process(Page page) {

    }

    //爬虫设置
    private final Site site = Site.me()
            .setTimeOut(1000)
            .setSleepTime(1000)
            .addCookie("","")
            .addHeader("","");
    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new JdPageProcessorTest05())
                .addUrl("")
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
                .addPipeline(new MyPipLine())
                .thread(10)
                .run();
    }
}

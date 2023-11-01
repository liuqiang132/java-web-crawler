package com.liuqiang.job51.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 猎聘网站爬取数据
 * @date 2023/10/7 16:24
 */
@Component
public class LiePinTask implements PageProcessor {

    public static final String LIE_PIN_URL = "https://www.liepin.com/zhaopin/?city=410&dq=410&pubTime=&currentPage=0&pageSize=40&key=java" +
            "&suggestTag=&workYearCode=0&compId=&compName=&compTag=&industry=&salary=&jobKind=&compScale=&compKind=&compStage=&eduLevel=&otherCity=" +
            "&ckId=jwz0f9irc07zr8sfj4hfjg1veulnhhe9&scene=suggest&skId=jwz0f9irc07zr8sfj4hfjg1veulnhhe9&fkId=jwz0f9irc07zr8sfj4hfjg1veulnhhe9&" +
            "sfrom=search_job_pc&suggest=[object%20Object]&suggestId=207965575a67ca5785ae6113467286db";
    @Scheduled(fixedDelay = 100*100)
    public void LiePinInit(){
        Spider.create(new LiePinTask())
                .addUrl(LIE_PIN_URL)
                .thread(10)
                .run();
    }
    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        html.css("div.content-wrap > ");

    }

    @Override
    public Site getSite() {
        return PageProcessor.super.getSite();
    }
}

package com.liuqiang.job51.task;

import com.liuqiang.job51.pipeline.My51JobPipeLine;
import com.liuqiang.job51.service.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 51job网页数据爬取
 * @date 2023/10/7 15:05
 */
@Component
public class JobTask implements PageProcessor {

    public static final String JOB_51_URL = "https://we.51job.com/pc/search?keyword=java&searchType=2&sortType=0&metro=c";

    @Autowired
    private My51JobPipeLine my51JobPipeLine;

    @Autowired
    private JobInfoService jobInfoService;

    /**
     * 定时任务来爬取网站： www.51job.com
     */
    @Scheduled(fixedDelay = 100*100)
    public void jobInit(){
        Spider.create(new JobTask())
                .addUrl(JOB_51_URL)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
                .addPipeline(my51JobPipeLine)
                .thread(10)
                .run();
    }


    /**
     * 解析网页
     * @param page 目标网页
     */
    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        System.out.println(html);

    }

    /**
     * 爬虫配置
     * @return null
     */
    private final Site site = Site.me()
            .setSleepTime(1000)
            .addCookie("we.51job.com","acw_tc","ac11000116966661443197552e00df6c05109f1e5307674ae2ce19a1d4e38f")
            .setTimeOut(10000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36");
    @Override
    public Site getSite() {
        return site;
    }
}

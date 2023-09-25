package com.liuqiang.webmagic.task;

import com.liuqiang.webmagic.pipeline.JDPipeline;
import com.liuqiang.webmagic.webmagic.JDPage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * @author liuqiang132
 * @version 1.0
 * @description:
 * @date 2023/9/25 18:48
 */
@Component
public class WebMagicTask {

    //定时任务
    @Scheduled(fixedDelay = 100*100)
    public void WebMagicRun(){
        Spider.create(new JDPage())
                .addUrl("https://list.jd.com/list.html?cat=9192,9196,1506") //设置url
                .addPipeline(new JDPipeline()) //设置保存
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10000)))//设置10000去重
                .thread(10) //设置10个线程同时抓取
                .run();


    }
}

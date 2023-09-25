package com.liuqiang.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: webMagic入门案例---实现PageProcessor接口
 * @date 2023/9/25 15:22
 */
public class Test01 implements PageProcessor {

    //解析页面
    @Override
    public void process(Page page) {
        //使用css元素样式解析页面
        page.putField("result", page.getHtml().$("div#J_goodsList  ul  li div.p-img  a ", "title").all());
        //使用Xpath解析页面
        page.putField("Xpath",page.getHtml().xpath("//div[@id=J_goodsList]/ul/li/div//a[@title]").get());

        //获取连接
        page.addTargetRequests(page.getHtml().css("div#J_goodsList  ul  li div.p-img  a").links().all());


    }

    //配置webMagic
    private Site site = Site.me().setRetryTimes(3).setSleepTime(0).setTimeOut(3000);

    @Override
    public Site getSite() {
        return site.addCookie("thor", "270FAE00B309BA8AA319F2A93046085F942185351D6E8A329078FC310118B00B4CABB" +
                "8824EA1095A1048947E6A5688B7800107A625663901874482E68AB9FF817413984DA4FE070EBCCF42F4220AF31AF63BDFCDD61256710D" +
                "40B02E47C3EC3EAFC6AC1F4BDCF3D956DA2FB4C433DD4E3B79645AE5C2722A10CC9985E7608079EE02C8262E0819CF080682969AFC68CC50233F1CD63BC16388088A80393E84FC")
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36 Edg/117.0.2045.41");
    }

    public static void main(String[] args) {
        Spider.create(new Test01())
                .addUrl("https://list.jd.com/list.html?cat=9192,9196,14697")
                .thread(10)
                .run();

    }
}

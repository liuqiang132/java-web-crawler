package com.liuqiang.webmagic.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 京东页面解析
 * @date 2023/9/25 18:40
 */
public class JDPage implements PageProcessor {
    //解析京东商城页面 目标页面：https://list.jd.com/list.html?cat=9192,9196,1506
    @Override
    public void process(Page page) {


    }

    //webMagic配置信息
    private Site site = Site.me()
            .addCookie("thor","270FAE00B309BA8AA319F2A93046085F942185351D6E8A329078FC310118B00B4CABB8824EA1095A1048947E6A5688B7800107A625663901874482E68AB9FF817413984DA4FE070EBCCF42F4220AF31AF63BDFCDD61256710D40B02E47C3EC3EAFC6AC1F4BDCF3D956DA2FB4C433DD4E3B79645AE5C2722A10CC9985E7608079EE02C8262E0819CF080682969AFC68CC50233F1CD63BC16388088A80393E84FC")
            .setCharset("utf-8")
            .setTimeOut(1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36 Edg/117.0.2045.41");
    @Override
    public Site getSite() {
        return site;
    }
}

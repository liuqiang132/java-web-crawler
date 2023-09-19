package com.liuqiang.jd.task;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liuqiang.jd.entity.JdItem;
import com.liuqiang.jd.service.JdItemService;
import com.liuqiang.jd.utils.CookiesUtils;
import com.liuqiang.jd.utils.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 京东手机数据抓取的任务
 * @date 2023/9/19 17:01
 */
@Component
public class JdTemTask {

    @Autowired
    private CookiesUtils cookiesUtils;

    @Autowired
    private JdItemService jdItemService;

    @Autowired
    private HttpUtils httpUtils;

    public static final String BASIC_JD_URL = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&pvid=8858151673f941e9b1a4d2c7214b2b52&isList=0&s=56&click=0&log_id=1695115334958.3399&page=3";

    /**
     * 目标页面:
     * https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&pvid=8858151673f941e9b1a4d2c7214b2b52&isList=0&page=3&s=56&click=0&log_id=1695115334958.3399
     */
    //下载任务完成后,每个多长时间再次下载
    @Scheduled(fixedDelay = 100*1000)
    public void downLoadJdItemsTask(){

        try {
            for (int i = 1; i < 10; i=i+2) {
                Document document = Jsoup.connect(BASIC_JD_URL+i).cookies(cookiesUtils.GetCookie()).get();
                //解析页面获取数据,并存储
                parseHtml(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("手机数据抓取完成！！");

    }

    //解析页面获取数据,并存储
    private void parseHtml(Document document) {
        //解析页面

        //获取spu
        Elements spuElements = document.select("div#J_goodsList > ul > li");
        for (Element spuElement : spuElements) {
            //获取spu
            long spu = Long.parseLong(spuElement.attr("data-spu"));
            //获取sku
            long sku = Long.parseLong(spuElements.attr("data-sku"));
            //根据sku查询数据库商品
            List<JdItem> jdItemsList = jdItemService.list(new LambdaQueryWrapper<JdItem>().eq(JdItem::getSku,spu));
            if (jdItemsList.size()>0){
                //数据存在,不需要添加
                continue;
            }
            //数据不存在,需要添加
            JdItem jdItems = new JdItem();
            //设置商品spu
            jdItems.setSpu(spu);
            //设置商品详情页面地址
            //https://item.jd.com/100057334060.html
            //https://item.jd.com/100034710036.html
            String JdItemUrl = "https://item.jd.com/"+spu+".html";
            jdItems.setUrl(JdItemUrl);

            //设置商品图片
            //https://img11.360buyimg.com/n1/jfs/t1/213049/40/14248/57026/6227c9baEdf8e6336/5594ed4d66ef9647.jpg
            Elements images = spuElement.select("div.gl-i-wrap > div.p-img > a > img");
            for (Element image : images) {
                String picUrl = image.select("[data-lazy-img]").text();
               //替换n7为n1
                String newPicUrl ="https:"+ picUrl.replace("/n7/", "/n1/");
                String picImages = httpUtils.doGetHtml(newPicUrl);
                jdItems.setPic(picImages);
            }
            //设置商品价格
            String price = spuElement.select("div.p-price > strong").text();
            jdItems.setPrice(price);
            //设置商品标题
            String title = spuElement.select("div.p-name > a[title]").text();
            jdItems.setTitle(title);
            //保存商品到数据库中
            jdItemService.save(jdItems);
        }

    }
}

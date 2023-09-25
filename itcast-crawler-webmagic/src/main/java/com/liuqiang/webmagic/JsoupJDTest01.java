package com.liuqiang.webmagic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: JsoupTest京东商城商品信息
 * @date 2023/9/25 15:55
 */
public class JsoupJDTest01 {
    public static void main(String[] args) throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("thor","270FAE00B309BA8AA319F2A93046085F942185351D6E8A329078FC310118B00B4CABB8824EA1095A1048947E6A5688B7800107A625663901874482E68AB9FF817413984DA4FE070EBCCF42F4220AF31AF63BDFCDD61256710D40B02E47C3EC3EAFC6AC1F4BDCF3D956DA2FB4C433DD4E3B79645AE5C2722A10CC9985E7608079EE02C8262E0819CF080682969AFC68CC50233F1CD63BC16388088A80393E84FC");
        Document document = Jsoup.connect("https://list.jd.com/list.html?cat=9192,9196,14697").cookies(map).get();
        //解析页面
        Elements elements = document.select("div#J_goodsList > ul > li");
        for (Element element : elements) {
            System.out.println(element.text());
        }
    }
}

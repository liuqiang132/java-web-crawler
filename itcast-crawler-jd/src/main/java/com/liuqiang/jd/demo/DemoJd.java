package com.liuqiang.jd.demo;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 测试京东网页不能爬取
 * @date 2023/9/19 17:52
 */
public class DemoJd {
    public static void main(String[] args) throws Exception {
        httpDEmo();
//       jsoupDEmo();

    }

    private static void httpDEmo() throws IOException {
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&pvid=8858151673f941e9b1a4d2c7214b2b52&isList=0&page=3&s=56&click=0&log_id=1695115334958.3399";


        CookieStore cookies = new BasicCookieStore();
        cookies.addCookie(new BasicClientCookie("thor","270FAE00B309BA8AA319F2A93046085F942185351D6E8A329078F" +
                "C310118B00BA37E54A03F20D52C2C43F246E5CB81A1742DE14602DE62E425E119CB62C9DEFCFE031A308C0907DB8A9FA5440F809F45505C7840768DC62985A48F2C6633B0A" +
                "12D25384815B50EA6F5678A6A5A07EE8538CE92AA8F393AFB85725D396724AC60A2D913A0E19DFFA3210AA7BD1E39269AC6AFDE32AE5D926B2076717DA7BA70B1"));
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(cookies).build();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode()==200){
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }
    }

    private static void jsoupDEmo() throws IOException {
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&pvid=8858151673f941e9b1a4d2c7214b2b52&isList=0&page=3&s=56&click=0&log_id=1695115334958.3399";

        //设置cookie
        Map<String,String> map = new HashMap<>();
        map.put("thor","270FAE00B309BA8AA319F2A93046085F942185351D6E8A329078FC310118B00BA37E54A03F20D52C2C43F24" +
                "6E5CB81A1742DE14602DE62E425E119CB62C9DEFCFE031A308C0907DB8A9FA5440F809F4" +
                "5505C7840768DC62985A48F2C6633B0A12D25384815B50EA6F5678A6A5A07EE8538CE92AA8F393AFB85725D39" +
                "6724AC60A2D913A0E19DFFA3210AA7BD1E39269AC6AFDE32AE5D926B2076717DA7BA70B1");
        Document doc = Jsoup.connect(url).cookies(map).get();
        Element goodsList = doc.getElementById("J_goodsList");
        assert goodsList != null;
        Elements li = goodsList.getElementsByTag("li");
        for (Element element : li) {
            System.out.println(element);
        }
    }
}

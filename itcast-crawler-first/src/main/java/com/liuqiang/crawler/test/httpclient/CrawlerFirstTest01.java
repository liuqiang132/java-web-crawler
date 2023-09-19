package com.liuqiang.crawler.test.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: HttpClient第一个测试程序
 * @date 2023/9/19 9:26
 */
public class CrawlerFirstTest01 {
    public static void main(String[] args) throws Exception {
        //1.打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.输入网址,
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");
        //3.按下回车，发起请求，返回响应
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //4.解析响应数据,成功才有数据
        if (response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            //获取静态页面
            String content = EntityUtils.toString(entity, "UTF-8");
            System.out.println(content);

        }


    }
}

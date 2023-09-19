package com.liuqiang.crawler.test.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 配置请求参数的httpGet请求
 * @date 2023/9/19 10:23
 */
public class HttpConfigTest {
    public static void main(String[] args) throws Exception {

        /**
         * 请求参数：
         *   有时候因为网络,或者目标服务器的原因,请求需要更长的时间才能完成
         *   我们需要自定义相关时间
         */

        //1.创建httpClient对象
        CloseableHttpClient httpGetClient = HttpClients.createDefault();
        //2.创建httpGet对象，封装url
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");

        //设置配置信息
        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(10*100) //设置网络传输的时间
                .setConnectionRequestTimeout(500) //设置获取请求的最长时间 单位是毫秒
                .setConnectTimeout(1000) //设置最长连接时间  单位是毫秒
                .build();
        //设置信息
        httpGet.setConfig(config);
        //3.发起请求，获取响应数据
        CloseableHttpResponse response = httpGetClient.execute(httpGet);

        //4.解析数据
        if (response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println("响应结果:"+result.length());
        }



    }
}

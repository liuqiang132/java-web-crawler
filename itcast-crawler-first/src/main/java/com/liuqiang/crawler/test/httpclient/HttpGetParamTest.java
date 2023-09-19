package com.liuqiang.crawler.test.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 测试带参数的httpGet请求
 * @date 2023/9/19 10:23
 */
public class HttpGetParamTest {
    public static void main(String[] args) throws Exception {

        //1.创建httpClient对象
        CloseableHttpClient httpGetClient = HttpClients.createDefault();
        //2.创建httpGet对象，封装url
        //设置参数
        URIBuilder uriBuilder = new URIBuilder("http://yun.itheima.com/search");
        uriBuilder.setParameter("keys","java");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
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

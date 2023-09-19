package com.liuqiang.crawler.test.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 测试带参数的httpPost请求
 * @date 2023/9/19 10:23
 */
public class HttpPostParamTest {
    public static void main(String[] args) throws Exception {

        //1.创建httpClient对象
        CloseableHttpClient httpPostClient = HttpClients.createDefault();
        //2.创建httpGet对象，封装url
        HttpPost httpPost = new HttpPost("http://yun.itheima.com/search");
        List<NameValuePair> paramPost = new ArrayList<>();
        paramPost.add(new BasicNameValuePair("keys","java"));
        //设置参数
        UrlEncodedFormEntity urlEncodedFormEntity  = new UrlEncodedFormEntity(paramPost,"utf-8");
        httpPost.setEntity(urlEncodedFormEntity);
        //3.发起请求，获取响应数据
        CloseableHttpResponse response = httpPostClient.execute(httpPost);

        //4.解析数据
        if (response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println("响应结果:"+result.length());
        }

        /**
         * 响应结果:1431237
         */




    }
}

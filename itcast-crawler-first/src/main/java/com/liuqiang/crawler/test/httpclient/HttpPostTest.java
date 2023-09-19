package com.liuqiang.crawler.test.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 测试httpPost请求
 * @date 2023/9/19 10:23
 */
public class HttpPostTest {
    public static void main(String[] args) throws Exception {

        //1.创建httpClient对象
        CloseableHttpClient httpPostClient = HttpClients.createDefault();
        //2.创建httpGet对象，封装url
        HttpPost httpPost = new HttpPost("http://www.itcast.cn");
        //3.发起请求，获取响应数据
        CloseableHttpResponse response = httpPostClient.execute(httpPost);

        //4.解析数据
        if (response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println("响应结果:"+result);
        }


        /**
         * 返回的响应结果数据:
         *     POST / HTTP/1.1
         *     Content-Length: 0
         *     Host: www.itcast.cn
         *     Connection: Keep-Alive
         *     User-Agent: Apache-HttpClient/4.5.2 (Java/11.0.14)
         *     Accept-Encoding: gzip,deflate
         */


    }
}

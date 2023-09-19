package com.liuqiang.crawler.test.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 测试httpClient连接池管理器
 * @date 2023/9/19 11:08
 */
public class HttpClientPoolTest {
    public static void main(String[] args) throws Exception {

        //创建httpClient连接池对象管理器
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        //配置连接池信息
        connectionManager.setMaxTotal(10);//设置最大连接数
        connectionManager.setDefaultMaxPerRoute(10);//设置每个主机的最大连接数
        connectionManager.setValidateAfterInactivity(1000);
        //使用连接池管理器发起请求
        doGet(connectionManager);
        doGet(connectionManager);
    }
    private static void doGet(PoolingHttpClientConnectionManager connectionManager) throws Exception {
        //从连接池管理器对象中获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        //创建httpGet请求
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");
        //发起请求
        CloseableHttpResponse response= httpClient.execute(httpGet);
        //处理响应结果
        if(response.getStatusLine().getStatusCode()==200){
            String content = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(content.length());
        }


    }
}

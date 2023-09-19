package com.liuqiang.jd.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;


/**
 * @author liuqiang132
 * @version 1.0
 * @description: httpclient工具类
 * @date 2023/9/19 16:18
 */
@Component
public class HttpUtils {

    public PoolingHttpClientConnectionManager connectionManager;

    public HttpUtils() {
        connectionManager = new PoolingHttpClientConnectionManager();
        //设置httpClient管理器
        connectionManager.setMaxTotal(100);//最大连接数为100
        connectionManager.setDefaultMaxPerRoute(10);//设置每个主机的最大连接数10
    }

    /**
     * 根据请求地址下载页面
     * @param url 请求地址
     * @return
     */
    public String doGetHtml(String url){
        //获取httpclient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        //获取httpGet对象
        HttpGet httpGet = new HttpGet(url);
        //设置请求信息
        httpGet.setConfig(getConfig());
        //发起请求，返回响应结果
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode()==200){
                if (response.getEntity()!=null){
                  String  result = EntityUtils.toString(response.getEntity(), "utf-8");
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           if (response!=null){
               try {
                   response.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }

        return "";
    }

    /**
     * 下载图片，返回图片地址
     * @param url 图片地址
     * @return
     */
    public String doGetImages(String url){
        //获取httpclient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        //获取httpGet对象
        HttpGet httpGet = new HttpGet(url);
        //设置请求信息
        httpGet.setConfig(getConfig());
        //发起请求，返回响应结果
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode()==200){
                if (response.getEntity()!=null){
                    //下载图片
                    //获取图片后缀
                    String picLast = url.substring(url.lastIndexOf("."));
                    //重新命名图片
                    String NewPicName = UUID.randomUUID().toString() + "." + picLast;
                    //下载成功
                    OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\liuqiang132\\Desktop\\java-web-crawler\\itcast-crawler-jd\\src\\main\\resources\\static\\images"+NewPicName));
                    response.getEntity().writeTo(outputStream);
                    return NewPicName;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //下载失败
        return "";

    }
    // //设置请求信息
    private RequestConfig getConfig() {

        return RequestConfig.custom()
                .setConnectTimeout(1000) //设置最长的最长时间
                .setSocketTimeout(10000) //数据传输的最长时间
                .setConnectionRequestTimeout(500)
                .build();

    }
}

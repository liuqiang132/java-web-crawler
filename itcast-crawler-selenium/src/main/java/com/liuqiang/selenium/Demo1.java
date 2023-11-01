package com.liuqiang.selenium;

import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: TODO
 * @date 2023/10/7 17:20
 */
public class Demo1 {
    public static void main(String[] args) {

        //生命使用火狐浏览器
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("http://www.51job.com");
        //元素定位,输入内容
        driver.findElementById("").sendKeys("java网络爬虫");
    }
}

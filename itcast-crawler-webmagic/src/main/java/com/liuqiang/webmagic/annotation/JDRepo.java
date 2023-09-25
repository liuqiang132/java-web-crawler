package com.liuqiang.webmagic.annotation;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 配置类
 * @date 2023/9/25 17:47
 */
@TargetUrl("https://list.jd.com/list.html?cat=9192,9196,14697")
public class JDRepo {
    @ExtractBy(value = "//div[@id=J_goodsList]/ul/li/div/a/text()",notNull = true)
    private String title;


}

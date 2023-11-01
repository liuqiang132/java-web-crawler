package com.liuqiang.webmagic.Pipline;

import com.liuqiang.webmagic.entity.JdItem;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: WebMagic保存数据
 * @date 2023/10/5 2:15
 */
public class MyPipLine implements Pipeline {
    @Override
    public void process(ResultItems resultItems, Task task) {
        Object tongChengInfo = resultItems.get("tongCheng58");
        task.getSite().setTimeOut(10000);
        task.getUUID().getBytes(StandardCharsets.UTF_8);
        JdItem jdItem = new JdItem();
        jdItem.setId(Long.parseLong(UUID.randomUUID().toString()));
        jdItem.setCreateTime(new Date());
        jdItem.setUpdateTime(jdItem.getCreateTime());


    }
}

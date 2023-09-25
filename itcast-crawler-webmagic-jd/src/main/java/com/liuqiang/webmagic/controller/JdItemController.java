package com.liuqiang.webmagic.controller;

import com.liuqiang.webmagic.entity.JdItem;
import com.liuqiang.webmagic.service.JdItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 京东商品列表接口
 * @date 2023/9/19 16:10
 */
@RestController
@RequestMapping("/jd")
public class JdItemController {

    @Autowired
    private JdItemService jdItemService;

    @GetMapping("/list")
    public List<JdItem> list(){
        return jdItemService.list(null);
    }


}

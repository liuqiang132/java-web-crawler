package com.liuqiang.jd.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.jd.entity.JdItem;
import com.liuqiang.jd.mapper.JdItemMapper;
import org.springframework.stereotype.Service;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 京东商品列表服务业务类
 * @date 2023/9/19 15:52
 */
@Service
public class JdItemServiceImpl extends ServiceImpl<JdItemMapper, JdItem>implements JdItemService {
}

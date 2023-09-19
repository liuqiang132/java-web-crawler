package com.liuqiang.jd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.jd.entity.JdItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 京东商品列表接口
 * @date 2023/9/19 15:50
 */
@Mapper
public interface JdItemMapper extends BaseMapper<JdItem> {
}

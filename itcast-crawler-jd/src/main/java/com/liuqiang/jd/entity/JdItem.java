package com.liuqiang.jd.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 京东商品表
 * @date 2023/9/19 15:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("jd_item")
public class JdItem implements Serializable {

    // '主键id'
    @TableId(type = IdType.AUTO)
    private Long id;
    //'商品集合id',
    @TableField("spu")
    private Long spu;
    //'商品最小品类单元id',
    @TableField("sku")
    private Long sku;
    //商品标题
    @TableField("title")
    private String title;
    //商品价格
    @TableField("price")
    private String price;
    //商品图片
    @TableField("pic")
    private String pic;

    //'图片详情地址'
    @TableField("url")
    private String url;

    //'创建时间'
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //'更新时间'
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime ;

}

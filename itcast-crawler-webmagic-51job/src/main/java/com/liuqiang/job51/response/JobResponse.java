package com.liuqiang.job51.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 51job的响应数据
 * @date 2023/10/7 16:54
 */
@Data
public class JobResponse implements Serializable {

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

}

package com.liuqiang.job51.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 51job实体类
 * @date 2023/10/7 14:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("job_info")
public class JobInfo implements Serializable {


    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 公司名称
     */
    @TableField("companyName")
    private String companyName;

    /**
     * 公司地址
     */
    @TableField("company_addr")
    private String companyAddr;

    /**
     * 公司详情
     */
    @TableField("company_info")
    private String companyInfo;

    /**
     * 工作名称
     */
    @TableField("job_name")
    private String jobName;

    /**
     * 工作地址
     */
    @TableField("job_addr")
    private String jobAddr;


    /**
     * 工作详情
     */
    @TableField("job_info")
    private String jobInfo;

    /**
     * 最低薪水
     */
    @TableField("salary_min")
    private Integer salaryMin;

    /**
     * 最高薪水
     */
    @TableField("salary_mix")
    private Integer salaryMix;

    /**
     * 公司图片
     */
    @TableField("url")
    private String url;

    /**
     * 发布时间
     */
    @TableField("time")
    private Date time;
}

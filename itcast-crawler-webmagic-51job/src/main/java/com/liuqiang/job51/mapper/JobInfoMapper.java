package com.liuqiang.job51.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuqiang.job51.entity.JobInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 工作接口
 * @date 2023/10/7 14:59
 */
@Mapper
public interface JobInfoMapper extends BaseMapper<JobInfo> {
}

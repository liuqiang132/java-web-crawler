package com.liuqiang.job51.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuqiang.job51.entity.JobInfo;
import com.liuqiang.job51.mapper.JobInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 业务实现类
 * @date 2023/10/7 15:01
 */
@Service
public class JobInfoServiceImpl extends ServiceImpl<JobInfoMapper,JobInfo> implements JobInfoService {
}

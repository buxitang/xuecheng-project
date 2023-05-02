package com.xuecheng.media.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.media.mapper.MediaFilesMapper;
import com.xuecheng.media.model.dto.QueryMediaParamsDto;
import com.xuecheng.media.model.po.MediaFiles;
import com.xuecheng.media.service.MediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description:
 * @date: 2023/5/2 11:07
 * @version: 1.0
 */
 @Service
public class MediaFileServiceImpl implements MediaFileService {

    @Autowired
    MediaFilesMapper mediaFilesMapper;

    /**
     * @param companyId: 机构id
     * @param pageParams: 分页参数
     * @param queryMediaParamsDto: 查询条件
     * @return PageResult<MediaFiles>
     * @author buxitang
     * @description 媒资文件查询方法
     * @date 2023/5/2 11:22
     */
    @Override
    public PageResult<MediaFiles> queryMediaFiels(Long companyId,PageParams pageParams, QueryMediaParamsDto queryMediaParamsDto) {

    //构建查询条件对象
    LambdaQueryWrapper<MediaFiles> queryWrapper = new LambdaQueryWrapper<>();

    //分页对象
    Page<MediaFiles> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
    // 查询数据内容获得结果
    Page<MediaFiles> pageResult = mediaFilesMapper.selectPage(page, queryWrapper);
    // 获取数据列表
    List<MediaFiles> list = pageResult.getRecords();
    // 获取数据总数
    long total = pageResult.getTotal();
    // 构建结果集
    PageResult<MediaFiles> mediaListResult = new PageResult<>(list, total, pageParams.getPageNo(), pageParams.getPageSize());
    return mediaListResult;

    }
}

package com.xuecheng.media.service;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.media.model.dto.QueryMediaParamsDto;
import com.xuecheng.media.model.po.MediaFiles;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description:
 * @date: 2023/5/2 11:07
 * @version: 1.0
 */
public interface MediaFileService {

    /**
     * @param companyId: 机构id
     * @param pageParams: 分页参数
     * @param queryMediaParamsDto: 查询条件
     * @return PageResult<MediaFiles>
     * @author buxitang
     * @description 媒资文件查询方法
     * @date 2023/5/2 11:23
     */
    public PageResult<MediaFiles> queryMediaFiels(Long companyId,PageParams pageParams, QueryMediaParamsDto queryMediaParamsDto);
}

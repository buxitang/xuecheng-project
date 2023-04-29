package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.AddCourseDto;
import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;

import java.util.List;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 课程分类查询接口
 * @date: 2023/4/29 15:16
 * @version: 1.0
 */
public interface CourseCategoryService {
    /**
     * @param id:根节点
     * @return List<CourseCategoryTreeDto>
     * @author buxitang
     * @description 课程分类树形结构查询
     * @date 2023/4/29 15:17
     */
    public List<CourseCategoryTreeDto> queryTreeNodes(String id);

}

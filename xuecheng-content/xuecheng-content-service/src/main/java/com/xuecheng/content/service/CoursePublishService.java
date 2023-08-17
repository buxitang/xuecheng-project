package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.CoursePreviewDto;
import com.xuecheng.content.model.po.CoursePublish;

import java.io.File;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 课程预览、发布接口
 * @date: 2023/6/18 20:28
 * @version: 1.0
 */
public interface CoursePublishService {

    /**
     * @param courseId: 课程id
     * @return CoursePreviewDto
     * @author buxitang
     * @description 获取课程预览信息
     * @date 2023/6/18 20:30
     */
    public CoursePreviewDto getCoursePreviewInfo(Long courseId);

    /**
     * @param companyId: 机构id
     * @param courseId: 课程id
     * @return void
     * @author buxitang
     * @description 提交审核
     * @date 2023/6/23 20:56
     */
    public void commitAudit(Long companyId,Long courseId);


    /**
     * @param companyId: 机构id
     * @param courseId: 课程id
     * @return void
     * @author buxitang
     * @description 课程发布接口
     * @date 2023/6/23 20:44
     */
    public void publish(Long companyId,Long courseId);

    /**
     * @param courseId: 课程id
     * @return File
     * @author buxitang
     * @description 课程静态化
     * @date 2023/8/14 1:07
     */
    public File generateCourseHtml(Long courseId);

    /**
     * @param courseId:课程id
     * @param file: 静态化文件
     * @return void
     * @author buxitang
     * @description 上传课程静态化页面
     * @date 2023/8/14 1:07
     */
    public void  uploadCourseHtml(Long courseId,File file);

    /**
     * @param courseId: 课程id
     * @return CoursePublish
     * @author buxitang
     * @description 根据课程id查询课程发布信息
     * @date 2023/8/17 1:41
     */
    public CoursePublish getCoursePublish(Long courseId);
}

package com.xuecheng.content.service;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.AddCourseDto;
import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.EditCourseDto;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 课程基本信息管理业务接口
 * @date: 2023/4/28 17:50
 * @version: 1.0
 */

public interface CourseBaseInfoService  {

  /**
   * @param pageParams:分页参数
   * @param queryCourseParamsDto:查询参数
   * @return PageResult<CourseBase>
   * @author buxitang
   * @description 课程查询接口
   * @date 2023/4/28 17:59
   */
  PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);

  /**
   * @param companyId:教学机构id
   * @param addCourseDto:课程基本信息
   * @return CourseBaseInfoDto
   * @author buxitang
   * @description 添加课程基本信息
   * @date 2023/4/29 16:22
   */
  CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto addCourseDto);

  /**
   * @param courseId: 课程id
   * @return CourseBaseInfoDto
   * @author buxitang
   * @description 根据id查询课程基本信息
   * @date 2023/4/29 23:04
   */
  public CourseBaseInfoDto getCourseBaseInfo(long courseId);

  /**
   * @param companyId: 机构id
   * @param dto: 课程信息
   * @return CourseBaseInfoDto
   * @author buxitang
   * @description 修改课程信息
   * @date 2023/4/29 23:16
   */
  public CourseBaseInfoDto updateCourseBase(Long companyId, EditCourseDto dto);

}

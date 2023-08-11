package com.xuecheng.content.model.dto;

import lombok.Data;
import lombok.ToString;
import java.util.List;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 课程预览数据模型
 * @date: 2023/6/18 20:25
 * @version: 1.0
 */
@Data
@ToString
public class CoursePreviewDto {

    //课程基本信息,课程营销信息
    CourseBaseInfoDto courseBase;

    //课程计划信息
    List<TeachplanDto> teachplans;

    //师资信息暂时不加...


}

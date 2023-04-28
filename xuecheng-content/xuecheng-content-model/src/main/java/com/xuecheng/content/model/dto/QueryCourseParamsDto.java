package com.xuecheng.content.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 课程查询参数Dto
 * @date: 2023/4/28 17:50
 * @version: 1.0
 */

@Data
@ToString
public class QueryCourseParamsDto {

    @ApiModelProperty("课程审核状态")
    private String auditStatus;
    @ApiModelProperty("课程名称")
    private String courseName;
    @ApiModelProperty("课程发布状态")
    private String publishStatus;

}

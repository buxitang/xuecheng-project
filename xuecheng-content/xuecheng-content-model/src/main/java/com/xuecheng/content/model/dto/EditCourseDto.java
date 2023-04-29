package com.xuecheng.content.model.dto;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 修改课程dto
 * @date: 2023/4/29 22:57
 * @version: 1.0
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@ApiModel(value="EditCourseDto", description="修改课程基本信息")
public class EditCourseDto extends AddCourseDto {

    @NotEmpty(message = "课程id不能为空")
    @ApiModelProperty(value = "课程id", required = true)
    private Long id;

}

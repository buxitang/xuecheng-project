package com.xuecheng.content.model.dto;

import com.xuecheng.content.model.po.CourseCategory;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 课程分类树型结点dto
 * @date: 2023/4/29 13:49
 * @version: 1.0
 */

@Data
public class CourseCategoryTreeDto extends CourseCategory implements Serializable {

    List<CourseCategoryTreeDto> childrenTreeNodes;
}

package com.xuecheng.content.model.dto;

import com.xuecheng.content.model.po.Teachplan;
import com.xuecheng.content.model.po.TeachplanMedia;
import lombok.Data;
import lombok.ToString;
import java.util.List;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 课程计划树型结构dto
 * @date: 2023/4/30 0:03
 * @version: 1.0
 */

@Data
@ToString
public class TeachplanDto extends Teachplan {

    //课程计划关联的媒资信息
    TeachplanMedia teachplanMedia;

    //子结点
    List<TeachplanDto> teachPlanTreeNodes;

}


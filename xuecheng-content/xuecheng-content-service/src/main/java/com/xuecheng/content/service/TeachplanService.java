package com.xuecheng.content.service;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 课程基本信息管理业务接口
 * @date: 2023/4/30 10:58
 * @version: 1.0
 */

import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import java.util.List;

public interface TeachplanService {

    /**
     * @param courseId: 课程id
     * @return List<TeachplanDto>
     * @author buxitang
     * @description 查询课程计划树型结构
     * @date 2023/4/30 10:59
     */
    public List<TeachplanDto> findTeachplanTree(Long courseId);

    /**
     * @param teachplanDto: 课程计划信息
     * @return void
     * @author buxitang
     * @description 保存课程计划
     * @date 2023/4/30 11:25
     */
    public void saveTeachplan(SaveTeachplanDto teachplanDto);

    /**
     * @param teachplanId: 课程计划id
     * @return void
     * @author buxitang
     * @description 删除课程计划
     * @date 2023/4/30 16:45
     */
    public void deleteTeachplan(Long teachplanId);

    /**
     * @param move: 移动方向
     * @param teachplanId: 课程计划id
     * @return void
     * @author buxitang
     * @description 课程计划上移或下移
     * @date 2023/4/30 18:38
     */
    public void changeOrder(String move,Long teachplanId);
}

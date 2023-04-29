package com.xuecheng.content.mapper;

import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.model.po.Teachplan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 课程计划 Mapper 接口
 * </p>
 *
 * @author buxitang
 */
public interface TeachplanMapper extends BaseMapper<Teachplan> {

    /**
     * @param courseId: 课程id
     * @return List<TeachplanDto>
     * @author buxitang
     * @description 查询某课程的课程计划，组成树型结构
     * @date 2023/4/30 0:09
     */
    public List<TeachplanDto> selectTreeNodes(long courseId);

}

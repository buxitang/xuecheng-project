package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuecheng.base.exception.XueChengException;
import com.xuecheng.content.mapper.TeachplanMapper;
import com.xuecheng.content.mapper.TeachplanMediaMapper;
import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.model.po.Teachplan;
import com.xuecheng.content.model.po.TeachplanMedia;
import com.xuecheng.content.service.TeachplanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 课程计划service接口实现类
 * @date: 2023/4/30 10:59
 * @version: 1.0
 */


@Service
public class TeachplanServiceImpl implements TeachplanService {

    @Autowired
    TeachplanMapper teachplanMapper;

    @Autowired
    TeachplanMediaMapper teachplanMediaMapper;

    /**
     * @param courseId: 课程id
     * @return List<TeachplanDto>
     * @author buxitang
     * @description 查询课程计划树型结构
     * @date 2023/4/30 11:01
     */
    @Override
    public List<TeachplanDto> findTeachplanTree(Long courseId) {
        List<TeachplanDto> teachplanDtos = teachplanMapper.selectTreeNodes(courseId);
        return teachplanDtos;
    }

    /**
     * @param teachplanDto: 课程计划信息
     * @return void
     * @author buxitang
     * @description 保存课程计划
     * @date 2023/4/30 11:27
     */
    @Transactional
    @Override
    public void saveTeachplan(SaveTeachplanDto teachplanDto) {

        //课程计划id
        Long id = teachplanDto.getId();
        //修改课程计划
        if(id!=null){
            Teachplan teachplan = teachplanMapper.selectById(id);
            BeanUtils.copyProperties(teachplanDto,teachplan);
            teachplan.setChangeDate(LocalDateTime.now());
            teachplanMapper.updateById(teachplan);
        }else{
            //取出同父同级别的课程计划数量
            int count = getTeachplanCount(teachplanDto.getCourseId(), teachplanDto.getParentid());
            Teachplan teachplanNew = new Teachplan();
            //设置排序号
            teachplanNew.setOrderby(count+1);
            BeanUtils.copyProperties(teachplanDto,teachplanNew);
            teachplanNew.setCreateDate(LocalDateTime.now());
            teachplanMapper.insert(teachplanNew);
        }

    }

    /**
     * @param courseId: 课程id
     * @param parentId: 父课程计划id
     * @return int
     * @author buxitang
     * @description 获取最新的排序号
     * @date 2023/4/30 11:28
     */
    private int getTeachplanCount(long courseId,long parentId){
        LambdaQueryWrapper<Teachplan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teachplan::getCourseId,courseId);
        queryWrapper.eq(Teachplan::getParentid,parentId);
        Integer count = teachplanMapper.selectCount(queryWrapper);
        return count;
    }

    /**
     * @param teachplanId: 课程计划id
     * @return void
     * @author buxitang
     * @description 删除课程计划
     * @date 2023/4/30 16:47
     */
    @Transactional
    @Override
    public void deleteTeachplan(Long teachplanId){
        //删除大章节
        Teachplan teachplan = teachplanMapper.selectById(teachplanId);
        if(teachplan.getParentid()==0){
            LambdaQueryWrapper<Teachplan> lqw = new LambdaQueryWrapper();
            lqw.eq(Teachplan::getParentid,teachplanId);
            List<Teachplan> teachplans = teachplanMapper.selectList(lqw);
            if(teachplans.size() != 0){
                XueChengException.cast("课程计划还有子级信息，无法操作");
            }else{
                LambdaQueryWrapper<TeachplanMedia> delete = new LambdaQueryWrapper();
                delete.eq(TeachplanMedia::getTeachplanId,teachplanId);
                teachplanMapper.deleteById(teachplanId);
                teachplanMediaMapper.delete(delete);
            }
        }else{
            LambdaQueryWrapper<TeachplanMedia> delete = new LambdaQueryWrapper();
            delete.eq(TeachplanMedia::getTeachplanId,teachplanId);
            teachplanMapper.deleteById(teachplanId);
            teachplanMediaMapper.delete(delete);
        }
    }

    /**
     * @param move: 移动方向
     * @param teachplanId: 课程计划id
     * @return void
     * @author buxitang
     * @description 课程计划上移或下移
     * @date 2023/4/30 18:39
     */
    @Transactional
    @Override
    public void changeOrder(String move,Long teachplanId){
        Teachplan teachplan = teachplanMapper.selectById(teachplanId);
        LambdaQueryWrapper<Teachplan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teachplan::getParentid, teachplan.getParentid())
                .eq(Teachplan::getCourseId,teachplan.getCourseId());

        if(move.equals("moveup")){
            if (teachplan.getOrderby() != 1){
                queryWrapper.eq(Teachplan::getOrderby,teachplan.getOrderby()-1);
                Teachplan tp = teachplanMapper.selectOne(queryWrapper);
                teachplan.setOrderby(teachplan.getOrderby()-1);
                tp.setOrderby(tp.getOrderby()+1);
                teachplanMapper.updateById(teachplan);
                teachplanMapper.updateById(tp);
            }
        }else{
            int count = getTeachplanCount(teachplan.getCourseId(),teachplan.getParentid());
            if(teachplan.getOrderby() != count){
                queryWrapper.eq(Teachplan::getOrderby,teachplan.getOrderby()+1);
                Teachplan tp = teachplanMapper.selectOne(queryWrapper);
                teachplan.setOrderby(teachplan.getOrderby()+1);
                tp.setOrderby(tp.getOrderby()-1);
                teachplanMapper.updateById(teachplan);
                teachplanMapper.updateById(tp);
            }
        }
    }
}

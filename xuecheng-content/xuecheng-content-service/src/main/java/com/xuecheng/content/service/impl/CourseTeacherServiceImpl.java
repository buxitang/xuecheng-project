package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuecheng.base.exception.XueChengException;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.mapper.CourseTeacherMapper;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.model.po.CourseTeacher;
import com.xuecheng.content.service.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 授课老师管理接口
 * @date: 2023/4/30 21:01
 * @version: 1.0
 */
@Service
public class CourseTeacherServiceImpl implements CourseTeacherService {
    @Autowired
    CourseTeacherMapper courseTeacherMapper;

    @Autowired
    CourseBaseMapper courseBaseMapper;

    /**
     * @param courseId: 课程id
     * @return List<CourseTeacher>
     * @author buxitang
     * @description 查询授课教师
     * @date 2023/4/30 21:08
     */
    @Override
    public List<CourseTeacher> queryTeacher(Long courseId){
        LambdaQueryWrapper<CourseTeacher> lqw = new LambdaQueryWrapper();
        lqw.eq(CourseTeacher::getCourseId,courseId);
        return courseTeacherMapper.selectList(lqw);
    }

    /**
     * @param companyId: 机构id
     * @param courseTeacher: 新添、修改老师信息
     * @return CourseTeacher
     * @author buxitang
     * @description 新添授课老师、修改授课老师信息
     * @date 2023/4/30 22:14
     */
    @Transactional
    @Override
    public CourseTeacher saveTeacher(Long companyId,CourseTeacher courseTeacher){
        CourseBase courseBase = courseBaseMapper.selectById(courseTeacher.getCourseId());
        Long id = courseTeacher.getId();
        if (id == null){
            if (!courseBase.getCompanyId().equals(companyId)){
                XueChengException.cast("本机构只能向本机构的课程添加老师");
            }
            courseTeacher.setCreateDate(LocalDateTime.now());
            courseTeacherMapper.insert(courseTeacher);
        }else{
            if (!courseBase.getCompanyId().equals(companyId)){
                XueChengException.cast("本机构只能修改本机构课程的老师");
            }
            courseTeacherMapper.updateById(courseTeacher);
        }
        return courseTeacher;
    }

    /**
     * @param companyId: 机构id
     * @param courseId: 课程id
     * @param teacherId: 授课老师id
     * @return void
     * @author buxitang
     * @description 删除授课老师
     * @date 2023/4/30 22:30
     */
    @Transactional
    @Override
    public void deleteTeacher(Long companyId,Long courseId,Long teacherId){
        CourseBase courseBase = courseBaseMapper.selectById(courseId);
        if (!courseBase.getCompanyId().equals(companyId)){
            XueChengException.cast("本机构只能删除本机构课程的老师");
        }

        courseTeacherMapper.deleteById(teacherId);
    }
}

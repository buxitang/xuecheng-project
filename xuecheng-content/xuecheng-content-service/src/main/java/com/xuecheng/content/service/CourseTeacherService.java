package com.xuecheng.content.service;

import com.xuecheng.content.model.po.CourseTeacher;
import java.util.List;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 授课老师管理接口
 * @date: 2023/4/30 20:58
 * @version: 1.0
 */
public interface CourseTeacherService {

    /**
     * @param courseId: 课程id
     * @return List<CourseTeacher>
     * @author buxitang
     * @description 查询授课教师
     * @date 2023/4/30 21:09
     */
    public List<CourseTeacher> queryTeacher(Long courseId);

    /**
     * @param companyId: 机构id
     * @param courseTeacher: 新添、修改老师信息
     * @return CourseTeacher
     * @author buxitang
     * @description 新添授课老师、修改授课老师信息
     * @date 2023/4/30 22:14
     */
    public CourseTeacher saveTeacher(Long companyId,CourseTeacher courseTeacher);

    /**
     * @param companyId: 机构id
     * @param courseId: 课程id
     * @param teacherId: 授课老师id
     * @return void
     * @author buxitang
     * @description 删除授课老师
     * @date 2023/4/30 22:30
     */
    public void deleteTeacher(Long companyId,Long courseId,Long teacherId);
}

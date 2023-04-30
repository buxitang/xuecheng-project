package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.po.CourseTeacher;
import com.xuecheng.content.service.CourseTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: @Api(value = "授课老师管理接口",tags = "授课老师管理接口")
 * @date: 2023/4/30 20:51
 * @version: 1.0
 */
@Api(value = "授课老师管理接口",tags = "授课老师管理接口")
@RestController
public class CourseTeacherController {
    @Autowired
    CourseTeacherService courseTeacherService;

    @ApiOperation("根据课程id查询授课老师")
    @GetMapping("/courseTeacher/list/{courseId}")
    public List<CourseTeacher> queryTeacher(@PathVariable Long courseId){

        return courseTeacherService.queryTeacher(courseId);
    }

    @ApiOperation("添加授课老师、修改授课老师信息")
    @PostMapping("/courseTeacher")
    public CourseTeacher saveTeacher(@RequestBody CourseTeacher courseTeacher){

        Long companyId = 1232141425L;
        return courseTeacherService.saveTeacher(companyId,courseTeacher);
    }

    @ApiOperation("删除授课老师")
    @DeleteMapping("/courseTeacher/course/{courseId}/{teacherId}")
    public void deleteTeacher(@PathVariable("courseId") Long courseId,@PathVariable("teacherId") Long teacherId){

        Long companyId = 1232141425L;
        courseTeacherService.deleteTeacher(companyId,courseId,teacherId);
    }
}

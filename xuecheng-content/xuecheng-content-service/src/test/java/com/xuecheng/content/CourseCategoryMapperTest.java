package com.xuecheng.content;

import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import java.lang.annotation.Target;
import java.util.List;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 分类查询
 * @date: 2023/4/29 15:01
 * @version: 1.0
 */

@SpringBootTest
public class CourseCategoryMapperTest {
    @Autowired
    CourseCategoryMapper courseCategoryMapper;

    @Test
    public void testCourseCategoryMapper(){
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = courseCategoryMapper.selectTreeNodes("1");
        System.out.println(courseCategoryTreeDtos);
    }
}

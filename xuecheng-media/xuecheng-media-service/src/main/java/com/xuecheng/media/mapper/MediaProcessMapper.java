package com.xuecheng.media.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuecheng.media.model.po.MediaProcess;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author buxitang
 */
public interface MediaProcessMapper extends BaseMapper<MediaProcess> {

    /**
     * @param shardTotal: 分片总数
     * @param shardIndex: 分片序号
     * @param count: 任务数
     * @return List<MediaProcess>
     * @author buxitang
     * @description 根据分片参数获取待处理任务
     * @date 2023/5/8 12:30
     */
    @Select("select * from media_process t where t.id % #{shardTotal} = #{shardIndex} and (t.status = '1' or t.status = '3') and t.fail_count < 3 limit #{count}")
    List<MediaProcess> selectListByShardIndex(@Param("shardTotal") int shardTotal, @Param("shardIndex") int shardIndex, @Param("count") int count);

    /**
     * @param id: 任务id
     * @return int 更新记录数
     * @author buxitang
     * @description 开启一个任务
     * @date 2023/5/8 14:34
     */
    @Update("update media_process m set m.status='4' where (m.status='1' or m.status='3') and m.fail_count<3 and m.id=#{id}")
    int startTask(@Param("id") long id);
}

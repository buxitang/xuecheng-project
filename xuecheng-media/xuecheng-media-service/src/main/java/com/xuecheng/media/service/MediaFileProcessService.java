package com.xuecheng.media.service;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.base.model.RestResponse;
import com.xuecheng.media.model.dto.QueryMediaParamsDto;
import com.xuecheng.media.model.dto.UploadFileParamsDto;
import com.xuecheng.media.model.dto.UploadFileResultDto;
import com.xuecheng.media.model.po.MediaFiles;
import com.xuecheng.media.model.po.MediaProcess;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;
import java.io.File;
import java.util.List;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 媒资文件处理业务方法
 * @date: 2023/5/8 14:25
 * @version: 1.0
 */

public interface MediaFileProcessService {

    /**
     * @param shardIndex: 分片序号
     * @param shardTotal: 分片总数
     * @param count:获取记录数
     * @return List<MediaProcess>
     * @author buxitang
     * @description 获取待处理任务
     * @date 2023/5/8 14:26
     */
    public List<MediaProcess> getMediaProcessList(int shardIndex, int shardTotal, int count);

    /**
     * @param id: 任务id
     * @return boolean true开启任务成功，false开启任务失败
     * @author buxitang
     * @description 开启一个任务
     * @date 2023/5/8 14:38
     */
    public boolean startTask(long id);

    /**
     * @param taskId: 任务id
     * @param status: 任务状态
     * @param fileId: 文件id
     * @param url: url
     * @param errorMsg: 错误信息
     * @return void
     * @author buxitang
     * @description 保存任务结果
     * @date 2023/5/8 14:56
     */
    void saveProcessFinishStatus(Long taskId,String status,String fileId,String url,String errorMsg);

}

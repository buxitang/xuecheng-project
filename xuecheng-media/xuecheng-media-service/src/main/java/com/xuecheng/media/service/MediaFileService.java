package com.xuecheng.media.service;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.base.model.RestResponse;
import com.xuecheng.media.model.dto.QueryMediaParamsDto;
import com.xuecheng.media.model.dto.UploadFileParamsDto;
import com.xuecheng.media.model.dto.UploadFileResultDto;
import com.xuecheng.media.model.po.MediaFiles;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description:
 * @date: 2023/5/2 11:07
 * @version: 1.0
 */
public interface MediaFileService {

    /**
     * @param companyId: 机构id
     * @param pageParams: 分页参数
     * @param queryMediaParamsDto: 查询条件
     * @return PageResult<MediaFiles>
     * @author buxitang
     * @description 媒资文件查询方法
     * @date 2023/5/2 11:23
     */
    public PageResult<MediaFiles> queryMediaFiels(Long companyId,PageParams pageParams, QueryMediaParamsDto queryMediaParamsDto);

    /**
     * @param companyId: 机构id
     * @param uploadFileParamsDto: 上传文件信息
     * @param localFilePath: 文件磁盘路径
     * @return UploadFileResultDto
     * @author buxitang
     * @description 上传文件
     * @date 2023/5/2 12:22
     */
    public UploadFileResultDto uploadFile(Long companyId, UploadFileParamsDto uploadFileParamsDto, String localFilePath);

    /**
     * @param companyId: 机构id
     * @param fileMd5: 文件md5值
     * @param uploadFileParamsDto: 上传文件的信息
     * @param bucket: 桶
     * @param objectName: 对象名称
     * @return MediaFiles
     * @author buxitang
     * @description 将文件信息添加到文件表
     * @date 2023/5/2 12:33
     */
    public MediaFiles addMediaFilesToDb(Long companyId, String fileMd5, UploadFileParamsDto uploadFileParamsDto, String bucket, String objectName);

    /**
     * @param fileMd5: 文件的md5
     * @return RestResponse<Boolean>
     * @author buxitang
     * @description 检查文件是否存在
     * @date 2023/5/2 21:30
     */
    public RestResponse<Boolean> checkFile(String fileMd5);

    /**
     * @param fileMd5: 文件的md5
     * @param chunkIndex: 分块序号
     * @return RestResponse<Boolean>
     * @author buxitang
     * @description 检查分块是否存在
     * @date 2023/5/2 21:30
     */
    public RestResponse<Boolean> checkChunk(String fileMd5, int chunkIndex);

    /**
     * @param fileMd5: 文件md5
     * @param chunk: 分块序号
     * @param localChunkFilePath: 分块文件本地路径
     * @return RestResponse
     * @author buxitang
     * @description 上传分块
     * @date 2023/5/2 22:45
     */
    public RestResponse uploadChunk(String fileMd5,int chunk,String localChunkFilePath);

    /**
     * @param companyId: 机构id
     * @param fileMd5: 文件md5
     * @param chunkTotal: 分块总和
     * @param uploadFileParamsDto: 文件信息
     * @return RestResponse
     * @author buxitang
     * @description 合并分块
     * @date 2023/5/2 23:42
     */
    public RestResponse mergeChunks(Long companyId,String fileMd5,int chunkTotal,UploadFileParamsDto uploadFileParamsDto);

    /**
     * @param bucket: 桶
     * @param objectName: 对象名称
     * @return File 下载后的文件
     * @author buxitang
     * @description 从minIO下载文件
     * @date 2023/5/8 17:33
     */
    public File downloadFileFromMinIO(String bucket, String objectName);

    /**
     * @param localFilePath: 文件地址
     * @param mimeType:  媒体类型
     * @param bucket:  桶
     * @param objectName: 对象名称
     * @return boolean
     * @author buxitang
     * @description 将文件写入minIO
     * @date 2023/5/2 12:34
     */
    public boolean addMediaFilesToMinIO(String localFilePath, String mimeType, String bucket, String objectName);
}

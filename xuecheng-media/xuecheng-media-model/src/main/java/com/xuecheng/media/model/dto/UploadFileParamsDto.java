package com.xuecheng.media.model.dto;

import lombok.Data;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 上传普通文件请求参数
 * @date: 2023/5/2 12:18
 * @version: 1.0
 */

@Data
public class UploadFileParamsDto {

    /**
     * 文件名称
     */
    private String filename;

    /**
     * 文件类型（文档，音频，视频）
     */
    private String fileType;
    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 标签
     */
    private String tags;

    /**
     * 上传人
     */
    private String username;

    /**
     * 备注
     */
    private String remark;
}


package com.xuecheng.base.exception;

import java.io.Serializable;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 错误响应参数包装
 * @date: 2023/4/29 19:40
 * @version: 1.0
 */
public class RestErrorResponse implements Serializable {

    private String errMessage;

    public RestErrorResponse(String errMessage){
        this.errMessage= errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}


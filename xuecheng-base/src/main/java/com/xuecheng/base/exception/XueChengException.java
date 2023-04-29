package com.xuecheng.base.exception;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 学成在线项目异常类
 * @date: 2023/4/29 19:33
 * @version: 1.0
 */
public class XueChengException extends RuntimeException {

    private String errMessage;

    public XueChengException() {
        super();
    }

    public XueChengException(String errMessage) {
        super(errMessage);
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public static void cast(CommonError commonError){
        throw new XueChengException(commonError.getErrMessage());
    }
    public static void cast(String errMessage){
        throw new XueChengException(errMessage);
    }

}

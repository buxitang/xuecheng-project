package com.xuecheng.ucenter.service;

import com.xuecheng.ucenter.model.po.XcUser;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: 微信认证接口
 * @date: 2023/8/16 2:00
 * @version: 1.0
 */

public interface WxAuthService {
    /**
     * @param code:
     * @return XcUser
     * @author buxitang
     * @description 微信扫码认证，携带令牌查询用户信息，保存用户信息到数据库
     * @date 2023/8/16 2:04
     */
    public XcUser wxAuth(String code);
}

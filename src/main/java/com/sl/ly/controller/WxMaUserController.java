package com.sl.ly.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.alibaba.fastjson.JSON;
import com.sl.ly.common.PassToken;
import com.sl.ly.pojo.User;
import com.sl.ly.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "微信-用户")
@RestController
@RequestMapping("/wx/user")
public class WxMaUserController {
    @Autowired
    private WxMaService wxMaService;

    @Autowired
    private UserService userService;

    @PassToken
    @ApiOperation("获取用户openID")
    @RequestMapping(value = "/login/{code}", method = RequestMethod.GET)
    public String login(@PathVariable("code") String code) {
        try {
            WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(code);
            String openid = sessionInfo.getOpenid();
            User userInfo = userService.getUserInfo(openid);
            if (userInfo == null){
                System.out.println(JSON.toJSONString(sessionInfo));
                return JSON.toJSONString(sessionInfo);
            }
            System.out.println(JSON.toJSONString(userInfo));
            //JwtUtils.createJWT(userInfo.getUserUUID());
           return JSON.toJSONString(userInfo);
        } catch (WxErrorException e) {
            return "bad code";
        }
    }
}

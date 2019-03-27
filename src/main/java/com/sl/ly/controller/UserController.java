package com.sl.ly.controller;

import com.sl.ly.pojo.User;
import com.sl.ly.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户注册 -1: 用户已经存在/ 0: 验证码错误/ 注册成功则返回用户信息")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(User user, String code) {
        return userService.register(user, code);
    }

    @ApiOperation("更新用户信息 -1: 用户已经存在/ 0: 验证码错误/ 1: 修改成功（针对修改手机号码）")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public int updateUserInfo(User user, String code) {
        return userService.updateUserInfo(user, code);
    }

    @ApiOperation("根据用户手机号搜索用户")
    @RequestMapping(value = "/search/{phone}", method = RequestMethod.GET)
    public User searchUserByPhone(@PathVariable("phone") String phone) {
        return userService.searchUserByPhone(phone);
    }
}

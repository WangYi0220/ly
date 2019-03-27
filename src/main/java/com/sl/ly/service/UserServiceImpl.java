package com.sl.ly.service;

import com.sl.ly.mapper.UserMapper;
import com.sl.ly.pojo.User;
import com.sl.ly.utils.RedisUtils;
import com.sl.ly.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private ProjectService projectService;

    /**
     * 获取用户信息
     *
     * @param openID
     * @return
     */
    @Override
    public User getUserInfo(String openID) {
        return userMapper.getUserInfo(openID);
    }

    /**
     * 绑定用户信息
     *
     * @param user
     * @return -1: 用户已经存在/ 0: 验证码错误/ 1: 注册成功
     */
    @Override
    public Object register(User user, String code) {
        String codeRedis = (String) redisUtils.get(user.getPhone());
        System.out.println(user);
        System.out.println(code);
        if (code == null || !code.equals(codeRedis)) return 0;
        String isExist = isExist(user.getOpenID(), user.getPhone());
        System.out.println("isExist："+isExist);
        if (isExist != null) return -1;
        String uuid = UUIDUtils.getUUID();
        user.setUserUUID(uuid);
        userMapper.register(user);
        projectService.updateProjectByPhone(uuid, user.getPhone());//设置已存在项目的userUUID字段
        return user;
    }

    /**
     * 判断手机号码是否被绑定
     * @param openID
     * @param phone
     * @return
     */
    @Override
    public String isExist(String openID, String phone) {
        return userMapper.isExist(openID, phone);
    }

    /**
     * 更新用户信息
     * @param user
     * @param code
     * @return -1: 用户已经存在/ 0: 验证码错误/ 1: 修改成功（针对修改手机号码）
     */
    @Override
    public int updateUserInfo(User user, String code) {
        if (code != null){
            String codeRedis = (String) redisUtils.get(user.getPhone());
            if (codeRedis == null || !code.equals(codeRedis)) return 0;
            String isExist = isExist(user.getOpenID(), user.getPhone());
            System.out.println("isExist："+isExist);
            if (isExist != null) return -1;
        }
        userMapper.updateUserInfo(user);
        return 1;
    }

    /**
     * 根据用户手机号搜索用户
     * @param phone
     * @return
     */
    @Override
    public User searchUserByPhone(String phone) {
        return userMapper.searchUserByPhone(phone);
    }

    @Override
    public String getUserUUID(String userUUID) {
        return userMapper.getUserUUID(userUUID);
    }
}

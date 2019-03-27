package com.sl.ly.service;

import com.sl.ly.pojo.User;

public interface UserService {
    User getUserInfo(String openID);

    Object register(User user,String code);

    String isExist(String openID, String phone);

    int updateUserInfo(User user, String code);

    User searchUserByPhone(String phone);

    String getUserUUID(String userUUID);
}

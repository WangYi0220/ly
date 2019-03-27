package com.sl.ly.mapper;

import com.sl.ly.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User getUserInfo(@Param("openID") String openID);

    void register(User user);

    String isExist(@Param("openID") String openID, @Param("phone") String phone);

    void updateUserInfo(User user);

    User searchUserByPhone(@Param("phone") String phone);

    String getUserUUID(@Param("userUUID") String userUUID);
}

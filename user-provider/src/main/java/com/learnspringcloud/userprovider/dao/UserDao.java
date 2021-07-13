package com.learnspringcloud.userprovider.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    int register(@Param("uname") String uname,
                 @Param("upassword")String upassword,
                 @Param("usex")String usex);

    User login(@Param("uname")String uname);
}

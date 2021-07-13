package com.learnspringcloud.goodsprovider.dao;

import com.entity.Userorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao {

    List<Userorder> getAllOrder(@Param("uid") int uid);
}

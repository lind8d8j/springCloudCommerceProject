package com.learnspringcloud.goodsprovider.dao;

import com.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {

    List<Goods> getAllGoods();

    List<Goods> getLikeGoods(@Param("gname") String gname);

    Goods getIdGoods(@Param("gid") Integer gid);
}

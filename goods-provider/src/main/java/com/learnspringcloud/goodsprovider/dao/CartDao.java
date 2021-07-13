package com.learnspringcloud.goodsprovider.dao;

import com.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartDao {

    List<Cart> getAllCart(@Param("uid")int uid);

    int insertCart(@Param("goodsname")String goodsname,
                   @Param("number")int number,
                   @Param("price")int price,
                   @Param("goodid")int goodid,
                   @Param("uid")int uid);

    int updateCart(@Param("number")int number,
                   @Param("id")int id);


    int deleteCart(@Param("did")int did);

    int insertOrder(@Param("goodsname") String goodsname,
                    @Param("number") int number,
                    @Param("price") int price,
                    @Param("uid") int uid);
}

package com.learnspringcloud.goodsprovider.controller;

import com.entity.Cart;
import com.learnspringcloud.goodsprovider.dao.CartDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CartController {

    @Resource
    CartDao cartDao;

    @GetMapping("/getAllCart")
    public List<Cart> getAllCart(@RequestParam("uid") int uid){
        return cartDao.getAllCart(uid);
    }

    @GetMapping("/insertCart")
    public int insertCart(@RequestParam("goodsname")String goodsname,
                          @RequestParam("number")int number,
                          @RequestParam("price")int price,
                          @RequestParam("goodid")int goodid,
                          @RequestParam("uid")int uid){
        return cartDao.insertCart(goodsname,number,price,goodid,uid);
    }

    @GetMapping("/updateCart")
    public int updateCart(@RequestParam("number")int number,
                          @RequestParam("id")int id){
        return cartDao.updateCart(number,id);
    }

    @GetMapping("/deleteCart")
    public int deleteCart(@RequestParam("did")int did){
        return cartDao.deleteCart(did);
    }

    @GetMapping("/insertOrder")
    public int insertOrder(@RequestParam("goodsname") String goodsname,
                           @RequestParam("number") int number,
                           @RequestParam("price") int price,
                           @RequestParam("uid") int uid){
        return cartDao.insertOrder(goodsname, number, price, uid);
    }
}

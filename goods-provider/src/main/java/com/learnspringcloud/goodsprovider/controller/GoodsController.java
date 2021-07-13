package com.learnspringcloud.goodsprovider.controller;

import com.entity.Goods;
import com.learnspringcloud.goodsprovider.dao.GoodsDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GoodsController {

    @Resource
    GoodsDao goodsDao;

    @GetMapping("/getAllGoods")
    public List<Goods> getAllGoods(){
        return goodsDao.getAllGoods();
    }

    @GetMapping("/getLikeGoods")
    public List<Goods> getLikeGoods(@RequestParam("gname")String gname){
        return goodsDao.getLikeGoods(gname);
    }

    @GetMapping("/getIdGoods")
    public Goods getIdGoods(@RequestParam("gid")int gid){
        return goodsDao.getIdGoods(gid);
    }
}

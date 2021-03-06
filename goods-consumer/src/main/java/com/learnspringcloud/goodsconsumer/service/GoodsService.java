package com.learnspringcloud.goodsconsumer.service;

import com.entity.Goods;
import com.learnspringcloud.goodsconsumer.hystrix.GoodsServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "goods-provider",fallback = GoodsServiceHystrix.class)
//@FeignClient(value = "goods-provider")
public interface GoodsService {
    @GetMapping("/getAllGoods")
    public List<Goods> getAllGoods();

    @GetMapping("/getLikeGoods")
    public List<Goods> getLikeGoods(@RequestParam("gname")String gname);

    @GetMapping("/getIdGoods")
    public Goods getIdGoods(@RequestParam("gid")int gid);
}

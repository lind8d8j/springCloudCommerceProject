package com.learnspringcloud.goodsconsumer.hystrix;

import com.entity.Goods;
import com.learnspringcloud.goodsconsumer.service.GoodsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsServiceHystrix implements GoodsService{
    @Override
    public List<Goods> getAllGoods() {
        return null;
    }

    @Override
    public List<Goods> getLikeGoods(String gname) {
        return null;
    }

    @Override
    public Goods getIdGoods(int gid) {
        return null;
    }
}

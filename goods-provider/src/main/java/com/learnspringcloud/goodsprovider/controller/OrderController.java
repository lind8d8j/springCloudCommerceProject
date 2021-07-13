package com.learnspringcloud.goodsprovider.controller;

import com.entity.Userorder;
import com.learnspringcloud.goodsprovider.dao.OrderDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    OrderDao orderDao;

    @GetMapping("/getAllOrder")
    List<Userorder> getAllOrder(@RequestParam("uid") int uid){
        return orderDao.getAllOrder(uid);
    }
}

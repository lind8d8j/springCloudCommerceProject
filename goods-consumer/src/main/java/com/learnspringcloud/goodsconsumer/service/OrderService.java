package com.learnspringcloud.goodsconsumer.service;

import com.entity.Userorder;
import com.learnspringcloud.goodsconsumer.hystrix.OrderServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "goods-provider",fallback = OrderServiceHystrix.class)
//@FeignClient(value = "goods-provider")
public interface OrderService {

    @GetMapping("/getAllOrder")
    List<Userorder> getAllOrder(@RequestParam("uid") int uid);
}

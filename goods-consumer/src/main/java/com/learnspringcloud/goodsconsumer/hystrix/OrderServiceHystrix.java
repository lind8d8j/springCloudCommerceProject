package com.learnspringcloud.goodsconsumer.hystrix;

import com.entity.Userorder;
import com.learnspringcloud.goodsconsumer.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceHystrix  implements OrderService {
    @Override
    public List<Userorder> getAllOrder(int uid) {
        return null;
    }
}

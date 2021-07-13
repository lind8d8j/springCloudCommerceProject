package com.learnspringcloud.userconsumer.servcie;

import com.entity.User;
import com.learnspringcloud.userconsumer.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "user-provider",fallback = UserServiceHystrix.class)
//@FeignClient(value = "user-provider")
public interface UserService {

    @GetMapping("/register")
    public int register(@RequestParam("uname") String uname,
                        @RequestParam("upassword") String upassword,
                        @RequestParam("usex") String usex);

    @GetMapping("/login")
    public User login(@RequestParam("uname")String uname);
}

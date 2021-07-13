package com.learnspringcloud.userconsumer.hystrix;

import com.entity.User;
import com.learnspringcloud.userconsumer.servcie.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {
    @Override
    public int register(String uname, String upassword, String usex) {
        return 0;
    }

    @Override
    public User login(String uname) {
        return null;
    }
}

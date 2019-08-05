package com.sls.demo.web.api;

import com.sls.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sls
 **/
@RestController
public class TestController {

    @Resource
    private UserService userService;

    @GetMapping("/test")
    public void test() {
        System.out.println(userService.getUser(1));
        System.out.println(userService.ok());
        userService.say();
    }
}

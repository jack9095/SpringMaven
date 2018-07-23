package com.spring.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 控制层
 */
@Controller
public class UserController {

    @Autowired
    private UserSerVice userSerVice;

    public void execute(){
        System.out.println("UserController execute...");
        userSerVice.add();
        System.out.println("UserController execute...fly");
    }
}

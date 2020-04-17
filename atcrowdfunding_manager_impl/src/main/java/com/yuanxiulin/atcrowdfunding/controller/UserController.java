package com.yuanxiulin.atcrowdfunding.controller;

import com.yuanxiulin.atcrowdfunding.manager.service.UserService;
import com.yuanxiulin.atcrowdfunding.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index(@RequestParam(value="pageNo",required = false,defaultValue = "1") Integer pageNo,
                        @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize, Map<String,Object> map){

        Page page = userService.queryPage(pageNo,pageSize);
        map.put("page",page);

        return "user/index";
    }
}

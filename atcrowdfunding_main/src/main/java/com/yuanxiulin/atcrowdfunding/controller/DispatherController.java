package com.yuanxiulin.atcrowdfunding.controller;

import com.yuanxiulin.atcrowdfunding.bean.User;
import com.yuanxiulin.atcrowdfunding.manager.service.UserService;
import com.yuanxiulin.atcrowdfunding.util.AjaxResult;
import com.yuanxiulin.atcrowdfunding.util.Const;
import com.yuanxiulin.atcrowdfunding.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
//@Scope("prototype")
public class DispatherController {

    @Autowired
    UserService userService;
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){

        session.invalidate();//销毁session对象

        return "redirect:/index.htm";
    }

    //异步请求
    @ResponseBody
    @RequestMapping("/doLogin")
    public Object doLogin(String loginacct, String userpswd, String type, HttpSession session){

        AjaxResult result = new AjaxResult();
        try {
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("loginacct",loginacct);
            paramMap.put("userpswd", MD5Util.digest(userpswd));
            paramMap.put("type",type);

            User user = userService.queryUserByLogin(paramMap);

            session.setAttribute(Const.LOGIN_USER,user);

            result.setSuccess(true);

        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("密码或账号错误");
        }
        return result;
    }


    /* @RequestMapping("/doLogin")
    public String doLogin(String loginacct, String userpswd, String type, HttpSession session){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("loginacct",loginacct);
        paramMap.put("userpswd",userpswd);
        paramMap.put("type",type);

        User user = userService.queryUserByLogin(paramMap);

        session.setAttribute(Const.LOGIN_USER,user);
        return "redirect:/main.htm";
    }
*/
}

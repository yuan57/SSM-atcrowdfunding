package com.yuanxiulin.atcrowdfunding.controller;

import com.yuanxiulin.atcrowdfunding.bean.User;
import com.yuanxiulin.atcrowdfunding.manager.service.UserService;
import com.yuanxiulin.atcrowdfunding.util.AjaxResult;
import com.yuanxiulin.atcrowdfunding.util.Const;
import com.yuanxiulin.atcrowdfunding.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/doDeleteUserBatch")
    public Object doDeleteUserBatch(Integer[] id){
        AjaxResult result = new AjaxResult();
        try {
            int count = userService.doDeleteUserBatch(id);
            result.setSuccess(count == id.length);
            result.setMessage("删除这些用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("删除这些用户失败");
        }
        return  result;
    }


    @ResponseBody
    @RequestMapping("/doDelete")
    public Object doDelete(Integer id){
        AjaxResult result = new AjaxResult();
        try {
            int count = userService.deleteUserById(id);
            result.setSuccess(count != 0);
            result.setMessage("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("删除失败");
        }
        return  result;
    }

    @ResponseBody
    @RequestMapping("/doUpdate")
    public Object doUpdate(User user){
        AjaxResult result = new AjaxResult();
        try {
            int count = userService.updateUser(user);
            result.setSuccess(count != 0);
            result.setMessage("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("修改失败");
        }
        return  result;
    }



    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id,Map map ){
        User user = userService.queryUserById(id);
        map.put(Const.LOGIN_USER,user);
        return "user/update";
    }


    @ResponseBody
    @RequestMapping("/doAdd")
    public Object doAdd(User user){
        AjaxResult result = new AjaxResult();
        try {
            int count = userService.addUser(user);
            result.setSuccess(count != 0);
            result.setMessage("增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("增加失败");
        }
        return  result;
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/add";
    }

    @ResponseBody
    @RequestMapping("/toIndex")
    public Object toIndex(@RequestParam(value="pageNo",required = false,defaultValue = "1") Integer pageNo,
                          @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                          @RequestParam(value="queryText",required = false) String queryText) {
        AjaxResult result = new AjaxResult();
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("pageNo",pageNo);
        paramMap.put("pageSize",pageSize);
        try {
            if((queryText!=null)&&(!("".equals(queryText)))) {
                if(queryText.contains("%")){
                    queryText = queryText.replace("%","\\\\%");
                }
                    paramMap.put("queryText",queryText);
            }
            Page page = userService.queryPage(paramMap);
            result.setSuccess(true);
            result.setPage(page);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("查找失败");
        }
        return result;
    }

    /*@ResponseBody
    @RequestMapping("/toIndex")
    public Object toIndex(@RequestParam(value="pageNo",required = false,defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize){
        AjaxResult result = null;
        try {
            result = new AjaxResult();
            Page page = userService.queryPage(pageNo,pageSize);
            result.setSuccess(true);
            result.setPage(page);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("查找失败");
        }
        return result;
    }*/


    @RequestMapping("/index")
    public String index(@RequestParam(value="pageNo",required = false,defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize, Map<String,Object> map){

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("pageNo",pageNo);
        paramMap.put("pageSize",pageSize);
        Page page = userService.queryPage(paramMap);
        map.put("page",page);

        return "user/index";
    }
}

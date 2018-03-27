package com.demo.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.demo.common.model.User;
import com.jfinal.aop.Duang;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018/3/27 0027.
 */
public class UserController extends Controller {

    public void index(){
        render("user.html");
    }

    public void getUsers(){
        UserService userService = Duang.duang(UserService.class);
        List<Record> users = userService.getUsers();
        List rst = new ArrayList();
        users.stream().forEach(r->rst.add(r));
        String jstr = JSON.toJSONString(rst);
        renderJson(jstr);
    }

    public void userList(){
        UserService userService = Duang.duang(UserService.class);
        List<User> users = userService.userList();
        String jstr = JSON.toJSONString(users);
        renderJson(jstr);
    }
}

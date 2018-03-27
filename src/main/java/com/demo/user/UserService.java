package com.demo.user;

import com.demo.common.model.User;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * Created by Administrator on 2018/3/27 0027.
 */
public class UserService {


    public List<Record> getUsers(){
        List<Record> users = Db.find("select * from user where 1=1");
        return users;
    }

    public Record getUser(String id){
        id = "5e6d5070b87e4781847b5d515095d3a1";
        Record user = Db.findById("user",id);
        return user;
    }

    public List<User> userList(){
        return User.dao.find("select * from user where 1=1");
    }
}

package com.test;

import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.entity.Users;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        UsersDao usersDao = new UsersDaoImpl();
        List<Users> usersList = usersDao.getUserList();
        System.out.println(usersList.size());
        /*Users users = usersDao.getUsersByID(new Long(1));
        System.out.println(users.getName() + " " + users.getPwd());*/
        Users users = usersDao.getUserByNamePwd("曲志雕", "123456");
        System.out.println(users.getId());
    }
}

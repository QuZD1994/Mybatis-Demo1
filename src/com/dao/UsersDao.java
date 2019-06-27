package com.dao;

import com.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersDao {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<Users> getUserList();

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    Users getUsersByID(Long id);

    /**
     * sql语句需要传递两个参数是是要那个@Param
     * 查询用户信息
     * @param name
     * @param pwd
     * @return
     */
    Users getUserByNamePwd(@Param("name") String name, @Param("pwd") String pwd);
}

package com.dao;

import com.Util.GetSession;
import com.entity.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UsersDaoImpl implements UsersDao{

    private SqlSession sqlSession = null;
    @Override
    public List<Users> getUserList() {

        List<Users> usersList = null;
        SqlSession sqlSession = getSqlsession();
        //4.持久化操作
        usersList = sqlSession.selectList("com.dao.UsersDao.getUserList");
        //5.关闭
        closeSqlsession(sqlSession);
        return usersList;
    }

    @Override
    public Users getUsersByID(Long id) {
        SqlSession sqlSession = getSqlsession();
        Users users = sqlSession.selectOne("com.dao.UsersDao.getUsersByID", id);
        closeSqlsession(sqlSession);
        return users;
    }

    @Override
    public Users getUserByNamePwd(String name, String pwd) {

        SqlSession sqlSession = getSqlsession();
        //需要传递两个参数，采用接口Mapper反射的方式
        //三个参数及以上可用对象封装
        UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
        Users users = usersDao.getUserByNamePwd(name, pwd);
        return users;
    }
    public SqlSession getSqlsession(){
        sqlSession = GetSession.getSqlSession();
        return sqlSession;
    }
    public void closeSqlsession(SqlSession sqlSession){
        if (sqlSession != null){
            sqlSession.close();
        }
    }
}

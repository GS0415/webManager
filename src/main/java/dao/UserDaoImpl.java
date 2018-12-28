package dao;

import pojo.User;
import util.IRowMap;
import util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public int add(User user) {
        return JdbcUtil.zsg("insert into user(username,password,tel) values(?,?,?)", user.getUserName(), user.getPassWord(), user.getTel());
    }

    @Override
    public int del(int id) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public List<User> sel() {
        return null;
    }


    @Override
    public User selOne(int id) {
        return null;
    }
    @Override
    public User selOneUser(String name) {
        return JdbcUtil.selectOne("select * from user where username=?", new IRowMap<User>() {
            @Override
            public User rowMap(ResultSet rs) {
                User user = new User();
                try {
                    user.setPassWord(rs.getString("password"));
                    user.setUserId(rs.getInt("id"));
                    user.setUserName(rs.getString("username"));
                    user.setTel(rs.getString("tel"));
                    user.setPhoto(rs.getString("photo"));
                    user.setSex(rs.getString("sex"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
            }
        }, name);
    }
}

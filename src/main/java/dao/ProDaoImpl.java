package dao;


import pojo.Product;
import util.IRowMap;
import util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProDaoImpl implements IProDao {

    @Override
    public int add(Product pro) {
        return JdbcUtil.zsg("insert into product(product_name,product_price,product_url,product_des) values(?,?,?,?)", pro.getProductName(), pro.getProductPrice(), pro.getProductUrl(), pro.getProductDes());
    }

    @Override
    public int del(int id) {
        return JdbcUtil.zsg("delete from product where product_id=?", id);
    }

    @Override
    public int update(Product pro) {
        return JdbcUtil.zsg("update product set product_name=?,product_price=?,product_url=?,product_des=? where product_id=?", pro.getProductName(), pro.getProductPrice(), pro.getProductUrl(), pro.getProductDes(), pro.getProductId());
    }

    @Override
    public List<Product> sel() {
        return JdbcUtil.select("select * from product", new IRowMap<Product>() {
            @Override
            public Product rowMap(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductUrl(rs.getString("product_url"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setProductPrice(rs.getDouble("product_price"));
                    p.setProductId(rs.getInt("product_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, null);
    }

    @Override
    public Product selOne(int id) {
        return JdbcUtil.selectOne("select * from product where product_id=?", new IRowMap<Product>() {
            @Override
            public Product rowMap(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductName(rs.getString("product_name"));
                    p.setProductPrice(rs.getDouble("product_price"));
                    p.setProductUrl(rs.getString("product_url"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setProductId(rs.getInt("product_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, id);
    }

   /* @Override
    public User SelOneUser(String name) {
        return JdbcUtil.selectOne("select * from user where username=?", new IRowMap<User>() {
            @Override
            public User rowMap(ResultSet rs) {
                User user =new User();
                try {
                    user.setPassWord(rs.getString("password"));
                    user.setUserId(rs.getInt("id"));
                    user.setUserName(rs.getString("username"));
                    user.setTel(rs.getString("tel"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
            }
        }, name);
    }*/


}






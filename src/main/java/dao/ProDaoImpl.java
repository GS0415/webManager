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
        return JdbcUtil.zsg("insert into product(product_name,product_price,product_url,product_des,mark_id,count) values(?,?,?,?,?,?)", pro.getProductName(), pro.getProductPrice(), pro.getProductUrl(), pro.getProductDes(),pro.getMarkId(),pro.getCount());
    }

    @Override
    public int del(int id) {
        return JdbcUtil.zsg("delete from product where product_id=?", id);
    }

    @Override
    public int update(Product pro) {
        return JdbcUtil.zsg("update product set product_name=?,product_price=?,product_url=?,product_des=?,count=?,mark_id=? where product_id=?", pro.getProductName(), pro.getProductPrice(), pro.getProductUrl(), pro.getProductDes(),pro.getCount(),pro.getMarkId(), pro.getProductId());
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
                    p.setCount(rs.getInt("count"));
                    p.setMarkId(rs.getInt("mark_id"));
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
                    p.setCount(rs.getInt("count"));
                    p.setMarkId(rs.getInt("mark_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        }, id);
    }

    @Override
    public int delByMid(int id) {
        return JdbcUtil.zsg("delete * from product where mark_id=?",id);
    }

    @Override
    public int getCount() {
        return JdbcUtil.executeCount("select count(*) from product",null);
    }

    @Override
    public int getCount(String text) {
        return JdbcUtil.executeCount("select count(*) from product where product_name like concat('%',?,'%') ",text);
    }

    @Override
    public List<Product> getResults(String text) {
        return null;
    }

    @Override
    public List<Product> getLists(int pageNo, int pageSize) {
        return JdbcUtil.select("select * from product limit ?,?", new IRowMap<Product>() {
            @Override
            public Product rowMap(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductId(rs.getInt("product_id"));
                    p.setProductPrice(rs.getDouble("product_price"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductUrl(rs.getString("product_url"));
                    p.setCount(rs.getInt("count"));
                    p.setMarkId(rs.getInt("mark_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        },(pageNo-1)*pageSize,pageSize);
    }



    @Override
    public List<Product> getLists(int pageNo, int pageSize, String text) {
        return JdbcUtil.select("select * from product  where product_name like concat('%',?,'%') limit ?,?", new IRowMap<Product>() {


            @Override
            public Product rowMap(ResultSet rs) {
                Product p = new Product();
                try {
                    p.setProductId(rs.getInt("product_id"));
                    p.setProductPrice(rs.getDouble("product_price"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setProductName(rs.getString("product_name"));
                    p.setProductUrl(rs.getString("product_url"));
                    p.setCount(rs.getInt("count"));
                    p.setMarkId(rs.getInt("mark_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        },text,(pageNo-1)*pageSize,pageSize);
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






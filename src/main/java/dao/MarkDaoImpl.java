package dao;

import pojo.Mark;
import pojo.Product;
import util.IRowMap;
import util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MarkDaoImpl implements IMarkDao {
    @Override
    public int addMark(Mark m) {
        return JdbcUtil.zsg("insert into mark (markname,logo)  values(?,?)",m.getMarkName(),m.getLogo());
    }

    @Override
    public int delMark(int id) {
        return JdbcUtil.zsg("delete from mark where markid=?",id);
    }

    @Override
    public int update(Mark m) {
        return JdbcUtil.zsg("update mark set markname=?,markid=?,logo=? ",m.getMarkName(),m.getMarkId(),m.getLogo());
    }

    @Override
    public List<Mark> sel() {
         return JdbcUtil.select("select * from mark,product where markid=mark_id", new IRowMap<Mark>() {
            @Override
            public Mark rowMap(ResultSet rs) {
                Mark m = new Mark();
                try {
                    m.setLogo(rs.getString("logo"));
                    m.setMarkId(rs.getInt("markid"));
                    m.setMarkName(rs.getString("markname"));
                    Set<Product> set =new HashSet<>();
                    Product p = new Product();
                    p.setProductName(rs.getString("product_name"));
                    p.setProductPrice(rs.getDouble("product_price"));
                    p.setProductUrl(rs.getString("product_url"));
                    p.setProductDes(rs.getString("product_des"));
                    p.setProductId(rs.getInt("product_id"));
                    p.setCount(rs.getInt("count"));
                    p.setMarkId(rs.getInt("mark_id"));
                    set.add(p);
                    m.setSet(set);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return m;
            }
        }, null);
    }

    @Override
    public List<Mark> selMark() {
        return JdbcUtil.select("select * from mark", new IRowMap<Mark>() {
            @Override
            public Mark rowMap(ResultSet rs) {
                Mark m=new Mark();
                try {
                    m.setMarkId(rs.getInt("markid"));
                    m.setMarkName(rs.getString("markname"));
                    m.setLogo(rs.getString("logo"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return m;
            }
        }, null);
    }

    @Override
    public Mark selOne(int id) {
        return JdbcUtil.selectOne("select * from Mark where markid=?", new IRowMap<Mark>() {
            @Override
            public Mark rowMap(ResultSet rs) {
                Mark m = new Mark();
                try {
                   m.setMarkName(rs.getString("markname"));
                   m.setLogo(rs.getString("logo"));
                   m.setMarkId(rs.getInt("markid"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return m;
            }
        }, id);
    }
}

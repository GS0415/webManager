package dao;

import pojo.Product;

import java.util.List;

public interface IProDao {

    int add(Product pro);

    int del(int id);

    int update(Product pro);

    List<Product> sel();

    Product selOne(int id);

    int delByMid(int id);


    public int getCount();
    public int getCount(String text);
    public List<Product> getResults(String text);
    public List<Product> getLists(int pageNo, int pageSize);
    public List<Product> getLists(int pageNo, int pageSize,String text);

}

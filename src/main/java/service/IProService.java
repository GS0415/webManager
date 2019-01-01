package service;


import pojo.Product;
import pojo.ResultData;

import java.util.List;

public interface IProService {
    int add(Product pro);

    int del(int id);

    int update(Product pro);

    List<Product> sel();

    Product selOne(int id);

    int delByMid(int id);

    public List<Product> getResults(String text);

    public ResultData getLists(int pageNo, int pageSize, String text);
    public ResultData getLists(int pageNo, int pageSize);
}

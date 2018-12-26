package service;



import pojo.Product;

import java.util.List;

public interface IProService {
    int add(Product pro);

    int del(int id);

    int update(Product pro);

    List<Product> sel();

    Product selOne(int id);

    int delByMid(int id);
}

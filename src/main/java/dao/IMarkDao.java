package dao;

import pojo.Mark;
import pojo.Product;

import java.util.List;

public interface IMarkDao {
    int add(Mark m);

    int delMark(int id);

    int update(Mark m);

    List<Mark> sel();

    List<Mark> selMark();

    Mark selOne(int id);
}

package service;



import dao.IProDao;
import dao.ProDaoImpl;
import pojo.Product;
import pojo.ResultData;

import java.util.List;

public class ProServiceImpl implements IProService {
    private IProDao dao = new ProDaoImpl();

    @Override
    public int add(Product pro) {
        return dao.add(pro);
    }

    @Override
    public int del(int id) {
        return dao.del(id);
    }

    @Override
    public int update(Product pro) {
        return dao.update(pro);
    }

    @Override
    public List<Product> sel() {

        return dao.sel();
    }

    @Override
    public Product selOne(int id) {
        return dao.selOne(id);
    }

    @Override
    public int delByMid(int id) {
        return dao.delByMid(id);
    }

    @Override
    public List<Product> getResults(String text) {
        return null;
    }

    @Override
    public ResultData getLists(int pageNo, int pageSize, String text) {
        ResultData data = new ResultData(pageNo,pageSize,dao.getCount(text));
        data.setLists(dao.getLists(pageNo,pageSize,text));
        return data;
    }
    @Override
    public ResultData getLists(int pageNo, int pageSize) {
        ResultData data = new ResultData(pageNo,pageSize,dao.getCount());
        data.setLists(dao.getLists(pageNo,pageSize));
        return data;
    }
}

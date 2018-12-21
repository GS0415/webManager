package service;



import dao.IProDao;
import dao.ProDaoImpl;
import pojo.Product;

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

}

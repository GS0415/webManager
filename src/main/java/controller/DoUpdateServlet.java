package controller;



import pojo.Product;
import service.IProService;
import service.ProServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doUpdate")
public class DoUpdateServlet extends HttpServlet {
    private IProService service = new ProServiceImpl();
    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        int id = Integer.parseInt(req.getParameter("id"));
        String url = req.getParameter("url");
        String des = req.getParameter("des");
        Product pro = new Product();
        pro.setProductPrice(price);
        pro.setProductDes(des);
        pro.setProductName(name);
        pro.setProductUrl(url);
        pro.setProductId(id);
        service.update(pro);
        resp.sendRedirect("list");
    }
}

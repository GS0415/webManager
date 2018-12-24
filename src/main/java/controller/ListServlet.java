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
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private IProService service = new ProServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = service.sel();
        System.out.println(list);
        req.setAttribute("list", list);
        req.getRequestDispatcher("jsp/list.jsp").forward(req, resp);
    }
}

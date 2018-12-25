package controller;


import pojo.Product;
import pojo.User;
import service.IProService;
import service.IUserService;
import service.ProServiceImpl;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private IProService service = new ProServiceImpl();
    IUserService service1 = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = service.sel();
        String name = req.getParameter("name");
        System.out.println(name);
        User user=service1.selOneUser(name);
        System.out.println(user);
        req.setAttribute("user",user);
        req.setAttribute("list", list);
        req.getRequestDispatcher("jsp/list.jsp").forward(req, resp);
    }
}

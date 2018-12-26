package controller;


import dao.IMarkDao;
import dao.MarkDaoImpl;
import pojo.Mark;
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
    IMarkDao service = new MarkDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Mark> list=service.sel();
        req.setAttribute("list", list);
        req.getRequestDispatcher("jsp/list.jsp").forward(req, resp);
    }
}

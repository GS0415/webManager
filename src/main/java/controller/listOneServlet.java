package controller;

import pojo.User;
import service.IUserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/listOne")
public class listOneServlet extends HttpServlet {
    IUserService service1 = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println(name);
        User user=service1.selOneUser(name);
        System.out.println(user);
        req.setAttribute("user",user);
        req.getRequestDispatcher("jsp/listOne.jsp").forward(req, resp);
    }


}

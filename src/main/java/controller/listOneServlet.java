package controller;

import pojo.User;
import service.IUserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/listOne")
public class listOneServlet extends HttpServlet {
    IUserService service1 = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        /*User u = User( session.getAttribute("user") );*/
        System.out.println(session.getAttribute("user"));
        req.getRequestDispatcher("jsp/listOne.jsp").forward(req, resp);
    }


}

package controller;

import dao.IMarkDao;
import dao.MarkDaoImpl;
import pojo.User;
import service.IProService;
import service.IUserService;
import service.ProServiceImpl;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

import static controller.listOneServlet.getCookie;

@WebServlet("/deleteMark")
public class DeleteMarkServlet extends HttpServlet {
    private IMarkDao service2 = new MarkDaoImpl();
    private IProService service = new ProServiceImpl();
    private IUserService service1=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("markId"));
        Cookie[] cookies = req.getCookies();
        Map<String, Cookie> map = getCookie(cookies);
        Cookie cookie = map.get("name");

        if (cookie == null) {
            resp.sendRedirect("login");
        } else {
            String name = cookie.getValue();
            User u = service1.selOneUser(name);
            HttpSession session = req.getSession();
            session.setAttribute("user", u);
            if (u.getQuan().equals("2")) {
                resp.sendRedirect("no");
            } else {
                service2.delMark(id);
                service.delByMid(id);
                resp.sendRedirect("listTwo");
            }
        }
    }
}

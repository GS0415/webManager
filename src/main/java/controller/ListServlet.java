package controller;


import dao.IMarkDao;
import dao.MarkDaoImpl;
import pojo.Mark;
import pojo.User;
import service.IUserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static controller.listOneServlet.getCookie;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    IMarkDao service = new MarkDaoImpl();
    IUserService service1 = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            List<Mark> list = service.sel();
            req.setAttribute("list", list);
            req.getRequestDispatcher("jsp/list.jsp").forward(req, resp);
        }
    }
}

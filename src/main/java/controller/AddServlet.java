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

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private IMarkDao service =new MarkDaoImpl();
    private IUserService service1=new UserServiceImpl();
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
           /* List<Mark> markList = service.selMark();
            req.setAttribute("markList",markList);*/
            req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
        }
    }
}

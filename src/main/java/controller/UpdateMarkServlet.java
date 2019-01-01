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
import java.util.Map;

import static controller.listOneServlet.getCookie;

@WebServlet("/updateMark")
public class UpdateMarkServlet extends HttpServlet {
    private IMarkDao service =new MarkDaoImpl();
    private IUserService service1=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("markId"));
        Mark m = service.selOne(id);
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
                req.setAttribute("m", m);
                req.getRequestDispatcher("jsp/updateMark.jsp").forward(req, resp);
            }
        }
    }
}

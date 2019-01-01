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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static controller.listOneServlet.getCookie;

@MultipartConfig
@WebServlet("/update")

public class UpdateServlet extends HttpServlet {
    private IUserService service1=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IProService service = new ProServiceImpl();
        IMarkDao service2 = new MarkDaoImpl();
        int id = Integer.parseInt(req.getParameter("productId"));
        Product pro = service.selOne(id);
        List<Mark> markList = service2.selMark();
        req.setAttribute("markList", markList);
        req.setAttribute("pro", pro);
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
                req.getRequestDispatcher("jsp/update.jsp").forward(req, resp);
            }
        }
    }
}

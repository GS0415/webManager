package controller;


import pojo.User;
import service.IUserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/listOne")
public class listOneServlet extends HttpServlet {
    IUserService service1 = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Map<String, Cookie> map = getCookie(cookies);
        Cookie cookie = map.get("name");


        if (cookie == null) {
            resp.sendRedirect("login");
        }else {
            String name = cookie.getValue();
            User u = service1.selOneUser(name);
            HttpSession session = req.getSession();
            session.setAttribute("user",u);
            req.getRequestDispatcher("jsp/listOne.jsp").forward(req, resp);
        }
    }





    public static Map<String, Cookie> getCookie(Cookie[] cookies) {
        Map<String, Cookie> map = new HashMap<>();
        if (cookies != null) {
            for (Cookie cookie : cookies
            ) {
                map.put(cookie.getName(), cookie);
            }
        }
        return map;
    }

}

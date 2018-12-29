package controller;

import pojo.User;
import service.IUserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        IUserService service = new UserServiceImpl();
        User user = null;
        String pw = req.getParameter("pwd");
        String name = req.getParameter("un");
        user = service.selOneUser(name);
        req.setAttribute("user", user);


        if (user != null) { // 可以使用
            if (user.getPassWord().equals(pw)) {
                Cookie cookie = new Cookie("name", name);
                cookie.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(cookie);
                HttpSession session =req.getSession();
                session.setAttribute("user",user);
                resp.getWriter().write("1");//密码匹配
            } else {
                resp.getWriter().write("2");//密码不正确
            }
        } else {
            resp.getWriter().write("3"); // 用户不存在
        }
    }
}

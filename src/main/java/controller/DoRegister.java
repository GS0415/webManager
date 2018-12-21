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

@WebServlet("/doRegister")
public class DoRegister extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("us");
        String pwd = req.getParameter("pwd");
        String pwds = req.getParameter("pwds");
        User user = service.selOneUser(username);
        if (user == null) {
            resp.getWriter().write("1");//可以注册
            System.out.println(pwd);
            if (pwd != "") {
                if (pwd.equals(pwds)) {
                    resp.getWriter().write("1");//可以注册 密码正确
                } else {
                    resp.getWriter().write("2");//可以注册 密码不正确
                }
            }
        } else {
            resp.getWriter().write("2");//用户名存在
            if (pwd != "") {
                if (pwd.equals(pwds)) {
                    resp.getWriter().write("1");//不可以注册 密码正确
                } else {
                    resp.getWriter().write("2");//不可以注册 密码不正确
                }
            }
        }
    }
}
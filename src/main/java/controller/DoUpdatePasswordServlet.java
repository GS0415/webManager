package controller;

import pojo.User;
import service.IUserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet("/doUpdatePassword")
public class DoUpdatePasswordServlet extends HttpServlet {
    private IUserService service=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pw=req.getParameter("pw");
        String pwd=req.getParameter("pwd");
        String pwds=req.getParameter("pwds");
        /*Cookie[] cookies =req.getCookies();
        Map<String,Cookie> map = getCookie(cookies);
        Cookie cookie =map.get("name");*/
        HttpSession session=req.getSession();
        User u = (User) session.getAttribute("user");
        String password =u.getPassWord();
        if(password.equals(pw)){
            if(pwd.equals(pwds)){
                u.setPassWord(pwd);
                service.update(u);
                resp.getWriter().write("1");//修改成功
            }else {
                resp.getWriter().write("2");//修改失败
            }
        }else {
            resp.getWriter().write("3");//修改失败
        }

    }
}

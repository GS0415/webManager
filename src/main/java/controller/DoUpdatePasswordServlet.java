package controller;

import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/doUpdatePassword")
public class DoUpdatePasswordServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pw=req.getParameter("pw");
        String pwd=req.getParameter("pwd");
        String pwds=req.getParameter("pwds");
        HttpSession session =req.getSession();
        System.out.println(session.getAttribute("user"));

    }
}

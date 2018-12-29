package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

import static controller.listOneServlet.getCookie;

@WebServlet("/exit")
public class Exit extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Map<String, Cookie> map = getCookie(cookies);
        HttpSession session = req.getSession();
        Cookie cookie=map.get("name");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        session.invalidate();
        resp.sendRedirect("login");
    }
}

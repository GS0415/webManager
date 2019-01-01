package controller;

import pojo.ResultData;
import pojo.User;
import service.IProService;
import service.IUserService;
import service.ProServiceImpl;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

import static controller.listOneServlet.getCookie;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    /*IMarkDao service = new MarkDaoImpl();*/
    IUserService service1 = new UserServiceImpl();
    IProService service = new ProServiceImpl();

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


            //分页

            int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
            int pageSize = 3;
            /*模糊查询*/
            String text = req.getParameter("text");
            if (text == "" || text == null) {
                /*list 分页条*/
                ResultData data = service.getLists(pageNo, pageSize);
                data.setUrl("list", "");
                req.setAttribute("data", data);
                req.getRequestDispatcher("jsp/list.jsp").forward(req, resp);
            } else {
                ResultData data = service.getLists(pageNo, pageSize, text);
                String params = "&text=" + text;
                data.setUrl("list", params);
                req.setAttribute("text", text);
                req.setAttribute("data", data);
                req.getRequestDispatcher("jsp/list.jsp").forward(req, resp);
            }

            //分页


        }
    }
}

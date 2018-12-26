package controller;

import dao.IMarkDao;
import dao.MarkDaoImpl;
import pojo.Mark;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateMark")
public class UpdateMarkServlet extends HttpServlet {
    private IMarkDao service =new MarkDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("markId"));
        Mark m=service.selOne(id);
        req.setAttribute("m",m);
        req.getRequestDispatcher("jsp/updateMark.jsp").forward(req,resp);
    }
}

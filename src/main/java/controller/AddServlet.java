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
import java.util.List;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private IMarkDao service =new MarkDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Mark> markList = service.selMark();
        req.setAttribute("markList",markList);
        req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
    }
}

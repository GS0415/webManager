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

@WebServlet("/listTwo")
public class ListTwoServlet extends HttpServlet {
    private IMarkDao service = new MarkDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Mark> list= service.selMark();
        req.setAttribute("list",list);
        req.getRequestDispatcher("jsp/listTwo.jsp").forward(req,resp);
    }
}

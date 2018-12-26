package controller;

import dao.IMarkDao;
import dao.MarkDaoImpl;
import service.IProService;
import service.ProServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteMark")
public class DeleteMarkServlet extends HttpServlet {
    private IMarkDao service = new MarkDaoImpl();
    private IProService service1=new ProServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("markId"));
        service.delMark(id);
        service1.delByMid(id);
        resp.sendRedirect("listTwo");

    }
}

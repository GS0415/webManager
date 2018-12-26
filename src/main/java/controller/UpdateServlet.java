package controller;



import dao.IMarkDao;
import dao.MarkDaoImpl;
import pojo.Mark;
import pojo.Product;
import service.IProService;
import service.ProServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@MultipartConfig
@WebServlet("/update")

public class UpdateServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IProService service = new ProServiceImpl();
        IMarkDao service1 =new MarkDaoImpl();
        int id = Integer.parseInt(req.getParameter("productId"));
        System.out.println(req.getParameter("productId"));
        Product pro = service.selOne(id);
        System.out.println(pro);
        List<Mark> markList = service1.selMark();
        req.setAttribute("markList",markList);
        req.setAttribute("pro", pro);
        req.getRequestDispatcher("jsp/update.jsp").forward(req, resp);
    }
}

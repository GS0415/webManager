package controller;



import pojo.Product;
import service.IProService;
import service.ProServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")

public class UpdateServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IProService service = new ProServiceImpl();
        int id = Integer.parseInt(req.getParameter("productId"));
        Product pro = service.selOne(id);
        req.setAttribute("pro", pro);
        req.getRequestDispatcher("Jsps/update.jsp").forward(req, resp);
    }
}

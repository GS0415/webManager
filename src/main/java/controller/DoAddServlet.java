package controller;

import pojo.Product;
import service.IProService;
import service.ProServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
@MultipartConfig
@WebServlet("/doAdd")
public class DoAddServlet extends HttpServlet {
    private IProService service = new ProServiceImpl();
    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));

        Part part =req.getPart("url");
        /*System.out.println(part);*/
        String str = "C:\\Users\\Administrator\\IdeaProjects\\webManager\\src\\main\\webapp\\images\\"+part.getSubmittedFileName();
        File file = new File(str);
        String url = str.substring(str.indexOf("images"));
        byte[] b=new byte[1024];
        InputStream is=part.getInputStream();
        OutputStream os =new FileOutputStream(file);
        int a = is.read(b,0,b.length);
        while (a!=-1){
            os.write(b);
            a = is.read(b,0,b.length);
        }

        String des = req.getParameter("des");
        int markId= Integer.parseInt(req.getParameter("mark"));
        int count= Integer.parseInt(req.getParameter("count"));

        Product pro = new Product();
        pro.setProductPrice(price);
        pro.setProductDes(des);
        pro.setProductName(name);
        pro.setProductUrl(url);
        pro.setMarkId(markId);
        pro.setCount(count);
        service.add(pro);
        resp.sendRedirect("list");
    }
}

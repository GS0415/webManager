package controller;

import dao.IMarkDao;
import dao.MarkDaoImpl;
import pojo.Mark;
import pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
@MultipartConfig
@WebServlet("/doAddMark")
public class DoAddMarkServlet extends HttpServlet {
    private IMarkDao service=new MarkDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        /*int markId= Integer.parseInt(req.getParameter("mark"));*/

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


        Mark m =new Mark();
       /* m.setMarkId(markId);*/
        m.setLogo(url);
        m.setMarkName(name);
        service.addMark(m);
        resp.sendRedirect("listTwo");
    }
}

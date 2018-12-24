package controller;
import pojo.User;
import service.IUserService;
import service.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {

    @Override

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserService service = new UserServiceImpl();
        User user = null;
        String pw = req.getParameter("pwd");
        String name = req.getParameter("un");
        user=service.selOneUser(name);
        System.out.println(name);
        System.out.println(pw);
        if (user != null) { // 可以使用
            if (user.getPassWord().equals(pw)) {
                resp.getWriter().write("1"); //密码匹配
                System.out.println(1);
            } else {
                resp.getWriter().write("2");//密码不正确
                System.out.println(2);
            }
        } else {
            resp.getWriter().write("3"); // 用户不存在
            System.out.println(3);
        }
    }
}

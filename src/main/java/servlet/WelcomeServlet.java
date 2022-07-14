package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// JavaEE 6 可免去編輯 web.xml
@WebServlet(name="welcome", urlPatterns = "/servlet/welcome")
public class WelcomeServlet extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();
    out.print("<h1>Welcome</h1>");
    out.close();
  }
}

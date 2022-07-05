package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// GenericServlet 通用型 Servlet
public class HelloServlet extends GenericServlet {

  @Override
  public void service(ServletRequest req, ServletResponse rep) throws ServletException, IOException {
    rep.setContentType("text/html;charset=utf-8");
    PrintWriter out = rep.getWriter();
    out.print("Hello Servlet " + new Date());
    out.print("<p />");
    out.print("Print 1 ~ 10");
    out.print("<p />");
    for (int i = 0; i <= 10; i++) {
      out.print(1);
    }
  }
}

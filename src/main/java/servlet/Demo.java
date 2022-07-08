package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Demo extends GenericServlet{

  public void service(ServletRequest req, ServletResponse rep) throws ServletException, IOException {
    PrintWriter out = rep.getWriter();
    out.print(req.getServerPort());
    out.print(req.getServerName());
    out.close();
  }

}

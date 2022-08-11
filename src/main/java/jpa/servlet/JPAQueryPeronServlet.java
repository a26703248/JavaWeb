package jpa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jpa/person/query")
public class JPAQueryPeronServlet extends JPABaseServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    out.println(getJPAService().getPerson(1));
    // out.println(getJPAService().queryAllPerson());
    // out.print(getJPAService().queryPersonByAge(30));
    // out.print(getJPAService().findByName("A")); // 包含
    // out.print(getJPAService().findByAgeBetween(30, 40));
  }

}

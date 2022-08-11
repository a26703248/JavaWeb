package jpa.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import jpa.service.JPAService;


public class JPABaseServlet extends HttpServlet{
  private JPAService jpaservice;

  @Override
  public void init() throws ServletException {
    super.init();
    jpaservice = new JPAService();
  }

  public JPAService getJPAService() {
    return jpaservice;
  }

}

package JDBC.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.service.UserService;

@WebServlet("/user/add")
public class AddUserServlet extends HttpServlet{
  private UserService userService = new UserService();


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    int rowCount = userService.add(username, password);

    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user/success.jsp");
    req.setAttribute("action", "add");
    req.setAttribute("rowCount", rowCount);
    rd.forward(req, resp);
  }
}

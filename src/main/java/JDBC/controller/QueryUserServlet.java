package JDBC.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.empty.User;
import JDBC.service.UserService;

@WebServlet(value={ "/user/query", "user"})
public class QueryUserServlet extends HttpServlet{
  private UserService userService = new UserService();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<User> users = userService.getUsers();

    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user/index.jsp");
    req.setAttribute("users", users);
    rd.forward(req, resp);
  }

}

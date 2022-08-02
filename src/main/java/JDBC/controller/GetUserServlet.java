package JDBC.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.empty.User;
import JDBC.service.UserService;

@WebServlet("/user/get")
public class GetUserServlet extends HttpServlet{
  private UserService userService = new UserService();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer id = Integer.valueOf(req.getParameter("id"));
    User user = userService.getUserById(id);

    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user/update");
    req.setAttribute("action", "get");
    req.setAttribute("user", user);
    rd.forward(req, resp);
  }
}

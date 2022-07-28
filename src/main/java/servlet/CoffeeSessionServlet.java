package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Coffee;

@WebServlet("/coffee/session")
public class CoffeeSessionServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // getSession(false) 代表使用已存在 session
    HttpSession session = req.getSession(false);
    if(session != null){
      if(session.getAttribute("coffee") != null && session.getAttribute("coffee") instanceof Coffee){
        Coffee coffee = (Coffee) session.getAttribute("coffee");
        resp.getWriter().print("Coffee Amount=" + coffee.getAmount() + "\n");
      }else{
        resp.getWriter().print("Coffee Amount: None");
      }
      resp.getWriter().print("session id=" + session.getId());
    }else{
      resp.getWriter().print("Coffee Amount: None");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String amount = req.getParameter("amount");
    HttpSession session = req.getSession(true);
    Coffee coffee = new Coffee();
    coffee.setAmount(Integer.valueOf(amount));
    session.setAttribute("coffee", coffee);
    resp.getWriter().print("Buy Coffee OK!\n");
    resp.getWriter().print("session id=" + session.getId());
  }
}

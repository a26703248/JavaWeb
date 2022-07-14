package mvc_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc_entity.Exchange;

@WebServlet("/mvc/controller/exchange")
public class ExchangeServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 抓取資料
    String formAmount = req.getParameter("amount");
    String formFrom = req.getParameter("from");
    String formTo = req.getParameter("to");

    // 資料整理
    Double amount = Double.parseDouble(formAmount);
    String from = formFrom;
    String to = formTo;

    // 建立 Exchange 物件
    Exchange exchange = new Exchange();
    exchange.setAmount(amount);
    exchange.setFrom(from);
    exchange.setTo(to);

    // 建立分派器
    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/exchange_result.jsp");
    req.setAttribute("exchange", exchange);
    rd.forward(req, resp);
  }
}

package mvc.mvc_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.mvc_entity.Exchange;
import mvc.mvc_service.ExchangeService;

@WebServlet("/mvc/controller/exchange")
public class ExchangeServlet extends HttpServlet {
  private ExchangeService service = new ExchangeService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 今日公休
    // resp.getWriter().print("今日公休");

    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/exchange_form.html");
    rd.forward(req, resp);
  }

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

    // 建立 Exchange 物件並呼叫 service
    Exchange exchange = service.getExchange(amount, from, to);
    exchange.setAmount(amount);
    exchange.setFrom(from);
    exchange.setTo(to);
    System.out.println(service.queryAllExchanges() instanceof List);

    // 建立分派器
    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/exchange_result.jsp");
    req.setAttribute("exchange", exchange);
    req.setAttribute("exchanges", service.queryAllExchanges());
    rd.forward(req, resp);
  }

}

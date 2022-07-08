package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HttpServlet http 型 servlet 代表是一個 http web服務
public class TodayServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 處理 get 請求
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E");
    String today = sdf.format(date);
    System.out.println(today);
    // 給server用
    resp.setCharacterEncoding("utf-8");
    req.setCharacterEncoding("utf-8");

    // 給 browser 瀏覽器用(header)
    resp.setContentType("text/html;charset=utf-8");

    PrintWriter out = resp.getWriter();
    out.print("<h1>");
    out.print(today);
    out.print("</h1>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 處理 post 請求
    super.doPost(req, resp);
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 處理 delete 請求
    super.doDelete(req, resp);
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 處理 put 請求
    super.doPut(req, resp);
  }

}

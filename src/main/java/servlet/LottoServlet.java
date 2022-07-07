package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 當繼承了 GenericServlet 代表是一個 Web 服務
public class LottoServlet extends GenericServlet{

  @Override
  public void service(ServletRequest req, ServletResponse rep) throws ServletException, IOException {
    // 商業邏輯
    Random random = new Random();
    List<Integer> lotto = new ArrayList<>();
    lotto.add(random.nextInt(10));
    lotto.add(random.nextInt(10));
    lotto.add(random.nextInt(10));
    lotto.add(random.nextInt(10));
    // 回應給 client
    rep.setContentType("text/html; charset=utf-8"); // 回應的文件格式
    PrintWriter out = rep.getWriter(); // 可以寫入回應物件
    out.print(lotto);
    out.close(); // 回應關閉(可寫可不寫,會自動關閉)
  }
}

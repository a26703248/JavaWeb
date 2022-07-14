package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet(urlPatterns="/servlet/alpha")
// 預設帶入都為 urlPatterns
@WebServlet("/servlet/alpha")
public class AlphaServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("image/jpg");
    // 由瀏覽器判斷
    // resp.setContentType("image/*");
    // resp.setContentType("*/*");
    String imagePath = "/home/a0909007892/alpha.jpg";
    File file = new File(imagePath);
    // PrintWriter 傳文字內容
    // ServletOutputStream 傳非文字內容(image, video, pdf)
    ServletOutputStream out = resp.getOutputStream();
    // 將資料複製到 out
    Files.copy(file.toPath(), out);
    out.close();
  }
}

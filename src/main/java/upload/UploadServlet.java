package upload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/servlet/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10, // 10MB
    maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UploadServlet extends HttpServlet {

  // 顯示/重倒上傳後 jsp 的頁面
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/upload_form.jsp");
    rd.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    // 找到 pname, price
    req.getParts().stream().filter(part -> part.getName().equals("pname") || part.getName().equals("price"))
        .forEach(part -> {
          try {
            String value = IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8);
            out.println(part.getName() + "=" + value);
          } catch (Exception e) {
            e.printStackTrace();
          }
        });

    // 找到 file1
    req.getParts().stream().filter(part -> part.getName().equals("file1"))
        .forEach(part -> {
          try {
            // 將上傳的圖片以 base64 的編碼方式製作成 base64 圖片碼
            // 製作步驟: InputStream -> byte[] -> base64 字串
            InputStream is = part.getInputStream();
            byte[] bytes = IOUtils.toByteArray(is);
            String base64 = Base64.getEncoder().encodeToString(bytes);
            // 建立 HTML <img src='data=image/png;base64, %s'> 標籤
            String imgHtml = "<img src='data:image/png;base64, %s'>";
            imgHtml = String.format(imgHtml, base64);
            String imageName = part.getSubmittedFileName();
            // 圖片名字
            out.println("ImageName = " + imageName);
            out.println("<br/>");
            // 圖片呈現
            out.println(imgHtml);
            // window 下
            // 存檔前檢查 'C:/upload' 是否存在
            // File file = new File("C:/upload");
            // if(!file.exists()){
            //   // 若不存在建立檔案
            //   file.mkdir();
            // }
            // part.write(file.toString() + "/" + imageName);
            // out.println("圖片存檔至 'C:/upload' 成功");

          } catch (Exception e) {
            e.printStackTrace();
          }

        });

  }

  // 處理上傳後的程序
  /*
   * @Override
   * protected void doPost(HttpServletRequest req, HttpServletResponse resp)
   * throws ServletException, IOException {
   * PrintWriter out = resp.getWriter();
   * // 顯示上傳的 header 資訊
   * Enumeration<String> headerNames = req.getHeaderNames();
   * while (headerNames.hasMoreElements()) {
   * String headerName = headerNames.nextElement();
   * String headerValue = headerNames.nextElement();
   * out.print(headerName + "=" + headerValue);
   * out.println("<br/>");
   * }
   * out.println("<hr>");
   *
   * // 顯示上傳的內容
   * InputStreamReader isr = new InputStreamReader(req.getInputStream());
   * char[] buffer = new char[1];
   * while(isr.read(buffer) != -1){
   * out.println(buffer);
   * }
   * out.println("<hr>");
   * }
   */

}

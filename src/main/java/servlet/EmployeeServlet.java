package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/employee")
public class EmployeeServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=utf-8");
    resp.setCharacterEncoding("UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("請洽詢客服人員");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html;charset=utf-8");
    resp.setCharacterEncoding("UTF-8");

    // 接收 request 資訊
    String empName = req.getParameter("empName");
    String empAge = req.getParameter("empAge");
    String empSex = req.getParameter("empAge");
    String empPos = req.getParameter("empPos");
    String empBirth = req.getParameter("empBirth");
    String[] empLang = req.getParameterValues("empLang");
    String empMemo = req.getParameter("empMemo");

    // 建立分派器
    RequestDispatcher rd = req.getRequestDispatcher("/templates/employee_result.jsp");
    // 準備好要傳給jsp資料
    req.setAttribute("empName", empName);
    req.setAttribute("empAge", empAge);
    req.setAttribute("empSex", empSex);
    req.setAttribute("empPos", empPos);
    req.setAttribute("empBirth", empBirth);
    req.setAttribute("empLang", Arrays.toString(empLang));
    req.setAttribute("empMemo", empMemo);
    // 轉發到 /templates/employee_result.jsp
    rd.forward(req, resp);

    // 直接回傳前端
    // PrintWriter out = resp.getWriter();
    // out.println("<html>");
    // out.println("<head>");
    // out.println("<title>員工資料表單</title>");
    // out.println("<link rel=\"stylesheet\" href=\"https://unpkg.com/purecss@2.1.0/build/pure-min.css\"/>");
    // out.println("</head>");
    // out.println("<body style=\"padding: 15px\">");
    // out.println("<form class=]\"pure-form\">");
    // out.println("<fieldset>");
    // out.println("<legend>員工表單</legend>");
    // out.println("姓名:" + empName + "<p/>");
    // out.println("年齡:" + empAge + "<p/>");
    // out.println("性別:" + empSex + "<p/>");
    // out.println("階級:" + empPos + "<p/>");
    // out.println("生日:" + empBirth + "<p/>");
    // out.println("程式:" + Arrays.toString(empLang) + "<p/>");
    // out.println("備註:" + empMemo + "<p/>");
    // out.println("<button type=\"reset\" class=\"pure-button pure-button-primary\"onclick=\" history.back()\">返回</button> ");
    // out.println("</fieldset>");
    // out.println("</form>");
    // out.println("</body>");
    // out.println("</html>");
  }

}

package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 若有多個 Filter 時不指定順序時會是隨機

// @WebFilter(urlPatterns={"/report/*"})
@WebFilter(urlPatterns={"/report/daily", "/report/monthly"})
public class LoginReportFilter extends HttpFilter{

  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
      throws IOException, ServletException {
        String username = req.getParameter("username");
        if(username != null && username.equals("admin")){
          chain.doFilter(req, res);
        }else{
          RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/report_login.jsp");
          rd.forward(req,res);
        }
  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stub

  }

}

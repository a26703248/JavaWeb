package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns={"/report/daily", "/report/monthly"})
public class AuthCodeFilter extends HttpFilter{

  @Override
  public void destroy() {

  }

  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
      throws IOException, ServletException {
        String userAuthCode = req.getParameter("userAuthCode") + "";
        String authCode = req.getSession().getAttribute("authCode") + "";
        if(userAuthCode.length() > 0 && authCode .length() > 1 && authCode.equalsIgnoreCase(userAuthCode)) {
          // 進行比對
          chain.doFilter(req, res);
        }else{
          RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/report_login.jsp");
          rd.forward(req, res);
        }
  }
}

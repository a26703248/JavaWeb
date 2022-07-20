package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/report/*")
public class WatermarkFilter extends HttpFilter{


  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
      throws IOException, ServletException {
        MyResponse myResponse = new MyResponse(res);
        chain.doFilter(req, myResponse);

        // 取得 html
        String html = myResponse.getHTMLSource();

        // 加上浮水印
        html = "<body background='/javaweb/resource/images/images.png'>" + html + "</body>";
        res.getWriter().print(html);
  }

  @Override
  public void destroy() {
  }


}

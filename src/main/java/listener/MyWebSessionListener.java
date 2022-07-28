package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyWebSessionListener implements HttpSessionListener {

  private static int count = 0;

  private void updateCount(int n, HttpSessionEvent se) {
    count += n;
    // Web 全域變數 = ServletContext變數(servlet) / Application(jsp)
    ServletContext context = se.getSession().getServletContext();
    context.setAttribute("count", count);
  }

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    updateCount(1, se);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    updateCount(-1, se);
  }

}

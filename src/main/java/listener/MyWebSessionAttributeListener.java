package listener;

import java.util.Enumeration;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

// Web 監聽器
// 訪問 JSP 頁面預設就會向 server 取得 session
// 訪問 html 需要向 server 做請求動作時後才會取得 session,預設訪問不會取 session
@WebListener
public class MyWebSessionAttributeListener implements HttpSessionAttributeListener {

  @Override
  public void attributeAdded(HttpSessionBindingEvent event) {
    HttpSession session = event.getSession();
    printInfo(session, "attributeAdded");
  }

  @Override
  public void attributeRemoved(HttpSessionBindingEvent event) {
  }

  @Override
  public void attributeReplaced(HttpSessionBindingEvent event) {
    HttpSession session = event.getSession();
    printInfo(session, "attributeReplaced");
  }


  private void printInfo(HttpSession session, String message){
    System.out.println(message + ": " + session.getAttributeNames() );
    Enumeration<String> names = session.getAttributeNames();
    while(names.hasMoreElements()) {
      String name = (String) names.nextElement();
      System.out.printf("%s = %s\n", name, session.getAttribute(name));
    }
  }


}

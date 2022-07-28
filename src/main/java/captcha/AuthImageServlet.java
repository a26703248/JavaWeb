package captcha;

// java 為 java 標準函示庫
import java.io.IOException;
import java.util.Random;

// java awt 為抽象圖形工具函示庫
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

// java javax 為 java 延伸函示庫
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// CAPTCHA 圖靈驗證碼
// 1. 自動產生 A-za-z + 0000 ~ 9999 之間的認證圖像(含干擾器)
// 2. 並且將該碼存放到 session 屬性中與使用者輸入的驗證碼進行比對
@WebServlet("/captcha/authcodeimage")
public class AuthImageServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Random random = new Random();
    // 產生認證碼
    String authCode = String.format("%c%03d", random.nextInt(52) + 65, random.nextInt(1000));
    System.out.printf("authCode: %s\n", authCode);

    // 將驗證碼存在 session 屬性
    req.getSession().setAttribute("authCode", authCode);

    // 產生認證圖片串流
    try {
      resp.setContentType("image/jpeg");
      ImageIO.write(getCaptcha(authCode), "JPEG", resp.getOutputStream());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  // 產生認證碼圖片串流
  public BufferedImage getCaptcha(String authCode){

    Random random = new Random();

    // 1. 建立圖像暫存區
    BufferedImage img = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);

    // 2. 建立畫布
    Graphics g = img.getGraphics();

    // 3. 設定畫布背景顏色
    g.setColor(Color.YELLOW);

    // 4. 設定塗滿背景
    g.fillRect(0, 0, 80, 30);

    // 5. 設定顏色
    g.setColor(Color.BLACK);

    // 6. 設定字型
    g.setFont(new Font("Arial", Font.BOLD, 30));

    // 7. 繪文字 drawString(印出字串, 文字右上角與圖片右上角間距x,y)
    // g.drawString(authCode, 10, 23);
    for (int i = 0; i < authCode.length(); i++) {
      g.setFont(new Font("Arial", i%2==0?Font.BOLD:Font.ITALIC, random.nextInt(20) + 10));
      g.drawString(authCode.charAt(i) + " ", 10 + i*20, 23);
    }

    // 繪製干擾線
    g.setColor(Color.RED);
    for (int i = 0; i < 10; i++) {
      int x1 = random.nextInt(80);
      int y1 = random.nextInt(30);
      int x2 = random.nextInt(80);
      int y2 = random.nextInt(30);
      g.drawLine(x1, y1, x2, y2);
    }

    return img;
  }

}

<%@ page
  language="java"
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  isELIgnored="false"
  %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="utf-8">
    <title>Report login</title>
    <link rel="stylesheet"
      href="https://unpkg.com/purecss@2.1.0/build/pure-min.css" />
    <script type="text/javascript">
      function changeAuthCodeImage() {
        // 在網址後方加上變動參數防止 cache 殘留問題，讓瀏覽器以為是新的網址強制做更新
        document.getElementById("authcodeimage").src = "/javaweb/captcha/authcodeimage?i=" + Math.random();
      }
    </script>
  </head>

  <body style="padding: 15px">
    <form method="post">
      <fieldset>
        <legend>Report Login 一次性</legend>
        Username: <input type="text"
          id="username"
          name="username">
        <p />
        驗證碼授權: <input type="text"
          id="authCode"
          name="userAuthCode">
        <img id="authcodeimage"
          src="/javaweb/captcha/authcodeimage"
          title="按我一下可以更新"
          onclick="changeAuthCodeImage()"
          style="cursor:pointer;"
          valign="middle">
        <p />

        <button type="submit"
          class="pure-button pure-button-primary">
          送出
        </button>

        <button type="reset"
          class="pure-button pure-button-primary"
          onclick="history.back()">
          返回
        </button>

      </fieldset>
    </form>
  </body>

  </html>

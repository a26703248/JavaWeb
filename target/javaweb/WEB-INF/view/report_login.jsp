<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>Report login</title>
  <link
    rel="stylesheet"
    href="https://unpkg.com/purecss@2.1.0/build/pure-min.css"
  />
</head>

<body style="padding: 15px">
  <form method="post">
    <fieldset>
      <legend>Report Login 一次性</legend>
      Username: <input type="text" id="username" name="username">

      <button
        type="submit"
        class="pure-button pure-button-primary"
      >
        送出
      </button>

      <button
        type="reset"
        class="pure-button pure-button-primary"
        onclick="history.back()"
      >
        返回
      </button>

    </fieldset>
  </form>
</body>

</html>

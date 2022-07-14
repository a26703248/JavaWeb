<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <title>匯率換算</title>
  <link
    rel="stylesheet"
    href="https://unpkg.com/purecss@2.1.0/build/pure-min.css"
  />
</head>

<body style="padding: 15px">
  <form class="pure-form">
    <fieldset>
      <legend>換匯表單</legend>
      <p />
      金額:${ exchange.amount }
      <p />
      換匯: ${ exchange.from }轉 ${ exchange.to }
      <p />
      匯率:${ exchange.exchange }
      <p />
      日期:${ exchange.datetime }
      <p />
      結果:${ exchange.result }
      <p />

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

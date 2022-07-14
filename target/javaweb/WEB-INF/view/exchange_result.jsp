<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import java.util.List; %>
<%@ page import mvc_entity.Exchange; %>
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
      金額:${ exchange.from } ${ exchange.amount }
      <p />
      換匯: ${ exchange.from } 轉 ${ exchange.to }
      <p />
      匯率:${ exchange.exchange }
      <p />
      日期:${ exchange.datetime }
      <p />
      結果:${ exchange.to } ${ exchange.result }
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
  <form class="pure-form">
    <fieldset>
      <legend>歷史紀錄</legend>
      <table class="pure-table">
        <thead>
          <tr>id</tr>
          <tr>amount</tr>
          <tr>form</tr>
          <tr>to</tr>
          <tr>exchanges</tr>
          <tr>result</tr>
          <tr>datetime</tr>
        </thead>
        <tbody>
          <% List exchanges = request.getAttributes("exchanges"); %>
          <%for(int i=0;i < exchanges.size(); i++){%>
            <tr>
              <td><%=i+1%></td>
              <td><%=exchanges.get(i).getAmount()%></td>
              <td><%=exchanges.get(i).getFrom()%></td>
              <td><%=exchanges.get(i).getTo()%></td>
              <td><%=exchanges.get(i).getExchange()%></td>
              <td><%=exchanges.get(i).getResult()%></td>
              <td><%=exchanges.get(i).getDatetime()%></td>
            </tr>
            <%}%>
        </tbody>
      </table>
      ${ exchange.exchanges }
    </fieldset>
  </form>



</body>

</html>

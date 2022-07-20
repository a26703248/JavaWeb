<%@ page import="com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.List"%>
<%@ page import="mvc.entity.Exchange"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!-- jstl tag 五大函式庫 -->
<!-- 核心函式庫 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- format 函式庫 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Function 函式庫 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- SQL 函式庫 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!-- XML 函式庫 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>


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
      <table class="pure-table pure-table-bordered">
        <thead>
          <tr>
            <th>id</th>
            <th>amount</th>
            <th>from</th>
            <th>to</th>
            <th>exchange</th>
            <th>result</th>
            <th>datetime</th>
          </tr>
        </thead>
        <tbody>
          <% List<Exchange> exchanges = (List<Exchange>)request.getAttribute("exchanges"); %>
          <% DecimalFormat df = new DecimalFormat("#.###"); %>
          <% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E"); %>
          <% for(int i=0;i < exchanges.size(); i++) {%>
          <tr>
            <td><%=i+1%></td>
            <td><%=exchanges.get(i).getAmount()%></td>
            <td><%=exchanges.get(i).getFrom()%></td>
            <td><%=exchanges.get(i).getTo()%></td>
            <td><%=df.format(exchanges.get(i).getExchange()) %></td>
            <td><%=df.format(exchanges.get(i).getResult()) %></td>
            <td><%=sdf.format(exchanges.get(i).getDatetime()) %></td>
          </tr>
          <%}%>
        </tbody>

        <hr />
        <tbody>
          <c:forEach
            var="exchange"
            varStatus="i"
            items="${exchanges}"
          >
            <tr>
              <td>${ i.index+1 }</td>
              <td>${ exchange.amount }</td>
              <td>${ exchange.from }</td>
              <td>${ exchange.to }</td>
              <td>
                ${ exchange.exchange }
                <fmt:formatNumber
                  value="${ exchange.exchange }"
                  pattern="#.###"
                />
              </td>
              <td>
                ${ exchange.result }
                <fmt:formatNumber
                  value="${ exchange.result }"
                  pattern="#.###"
                />
              </td>
              <td>
                ${ exchange.datetime }
                <fmt:formatDate
                  value="${ exchange.datetime }"
                  pattern="yyyy-MM-dd a hh:mm:ss E"
                />
              </td>
            </tr>
          </c:forEach>
        </tbody>

      </table>
    </fieldset>
  </form>


</body>

</html>

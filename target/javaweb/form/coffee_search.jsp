<%@ page import="com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default"%>

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
  <title>Coffee Search</title>
  <link
    rel="stylesheet"
    href="https://unpkg.com/purecss@2.1.0/build/pure-min.css"
  />
</head>

<body style="padding: 15px">
  <form
    class="pure-form"
    action="/javaweb/coffee/session"
    method="get"
  >
    <fieldset>
      <legend>Coffee Form</legend>
      <button
        type="submit"
        class="pure-button pure-button-primary"
      >
        查詢
      </button>

    </fieldset>
  </form>

</body>

</html>

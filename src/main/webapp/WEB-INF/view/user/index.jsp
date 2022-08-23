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
<!--
  ${ users }
-->
<html>

<head>
  <meta charset="utf-8">
  <meta
    http-equiv="X-UA-Compatible"
    content="IE=edge"
  >
  <link
    rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css"
  >
  <title>User Index</title>
  <meta
    name="description"
    content=""
  >
  <meta
    name="viewport"
    content="width=device-width, initial-scale=1"
  >
  <script>
    function deleteUserById(id) {
      if (confirm('是否要刪除 id:' + id + ' 的資料 ?')) {
        window.location.href = '${ pageContext.request.contextPath }/user/delete?id=' + id;
      }
    }

    function checkUserForm() {
      var username = window.document.getElementById('username').value;
      var password = window.document.getElementById('password').value;
      if (username == '') {
        alert('使用者名稱不可空白!')
        window.document.getElementById('username').focus();
        return false;
      }
      if (password == '') {
        alert('使用者密碼不可空白!')
        window.document.getElementById('password').focus();
        return false;
      }
      return true;
    }
  </script>
</head>

<body style="padding: 15px">
  <form
    method="post"
    action="${ pageContext.request.contextPath }/user/add"
    class="pure-form"
  >
    <fieldset>
      <legend></legend>
      Username:
      <input
        id="username"
        type="text"
        placeholder="請輸入使用者名稱"
        name="username"
      />
      <p />
      Password:
      <input
        id="password"
        type="text"
        placeholder="請輸入使用者密碼"
        name="password"
      />

      <button
        type="submit"
        class="pure-button pure-button-primary"
      >
        新增
      </button>
      <button
        type="reset"
        class="pure-button pure-button-primary"
      >
        清除
      </button>
    </fieldset>
  </form>
  <form class="pure-form">
    <fieldset>
      <legend>User List</legend>
      <table class="pure-table pure-table-bordered">
        <thead>
          <tr>
            <th>id</th>
            <th>username</th>
            <th>password</th>
            <th>createtime</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach
            var="user"
            items="${ users }"
          >
            <tr>
              <td>${user.id}</td>
              <td>${user.username}</td>
              <td>${user.password}</td>
              <td>${user.createtime}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </fieldset>
  </form>
</body>

</html>

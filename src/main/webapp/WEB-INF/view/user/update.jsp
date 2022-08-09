<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta
    http-equiv="X-UA-Compatible"
    content="IE=edge"
  >
  <title>Update</title>
  <meta
    name="description"
    content=""
  >
  <meta
    name="viewport"
    content="width=device-width, initial-scale=1"
  >
  <link
    rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css"
  >
</head>

<body>
  <form
    class="pure-form"
    method="post"
    action="${ pageContext.request.contextPath }/user/update"
  >
    <fieldset>
      <legend>
        <img
          src="${ pageContext.request.contextPath }/resource/images/user.png"
          width="40"
          valign="middle"
        >
        User form (Update)
      </legend>
      <!-- 利用隱藏欄位來放置 user.id -->
      <input
        type="hidden"
        name="id"
        value="${ user.id }"
      >
      Username: <input
        type="text"
        id="username"
        name="username"
        placeholder="請輸入使用者名稱"
        value="${ user.username }"
      />
      <p />
      Password: <input
        type="password"
        id="password"
        name="password"
        placeholder="請輸入使用者密碼"
        value="${ user.password }"
      />
      <p />
      <button
        type="button"
        onclick="window.location.href='${ pageContext.request.contextPath }/users';"
        class="pure-button pure-button-primary"
      >回首頁</button>
      <button
        type="submit"
        class="pure-button pure-button-primary"
      >修改</button>
    </fieldset>
  </form>
</body>

</html>

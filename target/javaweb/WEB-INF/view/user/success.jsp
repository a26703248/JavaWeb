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
  <title>Success</title>
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

<body style="padding:15px">
  <form
    class="pure-form"
    method="get"
    action="${ pageContext.request.contextPath }/users"
  >
    <fieldset>
      <legend>
        <img
          src="${ pageContext.request.contextPath }/resource/images/user.png"
          width="40"
          valign="middle"
        >
        ${ action } 成功
      </legend>
      <button
        type="submit"
        class="pure-button pure-button-primary"
      >回首頁</button>
    </fieldset>
  </form>
</body>

</html>

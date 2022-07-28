<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
    <form
      class="pure-form"
      method="post"
      enctype="multipart/form-data"
    >
      <fieldset>
        <legend>換匯表單</legend>
        品名1:
        <input
          type="text"
          placeholder="請輸入品名"
          name="pname"
        />
        <p />

        價格1:
        <input
          type="number"
          placeholder="請輸入價格"
          name="price"
        />
        <p />

        照片1:
        <input
          id="imgInp"
          type="file"
          name="file1"
        />
        <img id="preview" src="#" alt="your image" />
        <p />

        <button
          type="submit"
          class="pure-button pure-button-primary"
        >
          送出
        </button>
        <button
          type="reset"
          class="pure-button pure-button-primary"
        >
          重填
        </button>

      </fieldset>
    </form>
    <script>
      imgInp.onchange = evt => {
        const [file] = imgInp.files
        if (file) {
          preview.src = URL.createObjectURL(file)
        }
      }
    </script>


  </body>

  </html>

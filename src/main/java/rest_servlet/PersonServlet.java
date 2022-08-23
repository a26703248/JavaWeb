package rest_servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jpa.entity.Person;
import jpa.service.JPAService;

// Restful 原理
@WebServlet("/rest/person/*")
public class PersonServlet extends HttpServlet {
  private JPAService jpaservice = new JPAService();
  Gson gson = new Gson();

  // query
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer age = req.getParameter("age") == null ? null : Integer.parseInt(req.getParameter("age"));
    String name = req.getParameter("name");
    Integer min = req.getParameter("min") == null ? null : Integer.parseInt(req.getParameter("min"));
    Integer max = req.getParameter("max") == null ? null : Integer.parseInt(req.getParameter("max"));
    resp.addHeader("Access-Control-Allow-Origin", "*");

    // 功能性查詢
    if (age != null || name != null || (min != null && max != null)) {
      if (min != null && max != null) {
        List<Person> list = jpaservice.findByAgeBetween(min, max);
        resp.getWriter().println(gson.toJson(list));
        return;
      }

      if (age != null) {
        List<Person> list = jpaservice.queryPersonByAge(age);
        resp.getWriter().println(gson.toJson(list));
        return;
      }

      if (name != null) {
        List<Person> list = jpaservice.findByName('%' + name + '%');
        resp.getWriter().println(gson.toJson(list));
        return;
      }

      return;
    }

    // 一般查詢
    Integer id = checkPath(req);
    if (id == null) {
      List<Person> list = jpaservice.queryAllPerson();
      // resp.getWriter().println("多筆查詢:");
      resp.getWriter().print(gson.toJson(list));
    } else {
      Person person = jpaservice.getPerson(id);
      // resp.getWriter().println("單筆查詢:");
      resp.getWriter().print(gson.toJson(person));
    }

  }

  // create
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.addHeader("Access-Control-Allow-Origin", "*");
    if (checkPath(req) != null)
      return;
    String name = req.getParameter("name");
    Integer age = req.getParameter("age") == null ? 0 : Integer.parseInt(req.getParameter("age"));
    Person person = new Person();
    person.setName(name);
    person.setAge(age);
    jpaservice.addPerson(person);
    // resp.getWriter().println("單筆新增:");
    resp.getWriter().print(gson.toJson(person));
  }

  // update
  // getParameter method 只支援 get post,因為較舊的html form 只支援 get post
  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.addHeader("Access-Control-Allow-Origin", "*");
    Integer id = checkPath(req);
    if (id == null)
      return;

    // 自性解析串流資料
    ServletInputStream si = req.getInputStream(); // byte[]
    InputStreamReader sr = new InputStreamReader(si); // byte[] -> char[]
    BufferedReader br = new BufferedReader(sr); // char[] -> String
    String args = br.readLine(); // String

    // 轉 Map
    Map<String, String> map = new LinkedHashMap<>();
    for (String str : args.split("&")) {
      String[] array = str.split("=");
      map.put(array[0], array[1]);
    }

    String name = map.get("name");
    Integer age = map.get("age") == null ? 0 : Integer.parseInt(map.get("age"));
    Person person = new Person();
    person.setId(id);
    person.setName(name);
    person.setAge(age);

    // 修改
    jpaservice.updatePerson(person);

    // resp.getWriter().println("單筆修改");
    resp.getWriter().println(gson.toJson(person));
  }

  // delete
  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.addHeader("Access-Control-Allow-Origin", "*");
    Integer id = checkPath(req);
    if (id == null)
      return;
    jpaservice.deletePerson(id, jpaservice);

    // resp.getWriter().println("單筆刪除");
    resp.getWriter().println(gson.toJson(id));
  }

  private Integer checkPath(HttpServletRequest req) {
    String servicePath = req.getServletPath();
    String pathInfo = req.getPathInfo();
    System.out.println(servicePath);
    System.out.println(pathInfo);
    if (pathInfo == null || (pathInfo.length() == 1 && pathInfo.charAt(0) == '/')) {
      return null;
    } else if (pathInfo.length() > 1 && pathInfo.charAt(0) == '/') {
      Integer id = Integer.parseInt(pathInfo.replace("/", ""));
      return id;
    }
    return null;
  }

}

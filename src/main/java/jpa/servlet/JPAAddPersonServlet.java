package jpa.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.javafaker.Faker;

import jpa.entity.Person;
import jpa.service.JPAService;

@WebServlet("/jpa/person/add")
public class JPAAddPersonServlet extends JPABaseServlet{

  private JPAService jpaservice;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = new Faker().name().lastName();
    int age = new Random().nextInt(20) + 30;
    Person person = new Person();
    person.setAge(age);
    person.setName(name);
    jpaservice = getJPAService();
    jpaservice.addPerson(person);
    resp.getWriter().print("Add OK:" + person);
  }

}

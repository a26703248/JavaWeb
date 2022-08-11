package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.entity.Person;

public class JPAService {
  private static EntityManagerFactory emf;
  private EntityManager em;

  public JPAService() {
    if (emf == null) {
      emf = Persistence.createEntityManagerFactory("demo");
    }
    em = emf.createEntityManager();
  }

  // 新增
  public synchronized void addPerson(Person person) {
    EntityTransaction etx = em.getTransaction(); // 取得交易物件
    etx.begin(); // 開始
    em.persist(person); // 存入 persist
    etx.commit(); // 提交
  }

  // 查詢一筆
  public Person getPerson(Integer id) {
    return em.find(Person.class, id);
  }

  // 查詢全部
  public List<Person> queryAllPerson() {
    // Query query = em.createQuery("select p from Person p"); // JPQL
    Query query = em.createQuery("from Person p", Person.class); // JPQL
    List<Person> res = query.getResultList();
    return res;
  }

  // 查詢多筆 by age
  public List<Person> queryPersonByAge(Integer age) {
    String sql = "select p from Person p where p.age >= :ageValue"; // :ageValue 代表變數
    Query query = em.createQuery(sql);
    query.setParameter("ageValue", age); // 帶入值
    List<Person> res = query.getResultList();
    return res;
  }

  // 查詢多筆使用 NameQuery
  public List<Person> queryPersonByNameQuery(Integer age) {
    // Query query = em.createNamedQuery("Person.findAll");
    Query query = em.createNamedQuery("Person.findByAge").setParameter("ageValue", age);
    List<Person> res = query.getResultList();
    return res;
  }

  // 查詢多筆 by name
  public List<Person> findByName(String name) {
    return em.createNamedQuery("Person.findByName")
        .setParameter("nameValue", name)
        .getResultList();
  }

  // 查詢多筆 age 之間
  public List<Person> findByAgeBetween(Integer min, Integer max) {
    return em.createNamedQuery("Person.findByAgeBetween")
    .setParameter("min", min)
    .setParameter("max", max)
    .getResultList();
  }

  // 修改
  public synchronized void updatePerson(Person person) {
    if(getPerson(person.getId()) == null)return;
    EntityTransaction etx = em.getTransaction(); // 取得交易物件
    etx.begin(); // 開始
    em.merge(person); // 修改
    etx.commit(); // 提交
  }

  // 刪除
  public synchronized void deletePerson(Integer id, JPAService jpaservice) {
    if(getPerson(id) == null)return;
    Person person = jpaservice.getPerson(id);
    EntityTransaction etx = em.getTransaction(); // 取得交易物件
    etx.begin(); // 開始
    em.remove(person); // 刪除
    etx.commit(); // 提交
  }

}


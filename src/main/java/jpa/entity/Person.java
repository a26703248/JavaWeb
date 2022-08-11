package jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="person") // 如果資料表名稱與物件名稱一樣可不寫name
@NamedQueries({ // NamedQuery 使用,可以統一管理 JPQL 語法
  @NamedQuery(name="Person.findAll", query="select p from Person p"),
  @NamedQuery(name="Person.findByAge", query="select p from Person p where p.age >= :ageValue"),
  @NamedQuery(name="Person.findByName", query="select p from Person p where p.name >= :nameValue"),
  @NamedQuery(name="Person.findByAgeBetween", query="select p from Person p where p.age between :min and :max"),
})
public class Person implements Serializable{ // 跨資料庫查詢時盡量加上 Serializable 做識別
  @Id // 主鍵設定
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;

  @Column(name = "name", length= 50, nullable=false, unique = true) // 欄位設定
  private String name;

  private Integer age;

  @Override
  public String toString() {
    return "Person [Id=" + Id + ", age=" + age + ", name=" + name + "]";
  }

  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }


}

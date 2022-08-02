package JDBC.empty;

import java.util.Date;

public class User {
  private Integer id;
  private String username;
  private String password;
  private Date createtime;

  public User() {}

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  @Override
  public String toString() {
    return "User [createtime=" + createtime + ", id=" + id + ", password=" + password + ", username=" + username + "]";
  }


}

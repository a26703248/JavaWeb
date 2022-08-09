package JDBC.service;

import java.util.Base64;
import java.util.List;

import JDBC.empty.User;
import JDBC.repositery.UserDao;

public class UserService {
  private UserDao userDao = new UserDao();

  public int add(String username, String password) {
    String encodePassword = Base64.getEncoder().encodeToString(password.getBytes());
    User user = new User(username, encodePassword);
    return userDao.add(user);
  }

  public int updateUsername(Integer id, String username) {
    return userDao.updateUsername(id, username);
  }

  public int updatePassword(Integer id, String password) {
    String encodePassword = Base64.getEncoder().encodeToString(password.getBytes());
    return userDao.updatePassword(id, encodePassword);
  }

  public int update(Integer id, String username, String password) {
    String encodePassword = Base64.getEncoder().encodeToString(password.getBytes());
    User user = new User(username, encodePassword);
    return userDao.updateUser(id, user);
  }

  public int delete(Integer id) {
    return userDao.deleteUser(id);
  }

  public User getUserById(Integer id) {
    return userDao.getUserById(id);
  }

  public List<User> getUsers() {
    return userDao.getUsers();
  }

}

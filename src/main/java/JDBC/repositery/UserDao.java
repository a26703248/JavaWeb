package JDBC.repositery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import JDBC.empty.User;

public class UserDao {
  // 1. 資料庫放置位置
  private String dbPath = "/home/a0909007892/javaweb/db/";
  // 2. 資料庫名稱
  private String dbName = "webdb.db";
  // 3. 建立資料庫連線參數
  private String dbUrl = "jdbc:sqlite:" + dbPath + dbName;

  // 建立資料庫 DB
  public void createDB() throws Exception {

    // 4. 建立資料庫 Driver
    Class.forName("org.sqlite.JDBC");
    // 5. 建立資料庫連線物件
    Connection conn = DriverManager.getConnection(dbUrl);

    if (!conn.isClosed()) {
      System.out.println("資料庫連線/建立成功");
    }
    conn.close();
  }

  // 取得 Connection 物件
  private Connection getConnection() throws Exception{
    // 4. 建立資料庫 Driver
    Class.forName("org.sqlite.JDBC");
    // 5. 建立資料庫連線物件
    Connection conn = DriverManager.getConnection(dbUrl);

    return conn;
  }

  // 建立資料表 Table
  public void createTable() throws Exception{
    String sql = "create table if not exists user("
        + "id integer primary key,"
        + "username text not null,"
        + "password text not null,"
        + "createtime datetime default current_timestamp"
        + ")";

    Connection conn = getConnection();
    Statement stmt = conn.createStatement();
    stmt.executeUpdate(sql);
    System.out.println("user 資料表建立成功");

  }

  // 新增 user 資料列
  public int add(User user){
    String sql = "insert into user(username, password) values(?, ?)";
    int rowCount = 0;
    try (
      PreparedStatement stmt = getConnection().prepareStatement(sql);
    ) {
      stmt.setString(1, user.getUsername());
      stmt.setString(2, user.getPassword());
      rowCount = stmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rowCount;
  }

  // 修改 username 資料列
  public int updateUsername(Integer id, String username){
    int rowCount = 0;
    String sql = "update user set username=? where id=?";
    try (
      PreparedStatement stmt = getConnection().prepareStatement(sql);
    ) {
      stmt.setString(1, username);
      stmt.setInt(2, id);
      rowCount = stmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rowCount;
  }

  // 修改 password 資料列
  public int updatePassword(Integer id, String password){
    int rowCount = 0;
    String sql = "update user set password=? where id=?";
    try (
      PreparedStatement stmt = getConnection().prepareStatement(sql);
    ) {
      stmt.setString(1, password);
      stmt.setInt(2, id);
      rowCount = stmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rowCount;
  }

  // 修改 user 資料列
  public int updateUser(Integer id, User user){
    int rowCount = 0;
    String sql = "update user set username=?, password=? where id=?";
    try (
      PreparedStatement stmt = getConnection().prepareStatement(sql);
    ) {
      stmt.setString(1, user.getUsername());
      stmt.setString(2, user.getPassword());
      stmt.setInt(3, id);
      rowCount = stmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rowCount;
  }

  // 刪除 user 資料
  public int deleteUser(Integer id){
    int rowCount = 0;
    String sql = "delete from user where id=?";
    try (
      PreparedStatement stmt = getConnection().prepareStatement(sql);
    ) {
      stmt.setInt(1, id);
      rowCount = stmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rowCount;
  }

  // get user by id 資料列
  public User getUserById(Integer id){
    String sql = "select * from user where id=?";
    User user = null;
    try (
      PreparedStatement stmt = getConnection().prepareStatement(sql);
    ) {
      stmt.setInt(1, id);
      ResultSet res = stmt.executeQuery();
      if(res.next()){
        user = new User();
        user.setId(res.getInt("id"));
        user.setUsername(res.getString("username"));
        user.setPassword(res.getString("password"));
        user.setCreatetime(res.getDate("createtime"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }

  public List<User> getUsers(){
    String sql = "select * from user";
    List<User> users = new ArrayList<>();
    try (
      PreparedStatement stmt = getConnection().prepareStatement(sql);
    ) {
      ResultSet res = stmt.executeQuery();
      while(res.next()){
        User user = new User();
        user.setId(res.getInt("id"));
        user.setUsername(res.getString("username"));
        user.setPassword(res.getString("password"));
        user.setCreatetime(res.getDate("createtime"));
        users.add(user);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return users;
  }

  public static void main(String[] args) throws Exception {
    // 1. create db
    // new UserDao().createDB();
    // 2. create table
    // new UserDao().createTable();
    // 3. insert data
    // String password1 = "1234";
    // new UserDao().add(new User("john", Base64.getEncoder().encodeToString(password1.getBytes())));
    // String password2 = "1234";
    // new UserDao().add(new User("mary", Base64.getEncoder().encodeToString(password2.getBytes())));
    // int row = new UserDao().updateUsername(1, "john");
    // int row = new UserDao().updatePassword(2, Base64.getEncoder().encodeToString("ABCD".getBytes()));
    // int row = new UserDao().updateUser(2, new User("mary", Base64.getEncoder().encodeToString("5678".getBytes())));
    // int row = new UserDao().deleteUser(2);
    // System.out.println(row);
    // User user = new UserDao().getUserById(1);
    // System.out.println(user.toString());
    List<User> users = new UserDao().getUsers();
    for (User user : users) {
      System.out.println(user.toString());
    }
  }
}

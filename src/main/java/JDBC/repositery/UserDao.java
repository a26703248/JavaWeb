package JDBC.repositery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Base64;

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

  public static void main(String[] args) throws Exception {
    // new UserDao().createDB();
    // new UserDao().createTable();
    String password1 = "1234";
    new UserDao().add(new User("john", Base64.getEncoder().encodeToString(password1.getBytes())));
    String password2 = "1234";
    new UserDao().add(new User("mary", Base64.getEncoder().encodeToString(password2.getBytes())));
  }
}

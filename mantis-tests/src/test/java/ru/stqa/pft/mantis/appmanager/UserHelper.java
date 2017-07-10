package ru.stqa.pft.mantis.appmanager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan8 on 10.07.2017.
 */
public class UserHelper {
  private ApplicationManager app;

  public UserHelper(ApplicationManager app) {
    this.app = app;
  }

  public String getUserName() {
    Connection conn = null;
    List<String> result = new ArrayList<>();

    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracker?user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select username from mantis_user_table where username<>'administrator'");

      while (rs.next()) {
        result.add(rs.getString("username"));
      }
      rs.close();
      st.close();
      conn.close();
      return result.get(1);

    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
      return null;
    }

  }
}


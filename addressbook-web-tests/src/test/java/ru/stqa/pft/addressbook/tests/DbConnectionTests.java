package ru.stqa.pft.addressbook.tests;

import org.junit.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.sql.*;

/**
 * Created by ivan8 on 03.07.2017.
 */
public class DbConnectionTests {

  @Test
  public void testDbConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?serverTimezone=UTC&user=root&password=");
      Statement statement = conn.createStatement();
      ResultSet resultSet = statement.executeQuery("select group_id, group_name, group_header, group_footer from " +
              "group_list");
      Groups groups = new Groups();
      while (resultSet.next()) {
        groups.add(new GroupData().withId(resultSet.getInt("group_id")).withName(resultSet.getString("group_name"))
                .withHeader
                        (resultSet.getString("group_header")).withFooter(resultSet.getString("group_footer")));
      }

      System.out.println(groups);
      resultSet.close();
      statement.close();
      conn.close();
    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}

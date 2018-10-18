package model;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:" + fileName + ".db";
        File f = new File(fileName + ".db");
        if (!f.exists()) {
            try (Connection conn = DriverManager.getConnection(url)) {
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:vacation4u.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }

    public ArrayList<String> selectAll(String table_name, String... Parameters) {
        String fields = "";
        ArrayList<String> arr = new ArrayList<String>();

        for (int i = 0; i < Parameters.length; i++) {
            if (i == 0) {
                fields = Parameters[i];
            } else {
                fields = fields + ", " + Parameters[i];
            }
        }
        String sql = "SELECT " + fields + " FROM" + table_name;

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                for (int i = 0; i < Parameters.length; i++) {
                    arr.add(Parameters[i]);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }

    /**
     * Update data of a users specified by the username
     *
     * @param username
     * @param password the code of the user
     * @param birth birth date of the user
     * @param first_name name of the user
     * @param last_name last name of the user
     * @param city where the user lives
     */
    public void update(String username, String password, String birth, String first_name, String last_name, String city) {
        String sql = "UPDATE users SET usename = ? , " + "password = ? , "
                + "birth = ? , " + "first_name = ? , " + "last_name = ? , "
                + "city = ? "
                + "WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, birth);
            pstmt.setString(4, first_name);
            pstmt.setString(5, last_name);
            pstmt.setString(6, city);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Delete user specified by the username
     *
     * @param table_name
     * @param username
     */
    public void delete(String table_name, String username) {
        String sql = "DELETE FROM table_name WHERE username = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, username);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

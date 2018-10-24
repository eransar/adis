package model;

import Entities.IEntity;

import java.io.File;
import java.sql.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Database {
/*
Create new Database
param @fileName - the name of the database file
 */
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
/*
Connect to vacation database
 */
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
//            try {
////                if (conn != null) {
////                    conn.close();
////                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
        }
        return conn;
    }
/*
Insert Entity to the database
param @IEntity - interface for the objects in the database
 */
    public void Insert (IEntity entity){
            String sql = "INSERT INTO "+ entity.GetDBName()+"("+entity.getFieldsForDB()+")"+" VALUES"+"("+entity.getValuesForDB()+")";

            try (
                 Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (int i = 0; i < entity.getFieldsValue().size(); i++) {
                    pstmt.setString(i+1,entity.getFieldsValue().get(i));

                }
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getSQLState());
            }
        }
    /*
    read entity primary key from the database
    param @IEntity - interface for the objects in the database
    returns arraylist with the rows
     */
    public ArrayList<String> read(IEntity entity){
        ArrayList<String> read = new ArrayList<String>();
        ArrayList<String> fields_name = entity.getFields();
        String sql = "SELECT * FROM "+entity.GetDBName()+" "
                +"WHERE "+entity.getPrimaryKeyName()+"=\""+entity.getPrimaryKeyValue()+"\"";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
             ResultSetMetaData rsMetaData = rs.getMetaData(); // for debug purposes
            // loop through the result set

            for (int j = 0; rs.next(); j++) {
                for (int k = 0; k < entity.getFields().size() ; k++) {
                    read.add(rs.getString(fields_name.get(k)));
                }
            }


//            for (int i = 0; rs.next() ; i++) {
//                dict_read.put(fields_name.get(i),rs.getString(i+1));
//                System.out.println("added "+i);
//            }
        } catch (SQLException e) {
            String k = e.getMessage();
            System.out.println(e.getMessage());
        }
        return read;
    }

    public boolean isExist(IEntity entity) {
        boolean res;
        String sql = "SELECT" + " " + entity.getPrimaryKeyName() + " " + "FROM" + " " + entity.GetDBName() +" "+
                "WHERE"+" " + entity.getPrimaryKeyName() + "=" + '"' + entity.getPrimaryKeyValue() + '"';
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData rsMetaData = rs.getMetaData(); // for debug purposes

            res = !(rsMetaData.getColumnCount() == 0);


        } catch (SQLException e) {
            String k = e.getMessage();
            System.out.println(e.getMessage());
            return  false;
        }
        return res;
    }

    public void delete(IEntity entity){
        String sql = "DELETE FROM"+" "+entity.GetDBName()+" "+"WHERE"+" "+entity.getPrimaryKeyName()+"="+"?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            System.out.println(entity.getPrimaryKeyName());
            pstmt.setString(1, entity.getPrimaryKeyValue());
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }
//
    public void update(IEntity entity){
        String query="";
        for (int i = 0; i < entity.getFields().size() ; i++) {
            if(query.equals("")){
                query=entity.getFields().get(i)+" = ?";
            }
            else{
                query=query+" "+","+" "+entity.getFields().get(i)+" = ?";
            }

        }
        String sql ="UPDATE"+" "+entity.GetDBName()+" "+"SET"+" "+query+" "+"WHERE"+" "+entity.getPrimaryKeyName()+" "+"="
                +'"'+entity.getPrimaryKeyValue()+'"';

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            int i=0;
            for (i = 0; i < entity.getFields().size() ; i++) {
                pstmt.setString(i+1,entity.getFieldsValue().get(i));
            }
//            pstmt.setString(i+1,entity.getPrimaryKeyName());
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


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

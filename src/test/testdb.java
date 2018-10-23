package test;

import Entities.IEntity;
import Entities.User;
import model.Database;
import model.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class testdb {


    public static void main(String[] args) {
        Model model = Model.getInstance();
        User u1 = new User("test16", "1111", "abc", "test", "abc", "aaa");
        User u2 = new User("test16", "112222", "abc", "test", "abc", "aaa");
        Database db = new Database();
        model.InsertToDB(u1);
//        model.delete(u1);
        model.update(u2);
    }

//        ArrayList<String> result = model.ReadFromDB(u1);

//        System.out.println(result.size());



//        public static void delete(IEntity entity, Database db) {
//            String sql = "DELETE FROM users WHERE username = ?";
//
//            try (Connection conn = (db.connect());
//                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//                // set the corresponding param
//                pstmt.setString(1, id);
//                // execute the delete statement
//                pstmt.executeUpdate();
//
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//            System.out.println("worked");
//        }



    }


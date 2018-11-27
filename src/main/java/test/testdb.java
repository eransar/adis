package test;

import Entities.IEntity;
import Entities.User;
import Entities.Vacation;
import model.Database;
import model.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Thread.sleep;

public class testdb {


    public static void main(String[] args) throws InterruptedException {
        Model model = Model.getInstance();
        Vacation v = new Vacation("idan","Paris","ElAl","2$","11/27/2018","11/27/2019","","true");
        Vacation e = new Vacation("idan","Paris","ElAl","2$","11/27/2018","11/27/2019","","true");
        Database db = new Database();
        model.InsertToDB(v);
        model.InsertToDB(e);

//        model.delete(u1);
//        model.update(u2);
//        ArrayList<String> a = model.login(u3);
//        int i=5;
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


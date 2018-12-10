package test;

import Entities.Transaction;
import Entities.Vacation;
import model.Model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class testdb {


    public static void main(String[] args) throws InterruptedException {
        Model model = Model.getInstance();
//        CreateVacation v = new CreateVacation("idan","Paris","ElAl","2$","11/27/2018","11/27/2019","","true");
//        CreateVacation e = new CreateVacation("idan","Paris","ElAl","2$","11/27/2018","11/27/2019","","true");
//        Transaction d = new Transaction("idannn","merhav","1000000","99");
//        Transaction e = new Transaction("idannn","merhav","1000000","99");
//        Database db = new Database();
//        model.InsertToDB(d);
//        model.InsertToDB(e);
       int i= model.getMax(new Transaction());

//        ArrayList<List<String>> test =model.ReadFromDB(new Vacation(),"location","Pari");
//        int i =5 ;
//        ArrayList<List<String>> e = model.getData(new Vacation(),"creator","erantest");

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


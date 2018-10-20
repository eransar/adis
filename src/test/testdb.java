package test;

import Entities.User;
import model.Model;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class testdb {


    public static void main(String[] args) {
        Model model = Model.getInstance();
        User u1 = new User("testing","1111","abc","test","abc","aaa");
        //model.InsertToDB(u1);

        ArrayList<String> result = model.ReadFromDB(u1);

        System.out.println(result.size());


        int i = 5;
    }
}

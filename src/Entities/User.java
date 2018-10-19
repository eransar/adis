package Entities;

import java.util.ArrayList;

public class User extends AEntity{
    private String username;
    private String password;
    private String birthday;
    private String city;
    private String firstname;
    private String lastname;

    public User(String username,String password,String birthday, String city, String firstname, String lastname){
        super();
    this.username=username;
    this.password=password;
    this.birthday=birthday;
    this.city=city;
    this.firstname=firstname;
    this.lastname=lastname;

    }

    @Override
    public ArrayList<String> getFields() {
        return fields;

    }

    @Override
    public String getFieldsForDB() {
        String result ="";
        for (int i = 0; i < fields.size(); i++) {
            if (i == 0) {
                result = fields.get(i);
            } else {
                result = result + ", " + fields.get(i);
            }
        }
        return result;
    }

    @Override
    public String getValuesForDB() {
        String result="";
        for (int i = 0; i < fields.size(); i++) {
            if (i == 0) {
                result = "?";
            } else {
                result = result + ", " + "?";
            }
        }
        return result;
    }


    @Override
    public String GetDBName() {
        return "users";
    }

    @Override
    public void ReadFromDB() {

    }

    @Override
    public void InsertTODB() {

    }


    @Override
    public void DeleteFromDB() {

    }

    @Override
    public void UpdateFromDB() {

    }
}

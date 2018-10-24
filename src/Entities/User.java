package Entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User extends AEntity{
    private String username;
    private String password;
    private String birth;
    private String first_name;
    private String last_name;
    private String city;
    private String picture;


    public User(String username,String password,String birth, String city, String firstname, String lastname){
        super();
    this.username=username;
    this.password=password;
    this.birth =birth;
    this.city=city;
    this.first_name =firstname;
    this.last_name =lastname;
    this.picture="";

    }

    public User(ArrayList<String> LoginArray){
        super();
        this.username=LoginArray.get(0);
        this.password=LoginArray.get(1);
        this.birth =LoginArray.get(2);
        this.city=LoginArray.get(3);
        this.first_name =LoginArray.get(4);
        this.last_name =LoginArray.get(5);
        this.picture = LoginArray.get(6);
    }

    @Override

    /*
    Returns the fields value in arraylist
     */
    public ArrayList<String> getFieldsValue(){
        ArrayList<String> result = new ArrayList<>();
        result.add(this.username);
        result.add(this.password);
        result.add(this.birth);
        result.add(this.city);
        result.add(this.first_name);
        result.add(this.last_name);
        result.add(this.picture);

        return result;
    }

    @Override
    /*
    Returns DB name of the entity
     */
    public String GetDBName() {
        return "users";
    }

    @Override
    /*
    Returns primary key value of the user entity
     */
    public String getPrimaryKeyValue() {
        return username;
    }

    @Override
    /*
    Returns primary key name of the user entity
     */
    public String getPrimaryKeyName() {
        return "username";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUsername() {

        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBirth() {
        return birth;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCity() {
        return city;
    }
}

package Entities;

import javafx.beans.property.SimpleStringProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User extends AEntity{
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private SimpleStringProperty birth;
    private SimpleStringProperty first_name;
    private SimpleStringProperty last_name;
    private SimpleStringProperty city;
    private SimpleStringProperty picture;



    public User(String username,String password,String birth, String city, String firstname, String lastname){
        super();
    this.username=new SimpleStringProperty(username);
    this.password=new SimpleStringProperty(password);
    this.birth =new SimpleStringProperty(birth);
    this.city=new SimpleStringProperty(city);
    this.first_name =new SimpleStringProperty(firstname);
    this.last_name =new SimpleStringProperty(lastname);
    this.picture=new SimpleStringProperty("");


    }
    public User(String username){
        super();
        this.username=new SimpleStringProperty(username);
    }

    public User(ArrayList<String> LoginArray){
        super();
        this.username=new SimpleStringProperty(LoginArray.get(0));
        this.password=new SimpleStringProperty(LoginArray.get(1));
        this.birth =new SimpleStringProperty(LoginArray.get(2));
        this.first_name =new SimpleStringProperty(LoginArray.get(3));
        this.last_name =new SimpleStringProperty(LoginArray.get(4));
        this.city=new SimpleStringProperty(LoginArray.get(5));
        this.picture=new SimpleStringProperty(LoginArray.get(6));
    }

    @Override

    /*
    Returns the fields value in arraylist
     */
    public ArrayList<String> getFieldsValue(){
        ArrayList<String> result = new ArrayList<String>();
        result.add(this.username.getValue());
        result.add(this.password.getValue());
        result.add(this.birth.getValue());
        result.add(this.first_name.getValue());
        result.add(this.last_name.getValue());
        result.add(this.city.getValue());
        result.add(this.picture.getValue());

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
        return username.getValue();
    }

    @Override
    /*
    Returns primary key name of the user entity
     */
    public String getPrimaryKeyName() { return "username"; }

    public String getUsername() { return username.getValue(); }

    public void setUsername(String username) { this.username.set(username); }

    public void setPassword(String password) { this.password.set(password); }

    public void setBirth(String birth) { this.birth.set(birth); }

    public void setFirst_name(String first_name) { this.first_name.set(first_name); }

    public void setLast_name(String last_name) { this.last_name.set(last_name); }

    public void setCity(String city) { this.city.set(city); }


    public String getPassword() {
        return this.password.getValue();
    }

    public String getBirth() { return this.birth.getValue(); }

    public String getFirst_name() {
        return this.first_name.getValue();
    }

    public String getLast_name() {
        return this.last_name.getValue();
    }

    public String getCity() {
        return this.city.getValue();
    }
}

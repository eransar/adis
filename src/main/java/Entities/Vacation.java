package Entities;

import javafx.beans.property.SimpleStringProperty;
import model.Model;
import sun.rmi.runtime.Log;

import java.util.ArrayList;

public class Vacation extends AEntity {
    SimpleStringProperty vacation_id;
    SimpleStringProperty creator;
    SimpleStringProperty location;
    SimpleStringProperty airline;
    SimpleStringProperty price;
    SimpleStringProperty start_date;
    SimpleStringProperty end_date;
    SimpleStringProperty picture;
    SimpleStringProperty visible;
    SimpleStringProperty text;

    public Vacation(int id,String creator,String location,String airline, String price, String start_date, String end_date, String picture, String visible, String text){
        super();


        this.vacation_id=new SimpleStringProperty(""+(id));
        this.creator=new SimpleStringProperty(creator);
        this.location=new SimpleStringProperty(location);
        this.airline=new SimpleStringProperty(airline);
        this.price=new SimpleStringProperty(price);
        this.start_date=new SimpleStringProperty(start_date);
        this.end_date=new SimpleStringProperty(end_date);
        this.picture=new SimpleStringProperty(picture);
        this.visible=new SimpleStringProperty(visible);
        this.text=new SimpleStringProperty(text);
    }


    @Override
    public ArrayList<String> getFieldsValue() {
        ArrayList<String> result = new ArrayList<String>();
        result.add(vacation_id.getValue());
        result.add(this.creator.getValue());
        result.add(this.location.getValue());
        result.add(this.airline.getValue());
        result.add(this.price.getValue());
        result.add(this.start_date.getValue());
        result.add(this.end_date.getValue());
        result.add(this.picture.getValue());
        result.add(this.visible.getValue());
        result.add(this.text.getValue());

        return result;
    }

    public Vacation(){};

    public String getText() {
        return text.get();
    }

    public SimpleStringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public Vacation(ArrayList<String> LoginArray){
        super();
        this.vacation_id=new SimpleStringProperty(LoginArray.get(0));
        this.creator=new SimpleStringProperty(LoginArray.get(1));
        this.location =new SimpleStringProperty(LoginArray.get(2));
        this.airline =new SimpleStringProperty(LoginArray.get(3));
        this.price =new SimpleStringProperty(LoginArray.get(4));
        this.start_date=new SimpleStringProperty(LoginArray.get(5));
        this.end_date=new SimpleStringProperty(LoginArray.get(6));
        this.picture=new SimpleStringProperty(LoginArray.get(7));
        this.visible=new SimpleStringProperty(LoginArray.get(8));
        this.text=new SimpleStringProperty(LoginArray.get(9));
    }

    @Override
    public String GetDBName() {
        return "vacations";
    }

    @Override
    public String getPrimaryKeyValue() {
        return vacation_id.getValue();
    }


    public String getVacation_id() {
        return vacation_id.get();
    }

    public SimpleStringProperty vacation_idProperty() {
        return vacation_id;
    }

    public void setVacation_id(String vacation_id) {
        this.vacation_id.set(vacation_id);
    }

    public String getCreator() {
        return creator.get();
    }

    public SimpleStringProperty creatorProperty() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator.set(creator);
    }

    public String getLocation() {
        return location.get();
    }

    public SimpleStringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getAirline() {
        return airline.get();
    }

    public SimpleStringProperty airlineProperty() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline.set(airline);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getStart_date() {
        return start_date.get();
    }

    public SimpleStringProperty start_dateProperty() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date.set(start_date);
    }

    public String getEnd_date() {
        return end_date.get();
    }

    public SimpleStringProperty end_dateProperty() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date.set(end_date);
    }

    public String getPicture() {
        return picture.get();
    }

    public SimpleStringProperty pictureProperty() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture.set(picture);
    }

    public String getVisible() {
        return visible.get();
    }

    public SimpleStringProperty visibleProperty() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible.set(visible);
    }

    @Override
    public String getPrimaryKeyName() {
        return "vacation_id";

    }
}

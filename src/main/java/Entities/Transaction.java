package Entities;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Transaction extends AEntity {
    SimpleStringProperty transaction_id;
    SimpleStringProperty seller;
    SimpleStringProperty vacation_id;
    SimpleStringProperty buyer;
    SimpleStringProperty statuscode;
    SimpleStringProperty vacation2_id;
    SimpleStringProperty type;

    public Transaction(int id, String seller, String buyer, String vacation_id, String statuscode){
        super();
        this.transaction_id =new SimpleStringProperty(""+id);
        this.seller=new SimpleStringProperty(seller);
        this.vacation_id= new SimpleStringProperty(vacation_id);
        this.buyer=new SimpleStringProperty(buyer);
        this.statuscode=new SimpleStringProperty(statuscode);
        this.vacation2_id=new SimpleStringProperty("");
        this.type=new SimpleStringProperty("");

    }
    public Transaction(int id, String seller, String buyer, String vacation_id, String statuscode, String type){
        super();
        this.transaction_id =new SimpleStringProperty(""+id);
        this.seller=new SimpleStringProperty(seller);
        this.vacation_id= new SimpleStringProperty(vacation_id);
        this.buyer=new SimpleStringProperty(buyer);
        this.statuscode=new SimpleStringProperty(statuscode);
        this.vacation2_id=new SimpleStringProperty("");
        this.type=new SimpleStringProperty(type);

    }
    public Transaction(int id, String seller, String buyer, String vacation_id, String statuscode, String vacation2_id, String type){
        super();
        this.transaction_id =new SimpleStringProperty(""+id);
        this.seller=new SimpleStringProperty(seller);
        this.vacation_id= new SimpleStringProperty(vacation_id);
        this.buyer=new SimpleStringProperty(buyer);
        this.statuscode=new SimpleStringProperty(statuscode);
        this.vacation2_id=new SimpleStringProperty(vacation2_id);
        this.type=new SimpleStringProperty(type);

    }
    @Override
    public ArrayList<String> getFieldsValue() {
        ArrayList<String> result = new ArrayList<String>();
        result.add(this.transaction_id.getValue());
        result.add(this.seller.getValue());
        result.add(this.vacation_id.getValue());
        result.add(this.buyer.getValue());
        result.add(this.statuscode.getValue());
        result.add(this.vacation2_id.getValue());
        result.add(this.type.getValue());
        return result;
    }

    public Transaction(ArrayList<String> LoginArray){
        super();
        this.transaction_id=new SimpleStringProperty(LoginArray.get(0));
        this.seller=new SimpleStringProperty(LoginArray.get(1));
        this.vacation_id =new SimpleStringProperty(LoginArray.get(2));
        this.buyer =new SimpleStringProperty(LoginArray.get(3));
        this.statuscode =new SimpleStringProperty(LoginArray.get(4));
        this.vacation2_id=new SimpleStringProperty(LoginArray.get(5));
        this.type=new SimpleStringProperty(LoginArray.get(6));
    }
    public Transaction(){}

    public String getVacation2_id() {
        return vacation2_id.get();
    }

    public SimpleStringProperty vacation2_idProperty() {
        return vacation2_id;
    }

    public void setVacation2_id(String vacation2_id) {
        this.vacation2_id.set(vacation2_id);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }



    @Override
    public String GetDBName() {
        return "transactions";
    }

    @Override
    public String getPrimaryKeyValue() {
        return transaction_id.getValue();
    }

    @Override
    public String getPrimaryKeyName() {
        return "transaction_id";
    }

    public String getTransaction_id() {
        return transaction_id.get();
    }

    public SimpleStringProperty transaction_idProperty() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id.set(transaction_id);
    }

    public String getSeller() {
        return seller.get();
    }

    public SimpleStringProperty sellerProperty() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller.set(seller);
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

    public String getBuyer() {
        return buyer.get();
    }

    public SimpleStringProperty buyerProperty() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer.set(buyer);
    }

    public String getStatuscode() {
        return statuscode.get();
    }

    public SimpleStringProperty statuscodeProperty() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode.set(statuscode);
    }
}

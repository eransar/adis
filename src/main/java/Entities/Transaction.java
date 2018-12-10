package Entities;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Transaction extends AEntity {
    SimpleStringProperty transcation_id;
    SimpleStringProperty seller;
    SimpleStringProperty vacation_id;
    SimpleStringProperty buyer;
    SimpleStringProperty statuscode;

    public Transaction(int id, String seller, String buyer, String price, String vacation_id, String statuscode){
        super();
        this.transcation_id=new SimpleStringProperty(""+id);
        this.seller=new SimpleStringProperty(seller);
        this.vacation_id= new SimpleStringProperty(vacation_id);
        this.buyer=new SimpleStringProperty(buyer);
        this.statuscode=new SimpleStringProperty(statuscode);

    }

    @Override
    public ArrayList<String> getFieldsValue() {
        ArrayList<String> result = new ArrayList<String>();
        result.add(this.transcation_id.getValue());
        result.add(this.seller.getValue());
        result.add(this.vacation_id.getValue());
        result.add(this.buyer.getValue());
        result.add(this.statuscode.getValue());
        return result;
    }

    @Override
    public String GetDBName() {
        return "transactions";
    }

    @Override
    public String getPrimaryKeyValue() {
        return transcation_id.getValue();
    }

    @Override
    public String getPrimaryKeyName() {
        return "transaction_id";
    }
}

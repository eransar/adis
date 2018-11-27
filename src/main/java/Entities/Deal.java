package Entities;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Deal extends AEntity {
    private static int counter;
    SimpleStringProperty deals_id;
    SimpleStringProperty seller;
    SimpleStringProperty buyer;
    SimpleStringProperty price;
    SimpleStringProperty vacation_id;

    public Deal(String seller, String buyer, String price, String vacation_id){
        super();
        counter++;
        this.deals_id=new SimpleStringProperty(""+counter);
        this.seller=new SimpleStringProperty(seller);
        this.buyer=new SimpleStringProperty(buyer);
        this.price=new SimpleStringProperty(price);
        this.vacation_id=new SimpleStringProperty(vacation_id);

    }

    @Override
    public ArrayList<String> getFieldsValue() {
        ArrayList<String> result = new ArrayList<String>();
        result.add(this.deals_id.get());
        result.add(this.seller.getValue());
        result.add(this.buyer.getValue());
        result.add(this.price.getValue());
        result.add(this.vacation_id.getValue());
        return result;
    }

    @Override
    public String GetDBName() {
        return "deals";
    }

    @Override
    public String getPrimaryKeyValue() {
        return deals_id.getValue();
    }

    @Override
    public String getPrimaryKeyName() {
        return "deals_id";
    }
}

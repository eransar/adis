package Entities;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Payment extends AEntity{
    private SimpleStringProperty payment_id;
    private SimpleStringProperty seller;
    private SimpleStringProperty buyer;
    private SimpleStringProperty amount;
    private SimpleStringProperty vacation_id;
    private SimpleStringProperty buyer_id;
    private SimpleStringProperty buyer_cvv;
    private SimpleStringProperty buyer_cardexpiration;
    private SimpleStringProperty purchasedate;
    private SimpleStringProperty method;
    private SimpleStringProperty paypal_username;

    public Payment(int payment_id,String seller,String buyer,String amount
    ,int vacation_id,int buyer_id, String buyer_cvv
    ,String buyer_cardexpiration, String purchasedate, String method, String paypal_username){
        this.payment_id=new SimpleStringProperty(""+payment_id);
        this.seller=new SimpleStringProperty(seller);
        this.buyer=new SimpleStringProperty(buyer);
        this.amount=new SimpleStringProperty(amount);
        this.vacation_id=new SimpleStringProperty(""+vacation_id);
        this.buyer_id=new SimpleStringProperty(""+buyer_id);
        this.buyer_cvv=new SimpleStringProperty(buyer_cvv);
        this.buyer_cardexpiration=new SimpleStringProperty(buyer_cardexpiration);
        this.purchasedate=new SimpleStringProperty(purchasedate);
        this.method=new SimpleStringProperty(method);
        this.paypal_username=new SimpleStringProperty(paypal_username);
    }
    public Payment(ArrayList<String> LoginArray){
        super();
        this.payment_id=new SimpleStringProperty(LoginArray.get(0));
        this.seller=new SimpleStringProperty(LoginArray.get(1));
        this.buyer=new SimpleStringProperty(LoginArray.get(2));
        this.amount=new SimpleStringProperty(LoginArray.get(3));
        this.vacation_id=new SimpleStringProperty(LoginArray.get(4));
        this.buyer_id=new SimpleStringProperty(LoginArray.get(5));
        this.buyer_cvv=new SimpleStringProperty(LoginArray.get(6));
        this.buyer_cardexpiration=new SimpleStringProperty(LoginArray.get(7));
        this.purchasedate=new SimpleStringProperty(LoginArray.get(8));
        this.method=new SimpleStringProperty(LoginArray.get(9));
        this.paypal_username=new SimpleStringProperty(LoginArray.get(10));
    }
    public Payment(){}

    @Override
    public ArrayList<String> getFieldsValue() {
        ArrayList<String> result = new ArrayList<String>();
        result.add(payment_id.getValue());
        result.add(this.seller.getValue());
        result.add(this.buyer.getValue());
        result.add(this.amount.getValue());
        result.add(this.vacation_id.getValue());
        result.add(this.buyer_id.getValue());
        result.add(this.buyer_cvv.getValue());
        result.add(this.buyer_cardexpiration.getValue());
        result.add(this.purchasedate.getValue());
        result.add(this.method.getValue());
        result.add(this.paypal_username.getValue());

        return result;
    }

    @Override
    public String GetDBName() {
        return "payments";
    }

    @Override
    public String getPrimaryKeyValue() {
        return payment_id.getValue();
    }

    @Override
    public String getPrimaryKeyName() {
        return "payment_id";
    }
}

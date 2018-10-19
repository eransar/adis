package model;

import Entities.IEntity;

public class Model {
    private static Model ourInstance = new Model();

    public static Model getInstance() {
        return ourInstance;
    }
    private Database db;

    private Model() {
        this.db=new Database();
        db.connect();
    }

    public void Insert(IEntity entity){
//        db.
    }
}

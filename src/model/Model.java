package model;

import Entities.IEntity;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Model {
    private static Model ourInstance = new Model();

    public static Model getInstance() {
        return ourInstance;
    }
    private Database db;

    private Model() {
        this.db=new Database();
//        db.connect();
    }

    public void InsertToDB(IEntity entity){
        db.Insert(entity);
    }
    public ArrayList<String> ReadFromDB(IEntity entity){
        return db.read(entity);
    }
}

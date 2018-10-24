package model;

import Entities.IEntity;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/*
Representing the Model class in our project.
The model communicate with the database and get commands from the Controllers

Model is designed to be a Singleton so there is only one Model when the program runs and every controller can access it.
 */
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
    public boolean isExist(IEntity entity){return db.isExist(entity);}
    public void delete(IEntity entity){db.delete(entity);}
    public void update(IEntity entity){
        db.update(entity);
    }
}

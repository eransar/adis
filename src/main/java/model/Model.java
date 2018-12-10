package model;

import Entities.IEntity;
import com.sun.xml.internal.fastinfoset.algorithm.IEEE754FloatingPointEncodingAlgorithm;

import java.util.ArrayList;
import java.util.List;
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
    public ArrayList<List<String>> ReadFromDB(IEntity entity, String search, String searchFor){
        return db.read(entity,search,searchFor);
    }
    public boolean isExist(IEntity entity){return db.isExist(entity);}
    public void delete(IEntity entity){db.delete(entity);}
    public void update(IEntity entity){
        db.update(entity);
    }
    public ArrayList<String> login(IEntity entity){return db.login(entity);}
    public int getMax(IEntity entity){return db.getMax(entity);}
    public ArrayList<List<String>> getData(IEntity entity, String field, String find){
        return db.getData(entity,field,find);
    };
}

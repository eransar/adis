package Entities;



import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class AEntity implements IEntity {
    ArrayList<String> fields;


    public AEntity(){
        fields=new ArrayList<>();
        Field[] fieldarray = this.getClass().getDeclaredFields();
        for (int i = 0; i <fieldarray.length ; i++) {
            fields.add(fieldarray[i].getName());
        }

    }




}

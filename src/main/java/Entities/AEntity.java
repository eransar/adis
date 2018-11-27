package Entities;



import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class AEntity implements IEntity {
    ArrayList<String> fields;

/*
Constructor Creating fields based on declearedfield of the class.
when we initialize new Entity it will correspond to it's fields and not the parent.
 */
    public AEntity(){
        fields=new ArrayList<String>();
        Field[] fieldarray = this.getClass().getDeclaredFields();


        for (int i = 0; i <fieldarray.length ; i++) {
            if(!java.lang.reflect.Modifier.isStatic(fieldarray[i].getModifiers())){
                fields.add(fieldarray[i].getName());
            }

        }
    }
    /*
    Returns the fields in a long string with delimiters
     */
    public String getFieldsForDB() {
        String result ="";
        for (int i = 0; i < fields.size(); i++) {
            if (i == 0) {
                result = fields.get(i);
            } else {
                result = result + ", " + fields.get(i);
            }
        }
        return result;
    }

    /*
Returns String of question marks (?) for the database query
 */
    public String getValuesForDB() {
        String result="";
        for (int i = 0; i < fields.size(); i++) {
            if (i == 0) {
                result = "?";
            } else {
                result = result + ", " + "?";
            }
        }
        return result;
    }

    /*
Return the fields names in arraylist
 */
    public ArrayList<String> getFields() {
        return fields;

    }




}

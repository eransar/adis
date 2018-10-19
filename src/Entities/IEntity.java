package Entities;

import java.util.ArrayList;

public interface IEntity {

    public ArrayList<String> getFields();
    public ArrayList<String> getFieldsValue();
    public String getFieldsForDB();
    public String getValuesForDB();
    public String GetDBName();
    public void ReadFromDB();
    public void InsertTODB();
    public void DeleteFromDB();
    public void UpdateFromDB();

}

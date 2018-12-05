package Contrroller;

import Entities.IEntity;
import model.Model;
import view.IView;

import java.util.ArrayList;

public class MasterController {
    private static MasterController ourInstance = new MasterController();
    private Model model = Model.getInstance();
    private IView iview;
    private double PrefWidthSerach =0;
    private double PrefHeightSearch =0;


    public static MasterController getInstance() {
        return ourInstance;
    }

    private MasterController() {

    }

    public void setIview(IView iview) {
        this.iview = iview;
    }

    public void insert(IEntity entity){
        model.InsertToDB(entity);
    }
    public ArrayList<String> read(IEntity entity,String search,String searchFor){
        return model.ReadFromDB(entity,search,searchFor);
    }


    /**
     * Search init size
     * @param prefWidthSerach
     */
    public void setPrefWidthSerach(double prefWidthSerach) {
        this.PrefWidthSerach = prefWidthSerach;
    }

    public void setPrefHeightSearch(double prefHeightSearch) {
        this.PrefHeightSearch = prefHeightSearch;
    }

    public double getPrefWidthSerach() {
        return PrefWidthSerach;
    }

    public double getPrefHeightSearch() {
        return PrefHeightSearch;
    }

    ///////////////////////////////////////////////////////////////


    public boolean isExist(IEntity entity){return model.isExist(entity);}
    public void delete(IEntity entity){model.delete(entity);}
    public void update(IEntity entity){
        model.update(entity);
    }
    public ArrayList<String> login(IEntity entity){ return model.login(entity);}
}

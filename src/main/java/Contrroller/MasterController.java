package Contrroller;

import Entities.IEntity;
import Entities.User;
import javafx.stage.Stage;
import model.Model;
import view.IView;
import view.MainController;

import java.util.ArrayList;
import java.util.List;

public class MasterController {
    private static MasterController ourInstance = new MasterController();
    private Model model = Model.getInstance();
    private IView iview;
    //set search size
    private double PrefWidthSerach =0;
    private double PrefHeightSearch =0;
    //the current stage
    private Stage stage;
    private String howSearchNow;



    private User user;






    public String getHowSearchNow() {
        return howSearchNow;
    }

    public void setHowSearchNow(String howSearchNow) {
        this.howSearchNow = howSearchNow;
    }

    public static MasterController getInstance() {
        return ourInstance;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {

        this.stage = stage;
    }

    public void setIview(IView iview) {
        this.iview = iview;
    }

    public void insert(IEntity entity){
        model.InsertToDB(entity);
    }
    public ArrayList<List<String>> read(IEntity entity, String search, String searchFor){
        return model.ReadFromDB(entity,search,searchFor);
    }


    /**
     * Search init size
     * @param prefWidthSerach
     *
     *
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
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isExist(IEntity entity){return model.isExist(entity);}
    public void delete(IEntity entity){model.delete(entity);}
    public void update(IEntity entity){
        model.update(entity);
    }
    public ArrayList<String> login(IEntity entity){ return model.login(entity);}
}

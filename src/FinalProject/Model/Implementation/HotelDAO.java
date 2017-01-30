package FinalProject.Model.Implementation;

import FinalProject.Model.DAOImpl;
import FinalProject.Entity.Hotel;
import FinalProject.Services.ProjectUTILS;

import java.util.*;


public class HotelDAO extends DAOImpl<Hotel> {


    public HotelDAO() {
        super();
        if(super.getDataBaseList().size()==0){
            List<Hotel> list = ProjectUTILS.createHotels();
            super.setDataBaseList(list);
        }
    }

    public HotelDAO(List<Hotel> hotels){
        super.setDataBaseList(hotels);
    }

    public List<Hotel> getHotels() {
        return super.getDataBaseList();
    }

    public void setHotels(List<Hotel> dataBaseList) {
        super.setDataBaseList(dataBaseList);
    }

}

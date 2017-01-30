package FinalProject.Model.Implementation;

import FinalProject.Model.DAOImpl;
import FinalProject.Entity.Hotel;
import FinalProject.Services.ProjectUTILS;

import java.util.*;


public class HotelDAO extends DAOImpl<Hotel> {


    public HotelDAO() {
        super();
        if(super.getDataBaseList().size()==0 || super.getDataBaseList().stream().allMatch(hotel -> hotel.getRooms().size()==0)){
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

    public String getNameByID (UUID hotelID)
    {
        Hotel res = null;
        res = this.getDataBaseList().stream().filter(a->a.getId().equals(hotelID)).findFirst().get();
        String StrRes;
        if (res != null) StrRes = res.getHotelName();
        else StrRes = "no_result";
        return StrRes;
    }

    public String getCityByID (UUID hotelID)
    {
        Hotel res = null;
        res = this.getDataBaseList().stream().filter(a->a.getId().equals(hotelID)).findFirst().get();
        String StrRes;
        if (res != null) StrRes = res.getCity();
        else StrRes = "no_result";
        return StrRes;
    }

    public void setHotels(List<Hotel> dataBaseList) {
        super.setDataBaseList(dataBaseList);
    }

}

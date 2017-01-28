package FinalProject.main;

import java.util.List;
import java.util.Set;


public class HotelDAO extends DAOImpl<Hotel> {


    public HotelDAO() {
        super();
        if(super.getDataBaseList().size()==0){
            List<Hotel> list = ProjectUTILS.createHotels();
            ProjectUTILS.createDefaultRooms(list);
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

package FinalProject.main;

import java.util.List;
import java.util.Set;


public class HotelDAO extends DAOImpl<Hotel> {


    public HotelDAO() {
        super();
        if(super.getDataBaseList().size()==0){
            List<Hotel> list = ProjectUTILS.createHotels(0);
            ProjectUTILS.createDefaultRooms(list);
            super.setDataBaseList(list);
        }
    }

    public HotelDAO(List<Hotel> hotels){
        super.setDataBaseList(hotels);
    }

    @Override
    public Hotel save(Hotel object) {
        return super.save(object);
    }

    @Override
    public Hotel remove(Hotel object) {
        return super.remove(object);
    }

    @Override
    public Hotel update(Hotel object) {
        return super.update(object);
    }


    public List<Hotel> getHotels() {
        return super.getDataBaseList();
    }


    public void setHotels(List<Hotel> dataBaseList) {
        super.setDataBaseList(dataBaseList);
    }

    /*private List<Hotel> hotels;

    public HotelDAO(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public HotelDAO(){
        this.hotels = ProjectUTILS.createHotels(25);
        ProjectUTILS.createDefaultRooms(this.hotels);
    }

    @Override
    public Hotel save(Hotel hotel) {
        hotels.add(hotel);
        return hotel;
    }

    @Override
    public Hotel remove(Hotel hotel) {
        hotels.remove(hotel);
        return hotel;
    }

    @Override
    public Hotel update(Hotel hotel) {
        int i = hotels.indexOf(hotel);
        hotels.remove(i);
        hotels.add(i, hotel);
        return hotel;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }*/
}

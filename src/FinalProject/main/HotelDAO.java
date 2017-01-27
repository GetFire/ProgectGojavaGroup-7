package FinalProject.main;

import java.util.List;
import java.util.Set;


public class HotelDAO extends DAOImpl<Hotel> {
    //private List<Hotel> hotels;

    public HotelDAO(List<Hotel> hotels) {
        this.BAS = hotels;
    }

    public HotelDAO(){
        this.BAS = ProjectUTILS.createHotels(25);
        ProjectUTILS.createDefaultRooms((List<Hotel>)this.BAS);
    }
/*
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
*/
    @Override
    public Hotel update(Hotel hotel) {
        int i = ((List<Hotel>)this.BAS).indexOf(hotel);
        ((List<Hotel>)this.BAS).remove(i);
        ((List<Hotel>)this.BAS).add(i, hotel);
        return hotel;
    }

    public List<Hotel> getHotels() {
        return (List<Hotel>)this.BAS;
    }

    public void setHotels(List<Hotel> hotels) {
        this.BAS = hotels;
    }
}

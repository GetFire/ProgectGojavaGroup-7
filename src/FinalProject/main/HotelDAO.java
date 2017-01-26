package FinalProject.main;

import java.util.List;
import java.util.Set;


public class HotelDAO extends DAOImpl<Hotel> {
    private List<Hotel> hotels;

    public HotelDAO(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public HotelDAO(){
        this.hotels = ProjectUTILS.createHotels(10);
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
    }
}

package FinalProject;

import java.util.List;
import java.util.Set;


public class HotelDAO extends DAOImpl<Hotel> {
    private List<Hotel> hotels;

    public HotelDAO(List<Hotel> hotels) {
        this.hotels = hotels;
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
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}
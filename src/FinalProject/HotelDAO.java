package FinalProject;

import java.util.Set;


public class HotelDAO extends DAOImpl<Hotel> {
    private Set<Hotel> hotels;

    public HotelDAO(Set<Hotel> hotels) {
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

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }
}

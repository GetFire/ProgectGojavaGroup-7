package FinalProject;

import java.util.List;
import java.util.Set;


public class RoomDAO extends DAOImpl<Room> {
    private List<Hotel>hotels;

    public RoomDAO(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public Room save(Room object) {
        return super.save(object);
    }

    @Override
    public Room remove(Room object) {
        return super.remove(object);
    }

    @Override
    public Room update(Room object) {
        return super.update(object);
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}

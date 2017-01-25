package FinalProject;

import java.util.Set;


public class RoomDAO extends DAOImpl<Room> {
    private Set<Hotel>hotels;

    public RoomDAO(Set<Hotel> hotels) {
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

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }
}

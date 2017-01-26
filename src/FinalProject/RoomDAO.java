package FinalProject;

import java.util.List;

public class RoomDAO extends DAOImpl<Room> {
    private List<Hotel> hotels;

    public RoomDAO(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public RoomDAO() {
    }

    @Override
    public Room save(Room aRoom) {
        return super.save(aRoom);
    }

    @Override
    public Room remove(Room aRoom) {
        return super.remove(aRoom);
    }

    @Override
    public Room update(Room aRoom) {
        return super.update(aRoom);
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}

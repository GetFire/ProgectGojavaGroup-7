package FinalProject.main;

import java.util.List;

public class RoomDAO extends DAOImpl<Room> {
    private List<Room> rooms;

    public RoomDAO(List<Room> rooms) {
        this.rooms = rooms;
    }

    public RoomDAO() {
    }

    @Override
    public Room save(Room room) {
        rooms.add(room);
        return room;
    }

    @Override
    public Room remove(Room room) {
        rooms.remove(room);
        return room;
    }

    @Override
    public Room update(Room room) {
        int i = rooms.indexOf(room);
        rooms.remove(i);
        rooms.add(i, room);
        return room;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}

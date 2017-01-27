package FinalProject.main;

import java.util.List;

public class RoomDAO extends DAOImpl<Room> {
    public RoomDAO() {
        super();
    }

    public RoomDAO(List<Room> rooms){
        super.setDataBaseList(rooms);
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


    public List<Room> getRooms() {
        return super.getDataBaseList();
    }


    public void setRooms(List<Room> dataBaseList) {
        super.setDataBaseList(dataBaseList);
    }

}

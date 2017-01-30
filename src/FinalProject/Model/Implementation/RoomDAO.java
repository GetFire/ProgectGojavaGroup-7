package FinalProject.Model.Implementation;

import FinalProject.Model.DAOImpl;
import FinalProject.Entity.Room;
import FinalProject.Services.ProjectUTILS;

import java.util.List;
import java.util.stream.Collectors;

public class RoomDAO extends DAOImpl<Room> {
    public RoomDAO() {
        super();
        if(super.getDataBaseList().size()==0){
            this.setRooms(ProjectUTILS.createDefaultRooms("non-name"));
        }
    }

    public RoomDAO(List<Room> rooms){
        super.setDataBaseList(rooms);
    }

  /*  @Override
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
*/

    public List<Room> getRooms(String hotelName) {
        return super.getDataBaseList().stream().peek(room -> room.setHotelName(hotelName)).collect(Collectors.toList());
    }


    public void setRooms(List<Room> dataBaseList) {
        super.setDataBaseList(dataBaseList);
    }

}

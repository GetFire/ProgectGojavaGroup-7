package FinalProject;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Volodymyr Tymchuk on 16.01.2017 for ProgectGojavaGroup-7.
 */
public interface HotelsAPI {
    Collection<Hotel> findHotelByName(String name);
    Collection<Hotel> findHotelByCity(String city);
    void bookRoom(UUID roomID, UUID userID, UUID hotelID);
    void cancelReservation(UUID roomID, UUID userID, UUID hotelID);
    Collection<Room> findRoom(Map<String, String> params);
}

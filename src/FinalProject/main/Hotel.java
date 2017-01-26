package FinalProject.main;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Hotel {
    public static final String CITY = "city";
    public static final String HOTEL_NAME = "hotelName";
    public static final String PRICE = "price";
    public static final String PERSONS = "persons";

    private String hotelName;
    private String city;
    private  List<Room> rooms = new ArrayList<>();
    private UUID id;


    public Hotel(String hotelName, String city) {
        this.hotelName = hotelName;

        this.city = city;
        this.id = UUID.randomUUID();
    }


    public String getHotelName() {
        return hotelName;
    }

    public String getCity() {
        return city;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{Hotel Name: " + hotelName
                + ", city: " + city + '}';
    }
}

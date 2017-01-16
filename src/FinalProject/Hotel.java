package FinalProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Hotel {

    public static final String CITY = "city";
    public static final String HOTEL_NAME = "hotelName";
    public static final String PRICE = "price";
    public static final String PERSONS = "persons";

    private String hotelName;
    private String city;
    public List<Room> rooms = new ArrayList<>();
    private UUID id;




    public Hotel(String hotelName, String city) {
        this.hotelName = hotelName;
        this.city = city;
        this.id = UUID.randomUUID();
    }


    // создаем список из 10 комнат по умолчанию
    public void createDefaultRooms() {
        Room rm1 = new Room(1, hotelName);
        Room rm2 = new Room(2, hotelName);
        Room rm3 = new Room(3, hotelName);
        Room rm4 = new Room(4, hotelName);
        Room rm5 = new Room(5, hotelName);
        Room rm6 = new Room(1, hotelName);
        Room rm7 = new Room(2, hotelName);
        Room rm8 = new Room(3, hotelName);
        Room rm9 = new Room(4, hotelName);
        Room rm10 = new Room(5, hotelName);
        Collections.addAll(rooms, rm1, rm2, rm3, rm4, rm5, rm6, rm7, rm8, rm9, rm10);
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

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{Hotel Name: " + hotelName
                + ", city: " + city+ '}';
    }
}

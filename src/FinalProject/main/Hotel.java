package FinalProject.main;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Hotel implements Serializable{
    public static final String CITY = "city";
    public static final String HOTEL_NAME = "hotelName";
    public static final String PRICE = "price";
    public static final String PERSONS = "persons";

    private String hotelName;
    private String city;
    private List<Room> rooms = new ArrayList<>();
    private UUID id;


    public Hotel(String hotelName, String city) {
        this.hotelName = hotelName;
        this.rooms = new RoomDAO().getRooms(hotelName);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (hotelName != null ? !hotelName.equals(hotel.hotelName) : hotel.hotelName != null) return false;
        if (city != null ? !city.equals(hotel.city) : hotel.city != null) return false;
        return id != null ? id.equals(hotel.id) : hotel.id == null;

    }

    @Override
    public int hashCode() {
        int result = hotelName != null ? hotelName.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}

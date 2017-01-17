package FinalProject;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static FinalProject.Hotel.*;

/*
* An instance of this class simulates user operation
*/

public class Controller implements UserInterface, HotelsAPI {
    private List<Hotel> hotels = new ArrayList<>();
    //@добавлю DAO на будущее, потом в методах нужно использовать дао вместо поля hotels
    private DAOImpl hotelsDao = new DAOImpl();

    //Find hotels by name
    public Collection<Hotel> findHotelByName(String name) {
        return hotels.stream().filter(a -> a.getHotelName().equals(name)).collect(Collectors.toList());

    }

    // Find hotels by name city
    public Collection<Hotel> findHotelByCity(String city) {
        return hotels.stream().filter(a -> a.getCity().equals(city)).collect(Collectors.toList());

    }

    //Booking rhe room. пока не знаю что делать с userID
    public void bookRoom(UUID roomID, UUID userID, UUID hotelID) {
        List<Hotel> foundedHotels = hotels.stream().filter(a -> a.getId().equals(hotelID)).collect(Collectors.toList());
        Hotel hotel = foundedHotels.get(0);
        List<Room> rooms = hotel.getRooms().stream().filter(a -> a.getId().equals(roomID)).collect(Collectors.toList());
        Room foundedRoom = rooms.get(0);
        foundedRoom.setAvaible(false);
    }


    // Cancel booking. пока не знаю что делать с userID
    public void cancelReservation(UUID roomID, UUID userID, UUID hotelID) {
        List<Hotel> foundedHotels = hotels.stream().filter(a -> a.getId().equals(hotelID)).collect(Collectors.toList());
        Hotel hotel = foundedHotels.get(0);
        List<Room> rooms = hotel.getRooms().stream().filter(a -> a.getId().equals(roomID)).collect(Collectors.toList());
        Room foundedRoom = rooms.get(0);
        if (!foundedRoom.getIsAvaible()) {
            foundedRoom.setAvaible(true);
            foundedRoom.setDateAvaiableFrom(LocalDate.now());
            System.out.println("Выполнено!");
        }
    }

    // пока пускай будет так
    public Collection<Hotel> findRoom(Map<String, String> params) {
        //подготавливаю код
//        List<Hotel>allHotels = hotelsDao.getDao();
        List<Hotel> found = new ArrayList<>();

        // Тут предлагаю создать свою ошибку, InvalidFormException, в том случае когда поля city и hotelName - пустые
        String city;
        String hotelName;
        int price;
        int persons;

        if (params.get(CITY).equals("") || params.get(HOTEL_NAME).equals("")) {
            throw new InvalidFormException("Please fill the \"City\" and \"Hotel name\" fields");
        }
        city = params.get(CITY);
        hotelName = params.get(HOTEL_NAME);

        try {
            price = Integer.parseInt(params.get(PRICE));
        } catch (Exception e) {
            price = 0;
        }
        try {
            persons = Integer.parseInt(params.get(PERSONS));
        } catch (Exception ex) {
            persons = 0;
        }


// Set variable of searching

        int flag = 0;
        if (price != 0 && persons != 0) flag = 1;
        else if (price == 0 && persons != 0) flag = 2;
        else if (price != 0 && persons == 0) flag = 3;
        else if (price == 0 && persons == 0) flag = 4;

        switch (flag) {
            case 1:
                List<Hotel> found1 = hotels.stream()
                        .filter(a -> a.getCity().equals(city))
                        .filter(a -> a.getHotelName().equals(hotelName))
                        .collect(Collectors.toList());

                for (Hotel hotel : found1) {
                    List<Room> rooms = hotel.getRooms();
                    for (int i = 0; i < rooms.size(); i++) {
                        if (rooms.get(i).getPrice() != price && rooms.get(i).getPersons() != persons) {
                            rooms.remove(i);
                            i--;
                        }
                    }
                }
                found = found1;

                break;
            case 2:
                List<Hotel> found2 = hotels.stream()
                        .filter(a -> a.getCity().equals(city))
                        .filter(a -> a.getHotelName().equals(hotelName))
                        .collect(Collectors.toList());
                for (Hotel hotel : found2) {
                    List<Room> rooms = hotel.getRooms();
                    for (int i = 0; i < rooms.size(); i++) {
                        if (rooms.get(i).getPersons() != persons) {
                            rooms.remove(i);
                            i--;
                        }

                    }
                }
                found = found2;
                break;

            case 3:
                List<Hotel> found3 = hotels.stream()
                        .filter(a -> a.getCity().equals(city))
                        .filter(a -> a.getHotelName().equals(hotelName))
                        .collect(Collectors.toList());
                for (Hotel hotel : found3) {
                    List<Room> rooms = hotel.getRooms();
                    for (int i = 0; i < rooms.size(); i++) {
                        if (rooms.get(i).getPrice() != price) {
                            rooms.remove(i);
                            i--;
                        }
                    }
                }
                found = found3;
                break;
            case 4:
                found = hotels.stream()
                        .filter(a -> a.getCity().equals(city))
                        .filter(a -> a.getHotelName().equals(hotelName))
                        .collect(Collectors.toList());
                break;
        }

        if (found.get(0).getRooms().size() == 0) System.out.println("Not found. Try to change your parameters");

        return found;
    }

    // пока не знаю что с этим делать
    public User registerUser(User user) {
        return null;
    }

    public Controller(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}

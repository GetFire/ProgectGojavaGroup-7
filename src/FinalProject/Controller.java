package FinalProject;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static FinalProject.Hotel.*;

/*
Объект данного класса иммитирует работу юзера, путем генерации запросов
*/

public class Controller implements UserInterface {
    private List<Hotel> hotels = new ArrayList<>();
    //@добавлю DAO на будущее, потом в методах нужно использовать дао вместо поля hotels
    private DAOImpl hotelsDao = new DAOImpl();

    // Находим нужные отели, по имени
    public Collection<Hotel> findHotelByName(String name) {
        return hotels.stream().filter(a -> a.getHotelName().equals(name)).collect(Collectors.toList());

    }

    // Находим нужные отели, по городу
    public Collection<Hotel> findHotelByCity(String city) {
        return hotels.stream().filter(a -> a.getCity().equals(city)).collect(Collectors.toList());

    }

    //бронируем номер, пока не знаю что делать с userID
    public void bookRoom(UUID roomID, UUID userID, UUID hotelID) {
        List<Hotel> foundedHotels = hotels.stream().filter(a -> a.getId().equals(hotelID)).collect(Collectors.toList());
        Hotel hotel = foundedHotels.get(0);
        List<Room> rooms = hotel.getRooms().stream().filter(a -> a.getId().equals(roomID)).collect(Collectors.toList());
        Room foundedRoom = rooms.get(0);
        foundedRoom.setAvaible(false);
    }


    // снимаем бронь, пока не знаю что делать с userID
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

        // Тут предлагаю создать свою ошибку, InvalidForm, в том случае когда поля city и hotelName - пустые


        String city = params.get(CITY);
        String hotelName = params.get(HOTEL_NAME);
        int price;
        int persons;
        try {
            price = Integer.parseInt(params.get(PRICE));
        }catch (Exception e){
            price = 0;
        }
        try{
            persons = Integer.parseInt(params.get(PERSONS));
        }catch (Exception ex){
            persons=0;
        }



// Если все параметры не равны 0 или null
            List<Hotel> found1 = hotels.stream()
                    .filter(a -> a.getCity().equals(city))
                    .filter(a -> a.getHotelName().equals(hotelName))
                    .collect(Collectors.toList());
            for (Hotel hotel : found1) {
                List<Room> rooms = hotel.getRooms();
                for (Room room : rooms) {
                    if (room.getPrice() != price && room.getPersons() != persons) {
                        rooms.remove(room);
                    }
                }
            }
            found = found1;
            return found;
        }


    public User registerUser(User user) {
        return null;
    }

    public Controller(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}

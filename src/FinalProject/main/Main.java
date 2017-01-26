package FinalProject.main;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */

import java.time.LocalDate;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        // create User, Controller
        Controller controller = new Controller();
        System.out.println("Введите никнейм: ");
        String nickName = ProjectUTILS.readOnlyFillLine();
        System.out.println("Введите имя: ");
        String name = ProjectUTILS.readOnlyFillLine();
        System.out.println("Введите фамилию: ");
        String secondName = ProjectUTILS.readOnlyFillLine();

        User userMan = controller.registerUser(new User(nickName, name, secondName));

        //find hotel by city
        List<Hotel> sdf = (ArrayList<Hotel>) controller.findHotelByCity("Львов");
        System.out.println(sdf);

        // find hotel by name
        sdf = (ArrayList<Hotel>) controller.findHotelByName("FOUR POINTS BY SHERATON");
        System.out.println(sdf);


        // создаем параметры для поиска комнаты
        Map<String, String> params = ProjectUTILS.createUsersRequest();


        List<Room> testFound = (ArrayList<Room>) controller.findRoom(params);
        testFound.forEach(System.out::println);


        /** все что сверху - протестировано и работает. Дальше не могу тестировать, потомучто не написаны методы для DAO. UPD by GetFire*/

        /*List<Hotel> hotels= new ArrayList<>();
        Hotel hotel = new Hotel("Name", "City");
        hotels.add(hotel);
        List<Room> rooms = new ArrayList<>();

        Room room = new Room(5, "Name", 500);
        rooms.add(room);
        hotel.setRooms(rooms);

        HotelDAO hotelDAO = new HotelDAO(hotels);

        System.out.println(hotelDAO.getHotels().toString());

        List<Room> rooms1 = new ArrayList<>();

        Room room1 = new Room(6, "Name", 400);
        rooms1.add(room1);
        hotel.setRooms(rooms1);

        hotelDAO.update(hotel);
        List<Hotel> hotels2 = hotelDAO.getHotels();
        hotel = hotels2.get(0);
        System.out.println(hotel.getRooms().toString());*/


    }
}

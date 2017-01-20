package FinalProject;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //создаем данные
        List<Hotel> hotels = ProjectUTILS.createHotels(10);
        ProjectUTILS.createDefaultRooms(hotels);


        // создаем контроллер
        Controller controller = new Controller(hotels);

        List<Hotel> sdf = (ArrayList<Hotel>) controller.findHotelByCity("Львов");
        System.out.println(sdf);


        // создаем параметры для поиска комнаты
        Map<String, String> params = ProjectUTILS.createUsersRequest();



        List<Room> testFound = (ArrayList<Room>) controller.findRoom(params);
        testFound.forEach(System.out::println);

    }
}

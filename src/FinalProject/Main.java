package FinalProject;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */

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

        User userMan = controller.registerUser(new User(nickName,name,secondName));


//        //create data
//        List<Hotel> hotels = ProjectUTILS.createHotels(10);
//        ProjectUTILS.createDefaultRooms(hotels);
//
//
//        // create controller
//        Controller controller = new Controller(hotels);
//
//        //find hotel by city
////        System.out.print("Введите название города: ");
////        String city = ProjectUTILS.readOnlyFillLine();
//        List<Hotel> sdf = (ArrayList<Hotel>) controller.findHotelByCity("Львов");
//        System.out.println(sdf);
//
//
//        // создаем параметры для поиска комнаты
//        Map<String, String> params = ProjectUTILS.createUsersRequest();
//
//
//        List<Room> testFound = (ArrayList<Room>) controller.findRoom(params);
//        testFound.forEach(System.out::println);

    }
}

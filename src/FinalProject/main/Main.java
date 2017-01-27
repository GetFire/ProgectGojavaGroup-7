package FinalProject.main;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */

import java.time.LocalDate;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        // create User, Controller, hotels
        Controller controller = new Controller();
        List<Hotel> list = Controller.getHotelService();
        System.out.println("Доступные города: ");
        list.forEach(a -> System.out.print(a.getCity() + ", "));
        System.out.println();

        User userMan = ProjectUTILS.userCreater();


//
        //find hotel by city
        System.out.println("Для поиска по городу введите название города: ");
        String d = ProjectUTILS.readOnlyFillLine();
        List<Hotel> sdf = (ArrayList<Hotel>) controller.findHotelByCity(d);
        System.out.println(sdf);


        // find hotel by name
        System.out.println("Введи нзвание отеля ");
        String s = ProjectUTILS.readOnlyFillLine();
        sdf = (ArrayList<Hotel>) controller.findHotelByName(s);
        System.out.println(sdf);


        // create data for search room

        Map<String, String> params = ProjectUTILS.createUsersRequest();


        List<Room> testFound = (ArrayList<Room>) controller.findRoom(params);
        testFound.forEach(System.out::println);


        /** все что сверху - протестировано и работает. Дальше не могу тестировать, потомучто не написаны методы для DAO. UPD by GetFire*/


    }
}


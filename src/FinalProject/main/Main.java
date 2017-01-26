package FinalProject.main;

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


    }
}

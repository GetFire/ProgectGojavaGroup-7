package FinalProject;

/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */

import java.util.*;
import static FinalProject.Hotel.*;

public class Main {
    public static void main(String[] args) {

        //создаем данные
        Hotel plaza = new Hotel("Plaza", "Kyiv");
        Hotel turist = new Hotel("Turist", "Kyiv");

        System.out.println(1);

        Hotel lviv = new Hotel("Lvivska", "Lviv");
        Hotel cava = new Hotel("Kava", "Lviv");

        Hotel kh = new Hotel("Kharkivska", "Kharkiv");
        Hotel praga = new Hotel("Praga", "Kharkiv");

        plaza.createDefaultRooms();
        turist.createDefaultRooms();
        lviv.createDefaultRooms();
        cava.createDefaultRooms();
        kh.createDefaultRooms();
        praga.createDefaultRooms();

        System.out.println(2);

        List<Hotel> hotels = new ArrayList<>();
        Collections.addAll(hotels, plaza, turist, lviv, cava, kh, praga);

        System.out.println(3);

        // создаем контроллер
        Controller controller = new Controller(hotels);

        List<Hotel> sdf = (ArrayList<Hotel>) controller.findHotelByCity("Lviv");
        System.out.println(sdf);

        System.out.println(4);

        // создаем параметры для поиска комнаты
        Map<String, String> params = new HashMap<>();
        params.put(CITY, "Lviv");
        params.put(HOTEL_NAME, "Lvivska");
        params.put(PRICE, "");
        params.put(PERSONS, "2");

        System.out.println(5);

        try {
            List<Hotel> testFound = (ArrayList<Hotel>) controller.findRoom(params);
            System.out.println(testFound);
            System.out.println(6);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

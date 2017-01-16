package FinalProject;

import java.util.*;
import static FinalProject.Hotel.*;

public class Main {
    public static void main(String[] args) {

        //создаем данные
        Hotel plaza = new Hotel("Plaza","Kyiv");
        Hotel turist = new Hotel("Turist","Kyiv");

        Hotel lviv = new Hotel("Lvivska","Lviv");
        Hotel cava = new Hotel("Kava","Lviv");

        Hotel kh = new Hotel("Kharkivska", "Kharkiv");
        Hotel praga = new Hotel("Praga", "Kharkiv");

        plaza.createDefaultRooms();
        turist.createDefaultRooms();
        lviv.createDefaultRooms();
        cava.createDefaultRooms();
        kh.createDefaultRooms();
        praga.createDefaultRooms();

        List<Hotel> hotels = new ArrayList<>();
        Collections.addAll(hotels,plaza,turist,lviv,cava,kh,praga);

        // создаем контроллер
        Controller controller = new Controller(hotels);

        List<Hotel>sdf = (ArrayList<Hotel>)controller.findHotelByCity("Lviv");
        System.out.println(sdf);

        // создаем параметры для поиска комнаты
        Map<String,String> params= new HashMap<>();
        params.put(CITY,"Lviv");
        params.put(HOTEL_NAME,"Lvivska");
        params.put(PRICE,"0");
        params.put(PERSONS,"3");

        List<Hotel> testFound = (ArrayList<Hotel>)controller.findRoom(params);
        System.out.println(testFound);

    }
}

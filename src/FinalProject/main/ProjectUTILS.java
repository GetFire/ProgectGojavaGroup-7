package FinalProject.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

import static FinalProject.main.Hotel.*;


/**
 * Created by GetFire on 20.01.2017.
 * <p>
 * This class is going to help you simulated some of Users requests and create data entries
 */


public class ProjectUTILS {
    public static Map<String, String> createUsersRequest() {
        String city = "";
        String hotelName = "";
        String price = "";
        String persons = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите название города:");
            city = readOnlyFillLine();
            System.out.println("Введите название отеля:");
            hotelName = readOnlyFillLine();
            System.out.println("Введите желаемую цену:");
            price = br.readLine();
            System.out.println("Введите кол-во спальных мест:");
            persons = br.readLine();

        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }


        Map<String, String> params = new HashMap<>();
        params.put(CITY, city);
        params.put(HOTEL_NAME, hotelName);
        params.put(PRICE, price);
        params.put(PERSONS, persons);

        return params;
    }

    public static List<Hotel> createHotels(int howMany) {

        String[] citiesName = new String[]{"Винница", "Луцк", "Днепр", "Донецк", "Житомир", "Ужгород", "Запорожье", "Ивано-Франковск", "Киев",
                "Кропивницкий", "Луганск", "Львов", "Николаев", "Одесса", "Полтава", "Ровно", "Сумы", "Тернополь", "Харьков", "Херсон", "Хмельницкий",
                "Черкассы", "Чернигов", "Черновцы", "Севастополь", "Симферополь"};


        String[] hotelsNames = {"11 MIRRORS DESIGN HOTEL", "CRIMEA BREEZE RESIDENCE", "FAIRMONT GRAND HOTEL",
                "SENATOR APARTMENTS MAIDAN", "KHARKIV PALACE PREMIER HOTEL", "VILLA ELENA HOTEL & RESIDENCE", "MAR LE MAR CLUB", "INTERCONTINENTAL",
                "LEOPOLIS HOTEL", "HILTON KYIV", "HYATT REGENCY KYIV", "WELLNES SPA HOTEL MORE", "FOUR POINTS BY SHERATON", "ASTORIA HOTEL", "CONTINENTAL",
                "PREMIER PALACE HOTEL", "SWISS HOTEL", "NOBILIS HOTEL", "COSMOPOLITE HOTEL", "HOTEL BRISTOL", "HOTEL STARO", "HOLIDAY INN",
                "RADISSON BLU RESORT", "RADISSON BLU HOTEL"};

        List<Hotel> created = new ArrayList<>();

        howMany = hotelsNames.length;
        int rand1 = 0;
        int rand2 = 0;
        while (howMany > 0) {
            //int rand1 = (int) (Math.random() * hotelsNames.length);
            //int rand2 = (int) (Math.random() * citiesName.length);
            Hotel hotel = new Hotel(hotelsNames[rand1], citiesName[rand2]);
            /*if (created.contains(hotel)) {
                hotel = null;
                continue;
            }*/
            created.add(hotel);
            howMany--;
            rand1++;
            rand2++;
        }

        return created;
    }

    public static List<Hotel> createDefaultRooms(List<Hotel> hotels) {
        for (Hotel hotel : hotels) {
            List<Room> room = new ArrayList<>();
            String hotelName = hotel.getHotelName();
            Room rm1 = new Room(1, hotelName, 100);
            Room rm2 = new Room(2, hotelName, 200);
            Room rm3 = new Room(3, hotelName, 300);
            Room rm4 = new Room(4, hotelName, 400);
            Room rm5 = new Room(5, hotelName, 500);
            Room rm6 = new Room(1, hotelName, 100);
            Room rm7 = new Room(2, hotelName, 200);
            Room rm8 = new Room(3, hotelName, 300);
            Room rm9 = new Room(4, hotelName, 400);
            Room rm10 = new Room(5, hotelName, 500);
            Collections.addAll(room, rm1, rm2, rm3, rm4, rm5, rm6, rm7, rm8, rm9, rm10);
            hotel.setRooms(room);
        }
        return hotels;
    }

    public static String readOnlyFillLine() {
        int count = 3;
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (count > 0) {
            try {
                line = br.readLine();
                if (line.length() == 0 || Integer.valueOf(line) != null) {
                    count--;
                    System.err.println("This field must be filled in correctly. You have " + count + " attempts!");
                }
                if (count <= 0) {
                    throw new InvalidFormException("Sorry, invalid data!");
                }
            } catch (NumberFormatException ignored) {
                return line;
            } catch (IOException e) {
                System.out.println("Проблема гдето в утилите");
            }

        }
        return line;
    }

    public static User userCreater() {
        System.out.println("Введите логин: ");
        String nickName = readOnlyFillLine();
        System.out.println("Введите имя: ");
        String name = readOnlyFillLine();
        System.out.println("Введите фамилию: ");
        String secondName = readOnlyFillLine();
        return Controller.registerUser(new User(nickName, name, secondName));
    }


}
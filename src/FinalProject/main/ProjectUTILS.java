package FinalProject.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import static FinalProject.main.Hotel.*;
/**
 * Created by GetFire on 20.01.2017.
 * <p>
 * This class is going to help you simulated some of Users requests and create data entries
 */
public class ProjectUTILS {
    @SuppressWarnings("resource")
    static Scanner scan = new Scanner(System.in);
    public static Map<String, String> createUsersRequest() {
        String city = "";
        String hotelName = "";
        String price = "";
        String persons = "";
        Scanner br = scan;
        try{
//            System.out.println("Введите название города:");
            System.out.println("Please enter city's name: ");
            city = readOnlyFillLine();
//            System.out.println("Введите название отеля:");
            System.out.println("Please enter hotel's name: ");
            hotelName = readOnlyFillLine();
//            System.out.println("Введите желаемую цену:");
            System.out.println("Please enter desired price: ");
            price = ProjectUTILS.checkInt();
//            System.out.println("Введите кол-во спальных мест: ");
            System.out.println("Please enter the number of beds you need: ");
            persons = ProjectUTILS.checkInt();
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        Map<String, String> params = new HashMap<>();
        params.put(CITY, city);
        params.put(HOTEL_NAME, hotelName);
        params.put(PRICE, price);
        params.put(PERSONS, persons);
        return params;
    }
    public static List<Hotel> createHotels() {
        /*String[] citiesName = new String[]{"Винница", "Луцк", "Днепр", "Донецк", "Житомир", "Ужгород", "Запорожье", "Ивано-Франковск", "Киев",
                "Кропивницкий", "Луганск", "Львов", "Николаев", "Одесса", "Полтава", "Ровно", "Сумы", "Тернополь", "Харьков", "Херсон", "Хмельницкий",
                "Черкассы", "Чернигов", "Черновцы", "Севастополь", "Симферополь"};*/
        String[] citiesName = new String[]{"Vinnytsia", "Lutsk", "Dnipro", "Donetsk", "Zhytomyr", "Uzhhorod", "Zaporizhzhia", "Ivano-Frankivsk", "Kyiv",
                "Kropyvnytskyi", "Luhansk", "Lviv", "Mykolaiv", "Odesa", "Poltava", "Rivne", "Sumy", "Ternopil", "Kharkiv", "Kherson", "Khmelnytskyi",
                "Cherkasy", "Chernihiv", "Chernivtsi", "Sevastopol", "Simferopol"};
        String[] hotelsNames = {"11 MIRRORS DESIGN HOTEL", "CRIMEA BREEZE RESIDENCE", "FAIRMONT GRAND HOTEL",
                "SENATOR APARTMENTS MAIDAN", "KHARKIV PALACE PREMIER HOTEL", "VILLA ELENA HOTEL & RESIDENCE", "MAR LE MAR CLUB", "INTERCONTINENTAL",
                "LEOPOLIS HOTEL", "HILTON KYIV", "HYATT REGENCY KYIV", "WELLNES SPA HOTEL MORE", "FOUR POINTS BY SHERATON", "ASTORIA HOTEL", "CONTINENTAL",
                "PREMIER PALACE HOTEL", "SWISS HOTEL", "NOBILIS HOTEL", "COSMOPOLITE HOTEL", "HOTEL BRISTOL", "HOTEL STARO", "HOLIDAY INN",
                "RADISSON BLU RESORT", "RADISSON BLU HOTEL", "BEST WESTERN SEVASTOPOL HOTEL", "VICTORIA"};
        List<Hotel> created = new ArrayList<>();
        int howMany = hotelsNames.length;
        int rand1 = 0;
        while (howMany > 0) {
            Hotel hotel = new Hotel(hotelsNames[rand1], citiesName[rand1]);
            created.add(hotel);
            howMany--;
            rand1++;
        }
        return created;
    }
    public static List<Room> createDefaultRooms(String hotelName) {

            List<Room> room = new ArrayList<>();

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


        return room;
    }
    public static String readOnlyFillLine() {
        int count = 3;
        String line = "";
        @SuppressWarnings("resource")
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (count > 0) {
            try {
//                System.out.println(System.in.available());
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
//                System.out.println("Проблема гдето в утилите");
                System.out.println("The problem is somewhere in utils");
            }
        }
        return line;
    }
    public static User userCreater() {
//        System.out.println("Введите логин: ");
        System.out.println("Please enter your nickname: ");
        String nickName = readOnlyFillLine();
        if (Controller.getUserService().contains(Controller.getUserByNickname(nickName))) {
            System.out.println("Welcome back! We were missing you!");
//            Controller.getUserService().
//            user.setLogin(true);
            return Controller.getUserByNickname(nickName);
        } else {
//        System.out.println("Введите имя: ");
            System.out.println("Please enter your name: ");
            String name = readOnlyFillLine();
//        System.out.println("Введите фамилию: ");
            System.out.println("Please enter your surname: ");
            String secondName = readOnlyFillLine();
            return Controller.registerUser(new User(nickName, name, secondName));
        }
    }

    public static String readString() {
        String line = "";
        @SuppressWarnings("resource")
        Scanner br = scan;
        try  {
            line = br.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " from ProjectUTILS.readString");
        }
        finally {
            return line;
        }

    }
    public static String checkInt()
    {
        String res;
        while (true)
        {
            int chackIntRes;
            try
            {
                res = readString();
                if (res.equals("q"))
                    System.exit(1);
                chackIntRes = Integer.valueOf(res);
                break;
            }
            catch (NumberFormatException e)
            {
//                System.out.println("Не верные данные. Повторите");
                System.out.println("Sorry, invalid data! Please try again");
            }
        }
        return res;
    }
    public static Date toDate(String date)
    {
        Date res;

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        try {
            res= format.parse(date);
        } catch (ParseException e) {
//            System.out.println("Не верная дата, будет установлена текущая");
            System.out.println("Sorry, you entered incorrect date. Current date will be set up");
            res = new Date();
        }
        return res;
    }
}
package FinalProject.test;

import FinalProject.Controller.Controller;
import FinalProject.Entity.Hotel;
import FinalProject.Entity.Order;
import FinalProject.Entity.Room;
import FinalProject.Entity.User;
import FinalProject.Model.DAOImpl;
import FinalProject.Model.Implementation.HotelDAO;
import FinalProject.Model.Implementation.UserDAO;
import FinalProject.Services.ProjectUTILS;
import org.junit.BeforeClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TestSetUp {
    public static List<Hotel> emptyResult;
    public static List<User> users;
    public static List<Hotel> hotelsList;
    public static List<Order> ordersList;
    public static List<Room> roomsList;
    public static List<User> usersList;

    public static Controller controller;
    public static HotelDAO hotelDAO;
    public static UserDAO userDAO;
    public static DAOImpl daoImpl;
    public static User user;
    public static Hotel hotel;
    public static Order order;
    public static Room room;

    public static Date bookingDate;
    public static Date bookingDate2;
    public static Date currentDate;
    public static LocalDate date;

    public static String nonExistingName;
    public static String nonExistingNickName;
    public static String emptyString;
    public static String invalidDate;
    public static String dateFormat1;
    public static String dateFormat2;
    public static String dateFormat3;
    public static String dateFormat4;

    public static UUID validHotelId;
    public static UUID validRoomId;
    public static UUID nonExistingId;
    public static UUID validUserId;

    @BeforeClass
    public static void beforeClass() {
        emptyResult = new ArrayList<>();
        users = new ArrayList<>();
        hotelsList = new ArrayList<>();
        ordersList = new ArrayList<>();
        roomsList = new ArrayList<>();
        usersList = new ArrayList<>();

        controller = new Controller();
        hotelDAO = new HotelDAO();
        userDAO = new UserDAO(users);
        daoImpl = new DAOImpl();
        hotel = new Hotel("ROYAL", "WARSAW");
        order = new Order(validUserId, validHotelId, validRoomId, bookingDate, 4);
        room = new Room(2, 150, date, "ROYAL");
        user = Controller.getUserService().getUserByNickname("oops");

        Date bookingDate = ProjectUTILS.toDate("02.02.2017");
        Date bookingDate2 = ProjectUTILS.toDate("02.05.2017");
        currentDate = new Date();
        date = LocalDate.of(2017, 2, 2);

        nonExistingName = "I'm non existing name!";
        nonExistingNickName = "I'm non existing nickname!";
        emptyString = "";
        invalidDate = "Invalid Date";
        dateFormat1 = "20170202";
        dateFormat2 = "02-02-2017";
        dateFormat3 = "02-Feb-2017";
        dateFormat4 = "02 Feb 2017";

        validHotelId = UUID.fromString("c0fb0a9b-4fe9-4770-96d4-98260f2187ea");
        validRoomId = UUID.fromString("18ad1e54-1f66-4016-a158-b475913ad757");
        nonExistingId = UUID.fromString("00000000-0000-0000-0000-000000000000");
        validUserId = UUID.fromString("2698016f-38c9-453b-9bc6-4f662100d792");
    }
}

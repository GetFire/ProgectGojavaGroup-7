package FinalProject.test;

import FinalProject.Controller.Controller;
import FinalProject.Entity.Hotel;
import FinalProject.Entity.User;
import FinalProject.Services.InvalidFormException;
import FinalProject.Services.ProjectUTILS;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class ControllerTest {
    private static Controller controller;
    private static User user;
    private static User nullUser;
    private static String nonExistingName = "Not Exists";
    private static String emptyString = "";
    private static List<Hotel> emptyResult;
    private static UUID validHotelId = UUID.fromString("c0fb0a9b-4fe9-4770-96d4-98260f2187ea");
    private static UUID validRoomId = UUID.fromString("18ad1e54-1f66-4016-a158-b475913ad757");
    private static UUID nonExistingId = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private static Date bookingDate = ProjectUTILS.toDate("02.02.2017");
    private static Date bookingDate2 = ProjectUTILS.toDate("02.05.2017");

    @BeforeClass
    public static void setUpClass() throws Exception {
        controller = new Controller();
        emptyResult = new ArrayList<>();
        user = Controller.getUserByNickname("oops");
        nullUser = new User(null, null, null);
    }

    @Test
    public void findHotelByName_hotelDoesNotExist() throws Exception {
        assertEquals(emptyResult, controller.findHotelByName(nonExistingName));
    }

    @Test
    public void findHotelByCity_cityDoesNotExist() throws Exception {
        assertEquals(emptyResult, controller.findHotelByCity(nonExistingName));
    }

    @Test
    public void findHotelByCity_withNull() throws Exception {
        assertEquals(emptyResult, controller.findHotelByCity(emptyString));
    }

    @Test(expected = InvalidFormException.class)
    public void bookRoom_whenRoomIsNotFree() throws Exception {
        controller.bookRoom(validRoomId, user, validHotelId, bookingDate, 4);
        controller.bookRoom(validRoomId, user, validHotelId, bookingDate, 4);
    }

    @Test(expected = InvalidFormException.class)
    public void bookRoom_whenRoomIsNotFreeWithInvalidIds() throws Exception {
        controller.bookRoom(validRoomId, user, validHotelId, bookingDate2, 4);
        controller.bookRoom(nonExistingId, user, nonExistingId, bookingDate2, 4);
    }

    @Test(expected = InvalidFormException.class)
    public void bookRoom_whenRoomIsFreeWithInvalidIds() throws Exception {
        controller.cancelReservation(validRoomId, user, validHotelId);
        controller.bookRoom(nonExistingId, user, nonExistingId, bookingDate2, 4);
    }

    @Test(expected = InvalidFormException.class)
    public void cancelReservation_withNotValidRoomId() throws Exception {
        controller.bookRoom(validRoomId, user, validHotelId, bookingDate2, 4);
        controller.cancelReservation(nonExistingId, user, validHotelId);
        controller.cancelReservation(validRoomId, user, validHotelId);
    }

    @Test(expected = InvalidFormException.class)
    public void cancelReservation_withNotValidHotelId() throws Exception {
        controller.bookRoom(validRoomId, user, validHotelId, bookingDate2, 4);
        controller.cancelReservation(validRoomId, user, nonExistingId);
    }

    @Test
    public void getUserByNickname_withNull() throws Exception {
        assertNull(Controller.getUserByNickname(emptyString));
    }

    @Test
    public void getUserByNickname_withNonExistingNickname() throws Exception {
        assertNull(Controller.getUserByNickname(nonExistingName));
    }
}
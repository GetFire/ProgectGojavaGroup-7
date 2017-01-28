package FinalProject.test;

import FinalProject.main.Controller;
import FinalProject.main.Hotel;
import FinalProject.main.ProjectUTILS;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ControllerTest {
    private static Controller controller;
    private static String nonExistingName = "Not Exists";
    private static String nonExistingId = "00000000000";
    private static List<Hotel> emptyResult = new ArrayList<>();

    @BeforeClass
    public static void setUpClass() throws Exception {
        List<Hotel> hotels = ProjectUTILS.createHotels();
        ProjectUTILS.createDefaultRooms(hotels);
        controller = new Controller(hotels);
    }

    @Test
    public void findHotelByName_hotelDoesNotExist() throws Exception {
        assertEquals(emptyResult, controller.findHotelByName(nonExistingName));
    }

    @Test
    public void findHotelByCity_cityDoesNotExist() throws Exception {
        assertEquals(emptyResult, controller.findHotelByCity(nonExistingName));
    }

    @Ignore
    @Test
    public void bookRoom() throws Exception {
        System.out.println("I'm not ready");
        System.out.println("Case1: invalid roomID");
        System.out.println("Case2: invalid userID");
        System.out.println("Case3: invalid hotelID");
        System.out.println("Case4: invalid startDate");
        System.out.println("Case5: invalid days");
    }

    @Ignore
    @Test
    public void cancelReservation() throws Exception {
        System.out.println("I'm not ready");
        System.out.println("Case1: invalid roomID");
        System.out.println("Case2: invalid userID");
        System.out.println("Case3: invalid hotelID");
    }

    @Ignore
    @Test
    public void findRoom() throws Exception {

    }

    @Ignore
    @Test
    public void registerUser() throws Exception {

    }

}
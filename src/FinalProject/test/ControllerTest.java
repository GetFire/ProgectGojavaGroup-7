package FinalProject.test;

import FinalProject.Controller.Controller;
import FinalProject.Entity.Hotel;
import FinalProject.Entity.User;
import FinalProject.Services.ProjectUTILS;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class ControllerTest extends TestSetUp{

    @Test()
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

    @Test(expected = NullPointerException.class)
    public void bookRoom_whenRoomIsNotFree() throws Exception {
        controller.bookRoom(validRoomId, user, validHotelId, bookingDate, 4);
        controller.bookRoom(validRoomId, user, validHotelId, bookingDate, 4);
    }

    @Test(expected = NullPointerException.class)
    public void bookRoom_whenRoomIsNotFreeWithInvalidIds() throws Exception {
        controller.bookRoom(validRoomId, user, validHotelId, bookingDate2, 4);
        controller.bookRoom(nonExistingId, user, nonExistingId, bookingDate2, 4);
    }

    @Test(expected = NullPointerException.class)
    public void bookRoom_whenRoomIsFreeWithInvalidIds() throws Exception {
        controller.cancelReservation(validRoomId, user, validHotelId);
        controller.bookRoom(nonExistingId, user, nonExistingId, bookingDate2, 4);
    }

    @Test(expected = NullPointerException.class)
    public void cancelReservation_withNotValidRoomId() throws Exception {
        controller.bookRoom(validRoomId, user, validHotelId, bookingDate2, 4);
        controller.cancelReservation(nonExistingId, user, validHotelId);
        controller.cancelReservation(validRoomId, user, validHotelId);
    }

    @Test(expected = NullPointerException.class)
    public void cancelReservation_withNotValidHotelId() throws Exception {
        controller.bookRoom(validRoomId, user, validHotelId, bookingDate2, 4);
        controller.cancelReservation(validRoomId, user, nonExistingId);
    }

    @Test
    public void getUserByNickname_withNull() throws Exception {
        assertNull(Controller.getUserService().getUserByNickname(emptyString));
    }

    @Test
    public void getUserByNickname_withNonExistingNickname() throws Exception {
        assertNull(Controller.getUserService().getUserByNickname(nonExistingName));
    }
}
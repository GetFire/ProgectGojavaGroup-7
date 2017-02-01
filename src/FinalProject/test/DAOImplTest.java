package FinalProject.test;

import FinalProject.Services.ProjectUTILS;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class DAOImplTest extends TestSetUp{

    @Test
    public void save_hotel() throws Exception {
        daoImpl.setDataBaseList(hotelsList);
        daoImpl.save(hotel);
        assertEquals(daoImpl.getDataBaseList().contains(hotel), true);
        daoImpl.remove(hotel);
    }

    @Test
    public void save_order() throws Exception {
        daoImpl.setDataBaseList(ordersList);
        daoImpl.save(order);
        assertEquals(daoImpl.getDataBaseList().contains(order), true);
        daoImpl.remove(order);
    }

    @Test
    public void save_room() throws Exception {
        daoImpl.setDataBaseList(roomsList);
        daoImpl.save(room);
        assertEquals(daoImpl.getDataBaseList().contains(room), true);
        daoImpl.remove(room);
    }

    @Test
    public void save_user() throws Exception {
        daoImpl.setDataBaseList(usersList);
        daoImpl.save(user);
        assertEquals(daoImpl.getDataBaseList().contains(user), true);
        daoImpl.remove(user);
    }

    @Test
    public void remove_hotel() throws Exception {
        daoImpl.setDataBaseList(hotelsList);
        daoImpl.save(hotel);
        daoImpl.remove(hotel);
        assertEquals(daoImpl.getDataBaseList().contains(hotel), false);
    }

    @Test
    public void remove_order() throws Exception {
        daoImpl.setDataBaseList(ordersList);
        daoImpl.save(order);
        daoImpl.remove(order);
        assertEquals(daoImpl.getDataBaseList().contains(order), false);
    }

    @Test
    public void remove_room() throws Exception {
        daoImpl.setDataBaseList(roomsList);
        daoImpl.save(room);
        daoImpl.remove(room);
        assertEquals(daoImpl.getDataBaseList().contains(room), false);
    }

    @Test
    public void remove_user() throws Exception {
        daoImpl.setDataBaseList(usersList);
        daoImpl.save(user);
        daoImpl.remove(user);
        assertEquals(daoImpl.getDataBaseList().contains(user), false);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void update_notExistingHotel() throws Exception {
        daoImpl.setDataBaseList(hotelsList);
        daoImpl.update(hotel);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void update_notExistingOrder() throws Exception {
        daoImpl.setDataBaseList(ordersList);
        daoImpl.update(order);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void update_notExistingRoom() throws Exception {
        daoImpl.setDataBaseList(roomsList);
        daoImpl.update(room);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void update_notExistingUser() throws Exception {
        daoImpl.setDataBaseList(usersList);
        daoImpl.update(user);
    }
}
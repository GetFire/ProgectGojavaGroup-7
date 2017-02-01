package FinalProject.test;

import org.junit.Test;
import java.util.NoSuchElementException;

public class HotelDAOTest extends TestSetUp{

    @Test(expected = NoSuchElementException.class)
    public void getNameByID_withNonExistingId() throws Exception {
        hotelDAO.getNameByID(nonExistingId);
    }

    @Test(expected = NoSuchElementException.class)
    public void getNameByID_withNull() throws Exception {
        hotelDAO.getNameByID(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void getCityByID_withNonExistingId() throws Exception {
        hotelDAO.getCityByID(nonExistingId);
    }

    @Test(expected = NoSuchElementException.class)
    public void getCityByID_withNull() throws Exception {
        hotelDAO.getCityByID(null);
    }
}
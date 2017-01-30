package FinalProject.test;

import FinalProject.Entity.Hotel;
import FinalProject.Services.ProjectUTILS;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProjectUTILSTest {
    private static List<Hotel> emptyList = new ArrayList<>();

    @Ignore
    @Test
    public void createUsersRequest() throws Exception {
        System.out.println("It's too complicated to test Buffered reader. Will google it and we'll see");
    }

    @Test
    public void createHotels_withNegativeNumber() throws Exception {
        assertEquals(emptyList, ProjectUTILS.createHotels());
    }

    /*@Test
    public void createDefaultRooms_noHotelsCreated() throws Exception {
        assertEquals(emptyList, ProjectUTILS.createDefaultRooms(emptyList));
    }*/

    @Ignore
    @Test
    public void readOnlyFillLine() throws Exception {
        System.out.println("Do we really need this method?");
    }

}
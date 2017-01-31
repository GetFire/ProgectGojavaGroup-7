package FinalProject.test;

import FinalProject.Entity.Hotel;
import FinalProject.Services.ProjectUTILS;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ProjectUTILSTest {
    private static List<Hotel> emptyList = new ArrayList<>();
    private static String emptyString = "";
    private static String invalidDate = "Invalid Date";
    private static String dateFormat1 = "20170202";
    private static String dateFormat2 = "02-02-2017";
    private static String dateFormat3 = "02-Feb-2017";
    private static String dateFormat4 = "02 Feb 2017";

    private static Date currentDate = new Date();

    @Test
    public void toDate_withNull() throws Exception {
        assertEquals(ProjectUTILS.toDate(emptyString).compareTo(currentDate), 1);
    }

    @Test
    public void toDate_withInvalidDate() throws Exception {
        assertEquals(ProjectUTILS.toDate(invalidDate).compareTo(currentDate), 1);
    }

    @Test
    public void toDate_withDateFomat1() throws Exception {
        assertEquals(ProjectUTILS.toDate(dateFormat1).compareTo(currentDate), 1);
    }

    @Test
    public void toDate_withDateFomat2() throws Exception {
        assertEquals(ProjectUTILS.toDate(dateFormat2).compareTo(currentDate), 1);
    }

    @Test
    public void toDate_withDateFomat3() throws Exception {
        assertEquals(ProjectUTILS.toDate(dateFormat3).compareTo(currentDate), 1);
    }

    @Test
    public void toDate_withDateFomat4() throws Exception {
        assertEquals(ProjectUTILS.toDate(dateFormat4).compareTo(currentDate), 1);
    }
}
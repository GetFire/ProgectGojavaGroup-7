package FinalProject.test;

import FinalProject.Services.ProjectUTILS;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class ProjectUTILSTest extends TestSetUp{

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
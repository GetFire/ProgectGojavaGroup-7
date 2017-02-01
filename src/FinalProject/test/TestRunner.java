package FinalProject.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        ControllerTest.class,
        DAOImplTest.class,
        HotelDAOTest.class,
        ProjectUTILSTest.class,
        UserDAOTest.class
})
public class TestRunner {
}

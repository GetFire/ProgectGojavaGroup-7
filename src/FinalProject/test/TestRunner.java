package FinalProject.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        ControllerTest.class,
        DAOImplTest.class,
        OrderDAOTest.class,
        ProjectUTILSTest.class,
        RoomDAOTest.class,
        UserDAOTest.class
})
public class TestRunner {
}

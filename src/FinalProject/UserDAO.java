package FinalProject;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by Alex on 24.01.2017.
 */
public class UserDAO  {
    private Connection myConn;

    public UserDAO() throws  Exception{
        Properties prop = new Properties();
        prop.load(newFileInputStream("info.user"));
        String name = prop.getProperty("name");


        myConn = DriverManager.getConnection("name");
            }

    private InputStream newFileInputStream(String s) {
        return null;
    }



}

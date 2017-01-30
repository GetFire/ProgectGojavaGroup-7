package FinalProject.test;

import FinalProject.Entity.User;
import FinalProject.Model.Implementation.UserDAO;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDAOTest {
    private static List<User> users = new ArrayList<>();
    private static UserDAO userDAO = new UserDAO(users);

    @Test
    public void save_checkIfUserIsSaved() throws Exception {
        User testUser = new User("Nickname", "Name", "Surname");
        userDAO.save(testUser);
        assertEquals(users.contains(testUser), true);
    }

    @Test
    public void save_UserWithNullNickname() throws Exception {
        User testUser = new User(null, "Name", "Surname");
        userDAO.save(testUser);
        assertEquals(users.contains(testUser), true);
    }

    @Test
    public void save_UserWithNullName() throws Exception {
        User testUser = new User("Nickname", null, "Surname");
        userDAO.save(testUser);
        assertEquals(users.contains(testUser), true);
    }

    @Test
    public void save_UserWithNullSurname() throws Exception {
        User testUser = new User("Nickname", "Name", null);
        userDAO.save(testUser);
        assertEquals(users.contains(testUser), true);
    }

    @Test
    public void save_UserWithNullNicknameAndName() throws Exception {
        User testUser = new User(null, null, "Surname");
        userDAO.save(testUser);
        assertEquals(users.contains(testUser), true);
    }

    @Test
    public void save_UserWithNullNicknameAndSurname() throws Exception {
        User testUser = new User(null, "Name", null);
        userDAO.save(testUser);
        assertEquals(users.contains(testUser), true);
    }

    @Test
    public void save_UserWithNullNameAndSurname() throws Exception {
        User testUser = new User("Nickname", null, null);
        userDAO.save(testUser);
        assertEquals(users.contains(testUser), true);
    }

    @Test
    public void save_checkIfNullUserIsSaved() throws Exception {
        User testUser = new User(null, null, null);
        userDAO.save(testUser);
        assertEquals(users.contains(testUser), true);
    }

    @Test
    public void remove_checkThatUserWasRemoved() throws Exception {
        User user = new User("test", "Bruce", "Willis");
        users.add(user);
//        int sizeBefore = users.size();
        userDAO.remove(user);
        assertFalse(userDAO.getUsers().contains(user));
    }

    @Test
    public void remove_checkSize() throws Exception {
        User user = new User("test", "Bruce", "Willis");
        users.add(user);
        int sizeBefore = users.size();
        userDAO.remove(user);
        assertEquals(userDAO.getUsers().size(), sizeBefore - 1);
    }

    @Ignore
    @Test
    public void update() throws Exception {
        System.out.println("UserDAO.update() method is not implemented yet");
    }

}
package FinalProject.main;


import java.util.List;


/**
 * Created by tvv89 on 24.01.2017 for ProgectGojavaGroup-7.
 */
public class UserDAO extends DAOImpl<User> {


    public UserDAO(List<User> aUsers) {
        this.setDataBaseList(aUsers);

    }

    public UserDAO() {
        super();
    }

    public void writeUserDao(List<User> user) {
        super.setDataBaseList(user);
    }

    public List<User> getUsers() {
        return this.getDataBaseList();
    }
}


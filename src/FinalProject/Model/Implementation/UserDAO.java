package FinalProject.Model.Implementation;


import FinalProject.Model.DAOImpl;
import FinalProject.Entity.User;
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

    public User getUserByNickname(String nickname) {
        if (this.getDataBaseList() ==null) return null;
        for (User u : this.getDataBaseList()) {
            try
            {
                if (u.getNickname().equalsIgnoreCase(nickname)) {
                    u.setLogin(true);
                    return u;
                }
            }
            catch(NullPointerException e) {return null;}
        }
        return null;
    }

    public List<User> getUsers() {
        return this.getDataBaseList();
    }
}


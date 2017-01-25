package FinalProject;

import java.util.Set;

/**
 * Created by tvv89 on 24.01.2017 for ProgectGojavaGroup-7.
 */
public class UserDAO implements DAO<User> {
    private Set<User> users;

    public UserDAO(Set<User> users) {
        this.users = users;
    }

    @Override
    public User save(User aUser) {
        users.add(aUser);
        return aUser;
    }

    @Override
    public User remove(User aUser) {
        users.remove(aUser);
        return aUser;
    }

    @Override
    public User update(User aUser) { /** может в этом методе нужно сначала проверять есть ли юзер в базе, если есть вытаскивать его, менять данные
     и сохранять уже обновленного юзера в базу и вернуть его. Если его нет, возвращать sout(" Sorry, user not found") retutn aUser */
        return aUser;
    }
}

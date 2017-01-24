package FinalProject;

import java.util.Set;

/**
 * Created by tvv89 on 24.01.2017 for ProgectGojavaGroup-7.
 */
public class usersDAO implements DAO<User> {
    private Set<User> users;

    public usersDAO(Set<User> users) {
        this.users = users;
    }

    @Override
    public User save(User object) {
        users.add(object);
        return object;
    }

    @Override
    public User remove(User object) {
        users.remove(object);
        return object;
    }

    @Override
    public User update(User object) {
        return object;
    }
}

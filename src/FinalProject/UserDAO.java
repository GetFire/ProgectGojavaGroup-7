package FinalProject;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tvv89 on 24.01.2017 for ProgectGojavaGroup-7.
 */
public class UserDAO extends DAOImpl<User> {
    private Set<User> users;
    private static final String FILE_DIRECTION = "D:\\practice\\ProgectGojavaGroup-7\\src\\EscortFiles\\Users.txt";

    public UserDAO(Set<User> aUsers) {
        this.users = downloadUserDAO();
        aUsers.removeAll(this.users);
        this.users.addAll(aUsers);
        writeUserDao(this.users);
    }

    public UserDAO() {
        this.users = downloadUserDAO();
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
    public User update(User aUser) { /** может в этом методе нужно сначала проверять есть ли юзер в базе, если есть вытаскивать его,
     менять данные
     и сохранять уже обновленного юзера в базу и вернуть его. Если его нет, возвращать sout(" Sorry, user not found") retutn aUser */
        return aUser;
    }

    private Set<User> downloadUserDAO() {
        Set<User> users = new HashSet<>();
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(FILE_DIRECTION));
            while ((line = br.readLine()) != null) {
                String[] s = line.split("\\\\");
                users.add(new User(s[0], s[1], s[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successful downloaded!");
        return users;

    }

    public void writeUserDao(Set<User> user) {
        StringBuilder content = new StringBuilder();
        for (User user1 : user) {
            content.append(user1.getNickname()).append("\\").append(user1.getName()).append("\\").append(user1.getSecondName()).append("\n");
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_DIRECTION)));
            bw.write(content.toString());
            System.out.println("Successful recorded!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public Set<User> getUsers() {
        return users;
    }
}


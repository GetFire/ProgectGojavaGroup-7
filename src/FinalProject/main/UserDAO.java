package FinalProject.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by tvv89 on 24.01.2017 for ProgectGojavaGroup-7.
 */
public class UserDAO extends DAOImpl<User> {
   // private List<User> users;
    private static final String FILE_DIRECTION = "src/EscortFiles/Users.txt";

    public UserDAO(List<User> aUsers) {
        this.setDataBaseList(downloadUserDAO());
        aUsers.removeAll(this.getDataBaseList());
        this.getDataBaseList().addAll(aUsers);
        writeUserDao(this.getDataBaseList());
    }

    public UserDAO() {
        this.setDataBaseList(downloadUserDAO());
    }

/*    @Override
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
//        return aUser;
//    }

    private List<User> downloadUserDAO() {
        List<User> users = new ArrayList<>();
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
//        System.out.println("Successfully downloaded!");
        return users;

    }

    public void writeUserDao(List<User> user) {
        StringBuilder content = new StringBuilder();
        for (User user1 : user) {
            content.append(user1.getNickname()).append("\\").append(user1.getName()).append("\\").append(user1.getSurname()).append("\n");
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_DIRECTION)));
            bw.write(content.toString());
            System.out.println("Successfully recorded!");
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

    public List<User> getUsers() {
        return this.getDataBaseList();
    }
}


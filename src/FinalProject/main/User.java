package FinalProject.main;
/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */


import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable{

    private String nickname;
    private final String name;
    private final String surname;
    private UUID id;
    private boolean login = false;

    public User(String nickname, String name, String surname) {
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "{Nickname: " + nickname + " Name: " + name
                + " surname: " + surname + "}";
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return nickname != null ? nickname.equals(user.nickname) : user.nickname == null;
    }

    @Override
    public int hashCode() {
        return nickname != null ? nickname.hashCode() : 0;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public UUID getId() {
        return id;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
    public boolean getLogin() {
        return login;
    }
}

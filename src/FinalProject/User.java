package FinalProject;
/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */


import java.util.UUID;

public class User {

    private String nickname;
    private final String name;
    private final String secondName;
    private UUID id;

    public User(String nickname, String name, String secondName) {
        this.nickname = nickname;
        this.name = name;
        this.secondName = secondName;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "{Nickname: " + nickname + " Name: " + name
                + " secondName: " + secondName + "}";
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

    public String getSecondName() {
        return secondName;
    }

    public UUID getId() {
        return id;
    }
}

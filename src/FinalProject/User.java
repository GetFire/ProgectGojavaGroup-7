package FinalProject;
/**
 * Created by GetFire on 15.01.2017 for ProgectGojavaGroup-7.
 */


import java.util.UUID;

public class User {

    private final String name;
    private final String secondName;
    private UUID id;

    public User(String name, String secondName) {
        this.name = name;
        this.secondName = secondName;
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "{Name: " + name
                + " segondName: " + secondName + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name != null ? name.equals(user.name) : user.name == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
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

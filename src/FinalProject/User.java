package FinalProject;


import java.util.UUID;

public class User {

    private  final String name;
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

        return id != null ? id.equals(user.id) : user.id == null;

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

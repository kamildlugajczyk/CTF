package pl.kamildlugajczyk.ctf.user;

import pl.kamildlugajczyk.ctf.history.History;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class User {

    @Id
    private int id;
    private String name;
    private String password;
    private String role;
    private int points;
    private int ranking;

    @OneToMany(mappedBy = "user")
    Set<History> history;

    public User() {
    }

    public User(int id, String name, String password, String role, int points, int ranking) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.points = points;
        this.ranking = ranking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}


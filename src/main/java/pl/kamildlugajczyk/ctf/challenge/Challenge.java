package pl.kamildlugajczyk.ctf.challenge;

import pl.kamildlugajczyk.ctf.history.History;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Challenge {

    @Id
    private int id;
    private String name;
    private String description;
    private int points;
    private double rating;
    private String difficulty;
    private String flag;

    @OneToMany(mappedBy = "challenge")
    Set<History> history;

    public Challenge() {
    }

    public Challenge(String name, int id, String description, int points, double rating, String difficulty, String flag) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.points = points;
        this.rating = rating;
        this.difficulty = difficulty;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}


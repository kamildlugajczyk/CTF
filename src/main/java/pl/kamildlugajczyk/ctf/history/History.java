package pl.kamildlugajczyk.ctf.history;

import pl.kamildlugajczyk.ctf.challenge.Challenge;
import pl.kamildlugajczyk.ctf.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Challenge challenge;

    private LocalDate date;
    private int points;
    private int userRating;

    public History() {
    }

    public History(User user, Challenge challenge, LocalDate date, int points, int userRating) {
        this.user = user;
        this.challenge = challenge;
        this.date = date;
        this.points = points;
        this.userRating = userRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }
}


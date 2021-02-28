package pl.kamildlugajczyk.ctf.history;

import pl.kamildlugajczyk.ctf.challenge.Challenge;
import pl.kamildlugajczyk.ctf.user.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class History {

    @Id
    private int id;

    @ManyToOne
    User user;

    @ManyToOne
    Challenge challenge;

    private LocalDate date;
    private int points;
    private int userRating;

    public History() {
    }

    public History(int id, LocalDate date, int points, int userRating) {
        this.id = id;
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


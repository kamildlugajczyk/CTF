package pl.kamildlugajczyk.ctf.vote;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vote {

    @Id
    private int id;
    private int challengeId;
    private int userId;
    private int userRating;

    public Vote() {
    }

    public Vote(int id, int challengeId, int userId, int userRating) {
        this.id = id;
        this.challengeId = challengeId;
        this.userId = userId;
        this.userRating = userRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }
}


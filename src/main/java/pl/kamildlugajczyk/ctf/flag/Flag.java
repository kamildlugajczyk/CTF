package pl.kamildlugajczyk.ctf.flag;

public class Flag {

    private String flag;
    private int challengeId;

    public Flag() {
    }

    public Flag(String flag, int challengeId) {
        this.flag = flag;
        this.challengeId = challengeId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }
}

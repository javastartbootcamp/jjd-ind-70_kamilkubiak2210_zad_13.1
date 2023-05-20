package pl.javastart.voting;

import java.util.Objects;

// klasa pomocnicza, możesz ją dowolnie zmieniać, albo usunąć
public class Vote {

    private String voter;
    private Boolean vote; // true - ZA, false - PRZECIW, null - wstrzymanie się

    public Vote(String voter, Boolean vote) {
        this.voter = voter;
        this.vote = vote;
    }

    public Vote() {
    }

    public String getVoter() {
        return voter;
    }

    public Boolean getVote() {
        return vote;
    }

    @Override
    public String toString() {
        return voter + ": " + vote;
    }

    public String voteToString(Boolean vote) {
        String voteResult = "";
        if (vote == null) {
            voteResult = "WSTRZYMAŁ SIĘ";
        } else if (vote) {
            voteResult = "ZA";
        } else if (!vote) {
            voteResult = "PRZECIW";
        }
        return voteResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vote vote1 = (Vote) o;
        return Objects.equals(voter, vote1.voter) && Objects.equals(vote, vote1.vote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voter, vote);
    }
}

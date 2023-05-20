package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult extends Vote {
    private final List<Vote> voteList = new ArrayList<>();

    public VotingResult(List<Vote> list) {
        voteList.addAll(list);
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        double voteFor = 0;
        double voteAgainst = 0;
        double voiceHeld = 0;
        double allVotes = 0;
        for (Vote value : voteList) {
            if (value.getVote() == null) {
                voiceHeld++;
                allVotes++;
            } else if (value.getVote()) {
                voteFor++;
                allVotes++;
            } else if (!value.getVote()) {
                voteAgainst++;
                allVotes++;
            }
        }
        System.out.printf("Wstrzymało się: " + "%.2f%%\n", voiceHeld / allVotes * 100);
        System.out.printf("Głosów za: " + "%.2f%%\n", voteFor / allVotes * 100);
        System.out.printf("Głosów przeciw: " + "%.2f%%\n", voteAgainst / allVotes * 100);
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Ziobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Ziobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        System.out.println();
        for (Vote vote : voteList) {
            if (vote.getVoter().equals(voterName)) {
                System.out.println(vote.getVoter() + ": " + voteToString(vote.getVote()));
            }
        }
    }
}


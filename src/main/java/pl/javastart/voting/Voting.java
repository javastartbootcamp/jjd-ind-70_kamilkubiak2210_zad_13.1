package pl.javastart.voting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Jan Kowalski");
        voters.add("Zbigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zbigniew Siobro");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        List<Vote> voteList = new LinkedList<>();

        Boolean result = null;
        for (int i = 0; i < voters.size(); i++) {
            System.out.print("Jak głosuje " + voters.get(i) + "? ");
            String line;
            do {
                System.out.println("Podaj (z - za, p - przeciw, w - wstrzymanie się)");
                line = scanner.nextLine();
                if (line.equals("z") || line.equals("p") || line.equals("w")) {
                    switch (line) {
                        case "z" -> result = true;
                        case "p" -> result = false;
                        case "w" -> result = null;
                    }
                    break;
                }
            } while (!line.equals("z") || !line.equals("p") || !line.equals("w"));
            voteList.add(new Vote(voters.get(i), result));
        }
        return new VotingResult(voteList); // to możesz (a nawet powinieneś / powinnaś) zmienić :)
    }
}





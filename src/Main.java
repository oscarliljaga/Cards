import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Player player = new Player();
            player.deposit(1000);
            players.add(player);
        }

        for (int i = 0; i < players.size(); i++) {
            players.get(i).giveCard(deck.pickCard());
            players.get(i).giveCard(deck.pickCard());
        }

        for (int i = 0; i < players.size(); i++) {
            inputLoop: while (true) {
                String input = scanner.nextLine().toLowerCase();
                switch (input) {
                    case "fold":
                    case "f":
                        players.get(i).setFolded(true);
                        break inputLoop;

                    case "check":
                    case "c":

                }
            }
        }
    }
}
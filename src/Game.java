import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public Game() {
        startGame();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        ArrayList<Player> players = new ArrayList<>();
        int pot = 0;

        for (int i = 0; i < 2; i++) {
            Player player = new Player("Player" + i);
            player.deposit(1000);
            players.add(player);
        }

        for (Player player : players) {
            player.giveCard(deck.pickCard());
            player.giveCard(deck.pickCard());
        }

        boolean betting = true;
        while (betting) {
            betting = false;

            for (Player player : players) {
                if (player.isFolded()) break;
                System.out.println(player.name + "'s turn: \nChoose to [F]old, [C]all or [R]aise");

                inputLoop:
                while (true) {
                    String input = scanner.nextLine().toLowerCase();

                    switch (input) {
                        case "raise":
                        case "r":

                            break inputLoop;

                        case "call":
                        case "c":
                            break inputLoop;

                        case "fold":
                        case "f":
                            player.setFolded(true);
                            break inputLoop;

                        default:
                            System.out.println("Invalid input, try again...");
                            break;
                    }
                }
            }
        }
    }
}



import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<>();
    int pot = 0;
    int tableBet = 20;
    Card[] tableCards = new Card[5];

    public Game() {
        startGame();
    }

    public void startGame() {
        for (int i = 0; i < 2; i++) {
            Player player = new Player("Player" + i);
            player.deposit(1000);
            players.add(player);
        }

        while (true) {
            pot = 0;
            tableBet = 20;

            for (Player player : players) {
                player.giveCard(deck.pickCard());
                player.giveCard(deck.pickCard());
            }

            startBetting();

            for (int i = 0; i < 3; i++) {
                tableCards[i] = deck.pickCard();
                System.out.print(tableCards[i].value() + " of ");
                System.out.print(tableCards[i].color());
            }

            startBetting();

            tableCards[3] = deck.pickCard();
            System.out.print(tableCards[3].value() + " of ");
            System.out.print(tableCards[3].color());

            startBetting();tableCards[4] = deck.pickCard();
            System.out.print(tableCards[4].value() + " of ");
            System.out.print(tableCards[4].color());

            startBetting();
        }
    }

    void startBetting() {
        System.out.println("Pot: " + pot);
        System.out.println("Bet: " + tableBet);
        bettingLoop:
        while (true) {
            for (Player player : this.players) {
                if (player.isFolded()) break;
                if (player.getBet() == tableBet) {
                    for (int i = 0; i < players.size(); i++) {
                        pot += player.getBet();
                        player.resetBet();
                    }
                    break bettingLoop;
                }

                System.out.println(player.name + "'s turn: \nChoose to [F]old, [C]all or [R]aise [amount]");

                inputLoop:
                while (true) {
                    String[] args = scanner.nextLine().toLowerCase().split("\\s+");

                    switch (args[0]) {
                        case "raise":
                        case "r":
                            int raiseAmount;
                            try {
                                raiseAmount = Integer.parseInt(args[1]);
                            } catch (NumberFormatException e) {
                                System.out.println("Please use the format [R]/[Raise] [amount]");
                                break;
                            }
                            player.bet(tableBet - player.getBet());
                            tableBet += player.bet(raiseAmount);
                            break inputLoop;

                        case "check/call":
                        case "c":
                            player.bet(tableBet - player.getBet());
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



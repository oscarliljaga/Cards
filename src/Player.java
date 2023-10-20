import java.util.ArrayList;

public class Player {
    //Attributes
    public final String name;
    private ArrayList<Card> cards = new ArrayList<>();
    private int money;
    private int bet;
    private boolean folded = false;

    //Constructor
    public Player(String name) {
        this.name = name;
    }

    //Methods
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Removes a Card from the Player's cards
     *
     * @param card index of card to remove
     * @return removed card
     */
    public Card pickCard(Card card) {
        int cardIndex = cards.indexOf(card);
        return (cards.remove(cardIndex));
    }

    public void giveCard(Card card) {
        this.cards.add(card);
    }

    public void deposit(int amount) {
        this.money += amount;
    }

    /**
     * Withdraws an amount of money from a Player, subtracting the amount from the Player object.
     * If the specified amount isn't available for the Player, the whole available amount is instead withdrawn
     *
     * @param amount requested to withdraw
     * @return amount withdrawn
     */
    public int withdraw(int amount) {
        if (this.money - amount < 0) {
            int availableAmount = this.money;
            this.money = 0;
            return availableAmount;
        } else {
            this.money -= amount;
            return amount;
        }
    }

    public int getBet() {
        return this.bet;
    }

    public int bet(int amount) {

        return this.bet = withdraw(amount);
    }

    public void resetBet() {
        this.bet = 0;
    }

    public boolean isFolded() {
        return folded;
    }

    public void setFolded(boolean folded) {
        this.folded = folded;
    }
}

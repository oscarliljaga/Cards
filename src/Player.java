import java.util.ArrayList;

public class Player {
    //Attributes
    private ArrayList<Card> cards = new ArrayList<>();
    private int money;
    private boolean folded = false;

    //Methods
    public ArrayList<Card> getCards() {
        return cards;
    }

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

    public boolean isFolded() {
        return folded;
    }

    public void setFolded(boolean folded) {
        this.folded = folded;
    }
}

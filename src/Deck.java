import java.util.ArrayList;
import java.util.Random;
public class Deck {
    //Attributes
    private final ArrayList<Card> cards = new ArrayList<>();

    //Constructor
    /**
     * Constructs a deck of 52 cards, values 1-13 for each of the four colors
     * Note that the deck is sorted
     */
    public Deck() {
        for (int i = 0; i < CardColor.values().length; i++) {
            for (int j = 1; j < 14; j++) {
                Card myCard = new Card(j, CardColor.values()[i]);
                cards.add(myCard);
            }
        }
    }

    //Methods
    /**
     * Removes a random Card from the deck
     * @return picked Card
     */
    public Card pickCard() {
        Random myRandom = new Random();
        int pickedCard = myRandom.nextInt(cards.size());
        return (cards.remove(pickedCard));
    }

    public int getDeckSize() {
        return this.cards.size();
    }
}

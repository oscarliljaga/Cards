import java.util.ArrayList;
import java.util.Random;

public class Deck {
    //Attributes
    private ArrayList<Card> cards = new ArrayList<>();

    //Constructor
    public Deck() {
        for (int i = 0; i < CardColor.values().length; i++) {
            for (int j = 1; j < 14; j++) {
                Card myCard = new Card(j, CardColor.values()[i]);
                cards.add(myCard);
            }
        }
    }

    public Card pickCard() {
        Random myRandom = new Random();
        int pickedCard = myRandom.nextInt(cards.size());
        return (cards.remove(pickedCard));
    }
}

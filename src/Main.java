public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            Card myCard = deck.pickCard();
            System.out.println(myCard.color + "" + myCard.value);
        }
    }
}
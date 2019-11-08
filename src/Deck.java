import java.util.ArrayList;
import java.util.HashMap;

public class Deck {
    private HashMap<Integer, ArrayList<Card>> cards;
    private ArrayList<Card> discard;

    public Deck() {

    }

    public HashMap<Integer, ArrayList<Card>> getCards() {
        return cards;
    }
    public ArrayList<Card> getDiscard() {
        return discard;
    }

    public void discard(Card card) {
        discard.add(card);
    }
    public ArrayList<Card> getHand(int val) {
        return cards.get(val);
    }

    public void incrementAge() {

    }
}

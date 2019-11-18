import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
        Deck deck = new Deck();
        System.out.println(deck.getHand(1).get(0));
    }
}
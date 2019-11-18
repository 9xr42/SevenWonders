import java.io.IOException;
import java.util.ArrayList;

public class Board {
    private Deck deck;
    private ArrayList<Player> players;

    public Board() throws IOException {
        deck = new Deck();
        players = new ArrayList<Player>();
    }
}

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Board2 {
	private Deck2 deck;
	//private HashMap<Integer, ArrayList<Card>> cards;
    private ArrayList<Card2> discardPile;
    private int age;
    public ArrayList<Player2> players;
    public int mainPlayer;
    private boolean direction;

    public Board2() throws IOException {
        deck = new Deck2(); //////////////////////////////////
        age = 1;
        discardPile = new ArrayList<Card2>();
        direction = true; //true - clockwise. false - counterclockwise
        //cards = deck.getAgeDeck(age);

        Scanner sc = new Scanner(new File("wonderBoards.txt"));
        ArrayList<PlayerBoard2> wonders = new ArrayList<PlayerBoard2>();
        while(sc.hasNextLine()) {
            String[] str = sc.nextLine().split("-");
            for(String i: str)
            	System.out.println(i);
            wonders.add(new PlayerBoard2(str[0], new Wonder2(false, str[1], 3, null),
                    new Wonder2(false, str[2], 0, str[3]),
                    new Wonder2(false, str[4], 7, null), str[5]));
        }
        Collections.shuffle(wonders);

        players = new ArrayList<Player2>();
        
        for(int i = 0; i<3; i++)
        {
            players.add(new Player2(wonders.remove(0), i));
        }

    }

    public void playerTurn(int index) //graphic input
    {
        playCard(index);
        mainPlayer++;
        if(mainPlayer>3)
            mainPlayer-=4;
    }

    public void playCard(int card)
    {
        Card2 temp = deck.getHand(mainPlayer).remove(card); //gets the card in the hand
        players.get(mainPlayer).addCard(temp);
    }

    public ArrayList<Card2> getHand(int player)
    {
        return deck.getHand(player);
    }
    
    public String getPlayerBoard(int player)
    {
    	System.out.println(players.get(player).getBoardName());
    	return players.get(player).getBoardName();
    }

    public void incrementAge()
    {
        age++;
        deck.setAge(age);
        direction = !direction;
    }
    
    public ArrayList<Card2> getAgeDeck(int age)
    {
    	return deck.getAgeDeck(age);
    }
    
    public int getMainPlayerNum()
    {
    	return mainPlayer;
    }
    
    public Player2 getPlayer(int num)
    {
    	return players.get(num);
    }

    public ArrayList<Card2> playerHand(int player)
    {
        return this.players.get(player).getHand();
    }

}

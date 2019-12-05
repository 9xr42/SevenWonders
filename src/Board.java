import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Board {
    private Deck deck;
    private ArrayList<Card> ageDeck;
    private ArrayList<Card> discardPile;
    private int age;
    public ArrayList<Player> players;
    public int mainPlayer;
    private boolean direction;

    public Board() throws IOException {
        deck = new Deck(); //////////////////////////////////
        age = 1;
        discardPile = new ArrayList<Card>();
        direction = true; //true - clockwise. false - counterclockwise
        ageDeck = deck.getAgeDeck(age);

        Scanner sc = new Scanner(new File("wonderBoards.txt"));
        ArrayList<PlayerBoard> wonders = new ArrayList<PlayerBoard>();
        sc.nextLine();
        while(sc.hasNextLine()) {
            String[] str = sc.nextLine().split("|");
            wonders.add(new PlayerBoard(str[0], new Wonder(false, str[1], 3, null),
                    new Wonder(false, str[2], 0, str[3]),
                    new Wonder(false, str[4], 7, null), str[5]));
        }
        ArrayList<Integer> wonderAssign = new ArrayList<Integer>();
        for(int i = 1; i<11; i++)
            wonderAssign.add(i);

        players = new ArrayList<Player>();
        //for(int i = 0; i<4; i++)
        //{
        //    Collections.shuffle(wonderAssign);
        //    players.add(new Player(wonders.get(wonderAssign.remove(0)), , 3, i))
        //}

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
        Card temp = players.get(mainPlayer).getHand().get(card); //gets the card in the hand
        players.get(mainPlayer).addCard(temp);
    }

    public ArrayList<Card> getAgeDeck(int age)
    {
        return deck.getAgeDeck(age);
    }
    
    public String getPlayerBoard(int player)
    {
    	return players.get(player).getBoard();
    }

    public void incrementAge()
    {
        age++;
        ageDeck = deck.getAgeDeck(age);
        direction = !direction;
    }
    
    public int getMainPlayerNum()
    {
    	return mainPlayer;
    }
    
    public Player getPlayer(int num)
    {
    	return players.get(num);
    }

    public ArrayList<Card> playerHand(int player)
    {
        return deck.getHand(player);
    }

}

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
    private int round;
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
        mainPlayer = 0;
        round = 0;

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
    	return players.get(player).getBoardName();
    }
    
    public int getWinner()
    {
    	int highest = 0;
    	if(players.get(1).getScore()>players.get(highest).getScore())
    		highest = 1;
    	if(players.get(2).getScore()>players.get(highest).getScore())
    		highest = 2;
    	return highest;
    }
    
    public boolean incrRound()
    {
    	round++;
    	if(round==6&&age<3)
    	{
    		incrementAge();
    		return true;
    	}
    	else if(round==6)
    	{
    		age = 4;
    		return true;
    	}
    	return false;
    }
    
    public void militaryConflicts()
    {
    	if(players.get(0).getMilitaryPoints()>players.get(1).getMilitaryPoints())
    	{
    		players.get(0).increasePositiveWarPoints(1+2*(age-2));
    		players.get(1).increaseNegativeWarPoints(-1);
    	}
    	else if(players.get(0).getMilitaryPoints()<players.get(1).getMilitaryPoints())
    	{
    		players.get(1).increasePositiveWarPoints(1+2*(age-2));
    		players.get(0).increaseNegativeWarPoints(-1);
    	}
    	if(players.get(0).getMilitaryPoints()>players.get(2).getMilitaryPoints())
    	{
    		players.get(0).increasePositiveWarPoints(1+2*(age-2));
    		players.get(2).increaseNegativeWarPoints(-1);
    	}
    	else if(players.get(0).getMilitaryPoints()<players.get(2).getMilitaryPoints())
    	{
    		players.get(2).increasePositiveWarPoints(1+2*(age-2));
    		players.get(0).increaseNegativeWarPoints(-1);
    	}
    	if(players.get(1).getMilitaryPoints()>players.get(2).getMilitaryPoints())
    	{
    		players.get(1).increasePositiveWarPoints(1+2*(age-2));
    		players.get(2).increaseNegativeWarPoints(-1);
    	}
    	else if(players.get(1).getMilitaryPoints()<players.get(2).getMilitaryPoints())
    	{
    		players.get(2).increasePositiveWarPoints(1+2*(age-2));
    		players.get(1).increaseNegativeWarPoints(-1);
    	}
    }
    
    public void incrPlayer()
    {
    	if(direction)
    		mainPlayer++;
    	else
    		mainPlayer--;
    	if(mainPlayer>2)
    		mainPlayer-=3;
    	else if(mainPlayer<0)
    		mainPlayer+=3;
    }
    
    public boolean chain(Card2 card)
    {
    	return players.get(mainPlayer).chain(card);
    }
    
    public void addDiscard(Card2 card)
    {
    	deck.discard(card);
    }

    public void incrementAge()
    {
        age++;
        deck.setAge(age);
        direction = !direction;
        round = 0;
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

	public int getAge() {
		return age;
	}

}

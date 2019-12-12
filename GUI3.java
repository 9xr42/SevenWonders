import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI3 extends JFrame implements MouseListener
{
    private Board2 board;
    private JPanel panel;
    private TreeMap<String/*color*/, TreeMap<String, BufferedImage>> images;
    private TreeMap<String, BufferedImage> boards;
    private TreeMap<String, BufferedImage> other;
    private int mp;
    private int lp;
    private int rp;
    private int turn;
    private boolean cardChosen;
    private int index;
    private int playerClicked;
    private String cardAction;
    private String viewColor;
    private boolean militaryConflict;
    /*
    boards: 7 wonder boards alpha order
    other: 1 coin, 5coin, military 1, military 3, military 5, military loss
    row 1: blue cards, alpha order 12
    row 2 brown cards, alpha order 10
    row 3: green cards, alpha order 12
    row 4: grey cards, alpha order 6
    row 5: red cards, alpha order 9
    row 6: purple cards, alpha order 10
    row 7: yellow cards, alpha order 9
     */
    public static void main(String[] args) throws IOException {
        GUI3 x = new GUI3();
    }

    public GUI3() throws IOException {

        super("Seven Wonders: Welcoe");

        board = new Board2();

        militaryConflict = false;
        cardChosen = false;
        mp = 0;
        lp = 1;
        rp = 2;
        index = -1;
        playerClicked = -1;
        cardAction = "";
        viewColor = "";

        images = new TreeMap<String, TreeMap<String, BufferedImage>>();
        boards = new TreeMap<String, BufferedImage>();
        other = new TreeMap<String, BufferedImage>();

        boards.put("gizah", ImageIO.read(new File("gizah.png")));
        boards.put("rhodos", ImageIO.read(new File("rhodos.png")));
        boards.put("babylon", ImageIO.read(new File("babylon.png")));
        boards.put("ephesos", ImageIO.read(new File("ephesos.png")));
        boards.put("olympia", ImageIO.read(new File("olympia.png")));
        boards.put("alexandria", ImageIO.read(new File("alexandria.png")));
        boards.put("halikarnassos", ImageIO.read(new File("halikarnassos.png")));

        other.put("buy", ImageIO.read(new File("buy.png")));
        other.put("ore", ImageIO.read(new File("ore.png")));
        other.put("clay", ImageIO.read(new File("clay.png")));
        other.put("wood", ImageIO.read(new File("wood.png")));
        other.put("back", ImageIO.read(new File("back.png")));
        other.put("free", ImageIO.read(new File("free.png")));
        other.put("show", ImageIO.read(new File("show.png")));
        other.put("glass", ImageIO.read(new File("glass.png")));
        other.put("check", ImageIO.read(new File("check.png")));
        other.put("cloth", ImageIO.read(new File("cloth.png")));
        other.put("trash", ImageIO.read(new File("trash.png")));
        other.put("stone", ImageIO.read(new File("stone.png")));
        other.put("score", ImageIO.read(new File("score.jpg")));
        other.put("start", ImageIO.read(new File("start.png")));
        other.put("arrow2", ImageIO.read(new File("arrow2.png")));
        other.put("woodback", ImageIO.read(new File("woodback.jpg")));
        other.put("goback", ImageIO.read(new File("goback.png")));
        other.put("pyramid", ImageIO.read(new File("pyramid.png")));
        other.put("onecoin", ImageIO.read(new File("onecoin.png")));
        other.put("papyrus", ImageIO.read(new File("papyrus.png")));
        other.put("clockwise", ImageIO.read(new File("clockwise.png")));
        other.put("counterclockwise", ImageIO.read(new File("counterclockwise.png")));
        other.put("mainlogo", ImageIO.read(new File("mainlogo.png")));
        other.put("threecoin", ImageIO.read(new File("threecoin.png")));
        other.put("military1", ImageIO.read(new File("military1.png")));
        other.put("military3", ImageIO.read(new File("military3.png")));
        other.put("military5", ImageIO.read(new File("military5.png")));
        other.put("militaryloss", ImageIO.read(new File("militaryloss.png")));
        other.put("militaryPoint", ImageIO.read(new File("militaryPoint.jpg")));

        ArrayList<Card2> cards = new ArrayList<Card2>();
        ArrayList<Card2> red = new ArrayList<Card2>();
        ArrayList<Card2> blue = new ArrayList<Card2>();
        ArrayList<Card2> gray = new ArrayList<Card2>();
        ArrayList<Card2> brown = new ArrayList<Card2>();
        ArrayList<Card2> green = new ArrayList<Card2>();
        ArrayList<Card2> purple = new ArrayList<Card2>();
        ArrayList<Card2> yellow = new ArrayList<Card2>();

        images.put("blue", new TreeMap<String, BufferedImage>());
        images.put("brown", new TreeMap<String, BufferedImage>());
        images.put("green", new TreeMap<String, BufferedImage>());
        images.put("gray", new TreeMap<String, BufferedImage>());
        images.put("red", new TreeMap<String, BufferedImage>());
        images.put("purple", new TreeMap<String, BufferedImage>());
        images.put("yellow", new TreeMap<String, BufferedImage>());


        for(int i=1; i<=3; i++)
        {
            cards = board.getAgeDeck(i);
            for(Card2 card: cards)
            {
                if(card.color.equals("blue"))
                    blue.add(card);
                else if(card.color.equals("brown"))
                    brown.add(card);
                else if(card.color.equals("green"))
                    green.add(card);
                else if(card.color.equals("gray"))
                    gray.add(card);
                else if(card.color.equals("red"))
                    red.add(card);
                else if(card.color.equals("purple"))
                    purple.add(card);
                else
                    yellow.add(card);
            }
        }

        for(int x = 0; x<blue.size(); x++)
            images.get("blue").put(blue.get(x).name, ImageIO.read(new File(blue.get(x).name+".png")));
        for(int x = 0; x<brown.size(); x++)
            images.get("brown").put(brown.get(x).name, ImageIO.read(new File(brown.get(x).name+".png")));
        for(int x = 0; x<green.size(); x++)
            images.get("green").put(green.get(x).name, ImageIO.read(new File(green.get(x).name+".png")));
        for(int x = 0; x<gray.size(); x++)
            images.get("gray").put(gray.get(x).name, ImageIO.read(new File(gray.get(x).name+".png")));
        for(int x = 0; x<red.size(); x++)
            images.get("red").put(red.get(x).name, ImageIO.read(new File(red.get(x).name+".png")));
        for(int x = 0; x<purple.size(); x++)
            images.get("purple").put(purple.get(x).name, ImageIO.read(new File(purple.get(x).name+".png")));
        for(int x = 0; x<yellow.size(); x++)
            images.get("yellow").put(yellow.get(x).name, ImageIO.read(new File(yellow.get(x).name+".png")));
        //this.setSize(1900, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel() {

            public void paintComponent(Graphics g)
            {
                g.drawImage(other.get("woodback"), 0, 0, 2048, 1000, null);
                //3840 50 75
                //[1745, 1795, 1845, 1895, ...]
                //800 250
                //180 275
                g.setFont(new Font("Verdana", Font.BOLD, 14));
                g.setColor(Color.WHITE);

                if(board.getAge()==4&&!militaryConflict)
                {
                    ArrayList<int[]> sc = score();
                    //int[] scores = sc.get(0);
                    //int[] places = sc.get(1);
                    g.drawImage(other.get("mainlogo"), 150, 150, 600, 198, null);
                    g.setColor(Color.BLACK);
                    int[] places = board.getWinner();
                    g.setFont(new Font("Verdana", Font.BOLD, 40));
                    g.setColor(Color.WHITE);
                    g.drawString("PLAYER " + places[0] + " WINS: " +
                                    board.players.get(places[0]).getScore() + "  :DD",
                            700, 450);
                    g.setFont(new Font("Verdana", Font.BOLD, 14));
                    g.drawString("Player " + places[1] + " gets second place: " +
                                    board.players.get(places[1]).getScore() + "  Ż\\_(^_^)_/Ż ",
                            700, 500);
                    g.drawString("Player " + places[2] + " gets third place: "
                                    + board.players.get(places[2]).getScore() + "  (T_T)",
                            700, 550);
                    try {
                        g.drawImage(ImageIO.read(new File("end.png")), 1000, 500, 900, 357, null);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                else if(board.getAge()==4&&!militaryConflict)
                {
                    g.drawImage(other.get("score"), 750, 300, 500, 380, null);
                }
                else if(!cardChosen&&playerClicked==-1&&viewColor.equals("")&&!militaryConflict)
                {
                    g.setFont(new Font("Verdana", Font.BOLD, 40));
                    int wonderCount = board.players.get(mp).mostRecentWonder();
                    for(int i=0; i<wonderCount; i++)
                        g.drawImage(other.get("check"), 430+i*240, 850, 40, 30, null);
                    g.drawImage(boards.get(board.getPlayerBoard(board.getMainPlayerNum())), 300, 600, 800, 250, null);
                    g.drawString("Age " + board.getAge(), 950, 225);
                    g.setFont(new Font("Verdana", Font.BOLD, 14));
                    if(board.getAge()==2)
                    {
                        g.drawString("Direction: counterclockwise", 950, 250);
                        g.drawImage(other.get("counterclockwise"), 1200, 200, 50, 50, null);
                    }
                    else
                    {
                        g.drawString("Direction: clockwise", 950, 250);
                        g.drawImage(other.get("clockwise"), 1200, 200, 50, 50, null);
                    }


                    g.drawString("Click on the card to enlarge and show other cards! ->", 700, 950);

                    g.drawImage(other.get("mainlogo"), 784, 50, 480, 158, null);

                    ArrayList<Card2> temp = board.players.get(mp).getColorCards("brown");
                    g.drawString("Brown Cards", 1150, 550);
                    if(temp.size()>0)
                        g.drawImage(images.get("brown").get(temp.get(0).getName()), 1140, 560, 118, 180, null);

                    g.drawString("Blue Cards", 1150, 760);
                    temp = board.players.get(mp).getColorCards("blue");
                    if(temp.size()>0)
                        g.drawImage(images.get("blue").get(temp.get(0).getName()), 1140, 780, 118, 180, null);

                    g.drawString("Green Cards", 1350, 550);
                    temp = board.players.get(mp).getColorCards("green");
                    if(temp.size()>0)
                        g.drawImage(images.get("green").get(temp.get(0).getName()), 1340, 560, 118, 180, null);

                    g.drawString("Gray Cards", 1350, 760);
                    temp = board.players.get(mp).getColorCards("gray");
                    if(temp.size()>0)
                        g.drawImage(images.get("gray").get(temp.get(0).getName()), 1340, 780, 118, 180, null);

                    g.drawString("Red Cards", 1550, 550);
                    temp = board.players.get(mp).getColorCards("red");
                    if(temp.size()>0)
                        g.drawImage(images.get("red").get(temp.get(0).getName()), 1540, 560, 118, 180, null);

                    g.drawString("Yellow Cards", 1550, 760);
                    temp = board.players.get(mp).getColorCards("yellow");
                    if(temp.size()>0)
                        g.drawImage(images.get("yellow").get(temp.get(0).getName()), 1540, 780, 118, 180, null);

                    g.drawString("Purple Cards", 1750, 550);
                    temp = board.players.get(mp).getColorCards("purple");
                    if(temp.size()>0)
                        g.drawImage(images.get("purple").get(temp.get(0).getName()), 1740, 560, 118, 180, null);

                    g.drawImage(other.get("onecoin"), 50, 520, 50, 50, null);
                    g.drawString(" - "+(board.getPlayer(board.getMainPlayerNum()).getMoney()%3), 130, 550); //number of
                    //58 60
                    g.drawImage(other.get("threecoin"), 50, 580, 58, 60, null);
                    g.drawString(" - "+board.getPlayer(board.getMainPlayerNum()).getMoney()/3, 130, 615); //number of
                    g.drawImage(other.get("militaryPoint"), 50, 650, 50, 50, null);
                    g.drawString(" - "+board.getPlayer(board.getMainPlayerNum()).getMilitaryPoints(), 130, 680);

                    TreeMap<String, Integer> resources = board.players.get(board.mainPlayer).getResources();

                    g.drawImage(other.get("show"), 100, 50, 200, 200, null);
                    g.drawImage(other.get("show"), 1648, 50, 200, 200, null);

                    g.drawString("Your resources: ", 50, 720);
                    g.drawImage(other.get("wood"), 50, 725, 50, 50, null);
                    g.drawImage(other.get("clay"), 160, 725, 50, 50, null);
                    g.drawImage(other.get("stone"), 50, 785, 50, 50, null);
                    g.drawImage(other.get("ore"), 160, 785, 50, 50, null);
                    g.drawImage(other.get("glass"), 50, 845, 50, 50, null);
                    g.drawImage(other.get("papyrus"), 160, 845, 50, 50, null);
                    g.drawImage(other.get("cloth"), 50, 905, 50, 50, null);
                    g.drawString(" - " + resources.get("wood"), 110, 745);
                    g.drawString(" - " + resources.get("clay"), 210, 745);
                    g.drawString(" - " + resources.get("stone"), 110, 805);
                    g.drawString(" - " + resources.get("ore"), 210, 805);
                    g.drawString(" - " + resources.get("glass"), 110, 865);
                    g.drawString(" - " + resources.get("papyrus"), 210, 865);
                    g.drawString(" - " + resources.get("cloth"), 110, 925);

                    int[] positions = positions();
                    ArrayList<Card2> cards = board.getHand(mp);
                    for(int i=0; i<positions.length-1; i++)
                    {
                        Card2 temp2 = cards.get(i);
                        g.drawImage(images.get(temp2.color).get(temp2.name), positions[i], 300, 150, 229, null);
                    }

                }

                else if(militaryConflict)
                {
                    board.militaryConflicts();
                    g.setFont(new Font("Verdana", Font.BOLD, 40));
                    g.drawString("PLAYER 1         PLAYER2         PLAYER 3", 500, 400);
                    g.drawString(board.players.get(0).getPositiveWarPoints()+"                        "
                            +board.players.get(1).getPositiveWarPoints()+"                        "
                            +board.players.get(2).getPositiveWarPoints(), 500, 475);
                    g.drawString(board.players.get(0).getNegativeWarPoints()+"                        "
                            +board.players.get(1).getNegativeWarPoints()+"                        "
                            +board.players.get(2).getNegativeWarPoints(), 500, 675);
                    g.drawImage(other.get("military" + (1+(board.getAge()-2)*2)), 400, 475, 50, 50, null);
                    g.drawImage(other.get("militaryloss"), 400, 675, 50, 50, null);
                    g.drawImage(other.get("arrow2"), 1500, 700, 300, 298, null);
                }
                else if(!viewColor.equals(""))
                {
                    int count = 0;
                    for(Card2 card: board.players.get(mp).getColorCards(viewColor))
                    {
                        g.drawImage(images.get(viewColor).get(card.name),
                                1000-board.players.get(mp).getColorCards(viewColor).size()/2*200 + count*200-100, 300, 200, 306, null);
                        count++;
                    }

                    g.drawImage(other.get("goback"), 400, 850, 100, 100, null);
                }
                else if(cardAction.equals("free")||cardAction.equals("trash")||cardAction.equals("buy")||cardAction.contentEquals("pyramid"))
                {
                    cardStuff();
                    turn++;
                    cardAction = "";
                    boolean change = false;
                    if(turn%3==0)
                        change = board.incrRound();
                    cardChosen = false;
                    if(change)
                    {
                        militaryConflict = true;
                        turn = 0;
                        repaint();
                    }
                    board.incrPlayer();

                    setPlayerNum();
                    repaint();
                }
                else if(cardChosen)
                {
                    g.drawImage(images.get(board.getHand(mp).get(index).getColor()).get(board.getHand(mp).get(index).getName()),
                            824, 100, 300, 458, null);
                    g.drawImage(other.get("buy"), 750, 650, 50, 50, null);
                    g.drawImage(other.get("trash"), 1200, 650, 50, 50, null);
                    g.drawImage(other.get("pyramid"), 950, 650, 50, 50, null);
                    if(board.getPlayerBoard(board.mainPlayer).equals("olympia")&&board.players.get(mp).mostRecentWonder()>=2)
                        g.drawImage(other.get("free"), 950, 775, 75, 75, null);

                    if(board.chain(board.getHand(mp).get(index)))
                    {
                        g.drawString("****CAN BE BUILT FOR FREE THROUGH CHAINS****", 800, 800);
                    }

                    TreeMap<String, Integer> resources = board.players.get(board.mainPlayer).getResources();
                    g.drawString("Your resources: ", 50, 720);
                    g.drawImage(other.get("wood"), 50, 725, 50, 50, null);
                    g.drawImage(other.get("clay"), 160, 725, 50, 50, null);
                    g.drawImage(other.get("stone"), 50, 785, 50, 50, null);
                    g.drawImage(other.get("ore"), 160, 785, 50, 50, null);
                    g.drawImage(other.get("glass"), 50, 845, 50, 50, null);
                    g.drawImage(other.get("papyrus"), 160, 845, 50, 50, null);
                    g.drawImage(other.get("cloth"), 50, 905, 50, 50, null);
                    g.drawString(" - " + resources.get("wood"), 110, 745);
                    g.drawString(" - " + resources.get("clay"), 210, 745);
                    g.drawString(" - " + resources.get("stone"), 110, 805);
                    g.drawString(" - " + resources.get("ore"), 210, 805);
                    g.drawString(" - " + resources.get("glass"), 110, 865);
                    g.drawString(" - " + resources.get("papyrus"), 210, 865);
                    g.drawString(" - " + resources.get("cloth"), 110, 925);
                    g.drawImage(other.get("goback"), 400, 850, 100, 100, null);

                    g.drawImage(other.get("onecoin"), 50, 520, 50, 50, null);
                    g.drawString(" - "+(board.getPlayer(board.getMainPlayerNum()).getMoney()%3), 130, 550);
                    g.drawImage(other.get("threecoin"), 50, 580, 58, 60, null);
                    g.drawString(" - "+board.getPlayer(board.getMainPlayerNum()).getMoney()/3, 130, 615); //number of
                    g.drawImage(other.get("militaryPoint"), 50, 650, 50, 50, null);
                    g.drawString(" - "+board.getPlayer(board.getMainPlayerNum()).getMilitaryPoints(), 130, 680);
                }

                else if(playerClicked==lp)
                {
                    g.drawImage(boards.get(board.getPlayerBoard(lp)), 600, 700, 800, 250, null);
                    int wonderCount = board.players.get(lp).mostRecentWonder();
                    for(int i=0; i<wonderCount; i++)
                        g.drawImage(other.get("check"), 730+i*240, 950, 40, 30, null);
                    g.drawImage(other.get("onecoin"), 50, 520, 50, 50, null);
                    g.drawString(" - "+(board.getPlayer(lp).getMoney()%3), 130, 550); //number of
                    //58 60
                    g.drawImage(other.get("threecoin"), 50, 580, 58, 60, null);
                    g.drawString(" - "+board.getPlayer(lp).getMoney()/3, 130, 615); //number of
                    g.drawImage(other.get("militaryPoint"), 50, 650, 50, 50, null);
                    g.drawString(" - "+board.getPlayer(lp).getMilitaryPoints(), 130, 680);

                    TreeMap<String, Integer> resources = board.players.get(lp).getResources();
                    g.drawString("Player " + (lp+1) + "'s resources: ", 50, 720);
                    g.drawImage(other.get("wood"), 50, 725, 50, 50, null);
                    g.drawImage(other.get("clay"), 160, 725, 50, 50, null);
                    g.drawImage(other.get("stone"), 50, 785, 50, 50, null);
                    g.drawImage(other.get("ore"), 160, 785, 50, 50, null);
                    g.drawImage(other.get("glass"), 50, 845, 50, 50, null);
                    g.drawImage(other.get("papyrus"), 160, 845, 50, 50, null);
                    g.drawImage(other.get("cloth"), 50, 905, 50, 50, null);
                    g.drawString(" - " + resources.get("wood"), 110, 745);
                    g.drawString(" - " + resources.get("clay"), 210, 745);
                    g.drawString(" - " + resources.get("stone"), 110, 805);
                    g.drawString(" - " + resources.get("ore"), 210, 805);
                    g.drawString(" - " + resources.get("glass"), 110, 865);
                    g.drawString(" - " + resources.get("papyrus"), 210, 865);
                    g.drawString(" - " + resources.get("cloth"), 110, 925);
                    g.drawImage(other.get("goback"), 400, 850, 100, 100, null);

                    Player2 temp = board.players.get(lp);
                    ArrayList<Card2> card = temp.getColorCards("brown");
                    int count = 0;
                    g.drawString("Brown Cards", 500, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("brown").get(i.getName()), 475, 50+count, 150, 229, null);
                        count+=50;
                    }
                    count=0;
                    card = temp.getColorCards("blue");
                    g.drawString("Blue Cards", 660, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("blue").get(i.getName()), 635, 50+count, 150, 229, null);
                        count+=50;
                    }
                    count=0;
                    card = temp.getColorCards("green");
                    g.drawString("Green Cards", 820, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("green").get(i.getName()), 795, 50+count, 150, 229, null);
                        count+=50;
                    }
                    count=0;
                    card = temp.getColorCards("gray");
                    g.drawString("Gray Cards", 980, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("gray").get(i.getName()), 955, 50+count, 150, 229, null);
                        count+=50;
                    }
                    count=0;
                    card = temp.getColorCards("red");
                    g.drawString("Red Cards", 1140, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("red").get(i.getName()), 1115, 50+count, 150, 229, null);
                        count+=50;
                    }
                    count=0;
                    card = temp.getColorCards("yellow");
                    g.drawString("Yellow Cards", 1300, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("yellow").get(i.getName()), 1275, 50+count, 150, 229, null);
                        count+=50;
                    }
                    count=0;
                    card = temp.getColorCards("purple");
                    g.drawString("Purple Cards", 1460, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("purple").get(i.getName()), 1435, 50+count, 150, 229, null);
                        count+=50;
                    }

                    g.drawString("Resources: ", 50, 50);
                    g.drawString("(click to buy)", 50, 70);
                    TreeMap<String, String> lolz = board.players.get(mp).getDiscounts();
                    if(lolz.get("left").contains("wood"))
                        g.drawString("Discount: 1 coin for raw materials", 50, 90);
                    if(lolz.get("left").contains("glass"))
                        g.drawString("Discount: 1 coin for manufactured goods", 50, 110);

                    int count1 = 0;
                    for(String i: resources.keySet())
                    {
                        if(resources.get(i)>0)
                        {
                            //g.drawImage(other.get(i), 50, 120 + count1, 50, 50, null);
                            //g.setColor(Color.LIGHT_GRAY);
                            //g.fillRoundRect(120, 120+count1, 100, 50, 10, 10);
                            //g.setColor(Color.WHITE);
                            //g.drawString("Buy", 150, 150+count1);
                            String resourceName = i;

                            count1+=60;
                        }

                    }

                }
                else if(playerClicked==rp)
                {
                    g.drawImage(boards.get(board.getPlayerBoard(rp)), 600, 700, 800, 250, null);
                    int wonderCount = board.players.get(lp).mostRecentWonder();
                    for(int i=0; i<wonderCount; i++)
                        g.drawImage(other.get("check"), 730+i*240, 950, 40, 30, null);
                    g.drawImage(other.get("onecoin"), 50, 520, 50, 50, null);
                    g.drawString(" - "+(board.getPlayer(rp).getMoney()%3), 130, 550); //number of
                    //58 60
                    g.drawImage(other.get("threecoin"), 50, 580, 58, 60, null);
                    g.drawString(" - "+board.getPlayer(rp).getMoney()/3, 130, 615); //number of
                    g.drawImage(other.get("militaryPoint"), 50, 650, 50, 50, null);
                    g.drawString(" - "+board.getPlayer(rp).getMilitaryPoints(), 130, 680);

                    TreeMap<String, Integer> resources = board.players.get(rp).getResources();
                    g.drawString("Player " + (rp+1) + "'s resources: ", 50, 720);
                    g.drawImage(other.get("wood"), 50, 725, 50, 50, null);
                    g.drawImage(other.get("clay"), 160, 725, 50, 50, null);
                    g.drawImage(other.get("stone"), 50, 785, 50, 50, null);
                    g.drawImage(other.get("ore"), 160, 785, 50, 50, null);
                    g.drawImage(other.get("glass"), 50, 845, 50, 50, null);
                    g.drawImage(other.get("papyrus"), 160, 845, 50, 50, null);
                    g.drawImage(other.get("cloth"), 50, 905, 50, 50, null);
                    g.drawString(" - " + resources.get("wood"), 110, 745);
                    g.drawString(" - " + resources.get("clay"), 210, 745);
                    g.drawString(" - " + resources.get("stone"), 110, 805);
                    g.drawString(" - " + resources.get("ore"), 210, 805);
                    g.drawString(" - " + resources.get("glass"), 110, 865);
                    g.drawString(" - " + resources.get("papyrus"), 210, 865);
                    g.drawString(" - " + resources.get("cloth"), 110, 925);
                    g.drawImage(other.get("goback"), 400, 850, 100, 100, null);

                    Player2 temp = board.players.get(rp);
                    ArrayList<Card2> card = temp.getColorCards("brown");
                    int count = 0;
                    g.drawString("Brown Cards", 500, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("brown").get(i.getName()), 475, 50+count, 150, 229, null);
                        count+=50;
                    }
                    count=0;
                    card = temp.getColorCards("blue");
                    g.drawString("Blue Cards", 660, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("blue").get(i.getName()), 635, 50+count, 150, 229, null);
                        count+=50;
                    }
                    count=0;
                    card = temp.getColorCards("green");
                    g.drawString("Green Cards", 820, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("green").get(i.getName()), 795, 50+count, 150, 229, null);
                        count+=50;
                    }
                    count=0;
                    card = temp.getColorCards("gray");
                    g.drawString("Gray Cards", 980, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("gray").get(i.getName()), 955, 50+count, 150, 229, null);
                        count+=50;
                    }
                    count=0;
                    card = temp.getColorCards("red");
                    g.drawString("Red Cards", 1140, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("red").get(i.getName()), 1115, 50+count, 150, 229, null);
                        count+=50;
                    }
                    count=0;
                    card = temp.getColorCards("yellow");
                    g.drawString("Yellow Cards", 1300, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("yellow").get(i.getName()), 1275, 50+count, 150, 229, null);
                        count+=50;
                    }
                    count=0;
                    card = temp.getColorCards("purple");
                    g.drawString("Purple Cards", 1460, 25);
                    for(Card2 i: card)
                    {
                        g.drawImage(images.get("purple").get(i.getName()), 1435, 50+count, 150, 229, null);
                        count+=50;
                    }

                    g.drawString("Resources: ", 50, 50);
                    g.drawString("(click to buy)", 50, 70);
                    int count1 = 0;
                    for(String i: resources.keySet())
                    {
                        if(resources.get(i)>0)
                        {
                            //g.drawImage(other.get(i), 50, 120 + count1, 50, 50, null);
                            //g.setColor(Color.LIGHT_GRAY);
                            //g.fillRoundRect(120, 120+count1, 100, 50, 10, 10);
                            //g.setColor(Color.WHITE);
                            //g.drawString("Buy", 150, 150+count1);


                            count1+=60;
                        }

                    }

                    TreeMap<String, String> lolz = board.players.get(mp).getDiscounts();

                    if(lolz.get("right").contains("wood"))
                        g.drawString("Discount: 1 coin for raw materials", 50, 90);
                    if(lolz.get("right").contains("glass"))
                        g.drawString("Discount: 1 coin for manufactured goods", 50, 110);

                }


                //Player2 temp = board.getPlayer(board.getMainPlayerNum());

            }
        };
        //setStart();
        panel.addMouseListener(this);

        panel.setPreferredSize(new Dimension(2048, 1000));
        //panel.setBackground(Color.lightGray);

        add(panel);
        setContentPane(panel);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void cardStuff()
    {
        if(cardAction.equals("free"))
            board.players.get(mp).addCard(board.getHand(mp).remove(index));
        else if(cardAction.equals("trash"))
        {
            board.addDiscard(board.getHand(mp).remove(index));
            board.players.get(mp).changeMoney(3);
        }
        else
        {
            boolean bought = board.players.get(mp).buyCard(board.getHand(mp).get(index));
            if(bought)
                board.getHand(mp).remove(index);

        }
    }

    public int[] positions()
    {
        int length = board.getHand(mp).size();
        int[] temp = new int[length+1];
        if(length%2==0)
        {
            int start = 1024-length/2*150;
            for(int i=0; i<length+1; i++)
            {
                temp[i] = start;
                start+=150;
            }
        }
        else
        {
            int start = 1024-150-length/2*150;
            for(int i=0; i<length+1; i++)
            {
                temp[i] = start;
                start+=150;
            }
        }
        return temp;
    }

    public void setPlayerNum()
    {
        mp = board.mainPlayer;
        lp = 0;
        rp = 0;
        if(mp == 0)
        {
            rp = 1;
            lp = 2;
        }
        else if(mp == 1)
        {
            rp = 2;
            lp = 0;
        }
        else if(mp == 2)
        {
            rp = 0;
            lp = 1;
        }
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {
        //System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseReleased(MouseEvent e){
        int[] positions = positions();
        int x = e.getX();
        int y = e.getY();
        if(x>=positions[0]&&x<=positions[positions.length-1]&&playerClicked==-1&&!cardChosen&&y>=300&&y<=529)
        {
            int index = 0;
            for(int i = 0; i<positions.length; i++)
            {
                if((x-positions[i])<0 && (x-positions[i])>-180)
                {
                    index = i-1;
                    cardChosen = true;
                    this.index = index;
                    repaint();
                }
            }
        }
        else if(x>=1500&&x<=1800&&y<=998&&y>=700&&militaryConflict)
        {
            militaryConflict=false;
            repaint();
        }
        else if(x>=1140&&x<=1258&&y>=560&&y<=740&&playerClicked<0&&!cardChosen)
        {
            viewColor = "brown";
            repaint();
        }
        else if(x>=1140&&x<=1258&&y>=780&&y<=960&&playerClicked<0)
        {
            viewColor = "blue";
            repaint();
        }
        else if(x>=1340&&x<=1458&&y>=560&&y<=740&&playerClicked<0)
        {
            viewColor = "green";
            repaint();
        }
        else if(x>=1340&&x<=1458&&y>=780&&y<=960&&playerClicked<0)
        {
            viewColor = "gray";
            repaint();
        }
        else if(x>=1540&&x<=1658&&y>=560&&y<=740&&playerClicked<0)
        {
            viewColor = "red";
            repaint();
        }
        else if(x>=1540&&x<=1658&&y>=780&&y<=960&&playerClicked<0)
        {
            viewColor = "yellow";
            repaint();
        }
        else if(x>=1740&&x<=1858&&y>=560&&y<=740&&playerClicked<0)
        {
            viewColor = "purple";
            repaint();
        }
        else if(x>=100&&x<=300&&y>=50&&y<=250&&playerClicked!=rp)
        {
            playerClicked = lp;
            repaint();
        }
        else if(x>=1648&&x<=1848&&y>=50&&y<=250&&playerClicked!=lp)
        {
            playerClicked = rp;
            repaint();
        }
        else if((playerClicked>-1||(!viewColor.equals("")))&&x>=400&&x<=500&&y>=850&&y<=950)
        {
            playerClicked = -1;
            viewColor = "";
            repaint();
        }
        else if (cardChosen&&x>=400&&x<=500&&y>=850&&y<=950)
        {
            cardChosen = false;
            repaint();
        }
        else if(cardChosen&&x>=750&&x<=800&&y>=650&&y<=700)
        {
            cardAction = "buy";
            repaint();
        }
        else if(cardChosen&&x>=1200&&x<=1250&&y>=650&&y<=700)
        {
            cardAction = "trash";
            repaint();
        }
        else if(cardChosen&&x>=950&&x<=1025&&y>=775&&y<=850)
        {
            cardAction = "free";
            repaint();
        }
        else if(cardChosen&&x>=950&&x<=1000&&y>=650&&y<=700)
        {
            cardAction = "pyramid";
            board.players.get(mp).buildWonder();
            repaint();
        }
        //else if(playerClicked>0)
    }

    public void trading(boolean left, String res)
    {
        board.trade(left, res);
    }

    public ArrayList<int[]> score() {
        int a = board.players.get(lp).getGuildScore() + board.players.get(rp).getGuildScore();
        board.players.get(mp).setScore(a);
        int b = board.players.get(mp).getGuildScore() + board.players.get(rp).getGuildScore();
        board.players.get(lp).setScore(b);
        int c = board.players.get(lp).getGuildScore() + board.players.get(mp).getGuildScore();
        board.players.get(rp).setScore(c);

        a = board.players.get(mp).score;
        b = board.players.get(lp).score;
        c = board.players.get(rp).score;
        int[] scores = new int[3];
        int[] pos = new int[3];

        if(a > b && a > c)
        {
            scores[0] = a;
            pos[0] = 0;
            if(b > c)
            {
                scores[1] = b;
                scores[2] = c;
                pos[1] = 1;
                pos[2] = 2;
            }
            else
            {
                scores[1] = c;
                scores[2] = b;
                pos[1] = 2;
                pos[2] = 1;
            }
        }
        else if(b > a && b > c)
        {
            scores[0] = b;
            pos[0] = 1;
            if(a > c)
            {
                scores[1] = a;
                scores[2] = c;
                pos[1] = 0;
                pos[2] = 2;
            }
            else
            {
                scores[1] = c;
                scores[2] = a;
                pos[1] = 2;
                pos[2] = 0;
            }
        }
        else if(c > a && c > b)
        {
            scores[0] = c;
            pos[0] = 2;
            if(a > b)
            {
                scores[1] = a;
                scores[2] = b;
                pos[1] = 0;
                pos[2] = 1;
            }
            else
            {
                scores[1] = b;
                scores[2] = a;
                pos[1] = 1;
                pos[2] = 0;
            }
        }
        ArrayList<int[]> sc = new ArrayList<>();
        sc.add(scores);
        sc.add(pos);
        return sc;
    }


    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void setStart() throws IOException {
        JFrame start = new JFrame("Seven Wonders: Welcome");
        Dimension startSize = start.getMaximumSize();
        start.setSize(startSize);
        start.getContentPane().setBackground(Color.BLACK);
        start.setDefaultCloseOperation(EXIT_ON_CLOSE);
        start.setVisible(true);

        JPanel s2 = new JPanel();
        s2.setBackground(Color.WHITE);
        start.add(s2);
        s2.setVisible(true);

        JLabel bimg = new JLabel(new ImageIcon(other.get("back")));
        Dimension b = bimg.getPreferredSize();
        bimg.setSize(b);
        s2.add(bimg);
        bimg.setVisible(true);

        JLabel tx = new JLabel("TEAM ALICE");
        bimg.add(tx);
        tx.setFont(new Font("Serif", Font.BOLD, 24));
        Dimension size2 = tx.getMaximumSize();
        tx.setBounds(100, 25, size2.width, size2.height);
        tx.setVisible(true);

        JLabel tx2 = new JLabel("CLICK PLAY BUTTON TO BEGIN");
        bimg.add(tx2);
        tx2.setFont(new Font("Serif", Font.BOLD, 24));
        tx2.setForeground(Color.WHITE);
        Dimension size3 = tx2.getMaximumSize();
        tx2.setBounds(740, 800, size3.width, size3.height);
        tx2.setVisible(true);


        BufferedImage buttonIcon = other.get("start");
        JButton button = new JButton(new ImageIcon(buttonIcon));
        button.setBounds(840, 850, 200, 100);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        bimg.add(button);
        button.setVisible(true);

        button.addActionListener(actionEvent -> {
            start.dispose();
        });
    }
}
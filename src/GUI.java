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

public class GUI extends JFrame implements MouseListener
{
    private Board board;
    private JPanel panel;
    private TreeMap<String/*color*/, TreeMap<String, BufferedImage>> images;
    private TreeMap<String, BufferedImage> boards;
    private TreeMap<String, BufferedImage> other;
    private int mp;
    private int lp;
    private int rp;
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
        GUI x = new GUI();
    }

    public GUI() throws IOException {
        super("Seven Wonders: Welcome");
        board = new Board();
        images = new TreeMap<String, TreeMap<String, BufferedImage>>();
        boards = new TreeMap<String, BufferedImage>();
        other = new TreeMap<String, BufferedImage>();
        
        boards.put("Gizah", ImageIO.read(new File("Gizah.png")));
        boards.put("Rhodos", ImageIO.read(new File("Rhodos.png")));
        boards.put("Babylon", ImageIO.read(new File("Babylon.png")));
        boards.put("Ephesos", ImageIO.read(new File("Ephesos.png")));
        boards.put("Olympia", ImageIO.read(new File("Olympia.png")));
        boards.put("Alexandria", ImageIO.read(new File("Alexandria.png")));
        boards.put("Halikarnassos", ImageIO.read(new File("Halikarnassos.png")));
        
        other.put("wood", ImageIO.read(new File("wood.png")));
        other.put("back", ImageIO.read(new File("back.png")));
        other.put("show", ImageIO.read(new File("show.png")));
        other.put("start", ImageIO.read(new File("start.png")));
        other.put("goback", ImageIO.read(new File("goback.png")));
        other.put("onecoin", ImageIO.read(new File("onecoin.png")));
        other.put("threecoin", ImageIO.read(new File("threecoin.png")));
        other.put("military1", ImageIO.read(new File("military1.png")));
        other.put("military3", ImageIO.read(new File("military3.png")));
        other.put("military5", ImageIO.read(new File("military5.png")));
        other.put("militaryloss", ImageIO.read(new File("militaryloss.png")));
        
        ArrayList<Card> cards = new ArrayList<Card>();
        ArrayList<RedCard> red = new ArrayList<RedCard>();
        ArrayList<BlueCard> blue = new ArrayList<BlueCard>();
        ArrayList<GrayCard> gray = new ArrayList<GrayCard>();
        ArrayList<BrownCard> brown = new ArrayList<BrownCard>();
        ArrayList<GreenCard> green = new ArrayList<GreenCard>();
        ArrayList<PurpleCard> purple = new ArrayList<PurpleCard>();
        ArrayList<YellowCard> yellow = new ArrayList<YellowCard>();
        
        images.put("blue", new TreeMap<String, BufferedImage>());
        images.put("brown", new TreeMap<String, BufferedImage>());
        images.put("green", new TreeMap<String, BufferedImage>());
        images.put("gray", new TreeMap<String, BufferedImage>());
        images.put("red", new TreeMap<String, BufferedImage>());
        images.put("purple", new TreeMap<String, BufferedImage>());
        images.put("yellow", new TreeMap<String, BufferedImage>());

        for(int i=0; i<3; i++)
        {
            cards = board.getAgeDeck(i);
            for(Card card: cards)
            {
                if(card.getColor().equals("blue"))
                    blue.add((BlueCard)card);
                else if(card.getColor().equals("brown"))
                    brown.add((BrownCard)card);
                else if(card.getColor().equals("green"))
                    green.add((GreenCard)card);
                else if(card.getColor().equals("gray"))
                    gray.add((GrayCard)card);
                else if(card.getColor().equals("red"))
                    red.add((RedCard)card);
                else if(card.getColor().equals("purple"))
                    purple.add((PurpleCard)card);
                else
                    yellow.add((YellowCard)card);
            }
            
            
            for(int x = 0; x<blue.size(); x++)
                images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName()+".png")));
            for(int x = 0; x<brown.size(); x++)
            	images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName()+".png")));
            for(int x = 0; x<green.size(); x++)
            	images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName()+".png")));
            for(int x = 0; x<gray.size(); x++)
            	images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName()+".png")));
            for(int x = 0; x<red.size(); x++)
            	images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName()+".png")));
            for(int x = 0; i<purple.size(); i++)
            	images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName()+".png")));
            for(int x = 0; i<yellow.size(); i++)
            	images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName()+".png")));
            
            blue.clear();
            brown.clear();
            green.clear();
            gray.clear();
            red.clear();
            purple.clear();
            yellow.clear();
        }
        //this.setSize(1900, 1080); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel() {

            public void paintComponent(Graphics g)
            {
            	//3840 50 75
            	//[1745, 1795, 1845, 1895, ...]
            	//800 250
            	//180 275
            	g.setFont(new Font("Verdana", Font.BOLD, 14));
            	g.setColor(Color.BLACK);
            	g.drawImage(boards.get(board.getPlayerBoard(board.getMainPlayerNum())), 1520, 1500, 800, 250, null);
            	//50 50
            	g.drawImage(other.get("onecoin"), 50, 1000, 50, 50, null);
            	g.drawString(""+(board.getPlayer(board.getMainPlayerNum()).getMoney()%3), 110, 1120); //number of
            	//58 60
            	g.drawImage(other.get("threecoin"), 50, 1160, 58, 60, null);
            	g.drawString(""+board.getPlayer(board.getMainPlayerNum()).getMoney()/3, 120, 1180); //number of
            	g.drawImage(other.get("military1"), 50, 1230, 50, 58, null);
            	g.drawImage(other.get("military3"), 110, 1230, 50, 58, null);
            	g.drawImage(other.get("military5"), 170, 1230, 50, 58, null);
            	g.drawString(""+board.getPlayer(board.getMainPlayerNum()).getPositiveWarPoints(), 180, 1250);
            	g.drawString("Your resources: ", 50, 1280);
            	
            	int[] positions = positions();
            	ArrayList<Card> cards = board.getHand(mp);
            	for(int i=0; i<positions.length-2; i++)
            	{
            		Card temp = cards.get(i);
            		g.drawImage(images.get(temp.getColor()).get(temp.getName()), positions[i], 1000, 180, 275, null);
            	}
            	
            	//Player temp = board.getPlayer(board.getMainPlayerNum());
            	
            	
            	
            	
            	
            	
            }
        };
        //setStart();
        panel.addMouseListener(this);
		
		panel.setPreferredSize(new Dimension(1500, 1000));
	    panel.setBackground(Color.lightGray);
		
		add(panel);
		setContentPane(panel);
		pack();
		
		setLocationRelativeTo(null);
	    setVisible(true); 
    }
    
    public int[] positions()
    {
    	int length = board.getHand(mp).size();
    	int[] temp = new int[length+1];
    	if(length%2==0)
    	{
    		int start = 1920-length/2*180;
    		for(int i=0; i<length+1; i++)
    		{
    			temp[i] = start;
    			start+=180;
    		}
    	}
    	else
    	{
    		int start = 1920-90-length/2*180;
    		for(int i=0; i<length+1; i++)
    		{
    			temp[i] = start;
    			start+=180;
    		}
    	}
    	return temp;
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

         JLabel bimg = new JLabel(new ImageIcon("H:\\SevenWonders\\images\\back.png"));
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


         BufferedImage buttonIcon = ImageIO.read(new File("H:\\SevenWonders\\images\\start.png"));
         JButton button = new JButton(new ImageIcon(buttonIcon));
         button.setBounds(840, 850, 200, 100);
         button.setBorderPainted(false);
         button.setFocusPainted(false);
         button.setContentAreaFilled(false);
         bimg.add(button);
         button.setVisible(true);

         button.addActionListener(actionEvent -> {
             try {
                 start.dispose();
                 setGameFrame();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         });
    }
    
    public void setPlayerNum()
    {
        mp = board.mainPlayer;
        lp = 0;
        rp = 0;
        if(mp == 1)
        {
            lp = 2;
            rp = 3;
        }
        else if(mp == 2)
        {
            lp = 1;
            rp = 3;
        }
        else if(mp == 3)
        {
            lp = 1;
            rp = 2;
        }
    }

    public void setGameFrame() throws IOException
    {
        JFrame f = new JFrame("Seven Wonders: The Game");
        //Dimension startSize = f.getMaximumSize();
        f.setSize(3840, 2000);
        f.getContentPane().setBackground(Color.GRAY);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.addMouseListener(this);
        f.setVisible(true);

        JLabel bimg = new JLabel(new ImageIcon("H:\\SevenWonders\\images\\wood.jpg"));
        //Dimension b = bimg.getPreferredSize();
        bimg.setSize(1920, 1080);
        f.add(bimg);
        bimg.setVisible(true);

        JPanel s2 = new JPanel();
        s2.setBackground(Color.WHITE);
        bimg.add(s2);
        s2.setVisible(true);

        JLabel bim = new JLabel(new ImageIcon("H:\\SevenWonders\\images\\mainlogo.png"));
        Dimension bi = bim.getMinimumSize();
        bim.setBounds(700, 0, (int) bi.getWidth(), (int) bi.getHeight());
        bimg.add(bim);
        bim.setVisible(true);

        BufferedImage show = ImageIO.read(new File("H:\\SevenWonders\\images\\show.png"));
        JButton right = new JButton(new ImageIcon(show));
        Dimension x = right.getPreferredSize();
        right.setBounds(1350, 40, (int) x.getWidth(), (int) x.getHeight());
        right.setBorderPainted(false);
        right.setFocusPainted(false);
        right.setContentAreaFilled(false);
        bimg.add(right);
        right.setVisible(true);
        right.addActionListener(actionEvent -> {
            try {
                playerR();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JButton left = new JButton(new ImageIcon(show));
        Dimension y = left.getPreferredSize();
        left.setBounds(200, 40, (int) y.getWidth(), (int) y.getHeight());
        left.setBorderPainted(false);
        left.setFocusPainted(false);
        left.setContentAreaFilled(false);
        bimg.add(left);
        left.setVisible(true);
        left.addActionListener(actionEvent -> {
            try {
                PlayerL();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //BufferedImage btest = ImageIO.read(new File("H:\\SevenWonders\\images\\babylon.png"));
        JLabel testb = new JLabel(new ImageIcon("H:\\SevenWonders\\images\\babylon.png"));
        Dimension q = testb.getMaximumSize();
        testb.setBounds(700, 700, (int) q.getWidth(), (int) q.getHeight());
        bimg.add(testb);
        testb.setVisible(true);




    }

    public void playerR() throws IOException
    {
    	JFrame p1 = new JFrame("Right Player Cards");
        p1.setSize(1920, 1080);
        p1.getContentPane().setBackground(Color.GRAY);
        p1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        p1.setVisible(true);

        JPanel pan1 = new JPanel();
        pan1.setBackground(Color.WHITE);
        p1.add(pan1);
        pan1.setLayout(null);
        pan1.setVisible(true);

        JLabel bimg = new JLabel(new ImageIcon("H:\\SevenWonders\\images\\wood.jpg"));
        bimg.setSize(1920, 1080);
        p1.add(bimg);
        bimg.setVisible(true);

        BufferedImage pre = ImageIO.read(new File("H:\\SevenWonders\\images\\goback.png"));
        JButton back = new JButton(new ImageIcon(pre));
        Dimension x = back.getPreferredSize();
        back.setLayout(null);
        back.setBounds(800, 740, (int) x.getWidth(), (int) x.getHeight());
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        bimg.add(back);
        back.setVisible(true);
        back.addActionListener(actionEvent -> p1.dispose()
        );

        String bName = board.players.get(rp).getBoardName();
        JLabel board = new JLabel(new ImageIcon(boards.get("" + bName + ".png")));
        Dimension g = board.getPreferredSize();
        board.setBounds(200, 200, (int) g.getWidth(), (int) g.getHeight());
        bimg.add(board);
        board.setVisible(true);

        ArrayList<Card> cards = this.board.players.get(rp).getHand();
        for(int a = 0; a < cards.size(); a++)
        {
            if(cards.get(a).getColor().equals("brown"))
            {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a*20 + 200, (int)c.getWidth(), (int)c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                	zoomCard(cards.get(a).getName());
                });
            }
        }
    }
    
//    public void paintCardType(String color, int a, ArrayList<Card> cards, JLabel bimg)
//    {
//    	JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
//        Dimension c = card.getPreferredSize();
//        card.setBounds(a * 20 + 200, a*20 + 200, (int)c.getWidth(), (int)c.getHeight());
//        card.setBorderPainted(false);
//        card.setFocusPainted(false);
//        card.setContentAreaFilled(false);
//        bimg.add(card);
//        card.setVisible(true);
//        card.addActionListener(actionEvent -> {
//            zoomCard(cards.get(a).getName());
//        });
//    }

    public void PlayerL() throws IOException
    {
        JFrame p1 = new JFrame("Left Player Cards");
        p1.setSize(1920, 1080);
        p1.getContentPane().setBackground(Color.GRAY);
        p1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        p1.setVisible(true);

        JPanel pan1 = new JPanel();
        pan1.setBackground(Color.WHITE);
        p1.add(pan1);
        pan1.setLayout(null);
        pan1.setVisible(true);

        JLabel bimg = new JLabel(new ImageIcon("H:\\SevenWonders\\images\\wood.jpg"));
        bimg.setSize(1920, 1080);
        p1.add(bimg);
        bimg.setVisible(true);

        BufferedImage pre = ImageIO.read(new File("H:\\SevenWonders\\images\\goback.png"));
        JButton back = new JButton(new ImageIcon(pre));
        Dimension x = back.getPreferredSize();
        back.setLayout(null);
        back.setBounds(800, 740, (int) x.getWidth(), (int) x.getHeight());
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        bimg.add(back);
        back.setVisible(true);
        back.addActionListener(actionEvent -> p1.dispose()
        );

        String bName = board.players.get(lp).getBoardName();
        JLabel board = new JLabel(new ImageIcon(boards.get("" + bName + ".png")));
        Dimension g = board.getPreferredSize();
        board.setBounds(200, 200, (int) g.getWidth(), (int) g.getHeight());
        bimg.add(board);
        board.setVisible(true);

        ArrayList<Card> cards = this.board.players.get(rp).getHand();
        for(int a = 0; a < cards.size(); a++)
        {
            if(cards.get(a).getColor().equals("brown"))
            {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a*20 + 200, (int)c.getWidth(), (int)c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    zoomCard(cards.get(a).getName());
                });
            }
        }

    }


    public void zoomCard(String name)
    {
        JFrame z = new JFrame(name);
        z.setSize(400, 400);
        z.getContentPane().setBackground(Color.GRAY);
        z.setDefaultCloseOperation(EXIT_ON_CLOSE);
        z.setVisible(true);

        JPanel pan1 = new JPanel();
        pan1.setBackground(Color.WHITE);
        z.add(pan1);
        pan1.setLayout(null);
        pan1.setVisible(true);

        JLabel bimg = new JLabel(new ImageIcon(other.get("wood")));
        bimg.setSize(1920, 1080);
        z.add(bimg);
        bimg.setVisible(true);

        BufferedImage pre = other.get("goback");
        JButton back = new JButton(new ImageIcon(pre));
        Dimension x = back.getPreferredSize();
        back.setLayout(null);
        back.setBounds(800, 740, (int) x.getWidth(), (int) x.getHeight());
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        bimg.add(back);
        back.setVisible(true);
        back.addActionListener(actionEvent ->z.dispose()
        );

        JLabel c = new JLabel(new ImageIcon("" + name + ".png"));
        Dimension f = c.getPreferredSize();
        c.setBounds(0,0, c.getWidth(), c.getHeight());
        bimg.add(c);
        c.setVisible(true);
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
    public void mouseReleased(MouseEvent e) {
    	int[] positions = positions();
    	int x = e.getX();
		int y = e.getY();
    	if(x>=positions[0]&&x<=positions[positions.length-1])
    	{
    		if(y>=1000&&y<=1275)
    		{
    			int index = 0;
    			for(int i = 0; i<positions.length; i++)
    			{ 
    				if((x-positions[i])<0 && (x-positions[i])>-180)
    					index = i-1;
				//call method, pass in index
    			}
    			
    		}
    	}
    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame implements MouseListener
{

    public static void main(String[] args) throws IOException {
        GUI x = new GUI();
    }

    public GUI() throws IOException {
        super("Seven Wonders: Welcome");
        board = new Board();
        images = new BufferedImage[9][12];
        images[0][0] = ImageIO.read(new File("Alexandria.png"));
        images[1][0] = ImageIO.read(new File("onecoin.png"));
        images[1][1] = ImageIO.read(new File("fivecoin.png"));
        images[1][2] = ImageIO.read(new File("military1.png"));
        images[1][3] = ImageIO.read(new File("military3.png"));
        images[1][4] = ImageIO.read(new File("military5.png"));
        images[1][5] = ImageIO.read(new File("militaryloss.png"));

        ArrayList<Card> cards = new ArrayList<Card>();
        ArrayList<BlueCard> blue = new ArrayList<BlueCard>();
        ArrayList<BrownCard> brown = new ArrayList<BrownCard>();
        ArrayList<GreenCard> green = new ArrayList<GreenCard>();
        ArrayList<GrayCard> gray = new ArrayList<GrayCard>();
        ArrayList<RedCard> red = new ArrayList<RedCard>();
        ArrayList<PurpleCard> purple = new ArrayList<PurpleCard>();
        ArrayList<YellowCard> yellow = new ArrayList<YellowCard>();

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
                images[2][x] = ImageIO.read(new File(blue.get(x).getName()+".png"));
            for(int x = 0; x<brown.size(); x++)
                images[3][x] = ImageIO.read(new File(brown.get(x).getName()+".png"));
            for(int x = 0; x<green.size(); x++)
                images[4][x] = ImageIO.read(new File(green.get(x).getName()+".png"));
            for(int x = 0; x<gray.size(); x++)
                images[5][x] = ImageIO.read(new File(gray.get(x).getName()+".png"));
            for(int x = 0; x<red.size(); x++)
                images[6][x] = ImageIO.read(new File(red.get(x).getName()+".png"));
            for(int x = 0; i<purple.size(); i++)
                images[7][i] = ImageIO.read(new File(purple.get(i).getName()+".png"));
            for(int x = 0; i<yellow.size(); i++)
                images[8][i] = ImageIO.read(new File(yellow.get(i).getName()+".png"));
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

        BufferedImage pre = ImageIO.read(new File("H:\\SevenWonders\\images\\goback.png"));
        JButton back = new JButton(new ImageIcon(pre));
        back.setLayout(null
        );
        Dimension x = back.getPreferredSize();
        back.setBounds(800, 750, (int) x.getWidth(), (int) x.getHeight());
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        pan1.add(back);
        back.setVisible(true);
        back.addActionListener(actionEvent -> p1.dispose()
        );
    }

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

        BufferedImage pre = ImageIO.read(new File("H:\\SevenWonders\\images\\goback.png"));
        JButton back = new JButton(new ImageIcon(pre));
        Dimension x = back.getPreferredSize();
        back.setLayout(null);
        back.setBounds(800, 740, (int) x.getWidth(), (int) x.getHeight());
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        pan1.add(back);
        back.setVisible(true);
        back.addActionListener(actionEvent -> p1.dispose()
        );
    }





    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}

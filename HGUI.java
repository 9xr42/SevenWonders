import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HGUI implements MouseListener
{
    public static void main(String[] args) throws IOException {
        HGUI gui = new HGUI();
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    Board board;   // Board object
    ArrayList<Card> cards;  //
    private TreeMap<String /*color*/, TreeMap<String, BufferedImage>> images;
    private TreeMap<String, BufferedImage> boards;
    private TreeMap<String, BufferedImage> other;

    JFrame gameFrame;
    JLabel woodBack;
    JPanel game;

    int mp;
    int lp;
    int rp;

    public HGUI() throws IOException
    {
        board = new Board();
        images = new TreeMap<>();
        boards = new TreeMap<>();
        other = new TreeMap<>();
        mp = board.mainPlayer;

        setImages();
        setStart();
    }

    //Sets the start screen of the game

    public void setStart() throws IOException {
        //creates the JFrame
        JFrame frame = new JFrame("Seven Wonders: Welcome");
        Dimension startSize = frame.getMaximumSize();
        frame.setSize(startSize);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //creates the JPanel and adds it to the JFrame
        JPanel start = new JPanel();
        start.setBackground(Color.WHITE);
        frame.add(start);
        start.setVisible(true);

        //creates a JLabel for the background and adds it to the JPanel
        JLabel bg = new JLabel(new ImageIcon("H:\\SevenWonders\\images\\back.png"));
        Dimension bgSize = bg.getPreferredSize();
        bg.setSize(bgSize);
        start.add(bg);
        bg.setVisible(true);

        //creates the JLabel for text for directions
        JLabel playText = new JLabel("CLICK PLAY BUTTON TO BEGIN");
        bg.add(playText);
        playText.setFont(new Font("Serif", Font.BOLD, 24));
        playText.setForeground(Color.WHITE);
        Dimension playTextSize = playText.getMaximumSize();
        playText.setBounds(740, 800, playTextSize.width, playTextSize.height);
        playText.setVisible(true);

        //Creates the JButton to start the game
        BufferedImage playIcon = ImageIO.read(new File("H:\\SevenWonders\\images\\start.png"));
        JButton play = new JButton(new ImageIcon(playIcon));
        play.setBounds(840, 850, 200, 200);
        play.setBorderPainted(false);
        play.setFocusPainted(false);
        play.setContentAreaFilled(false);
        bg.add(play);
        play.setVisible(true);

        //adds ActionListener to open the main game frame and discard this one
        play.addActionListener(actionEvent -> {
            frame.dispose();
            try {
                setFrame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setFrame() throws IOException {
        gameFrame = new JFrame("Seven Wonders: The Game");
        gameFrame.setSize(3840, 2160);
        gameFrame.getContentPane().setBackground(Color.GRAY);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.addMouseListener(this);
        gameFrame.setVisible(true);

        woodBack = new JLabel(new ImageIcon("H:\\SevenWonders\\images\\wood.jpg"));
        woodBack.setSize(1920, 1080);
        gameFrame.add(woodBack);
        woodBack.setVisible(true);

        game = new JPanel();
        game.setBackground(Color.WHITE);
        game.setLayout(null);
        game.addMouseListener(this);
        woodBack.add(game);

        setGame();
    }

    public void setGame() throws IOException {
        gameFrame.removeAll();
        gameFrame.repaint();

        //adds the main logo onto the panel
        JLabel logo = new JLabel(new ImageIcon("H:\\SevenWonders\\images\\mainlogo.png"));
        Dimension logoSize = logo.getMinimumSize();
        logo.setBounds(700, 0, logoSize.width, logoSize.height);
        woodBack.add(logo);
        logo.setVisible(true);

        BufferedImage show = ImageIO.read(new File("H:\\SevenWonders\\images\\show.png"));

        JButton right = new JButton(new ImageIcon(show));
        Dimension rSize = right.getPreferredSize();
        right.setBounds(1350, 40, (int) rSize.getWidth(), (int) rSize.getHeight());
        right.setBorderPainted(false);
        right.setFocusPainted(false);
        right.setContentAreaFilled(false);
        woodBack.add(right);
        right.setVisible(true);
        right.addActionListener(actionEvent -> {
            try {
                playerR();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JButton left = new JButton(new ImageIcon(show));
        Dimension lSize = left.getPreferredSize();
        left.setBounds(200, 40, (int) lSize.getWidth(), (int) lSize.getHeight());
        left.setBorderPainted(false);
        left.setFocusPainted(false);
        left.setContentAreaFilled(false);
        woodBack.add(left);
        left.setVisible(true);
        left.addActionListener(actionEvent -> {
            try {
                PlayerL();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        String boardName = board.getPlayerBoard(mp);
        JLabel mpBoard = new JLabel(new ImageIcon("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\images\\" + boardName + ".png"));
        Dimension mpBoardSize = mpBoard.getMaximumSize();
        mpBoard.setBounds(700, 700, mpBoardSize.width, mpBoardSize.height);
        woodBack.add(mpBoard);
        mpBoard.setVisible(true);
    }
    public void playerR() throws IOException
    {
        JFrame p1 = new JFrame("Right Player Cards");
        p1.setSize(1920, 1080);
        p1.getContentPane().setBackground(Color.GRAY);
        p1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        back.setLayout(null);
        Dimension x = back.getPreferredSize();
        back.setBounds(800, 750, (int) x.getWidth(), (int) x.getHeight());
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        bimg.add(back);
        back.setVisible(true);
        back.addActionListener(actionEvent -> p1.dispose()
        );

        String bName = board.getPlayerBoard(rp);
        JLabel board = new JLabel(new ImageIcon(boards.get("" + bName + ".png")));
        Dimension g = board.getPreferredSize();
        board.setBounds(200, 200, (int) g.getWidth(), (int) g.getHeight());
        bimg.add(board);
        board.setVisible(true);


        for(int a = 0; a < cards.size(); a++)
        {
            if(cards.get(a).getColor().equals("brown"))
            {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a*20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("brown");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

        for(int a = 0; a < cards.size(); a++)
        {
            if(cards.get(a).getColor().equals("gray"))
            {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a*20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("gray");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

        for(int a = 0; a < cards.size(); a++)
        {
            if(cards.get(a).getColor().equals("yellow"))
            {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a*20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("yellow");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

        for(int a = 0; a < cards.size(); a++)
        {
            if(cards.get(a).getColor().equals("red"))
            {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a*20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("red");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

        for(int a = 0; a < cards.size(); a++)
        {
            if(cards.get(a).getColor().equals("blue"))
            {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a*20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("blue");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

        for(int a = 0; a < cards.size(); a++)
        {
            if(cards.get(a).getColor().equals("purple"))
            {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a*20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("purple");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

        for(int a = 0; a < cards.size(); a++)
        {
            if(cards.get(a).getColor().equals("green"))
            {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a*20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("green");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

    }

    public void zoomCard(String name) throws IOException {
        JFrame z = new JFrame(name);
        z.setSize(400, 400);
        z.getContentPane().setBackground(Color.GRAY);
        z.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        z.setVisible(true);

        JPanel pan1 = new JPanel();
        pan1.setBackground(Color.WHITE);
        z.add(pan1);
        pan1.setLayout(null);
        pan1.setVisible(true);

        JLabel bimg = new JLabel(new ImageIcon("H:\\SevenWonders\\images\\wood.jpg"));
        bimg.setSize(1920, 1080);
        z.add(bimg);
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
        back.addActionListener(actionEvent -> z.dispose()
        );



        for(int a = 0; a < cards.size(); a++)
        {
            if(cards.get(a).getColor().equals(name))
            {
                JLabel c = new JLabel(new ImageIcon("" + name + ".png"));
                Dimension f = c.getPreferredSize();
                c.setBounds(0,0, (int) f.getWidth(), (int) f.getHeight());
                bimg.add(c);
                c.setVisible(true);
            }
        }
    }


    public void PlayerL() throws IOException {
        JFrame p1 = new JFrame("Left Player Cards");
        p1.setSize(1920, 1080);
        p1.getContentPane().setBackground(Color.GRAY);
        p1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

        String bName = board.getPlayerBoard(lp);
        JLabel board = new JLabel(new ImageIcon(boards.get("" + bName + ".png")));
        Dimension g = board.getPreferredSize();
        board.setBounds(200, 200, (int) g.getWidth(), (int) g.getHeight());
        bimg.add(board);
        board.setVisible(true);

        for (int a = 0; a < cards.size(); a++) {
            if (cards.get(a).getColor().equals("brown")) {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a * 20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("brown");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

        for (int a = 0; a < cards.size(); a++) {
            if (cards.get(a).getColor().equals("gray")) {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a * 20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("gray");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

        for (int a = 0; a < cards.size(); a++) {
            if (cards.get(a).getColor().equals("yellow")) {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a * 20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("yellow");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

        for (int a = 0; a < cards.size(); a++) {
            if (cards.get(a).getColor().equals("red")) {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a * 20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("red");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

        for (int a = 0; a < cards.size(); a++) {
            if (cards.get(a).getColor().equals("blue")) {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a * 20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("blue");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

        for (int a = 0; a < cards.size(); a++) {
            if (cards.get(a).getColor().equals("purple")) {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a * 20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("purple");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }

        for (int a = 0; a < cards.size(); a++) {
            if (cards.get(a).getColor().equals("green")) {
                JButton card = new JButton(new ImageIcon("" + cards.get(a).getName() + ".png"));
                Dimension c = card.getPreferredSize();
                card.setBounds(a * 20 + 200, a * 20 + 200, (int) c.getWidth(), (int) c.getHeight());
                card.setBorderPainted(false);
                card.setFocusPainted(false);
                card.setContentAreaFilled(false);
                bimg.add(card);
                card.setVisible(true);
                card.addActionListener(actionEvent -> {
                    try {
                        zoomCard("green");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
        }
    }


    public void setPlayerNum()
    {
        mp = board.mainPlayer;
        lp = 0;
        rp = 0;
        if (mp == 1) {
            lp = 2;
            rp = 3;
        } else if (mp == 2) {
            lp = 1;
            rp = 3;
        } else if (mp == 3) {
            lp = 1;
            rp = 2;
        }
    }

    public void cardAction(int pos) throws IOException {
        JFrame z = new JFrame("action");
        z.setSize(400, 400);
        z.getContentPane().setBackground(Color.GRAY);
        z.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        z.setVisible(true);

        JPanel pan1 = new JPanel();
        pan1.setBackground(Color.WHITE);
        z.add(pan1);
        pan1.setLayout(null);
        pan1.setVisible(true);

        JLabel bimg = new JLabel(new ImageIcon("H:\\SevenWonders\\images\\wood.jpg"));
        bimg.setSize(1920, 1080);
        z.add(bimg);
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
        back.addActionListener(actionEvent -> z.dispose()
        );

        ArrayList<Card> hand = board.playerHand(mp);
        String name = hand.get(pos).getName();

        JLabel c = new JLabel(new ImageIcon("" + name + ".png"));
        Dimension f = c.getPreferredSize();
        c.setBounds(0,0, c.getWidth(), c.getHeight());
        bimg.add(c);
        c.setVisible(true);

        BufferedImage t = ImageIO.read(new File("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\images\\trash.png"));
        JButton tr = new JButton(new ImageIcon(t));
        Dimension mo = tr.getPreferredSize();
        tr.setLayout(null);
        tr.setBounds(800, 740, (int) mo.getWidth(), (int) mo.getHeight());
        tr.setBorderPainted(false);
        tr.setFocusPainted(false);
        tr.setContentAreaFilled(false);
        bimg.add(tr);
        tr.setVisible(true);
        tr.addActionListener(actionEvent -> z.dispose()
        );

        BufferedImage u = ImageIO.read(new File("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\images\\buy.png"));
        JButton buy = new JButton(new ImageIcon(u));
        Dimension mol = tr.getPreferredSize();
        buy.setLayout(null);
        buy.setBounds(800, 760, (int) mol.getWidth(), (int) mol.getHeight());
        buy.setBorderPainted(false);
        buy.setFocusPainted(false);
        buy.setContentAreaFilled(false);
        bimg.add(buy);
        tr.setVisible(true);
        tr.addActionListener(actionEvent -> z.dispose()
        );

        BufferedImage lol = ImageIO.read(new File("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\images\\pyramid.png"));
        JButton bu = new JButton(new ImageIcon(lol));
        Dimension zol = bu.getPreferredSize();
        bu.setLayout(null);
        bu.setBounds(800, 780, (int) zol.getWidth(), (int) zol.getHeight());
        bu.setBorderPainted(false);
        bu.setFocusPainted(false);
        bu.setContentAreaFilled(false);
        bimg.add(bu);
        bu.setVisible(true);
        bu.addActionListener(actionEvent -> z.dispose()
        );

        BufferedImage tf = ImageIO.read(new File("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\images\\free.png"));
        JButton fr = new JButton(new ImageIcon(tf));
        Dimension molz = fr.getPreferredSize();
        fr.setLayout(null);
        fr.setBounds(800, 800, (int) molz.getWidth(), (int) molz.getHeight());
        fr.setBorderPainted(false);
        fr.setFocusPainted(false);
        fr.setContentAreaFilled(false);
        bimg.add(fr);
        fr.setVisible(true);
        fr.addActionListener(actionEvent -> z.dispose()
        );



    }



    public void setImages() throws IOException
    {
        boards.put("Gizah", ImageIO.read(new File("Gizah.png")));
        boards.put("Rhodos", ImageIO.read(new File("Rhodos.png")));
        boards.put("Babylon", ImageIO.read(new File("Babylon.png")));
        boards.put("Ephesos", ImageIO.read(new File("Ephesos.png")));
        boards.put("Olympia", ImageIO.read(new File("Olympia.png")));
        boards.put("Alexandria", ImageIO.read(new File("Alexandria.png")));
        boards.put("Halikarnassos", ImageIO.read(new File("Halikarnassos.png")));

        other.put("ore", ImageIO.read(new File("ore.png")));
        other.put("clay", ImageIO.read(new File("clay.png")));
        other.put("wood", ImageIO.read(new File("wood.png")));
        other.put("back", ImageIO.read(new File("back.png")));
        other.put("free", ImageIO.read(new File("free.png")));
        other.put("show", ImageIO.read(new File("show.png")));
        other.put("glass", ImageIO.read(new File("glass.png")));
        other.put("cloth", ImageIO.read(new File("cloth.png")));
        other.put("trash", ImageIO.read(new File("trash.png")));
        other.put("stone", ImageIO.read(new File("stone.png")));
        other.put("start", ImageIO.read(new File("start.png")));
        other.put("wood", ImageIO.read(new File("woodback.png")));
        other.put("goback", ImageIO.read(new File("goback.png")));
        other.put("pyramid", ImageIO.read(new File("pyramid.png")));
        other.put("onecoin", ImageIO.read(new File("onecoin.png")));
        other.put("papyrus", ImageIO.read(new File("papyrus.png")));
        other.put("mainlogo", ImageIO.read(new File("mainlogo.png")));
        other.put("threecoin", ImageIO.read(new File("threecoin.png")));
        other.put("military1", ImageIO.read(new File("military1.png")));
        other.put("military3", ImageIO.read(new File("military3.png")));
        other.put("military5", ImageIO.read(new File("military5.png")));
        other.put("militaryloss", ImageIO.read(new File("militaryloss.png")));

        ArrayList<Card> cards = new ArrayList<Card>();
        ArrayList<Card> red = new ArrayList<Card>();
        ArrayList<Card> blue = new ArrayList<Card>();
        ArrayList<Card> gray = new ArrayList<Card>();
        ArrayList<Card> brown = new ArrayList<Card>();
        ArrayList<Card> green = new ArrayList<Card>();
        ArrayList<Card> purple = new ArrayList<Card>();
        ArrayList<Card> yellow = new ArrayList<Card>();

        images.put("blue", new TreeMap<String, BufferedImage>());
        images.put("brown", new TreeMap<String, BufferedImage>());
        images.put("green", new TreeMap<String, BufferedImage>());
        images.put("gray", new TreeMap<String, BufferedImage>());
        images.put("red", new TreeMap<String, BufferedImage>());
        images.put("purple", new TreeMap<String, BufferedImage>());
        images.put("yellow", new TreeMap<String, BufferedImage>());

        for (int i = 0; i < 3; i++) {
            cards = board.getAgeDeck(i);
            for (Card card : cards) {
                if (card.getColor().equals("blue"))
                    blue.add(card);
                else if (card.getColor().equals("brown"))
                    brown.add(card);
                else if (card.getColor().equals("green"))
                    green.add(card);
                else if (card.getColor().equals("gray"))
                    gray.add(card);
                else if (card.getColor().equals("red"))
                    red.add(card);
                else if (card.getColor().equals("purple"))
                    purple.add(card);
                else
                    yellow.add(card);
            }


            for (int x = 0; x < blue.size(); x++)
                images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName() + ".png")));
            for (int x = 0; x < brown.size(); x++)
                images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName() + ".png")));
            for (int x = 0; x < green.size(); x++)
                images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName() + ".png")));
            for (int x = 0; x < gray.size(); x++)
                images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName() + ".png")));
            for (int x = 0; x < red.size(); x++)
                images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName() + ".png")));
            for (int x = 0; i < purple.size(); i++)
                images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName() + ".png")));
            for (int x = 0; i < yellow.size(); i++)
                images.get("blue").put(blue.get(x).getName(), ImageIO.read(new File(blue.get(x).getName() + ".png")));

            blue.clear();
            brown.clear();
            green.clear();
            gray.clear();
            red.clear();
            purple.clear();
            yellow.clear();
        }
    }

    public int[] positions()
    {
        int length = board.playerHand(mp).size();
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

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

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
                    try {
                        cardAction(index);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
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

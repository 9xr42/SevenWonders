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
        setStart();
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

        JLabel bimg = new JLabel(new ImageIcon("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\images\\startBack.png"));
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
        tx2.setBounds(730, 700, size3.width, size3.height);
        tx2.setVisible(true);


        BufferedImage buttonIcon = ImageIO.read(new File("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\images\\play.png"));
        JButton button = new JButton(new ImageIcon(buttonIcon));
        button.setBounds(830, 750, 200, 100);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        bimg.add(button);
        button.setVisible(true);

        button.addActionListener(actionEvent -> {
            try {
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

        JLabel bimg = new JLabel(new ImageIcon("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\images\\woodBack.jpg"));
        //Dimension b = bimg.getPreferredSize();
        bimg.setSize(3840, 2000);
        f.add(bimg);
        bimg.setVisible(true);

        JPanel s2 = new JPanel();
        s2.setBackground(Color.WHITE);
        bimg.add(s2);
        s2.setVisible(true);

        JLabel bim = new JLabel(new ImageIcon("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\images\\mainlogo.png"));
        Dimension bi = bim.getMinimumSize();
        bim.setBounds(650, 0, (int) bi.getWidth(), (int) bi.getHeight());
        bimg.add(bim);
        bim.setVisible(true);

        BufferedImage show = ImageIO.read(new File("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\images\\show.png"));
        JButton right = new JButton(new ImageIcon(show));
        Dimension x = right.getPreferredSize();
        right.setBounds(200, 400, (int) x.getWidth(), (int) x.getHeight());
        right.setBorderPainted(false);
        right.setFocusPainted(false);
        right.setContentAreaFilled(false);
        bimg.add(right);
        right.setVisible(true);
        right.addActionListener(actionEvent -> {
            try {
                player1();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    public void player1() throws IOException
    {
        JFrame p1 = new JFrame("Player 1 Cards");
        p1.setSize(3840, 2160);
        p1.getContentPane().setBackground(Color.GRAY);
        p1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        p1.setVisible(true);

        JPanel pan1 = new JPanel();
        pan1.setBackground(Color.WHITE);
        p1.add(pan1);
        pan1.setLayout(null);
        pan1.setVisible(true);

        BufferedImage pre = ImageIO.read(new File("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\images\\goback.png"));
        JButton back = new JButton(new ImageIcon(pre));
        Dimension x = back.getPreferredSize();
        back.setBounds(700, 670, (int) x.getWidth(), (int) x.getHeight());
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

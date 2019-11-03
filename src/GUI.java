import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

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

        JLabel bimg = new JLabel(new ImageIcon("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\src\\wholeback.png"));
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


        BufferedImage buttonIcon = ImageIO.read(new File("C:\\Users\\aggar\\IdeaProjects\\SevenWondersMyVersion\\src\\start.png"));
        JButton button = new JButton(new ImageIcon(buttonIcon));
        button.setBounds(830, 750, 200, 100);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        bimg.add(button);
        button.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setGameFrame();
            }
        });



    }

    public void setGameFrame()
    {
        JFrame f = new JFrame("Seven Wonders: The Game");
        Dimension startSize = f.getMaximumSize();
        f.setSize(startSize);
        f.getContentPane().setBackground(Color.GRAY);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);



    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {

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
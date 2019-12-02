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

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class UnoGame extends JFrame implements MouseListener{
		
	private Board board;
	private JPanel panel;
	private BufferedImage[][] cards;
	
	public static void main(String[] args) throws IOException
	{
		UnoGame uno = new UnoGame();
		//uno.playGame();
	}
	
	public UnoGame() throws IOException
	{
		super("Uno");
		board = new Board();
		cards = new BufferedImage[5][16];
		for (int i = 0; i < 13; i++)
			cards[0][i] = ImageIO.read(new File("Red"+i+".png"));
		for (int i = 0; i < 13; i++)
			cards[1][i] = ImageIO.read(new File("Blue"+i+".png"));
		for (int i = 0; i < 13; i++)
			cards[2][i] = ImageIO.read(new File("Green"+i+".png"));
		for (int i = 0; i < 13; i++)
			cards[3][i] = ImageIO.read(new File("Yellow"+i+".png"));
		for (int i = 13; i < 16; i++)
			cards[4][i] = ImageIO.read(new File("Black"+i+".png"));

	//	this.setSize(1900, 1080); 
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
	    
		
		panel = new JPanel() {
			
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				
				
			//	g.fillRect(0, 0, 100, 100);
				Font font = new Font("Verdana", Font.BOLD, 14);
				g.setFont(font);
				if(board.getReverse()==false)
				{
					g.drawString("Direction: Clockwise", 710, 405);
				}
				else
				{
					g.drawString("Direction: Counter-clockwise", 680, 405);
				}
				ArrayList<Card> hand  = board.playerHand(board.getMainPlayer());
				int count = 1;
   			    for (int i=0; i<hand.size(); i++)
				{
   			    	//try{ 
   						//BufferedImage img1 = ImageIO.read((new File(board.playerHand(board.getMainPlayer()).get(i).toString()+".png")));
   						//if(i%2==1)
   					g.drawImage(cards[hand.get(i).getColorNum()][hand.get(i).getFaceNum()], 750-(hand.size()/2)*100+i*100, 800, 100, 150, null);
   							//g.drawImage(img1, getWidth()/2-(i+1)*50, 800, 100, 150, null);
   						//g.drawImage(img1, getWidth()/2-(hand.size()/2)*100+i*100, 800, 100, 150, null);
   						//else
   							//g.drawImage(cards[hand.get(i).getColorNum()][hand.get(i).getFaceNum()], getWidth()/2+(i)*50, 800, 100, 150, null);
   							//g.drawImage(img1, getWidth()/2+(i)*50, 800, 100, 150, null);
   						
   					//}
   					//catch (Exception e)
   					//{
   					//	System.out.println("Error Loading Images: " + e.getMessage());
   					//}
   					g.drawString("Suggested: ", 515, 445);
   					if((hand.get(i).getColor().equals(board.getColor())&&hand.get(i).getFace().equals("10"))||hand.get(i).getFace().equals(board.getCenter().getFace())&&hand.get(i).getFace().equals("10"))
   					{
   						g.drawString(hand.get(i).getColor()+" Plus 2", 515, 445+count*20);
   						count++;
   					}
   					else if((hand.get(i).getColor().equals(board.getColor())&&hand.get(i).getFace().equals("11"))||hand.get(i).getFace().equals(board.getCenter().getFace())&&hand.get(i).getFace().equals("11"))
   					{
   						g.drawString(hand.get(i).getColor()+" Skip", 515, 445+count*20);
   						count++;
   					}
   					else if((hand.get(i).getColor().equals(board.getColor())&&hand.get(i).getFace().equals("12"))||hand.get(i).getFace().equals(board.getCenter().getFace())&&hand.get(i).getFace().equals("12"))
   					{
   						g.drawString(hand.get(i).getColor()+" Reverse", 515, 445+count*20);
   						count++;
   					}
   					else if(hand.get(i).getFace().equals("13")&&board.wildFourValid())
   					{
   						g.drawString("WildDraw4", 515, 445+count*20);
   						count++;
   					}
   					else if(hand.get(i).getFace().equals("14"))
   					{
   						g.drawString("Wild Card", 515, 445+count*20);
   						count++;
   					}
   					else if(hand.get(i).getColor().equals(board.getColor()))
   					{
   						g.drawString(hand.get(i).toString(), 515, 445+count*20);
   						count++;
   					}
   					else if(hand.get(i).getFace().equals(board.getCenter().getFace()))
   					{
   						g.drawString(hand.get(i).toString(), 515, 445+count*20);
   						count++;
   					}
				}
   			    if(count==1)
   			    	g.drawString("Draw", 515, 465);
   			    //Font font = new Font("Verdana", Font.BOLD, 14);
   			    int player = (board.getMainPlayer()%4)+1;
   			    g.setFont(new Font("Verdana", Font.BOLD, 14));
   			    g.drawString("Player "+ player,746,750);
   			    if(hand.size()==1)
   			    {
   			    	g.setFont(new Font("Verdana", Font.BOLD, 20));
   			    	g.drawString("Uno!", 748, 730);
   			    }
   			    	
   			    //for(int i = hand.size()/2; i<hand.size(); i++)
   			   // {
   			    	//try{ 
   						//BufferedImage img1 = ImageIO.read((new File(board.playerHand(board.getMainPlayer()).get(i).toString()+".png")));
   						//if(i%2==1)
   					//g.drawImage(cards[hand.get(i).getColorNum()][hand.get(i).getFaceNum()], getWidth()/2+(i-3)*100, 800, 100, 150, null);
   							//g.drawImage(img1, getWidth()/2-(i+1)*50, 800, 100, 150, null);
   						//else
   							//g.drawImage(cards[hand.get(i).getColorNum()][hand.get(i).getFaceNum()], getWidth()/2+(i)*50, 800, 100, 150, null);
   							//g.drawImage(img1, getWidth()/2+(i)*50, 800, 100, 150, null);
   						//g.drawImage(img1, getWidth()/2+(i-3)*100, 800, 100, 150, null);
   						
   					//}
   					//catch (Exception e)
   					//{
   					//	System.out.println("Error Loading Images: " + e.getMessage());
   					//}
   			    //}
				
				//g.drawImage(cards[0][15], 750, 100, 130, 180, null);
				//g.fillRect(100, 100, 100, 100);
				
				
				try{ //sets up center
					BufferedImage img1 = ImageIO.read((new File(board.getCenter().toString()+".png")));
					//g.drawImage(cards[board.getCenter().getColorNum()][board.getCenter().getFaceNum()], 775, 425, 100, 150, null);
					g.drawImage(img1, 800, 425, 100, 150, null);
					
					//img1 = ImageIO.read((new File("Black15.png")));
					g.drawImage(cards[4][15], 675, 425, 100, 150, null);
				}
				catch (Exception e)
				{
						System.out.println("Error Loading Images: " + e.getMessage());
				}
				
				for(int x=0; x<board.playerHand(board.getMainPlayer()+1).size();x++)
				{
					//try{ 
						//BufferedImage img1 = ImageIO.read((new File("Black15.png")));

   					g.drawImage(cards[4][15], 50, 100+(x+1)*50, 100, 150, null);
   						
						//g2d.drawImage(img1, 50, 150+x*150, 100, 150, null);
					///}
					//catch (Exception e)
					//{
					//	System.out.println("Error Loading Images: " + e.getMessage());
					//}
				}
				if(player==4)
					player=1;
				else
					player++;
				g.setFont(new Font("Verdana", Font.BOLD, 14));
				g.drawString("Player "+ player,200,500);
   			    if(board.playerHand((board.getMainPlayer()+1)%4).size()==1)
   			    {
   			    	g.setFont(new Font("Verdana", Font.BOLD, 20));
   			    	g.drawString("Uno!", 200, 480);
   			    }
   			    
				for(int x=0; x<board.playerHand((board.getMainPlayer()+2)%4).size();x++)
				{
					//try{ 
						//BufferedImage img1 = ImageIO.read((new File("Black15.png")));
						if(x%2==1)
   							g.drawImage(cards[4][15], getWidth()/2-(x+1)*50, 50, 100, 150, null);
   						else
   							g.drawImage(cards[4][15], getWidth()/2+(x)*50, 50, 100, 150, null);
					//}
					//catch (Exception e)
					//{
					//	System.out.println("Error Loading Images: " + e.getMessage());
					//}
				}
   			    
				//g.drawString("Player Three", 450, 225);
				if(player==4)
					player=1;
				else
					player++;
				g.setFont(new Font("Verdana", Font.BOLD, 14));
				g.drawString("Player "+ player,746,250);
				if(board.playerHand((board.getMainPlayer()+2)%4).size()==1)
   			    {
   			    	g.setFont(new Font("Verdana", Font.BOLD, 20));
   			    	g.drawString("Uno!", 748, 270);
   			    }
				
				for(int x=0; x<board.playerHand((board.getMainPlayer()+3)%4).size();x++)
				{
					//try{ 
						//BufferedImage img1 = ImageIO.read((new File("Black15.png")));

					g.drawImage(cards[4][15], 1350, 100+(x+1)*50, 100, 150, null);
							        
						//g2d.drawImage(img1, 850, 150+x*150, 100, 150, null);
					//}
					//catch (Exception e)
					//{
					//	System.out.println("Error Loading Images: " + e.getMessage());
					// }
				}
				if(player==4)
					player=1;
				else
					player++;
				g.setFont(new Font("Verdana", Font.BOLD, 14));
				g.drawString("Player "+ player,1250,500);
				if(board.playerHand((board.getMainPlayer()+3)%4).size()==1)
   			    {
   			    	g.setFont(new Font("Verdana", Font.BOLD, 20));
   			    	g.drawString("Uno!", 1250, 480);
   			    }
				
				if(board.getColor().equals("Black"))
				{
					g.setColor(Color.RED);
					g.fillRect(650, 600, 50, 50);
					g.setColor(Color.YELLOW);
					g.fillRect(720, 600, 50, 50);
					g.setColor(Color.GREEN);
					g.fillRect(790, 600, 50, 50);
					g.setColor(Color.BLUE);
					g.fillRect(860, 600, 50, 50);
				}
				
				if(board.getColor().equals("Red"))
				{
					g.setColor(Color.RED);
					g.fillRect(920, 475, 50, 50);
				}
				else if(board.getColor().equals("Blue"))
				{
					g.setColor(Color.BLUE);
					g.fillRect(920, 475, 50, 50);
				}
				else if(board.getColor().equals("Green"))
				{
					g.setColor(Color.GREEN);
					g.fillRect(920, 475, 50, 50);
				}
				else if(board.getColor().equals("Yellow"))
				{
					g.setColor(Color.YELLOW);
					g.fillRect(920, 475, 50, 50);
				}
				
				if(board.playerHand(0).size()==0)
			    {
					g.setColor(Color.BLACK);
			    	g.fillRect(200, 200, 1100, 600);
			    	g.setColor(Color.WHITE);
			    	g.setFont(new Font("Verdana", Font.BOLD, 100));
			    	g.drawString("Player 1 Wins!", 350, 500);
			    }
				else if(board.playerHand(1).size()==0)
				{
					g.setColor(Color.BLACK);
			    	g.fillRect(200, 200, 1100, 600);
			    	g.setColor(Color.WHITE);
			    	g.setFont(new Font("Verdana", Font.BOLD, 100));
  		    		g.drawString("Player 2 Wins!", 350, 500);
			    }
				else if(board.playerHand(2).size()==0)
				{
					g.setColor(Color.BLACK);
			    	g.fillRect(200, 200, 1100, 600);
			    	g.setColor(Color.WHITE);
			    	g.setFont(new Font("Verdana", Font.BOLD, 100));
			    	g.drawString("Player 3 Wins!", 350, 500);
				}
				else if(board.playerHand(3).size()==0)
				{
					g.setColor(Color.BLACK);
			    	g.fillRect(200, 200, 1100, 600);
			    	g.setColor(Color.WHITE);
			    	g.setFont(new Font("Verdana", Font.BOLD, 100));
			    	g.drawString("Player 4 Wins!", 350, 500);
			    }
				
				
			}
		};
		
		panel.addMouseListener(this);
		
		panel.setPreferredSize(new Dimension(1500, 1000));
	    panel.setBackground(Color.lightGray);
		//panel.setBackground(Color.ORANGE);
		
		add(panel);
		setContentPane(panel);
		pack();
		
		setLocationRelativeTo(null);
	    setVisible(true); 
	}
	
	//public void playGame()
	//{
		//board = new Board();
		//int x= 0;
		
//		JFrame frame = new JFrame("Uno"); 
//      frame.setSize(1500, 1000); 
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
//	    JPanel panel = new UnoGraphics();
//	    panel.setBackground(Color.WHITE); 
//	    frame.getContentPane().add(panel, BorderLayout.CENTER); 
//	    frame.setVisible(true); 
//	
		/*boolean reverse = false;
		int temp = 0;
	    
		while(board.playerHand(1).size()>0&&board.playerHand(2).size()>0
				&&board.playerHand(3).size()>0&&board.playerHand(4).size()>0)
		{
			if(reverse==false)
			{
				temp=board.playerTurn(x);
				if(temp==-1)
					reverse=true;
				x+=temp;
				x%=4;
			}
			
			else
			{
				temp=board.playerTurn(x);
				if(temp==-1)
					reverse=false;
				x+=-1*temp;
				if(x<0)
				{
					x+=temp*2;
				}
				x%=4;
			}
		}*/
	//}
	
	
	
	public ArrayList<Card> getPlayerHand(int x)
	{
		return board.playerHand(x);
	}
	
	public int getNumCards(int x)
	{
		return board.playerHandSize(x);
	}
	
	public void mouseReleased(MouseEvent e) {
		if(!(board.playerHand(board.getMainPlayer()).size()==0||
				board.playerHand((board.getMainPlayer()+1)%4).size()==0||
				board.playerHand((board.getMainPlayer()+2)%4).size()==0||
				board.playerHand((board.getMainPlayer()+3)%4).size()==0))
		{
			int x = e.getX();
			int y = e.getY();
			
			int size = board.playerHand(board.getMainPlayer()).size();
			int index = 0;
			
			if(board.getCenter().getColor().equals("Black")&&y<=650&&y>=600)
			{
				if(x<=700&&x>=650)
				{
					board.setColor("Red");
					if(board.getCenter().getFace().equals("13"))
					{
						board.addPlayerCount();
						board.addPlayerCount();
					}
					else
						board.addPlayerCount();
				}
				else if(x<=770&&x>=720)
				{
					board.setColor("Yellow");
					if(board.getCenter().getFace().equals("13")&&board.getReverse()==false)
					{
						board.addPlayerCount();
						board.addPlayerCount();
					}
					else if(board.getCenter().getFace().equals("13")&&board.getReverse()==true)
					{
						board.subtractPlayerCount();
						board.subtractPlayerCount();
					}
					else if(board.getReverse()==false)
						board.addPlayerCount();
					else if(board.getReverse()==true)
						board.subtractPlayerCount();
				}
				else if(x<=840&&x>=790)
				{
					board.setColor("Green");
					if(board.getCenter().getFace().equals("13"))
					{
						board.addPlayerCount();
						board.addPlayerCount();
					}
					else
						board.addPlayerCount();
				}
				else if(x>=860&&x<=940)
				{
					board.setColor("Blue");
					if(board.getCenter().getFace().equals("13"))
					{
						board.addPlayerCount();
						board.addPlayerCount();
					}
					else
						board.addPlayerCount();
				}
					
				
				repaint();
			}
			else if(board.playerSuggested()==true && x>=650 && x<=750 && y>=425 && y<=575)
			{
				board.drawCard(board.getMainPlayer());
				if(board.playerSuggested())
				{
					board.addPlayerCount();
				}
				repaint();
			}
			else if(x>=750-(size/2)*100 && x<= 750+size*100 && y<=950 && y>=800)
			{
				//int temp = 750-(size/2)*100 - (750+(size-4)*100);
				int[] positions = new int[size+1];
				for(int i = 0; i<positions.length; i++)
				{ 
					positions[i] = 750-(size/2)*100+i*100;
					if((x-positions[i])<0 && (x-positions[i])>-100)
						index = i-1;
				}
				// ( beginning x - end x ) / board.playerHand(board.getMainPlayer()).size()
				//find which part x is in
				//if that card matches anything w center card or is wild card, call board method
				
				if(!(index==-1)&&(board.playerHand(board.getMainPlayer()).get(index).getColor().equals(board.getColor())
						||board.playerHand(board.getMainPlayer()).get(index).getFace().equals(board.getCenter().getFace())
						||board.playerHand(board.getMainPlayer()).get(index).getFace().equals("14")))
				{
					if(board.playerHand(board.getMainPlayer()).get(index).getFace().equals("12")&&board.getReverse()==true)
					{
						board.reverse();
						//board.reversePlayerTurn(index);
						board.playerTurn(index);
						repaint();
					}
					else if(board.playerHand(board.getMainPlayer()).get(index).getFace().equals("12")&&board.getReverse()==false)
					{
						board.reverse();
						//board.playerTurn(index);
						board.reversePlayerTurn(index);
						repaint();
					}
					else if(board.getReverse()==false)
						board.playerTurn(index);
					else if(board.getReverse()==true)
						board.reversePlayerTurn(index);
				}
				else if(board.playerHand(board.getMainPlayer()).get(index).getFace().equals("13")&&board.wildFourValid())
				{
					if(board.getReverse()==false)
						board.playerTurn(index);
					else if(board.getReverse()==true)
						board.reversePlayerTurn(index);
				}
				repaint();
			}
		}
		
		
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

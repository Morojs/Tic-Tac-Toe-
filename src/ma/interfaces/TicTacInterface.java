package ma.interfaces;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ma.classes.Client;
public class TicTacInterface extends JPanel {

		private char symbole = 'X';
		private JButton[] buttons = new JButton[9];
		private Client _client;
	  
		public TicTacInterface() throws UnknownHostException, IOException {
			Client.matrice=new char[3][3];
			_client=new Client(InetAddress.getLocalHost(),4040);
			for (int l = 0; l < Client.matrice.length; l++) {
				for (int c = 0; c < Client.matrice.length; c++)
					Client.matrice[l][c]='?';
			}
			setLayout(new GridLayout(3,3));
			initializeButtons();
			
		}
		// m�thode utilis�e pour cr�er les 9 boutons
		
		public void initializeButtons()
	    {
		
		   
		   int c=0,l=0;
	        for(int i = 0; i <= 8; i++)
	        {
	        	
	            buttons[i] = new JButton();
	            buttons[i].setText("?");
	            buttons[i].setBackground(Color.black);
	            buttons[i].setForeground(Color.white);
	            if(i==3 || i==6) {
	            	c=0; 
	            	++l;
	            }
	            buttons[i].putClientProperty("matrice",Integer.toString(l)+","+Integer.toString(c++)); // NOI18N
	            buttons[i].addActionListener(new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton buttonClicked = (JButton) e.getSource(); //get the particular button that was clicked
				        buttonClicked.setText(String.valueOf(symbole));
				        String[] parts = ((String) buttonClicked.getClientProperty("matrice")).split(",");
				        Client.matrice[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])]=symbole;
				        try {
				        	_client.play();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				        
					}
				});
	            add(buttons[i]); // ajouter button dans JPanel        
	        }
	    }
		
	
		// m�thode utilis�e pour r�initialiser les boutons
		// pour que vous puissiez jouer � nouveau
		private void resetButtons() {
			for(int i =0;i<9;i++) {
				  buttons[i].setText("?");
				  buttons[i].setBackground(Color.white);
				  
			  }	
		}

		// v�rification designe
		
		public boolean checkDraw() {
			boolean full = true;
			for(int i = 0 ; i<9;i++) {
				if(buttons[i].getText().charAt(0) == '?') {
					full = false;
				}
			}
			return full;
		}
		
		public static void main(String[] args) throws UnknownHostException, IOException {
			JFrame window = new JFrame("Tic Tac Toe");
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        window.getContentPane().add(new TicTacInterface()); // adds the data
	        window.setBounds(500,500,500,500); // area
	        window.setVisible(true); // show the window
	        window.setLocationRelativeTo(null); // center the window
		}

}
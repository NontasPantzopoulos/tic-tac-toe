package main.tictactoe.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import main.tictactoe.model.GameEngine;
import main.tictactoe.model.Player;
import main.tictactoe.utils.SpringUtilities;

@SuppressWarnings("serial")
public class HallOfFame extends JPanel{
	private GameEngine ge;

	public HallOfFame(GameEngine ge) {
		this.setGe(ge);
		initComponents();
	}
	
	
	private void initComponents() {
		this.setLayout(new SpringLayout());
		this.setBackground(Color.YELLOW);
		//this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		JLabel title= myTitleLabel("HallOfFame");
		this.add(new JLabel(""));
		this.add(title);
		this.add(new JLabel(""));
		
		Player[] topPlayers = ge.getPlayerRoster().findHallOfFame(10);
		for(int i=0;i<topPlayers.length;i++) {
			if(topPlayers[i]!=null) {
				Player p = topPlayers[i];
				JLabel num=myLabel((i+1)+".");
				JLabel playerLabel = myLabel(p.getName());
				JLabel score=myLabel(String.valueOf(p.getScore()));
				//playerLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
//				playerLabel.setFont(new Font(playerLabel.getName(), Font.BOLD, 28));
//				playerLabel.setPreferredSize(new Dimension(400,60));
//				playerLabel.setAlignmentX(LEFT_ALIGNMENT);
				this.add(num);
				this.add(playerLabel);
				this.add(score);
				//this.add(Box.createRigidArea(new Dimension(5, 0)));
			}else {
				JLabel num=myLabel((i+1)+".");
				JLabel text=myLabel("---");
//				blankLabel.setFont(new Font(blankLabel.getName(), Font.BOLD, 28));
//				blankLabel.setPreferredSize(new Dimension(400,60));
				this.add(num);
				this.add(text);
				this.add(new JLabel(""));
			}
			
		}
		
		SpringUtilities.makeGrid(this,
                11, 3, //rows, cols
                20, 20, //initialX, initialY
                5, 5);//xPad, yPad
	}
	
	private JLabel myTitleLabel(String text) {
		JLabel label=new JLabel(text);
		label.setFont(new Font(label.getName(), Font.BOLD, 28));
		//label.setPreferredSize(new Dimension(500,50));
		//label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		return label;
	}
	
	private JLabel myLabel(String text) {
		JLabel label=new JLabel(text);
		label.setFont(new Font(label.getName(), Font.BOLD, 28));
		//label.setPreferredSize(new Dimension(350,50));
		//label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		return label;
	}
	private JLabel myNumberLabel(String text) {
		JLabel label=new JLabel(text);
		label.setFont(new Font(label.getName(), Font.BOLD, 28));
		//label.setPreferredSize(new Dimension(80,50));
		label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		return label;
	}

	public GameEngine getGe() {
		return ge;
	}


	public void setGe(GameEngine ge) {
		this.ge = ge;
	}


	
	
	
	

}

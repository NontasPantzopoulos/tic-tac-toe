package main.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.tictactoe.controller.PlayerPanelController;
import main.tictactoe.model.GameEngine;
import main.tictactoe.model.Player;
import main.tictactoe.model.enums.Signs;
import main.tictactoe.utils.GeneralUtils;

@SuppressWarnings("serial")
public class PlayerPanel extends AbstractPanel implements InterfacePanel {
	private JPanel buttonsPanel;
	private JPanel dataPanel;
	private JPanel parentPanel;
	private PlayerPanelController playerPanelController;
	private Signs sign;
	

	public PlayerPanel(MainWindow mainWindow,JPanel parentPanel,GameEngine ge,Signs sign) {
		super(ge,mainWindow);
		this.playerPanelController = new PlayerPanelController(super.getMainWindow(),this,super.getGe());
		this.sign=sign;
		initComponents();
	}
	
	@Override
	public void initComponents() {
		this.addMouseListener(playerPanelController);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.GREEN);
		
		this.buttonsPanel = new JPanel();
		this.buttonsPanel.setBackground(Color.GREEN);
		this.buttonsPanel.add(createButton("Start Game"));
		this.buttonsPanel.add(createButton("SelectPlayer"));
		
		this.dataPanel = new JPanel();
		this.dataPanel.setBackground(Color.GREEN);
		this.dataPanel.setLayout(new BoxLayout(this.dataPanel, BoxLayout.Y_AXIS));
		JLabel signLabel = new JLabel(sign.toString());
		signLabel.setFont(new Font(signLabel.getName(), Font.PLAIN, 100));
		signLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.dataPanel.add(signLabel);
		this.add(buttonsPanel,BorderLayout.NORTH);
		this.add(dataPanel,BorderLayout.CENTER);
		GeneralUtils.log("PlayerPanel", "New PlayerPanel Created");
		
	}
	
	private JButton createButton(String text) {
		if(text.equals("Start Game") && !this.ge.readyToPlay()) {
			JButton b = new JButton(text);
			b.setName(text);
			b.setActionCommand(text);
			b.addActionListener(playerPanelController);
			b.setPreferredSize(new Dimension(110,20));
			b.setEnabled(false);
			return b;
		}
		JButton b = new JButton(text);
		b.setName(text);
		b.setActionCommand(text);
		b.addActionListener(playerPanelController);
		b.setPreferredSize(new Dimension(110,20));
		return b;
	}
	
	
	public void selectPlayer() throws CloneNotSupportedException {
		this.dataPanel.removeAll();
		JLabel signLabel = new JLabel(sign.toString());
		signLabel.setFont(new Font(signLabel.getName(), Font.PLAIN, 100));
		signLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.dataPanel.add(signLabel);
		
		Player p =null;
		String[] allPlayers = (String[]) ge.getPlayerRoster().findPlayerNames().toArray(new String[0]);
		//Show Player Selection Dialog
		String selPlayer = (String) JOptionPane.showInputDialog(parentPanel, 
			"Choose a Player...",
			"Player selection",
			JOptionPane.PLAIN_MESSAGE,
			null,
			allPlayers,
			null
			);
		
		if(selPlayer!=null && sign==Signs.X) {
			if(ge.getPlayerO()!=null) {
				if(selPlayer.equals(ge.getPlayerO().getName())) {
					JOptionPane.showMessageDialog(null,selPlayer+" is already selected ","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			p = (Player) ge.getPlayerRoster().findPlayerByName(selPlayer);
//			p = (Player) ge.getPlayerRoster().findPlayerByName(selPlayer).clone();
//			p.setDraws(0);
//			p.setLosses(0);
//			p.setWins(0);
//			p.setScore(0);
			ge.setPlayerX(p);
			GeneralUtils.log("PlayerPanel", selPlayer+" selected as X");
		
		}
		if(selPlayer!=null && sign==Signs.O) {
			
			if(ge.getPlayerX()!=null) {
				if(selPlayer.equals(ge.getPlayerX().getName())) {
					JOptionPane.showMessageDialog(null,selPlayer+" is already selected ","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			p = (Player) ge.getPlayerRoster().findPlayerByName(selPlayer);
//			p = (Player) ge.getPlayerRoster().findPlayerByName(selPlayer).clone();
//			p.setDraws(0);
//			p.setLosses(0);
//			p.setWins(0);
//			p.setScore(0);
			ge.setPlayerO(p);
			GeneralUtils.log("PlayerPanel", selPlayer+" selected as O");
		
		}
		
		if(selPlayer==null) {
			return;
		}
		JLabel selPlayerLabel =  new JLabel(selPlayer);
		selPlayerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel selPlayerTotal = new JLabel("Total: "+ge.getPlayerRoster().findPlayerByName(selPlayer).getTotalGames());
		//selPlayerTotal.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel selPlayerWon = new JLabel();
		if(ge.getPlayerRoster().findPlayerByName(selPlayer).getTotalGames()>0) {
			selPlayerWon.setText("Won: "+(100*ge.getPlayerRoster().findPlayerByName(selPlayer).getWins()/ge.getPlayerRoster().findPlayerByName(selPlayer).getTotalGames())+"%");
		}else{
			selPlayerWon.setText("Won: 0%");
		}
		//selPlayerWon.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel selPlayerLost = new JLabel();
		if(ge.getPlayerRoster().findPlayerByName(selPlayer).getTotalGames()>0) {
			selPlayerLost.setText("Lost: "+(100*ge.getPlayerRoster().findPlayerByName(selPlayer).getLosses()/ge.getPlayerRoster().findPlayerByName(selPlayer).getTotalGames())+"%");
		}else{
			selPlayerLost.setText("Lost: 0%");
		}
		
		//selPlayerLost.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel selPlayerTotalScore = new JLabel("Total score: "+ge.getPlayerRoster().findPlayerByName(selPlayer).getScore());
		//selPlayerTotalScore.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel selPlayerRecentScore = new JLabel("Recent score: "+p.getScore());
		selPlayerRecentScore.setAlignmentX(LEFT_ALIGNMENT);
		JLabel selPlayerBestGames = new JLabel("Best Games");
		this.dataPanel.add(selPlayerLabel);
		this.dataPanel.add(new JLabel(" "));
		this.dataPanel.add(selPlayerTotal);
		this.dataPanel.add(selPlayerWon);
		this.dataPanel.add(selPlayerLost);
		this.dataPanel.add(new JLabel(" "));
		this.dataPanel.add(selPlayerTotalScore);
		this.dataPanel.add(selPlayerRecentScore);
		this.dataPanel.add(new JLabel(" "));
		this.dataPanel.add(selPlayerBestGames);
		
		//selPlayerBestGames.setAlignmentX(Component.LEFT_ALIGNMENT);
		for(int i=0;i<p.getPlayersBestGames().length;i++) {
			if(p.getPlayersBestGames()[i]!=null) {
				JLabel bestLabel = new JLabel(p.getPlayersBestGames()[i].getPlayerX().getName()+" vs "+p.getPlayersBestGames()[i].getPlayerO().getName());
				this.dataPanel.add(bestLabel);
			}
		}
		
		
		
		this.dataPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.dataPanel.repaint();
		this.dataPanel.revalidate();
		
		if(ge.readyToPlay()) {
//			parentFrame.showCard(MainWindow.getGameboard());
			mainWindow.getContentsLeftPanel().getButtonsPanel().getComponent(0).setEnabled(true);
			mainWindow.getContentsRightPanel().getButtonsPanel().getComponent(0).setEnabled(true);
		}
		
	}

	public JPanel getPanel() {
		return this;
	}

	public JPanel getButtonsPanel() {
		return buttonsPanel;
	}

	public void setButtonsPanel(JPanel buttonsPanel) {
		this.buttonsPanel = buttonsPanel;
	}

	public JPanel getDataPanel() {
		return dataPanel;
	}

	public void setDataPanel(JPanel dataPanel) {
		this.dataPanel = dataPanel;
	}

	public JPanel getParentPanel() {
		return parentPanel;
	}

	public void setParentPanel(JPanel parentPanel) {
		this.parentPanel = parentPanel;
	}

	public GameEngine getGe() {
		return ge;
	}

	public void setGe(GameEngine ge) {
		this.ge = ge;
	}

	public PlayerPanelController getPlayerPanelController() {
		return playerPanelController;
	}

	public void setPlayerPanelController(PlayerPanelController playerPanelController) {
		this.playerPanelController = playerPanelController;
	}

	public Signs getSign() {
		return sign;
	}

	public void setSign(Signs sign) {
		this.sign = sign;
	}

	
	
	
	
}

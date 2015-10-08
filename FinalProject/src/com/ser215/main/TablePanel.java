package com.ser215.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class TablePanel extends JPanel {
	
	final int[] DEALER_X = {50, 100, 150, 200, 250, 300, 350, 400, 450};
	final int[] PLAYER_X = {50, 100, 150, 200, 250, 300, 350, 400, 450};
	final int DEALER_Y = 44;
	final int PLAYER_Y = 232;
	private URL backUrl;
	private Image cardBack;
	
	public TablePanel() {
		setBackground(new Color(0, 153, 51));
		
		@SuppressWarnings("rawtypes")
		Class cls = this.getClass();
		backUrl = cls.getResource("/images/back.jpg");
		this.cardBack = Toolkit.getDefaultToolkit().getImage(backUrl);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		GameState state = BlackJack.gameState;
		
		//if (state == GameState.PLAYER_ACT || state == GameState.DEALER_ACT) {
		if (state != GameState.INIT && state != GameState.BETTING) {
			int dealerX = 0;
			int playerX = 0;
			
			for (Card card : Dealer.getDealerHand().getCards()) {
				if (dealerX < Hand.CARD_LIMIT) {
					Image cardImg = card.getImg();
					g.drawImage(cardImg, DEALER_X[dealerX], DEALER_Y, null);
					dealerX += 1;
				}
			}
			
			if (!Dealer.getDealerHand().isShowHoleCard()) {
				g.drawImage(cardBack, DEALER_X[1], DEALER_Y, null);
			}
			
			for (Card card : Player.getPlayerHand1().getCards()) {
				if (playerX < Hand.CARD_LIMIT) {
					Image cardImg = card.getImg();
					g.drawImage(cardImg, PLAYER_X[playerX], PLAYER_Y, null);
					playerX += 1;
				}
			}
		}
		
		/*if (state == GameState.PLAYER_BUST) {
			
		}*/
		repaint();
	}
}
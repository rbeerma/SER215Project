package com.ser215.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class TablePanel extends JPanel {
	
	final int[] DEALER_X = {50, 100, 150, 200, 250, 300, 350, 400, 450};
	final int[] PLAYER_X = {50, 100, 150, 200, 250, 300, 350, 400, 450};
	final int DEALER_Y = 44;
	final int PLAYER_Y = 232;
	
	BufferedImage cardBack;
	
	public TablePanel() {
		setBackground(new Color(0, 153, 51));
		try {
			this.cardBack = ImageIO.read(new File("images/back.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (Deck.cardsDealt) {
			int dealerX = 0;
			int playerX = 0;
			
			for (Card card : Dealer.getDealerHand().getCards()) {
				if (dealerX < Dealer.getDealerHand().CARD_LIMIT) {
					BufferedImage cardImg = card.getImg();
					g.drawImage(cardImg, DEALER_X[dealerX], DEALER_Y, null);
					dealerX += 1;
				}
			}
			
			if (!Dealer.getDealerHand().isShowHoleCard()) {
				g.drawImage(cardBack, DEALER_X[1], DEALER_Y, null);
			}
			
			for (Card card : Player.getPlayerHand1().getCards()) {
				if (playerX < Player.getPlayerHand1().CARD_LIMIT) {
					BufferedImage cardImg = card.getImg();
					g.drawImage(cardImg, PLAYER_X[playerX], PLAYER_Y, null);
					playerX += 1;
				}
			}
			
		}
		repaint();
	}
}
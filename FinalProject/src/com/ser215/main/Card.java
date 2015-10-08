package com.ser215.main;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Card {
	private int suit;
	private int value;
	private int pipValue;
	private Image img;
	private URL imgUrl;
	
	private static String[] suits = {"heart", "diamond", "club", "spade"};
	private static String[] pipValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	public Card() {};
	
	public Card(int suit, int pipValue) {
		this.suit = suit;
		this.pipValue = pipValue;
		setInitialValue(pipValue);
		
		Card c = new Card();
		@SuppressWarnings("rawtypes")
		Class cls = c.getClass();
		imgUrl = cls.getResource("/images/" + this.toString() + ".jpg");
				
		this.img = Toolkit.getDefaultToolkit().getImage(imgUrl);
		
	}
	
	public String toString() {
		return suits[suit] + pipValues[pipValue];
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	/* This method sets the initial value of each card to its pipValue
	 * After the deal, or upon hitting, the hand will be reviewed for
	 * any Aces and the cards value will be adjusted to 11 as needed
	 */
	public void setInitialValue(int pipVal) {
		if (pipVal == 0) {
			// this is an ace
			this.value = 11;
		} else if (pipVal >= 9) {
			this.value = 10;
		} else {
			this.value = pipVal + 1;
		}
	}

	public int getPipValue() {
		return pipValue;
	}

	public void setPipValue(int pipValue) {
		this.pipValue = pipValue;
	}
	
	public boolean isAce() {
		return pipValue == 0;
	}
	
	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

}

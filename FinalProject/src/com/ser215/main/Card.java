package com.ser215.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card {
	private int suit;
	private int value;
	private int pipValue;
	private BufferedImage img;
	
	private static String[] suits = {"heart", "diamond", "club", "spade"};
	private static String[] pipValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		
	public Card(int suit, int pipValue) {
		this.suit = suit;
		this.pipValue = pipValue;
		setValue(pipValue);
		try {
			this.img = ImageIO.read(new File("images/" + this.toString() + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

	public void setValue(int pipVal) {
		if (pipVal >= 9) {
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
	
	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		try {
			System.out.println("Loading image at " + "images/" + this.toString() + ".jpg");
			this.img = ImageIO.read(new File("images/" + this.toString() + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

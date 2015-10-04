package com.ser215.main;

import java.util.ArrayList;

public class Hand {
	private int totalValue;
	private ArrayList<Card> cards;
	private boolean showHoleCard;
	public static final int CARD_LIMIT = 9;
	
	public Hand() {
		this.cards = new ArrayList<Card>();
		this.showHoleCard = false;
	}
	
	public void addCard(Card card) {
		cards.add(card);
		this.totalValue += card.getValue();
	}
	
	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public boolean isShowHoleCard() {
		return showHoleCard;
	}
	
	public void setShowHoleCard(boolean showHoleCard) {
		this.showHoleCard = showHoleCard;
	}

	public String toString() {
		String temp = "\n";
		
		for (Card card : cards) {
			temp += card.toString() + "\n";
		}
		
		return temp;
	}
}

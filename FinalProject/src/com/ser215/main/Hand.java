package com.ser215.main;

import java.util.ArrayList;

public class Hand {
	private int totalValue;
	private ArrayList<Card> cards;
	
	public Hand() {
		this.cards = new ArrayList<Card>();
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
	
	public String toString() {
		String temp = "\n";
		
		for (Card card : cards) {
			temp += card.toString() + "\n";
		}
		
		return temp;
	}
}

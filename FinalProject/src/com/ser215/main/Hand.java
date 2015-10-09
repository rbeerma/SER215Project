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
	
	// Add new card to the hand
	public void addCard(Card card) {
		cards.add(card);
		this.totalValue += card.getValue();
	}
	
	// Get the total value of the hand
	public int getTotalValue() {
		return totalValue;
	}

	// Set the total value of the hand
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	/*
	 * This method updates the total value of the hand if one or more of the cards
	 * is an Ace
	 */
	public void updateValue() {
		for (Card card : cards) {
			if (card.isAce() && card.getValue() == 11) {
				if (totalValue > 21) {
					card.setValue(1);
					totalValue = totalValue - 10;
				}
			}
		}
	}

	// Gets all cards in the hand
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	// Sets which card is the hole card
	public boolean isShowHoleCard() {
		return showHoleCard;
	}
	
	// Exposes the hole card to show results
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
	
	// Removes all cards from the hand after a round of play
	public void clear() {
		this.cards.clear();
		this.totalValue = 0;
	}
	
	public boolean hasAce(){
		boolean ace = false;
		for(Card card : cards){
			if(card.isAce()){
				ace = true;
			}
		}
		return ace;
	}
}

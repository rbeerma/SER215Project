package com.ser215.main;

public class Dealer {
	private Hand dealerHand;
	private Card showingCard;
	
	/**
	 * sets the hand of the dealer
	 * @param hand hand to be set to dealer
	 */
	public void setHand(Hand hand) {
		this.dealerHand = hand;
	}
	
	/**
	 * returns the hand of the dealer
	 * @return hand of the dealer
	 */
	public Hand getHand() {
		return this.dealerHand;
	}
	
	public Card getShowingCard() {
		return showingCard;
	}
	
	public void setShowingCard(Card showingCard) {
		this.showingCard = showingCard;
	}
}

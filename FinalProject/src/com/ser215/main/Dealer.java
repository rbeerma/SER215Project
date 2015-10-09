package com.ser215.main;

public class Dealer {
	private static Hand dealerHand;
	private Card showingCard;
	private Card holeCard;
	
	public Dealer() {}
	
	/**
	 * sets the hand of the dealer
	 * @param hand hand to be set to dealer
	 */
	public void setHand(Hand hand) {
		dealerHand = hand;
	}
	
	/**
	 * returns the hand of the dealer
	 * @return hand of the dealer
	 */
	public static Hand getDealerHand() {
		return dealerHand;
	}
	
	// Get the showing card
	public Card getShowingCard() {
		return showingCard;
	}
	
	// Set the showing card
	public void setShowingCard(Card showingCard) {
		this.showingCard = showingCard;
	}
	
	// Get the hole card
	public Card getHoleCard() {
		return holeCard;
	}
	
	// Set the hole card
	public void setHoleCard(Card holeCard) {
		this.holeCard = holeCard;
	}
	
	// Clears the dealer hand
	public void clearHand(){
		dealerHand.clear();
	}

}

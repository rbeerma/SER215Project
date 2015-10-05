package com.ser215.main;

public class Dealer {
	private static Hand dealerHand;
	private Card showingCard;
	
	
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
	
	public Card getShowingCard() {
		return showingCard;
	}
	
	public void setShowingCard(Card showingCard) {
		this.showingCard = showingCard;
	}
	
	public void clearHand(){
		this.dealerHand.clearHand();
	}
}

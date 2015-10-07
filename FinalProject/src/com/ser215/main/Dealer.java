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
	
	public Card getShowingCard() {
		return showingCard;
	}
	
	public void setShowingCard(Card showingCard) {
		this.showingCard = showingCard;
	}
	
	public Card getHoleCard() {
		return holeCard;
	}
	
	public void setHoleCard(Card holeCard) {
		this.holeCard = holeCard;
	}
	
	public void clearHand(){
		dealerHand.clear();
	}

}

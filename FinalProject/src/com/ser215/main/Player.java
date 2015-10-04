package com.ser215.main;

public class Player {
	private String name;
	private Hand playerHand1;
	private Hand playerHand2;
	
	public Player(String name) {
		this.name = name;
		this.playerHand1 = null;
		this.playerHand2 = null;
	}
	
	public Player(String name, Hand hand) {
		this.name = name;
		this.playerHand1 = hand;
	}
	
	/**
	 * returns the name of the player
	 * @return name of the player
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * sets the name of the player
	 * @param name name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * sets the hand of the player
	 * @param hand hand to be set to player
	 */
	public void setPlayerHand1(Hand hand1) {
		this.playerHand1 = hand1;
	}
	
	public void setPlayerHand2(Hand hand2) {
		this.playerHand2 = hand2;
	}
	
	/**
	 * returns the hand of the player
	 * @return hand of the player
	 */
	public Hand getPlayerHand1() {
		return this.playerHand1;
	}
	
	public Hand getPlayerHand2() {
		return this.playerHand2;
	}
	
}

package com.ser215.main;
public class Bank {
	private double balance;
	private double betTotal;
	private final double MAX_BET = 1000;
	private double currentBet;
	
	public Bank() {
		this.balance = 0;
		this.betTotal = 0;
		this.currentBet = 0;
	}
	
	/**
	 * places the bet, sets the bet total
	 * @param bet amount to be bet
	 */
	public void placeBet(double bet) {
		this.currentBet = bet;
		this.betTotal = betTotal += bet;
	}
	
	/**
	 * returns the balance of bank
	 * @return balance of bank
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * Pays out the normal 2:1 return on bet.
	 */
	public void payoutNormal() {
		balance += 2 * currentBet;
	}
	
	/**
	 * Pays out the 3:2 return on bet.
	 */
	public void payoutBlackjack() {
		balance += (3/2) * currentBet;
	}
	
	/**
	 * Increases the current bet by the new bet amount.
	 * @param bet amount to be added to bet
	 */
	public void increaseBet(double bet) {
		this.betTotal += bet;
	}
	
	/**
	 * Clears the bet back to 0.
	 */
	public void clearBet() {
		this.currentBet = 0;
		this.betTotal = 0;
	}
	
	public void payoutSurrender() {
		//TO DO, UNSURE
	}
}
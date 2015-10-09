package com.ser215.main;
public class Bank {
	private double balance;
	public static final double MAX_BET = 500;
	private double currentBet;
	private double splitBet;
	
	public Bank() {
		this.balance = 0;
		this.currentBet = 0;
	}
	
	/**
	 * places the bet, sets the bet total
	 * @param bet amount to be bet
	 */
	public void placeBet(double bet) {
		this.currentBet = bet;
	}
	
	// Currently unused
	public double getSplitBet() {
		return splitBet;
	}

	// Currently unused
	public void setSplitBet(double splitBet) {
		this.splitBet = splitBet;
	}

	// Gets the current bet amount
	public double getCurrentBet() {
		return currentBet;
	}

	// Sets the current bet amount
	public void setCurrentBet(double currentBet) {
		this.currentBet = currentBet;
	}

	/**
	 * returns the balance of bank
	 * @return balance of bank
	 */
	public double getBalance() {
		return this.balance;
	}
	
	// Sets the total bank balance
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Pays out the normal 1:1 return on bet.
	 */
	public void payoutWin() {
		balance += 2 * currentBet;
		currentBet = 0;
	}
	
	/**
	 * Pays out the 3:2 return on bet.
	 */
	public void payoutBlackjack() {
		balance += 2.5 * currentBet;
		currentBet = 0;
	}
	
	/**
	 * Increases the current bet by the new bet amount.
	 * @param bet amount to be added to bet
	 */
	public void increaseBet(double bet) {
		currentBet += bet;
		balance -= bet;
	}
	
	/**
	 * Clears the bet back to 0.
	 */
	public void clearBet() {
		this.currentBet = 0;
	}
	
	// This method is currently unused
	public void payoutSurrender() {
		balance += 0.5 * currentBet;
		currentBet = 0;
	}

	// Pays out the correct amount if the round is a push
	public void payoutPush() {
		balance += currentBet;
		currentBet = 0;
		
	}
}
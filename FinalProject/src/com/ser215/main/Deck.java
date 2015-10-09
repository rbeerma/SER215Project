package com.ser215.main;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	private static int totalCards;
	public static boolean cardsDealt;
	
	// Initialize the deck
	public Deck() {
		cardsDealt = false;
		totalCards = 52;
		cards = new ArrayList<Card>();
		
		for (int i=0; i<=3; i++) {
			for (int j=0; j<=12; j++) {
				cards.add(new Card(i, j));
			}
		}
	}
	
	// Get the next card from the top of the deck
	public Card getNextCard() {
		Random random = new Random();
		int index = 0;
		
		if (totalCards <= 6) {
			this.cards = newDeck();
		}
		
		do {
			index = random.nextInt(52);
		} while (cards.get(index) == null);
		
		totalCards--;
		Card temp = cards.get(index);
		cards.set(index, null);
				
		return temp;
	}
	
	// Get a current count of cards remaining
	public int getTotalCards() {
		return totalCards;
	}
	
	// Build a new deck if the old one is nearly empty
	public ArrayList<Card> newDeck() {
		ArrayList<Card> newCards = new ArrayList<Card>();
		
		for (int i=0; i<=3; i++) {
			for (int j=0; j<=12; j++) {
				newCards.add(new Card(i, j));
			}
		}
		
		totalCards = 52;
		
		return newCards;
	}
	
	public String toString() {
		String cardList = "";
		for (Card card : cards) {
			cardList += card.toString() + "\n" ;
		}
		
		return cardList;
	}
}

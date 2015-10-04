package com.ser215.main;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	private Card nextCard; //not sure if this is needed
	private static int totalCards;
		
	public Deck() {
		totalCards = 52;
		cards = new ArrayList<Card>();
		//int x = 0;
		
		for (int i=0; i<=3; i++) {
			for (int j=0; j<=12; j++) {
				cards.add(new Card(i, j));
				//x++;
			}
		}
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println(deck.toString());
	}
	
	public Card getNextCard() {
		Random random = new Random();
		int index = 0;
		
		do {
			index = random.nextInt(52);
		} while (cards.get(index) == null);
		
		totalCards--;
		Card temp = cards.get(index);
		cards.set(index, null);
		return temp;
	}
	
	public int getTotalCards() {
		return totalCards;
	}
	
	public String toString() {
		String cardList = "";
		for (Card card : cards) {
			cardList += card.toString() + "\n" ;
		}
		
		return cardList;
	}
}

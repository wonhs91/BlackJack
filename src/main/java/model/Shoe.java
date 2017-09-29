package main.java.model;

import main.java.constants.BlackJackConstants;

import java.util.Collections;
import java.util.Stack;

public class Shoe {
	
	private Stack<Card> shoe;
	private int origNumDecks;
	// shufflePoint must be less than 1
	private double shufflePoint;

	// TODO: track number of each cards (ex. how many 10's left, ace's left ...)

	public Shoe(int numDecks, double shufflePoint){
		this.shoe = createShoe(numDecks);
		this.shufflePoint = shufflePoint;
		origNumDecks = numDecks;
	}

	public int getOrigNumDecks() {
		return origNumDecks;
	}

	public Stack<Card> getShoe() {
		return shoe;
	}

	public void setShoe(Stack<Card> shoe) {
		this.shoe = shoe;
	}

	public double getShufflePoint(){
		return shufflePoint;
	}

	public void setShufflePoint(double shufflePoint){
		this.shufflePoint = shufflePoint;
	}

	public boolean isShufflePointReached(){
		 double cardLeft = getNumCards() / getOrigNumCards();
		 return cardLeft <= shufflePoint;
	}

	public int getOrigNumCards(){
		return origNumDecks * BlackJackConstants.NUM_CARDS_IN_A_DECK;
	}

	public int getNumCards(){
		return shoe.size();
	}

	public void repopulateShoe(){
		this.shoe = createShoe(origNumDecks);
	}

	public void shuffleShoe(){
		Collections.shuffle(shoe);
	}

	public void reShuffleShoe(){
		repopulateShoe();
		shuffleShoe();
	}

	private Stack<Card> createShoe(int numDecks){
		Stack<Card> tempShoe = new Stack<Card>();

		for (int i = 0; i < numDecks; i++) {

			for (Suit suit : Suit.values()) {

				Suit currentSuit = suit;

				for (Rank currentRank : Rank.values()) {
					Card card = new Card(currentRank, currentSuit);
					tempShoe.add(card);
				}
			}
		}

		return tempShoe;
	}


}

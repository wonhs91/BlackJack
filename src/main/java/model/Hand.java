package main.java.model;

import main.java.constants.BlackJackConstants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by stephen on 7/14/17.
 */
public class Hand {

    private Collection<Card> hand;


    public Hand(){
        this.hand = new ArrayList<Card>();
    }

    /*public void setHand(Collection<Card> hand) {
        this.hand = hand;
    }*/

    public Collection<Card> getHand() {
        return hand;
    }

    public void addCard(Card card){
        this.hand.add(card);
    }

    public void removeHand(){
        this.hand = Collections.emptyList();
    }

    public Card getFaceCard(){
        Iterator<Card> iterator = hand.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    public int getValue() {

        int numAces = 0;
        int handValue = 0;

        for (Card card : hand){
            if (card.getRank() == Rank.ACE){
                numAces += 1;
            }

            handValue += card.getValue();
        }

        while(handValue <= BlackJackConstants.BLACKJACK_VALUE - 10 && numAces != 0){

            handValue += 10;

            numAces--;
        }

        return handValue;
    }




}

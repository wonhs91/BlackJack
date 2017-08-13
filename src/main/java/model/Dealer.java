package main.java.model;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by stephen on 6/1/17.
 */
public class Dealer {

    private Hand hand;
    private Decision decision;
    private Shoe shoe;
    //TODO: Dealer Strategy

    public Dealer(Shoe shoe){
        this.shoe = shoe;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Decision getDecision() {
        return decision;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }

    public void shuffleShoe(){

        Stack<Card> tempShoe = shoe.getShoe();
        Collections.shuffle(tempShoe);

        shoe.setShoe(tempShoe);
    }

    public Card drawACard(){
        return shoe.getShoe().pop();
    }

}

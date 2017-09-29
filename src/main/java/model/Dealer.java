package main.java.model;

import main.java.constants.BlackJackConstants;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by stephen on 6/1/17.
 */
public class Dealer extends CardHolder{

    private Shoe shoe;
    //TODO: Dealer Strategy

    public Dealer(Shoe shoe){
        this.id = BlackJackConstants.DEALER_ID;
        this.shoe = shoe;
        this.decision = Decision.NO_DECISION;
        this.hand = new Hand();
        this.name = "The Dealer";
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

    public Card drawACard(){
        return shoe.getShoe().pop();
    }

    @Override
    public Decision makeDecision(){
        Decision tempDecision;
        if (this.getHand().getValue() < BlackJackConstants.DEALER_STAND_VALUE){
            tempDecision = Decision.HIT;
        } else {
            tempDecision = Decision.STAND;
        }
        return tempDecision;
    }
}

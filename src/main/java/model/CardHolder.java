package main.java.model;

public abstract class CardHolder {

    protected String id;
    protected Hand hand;
    protected Decision decision;
    protected String name;

    public String getId() {
        return id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void recieveACard(Card card){
        this.getHand().addCard(card);
    }

    public abstract Decision makeDecision();

    public void reset(){
        hand = new Hand();
        decision = Decision.NO_DECISION;
    }

}

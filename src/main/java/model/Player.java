package main.java.model;

public class Player {

	private String id;
	private String name;
	private double betAmount;
	private double asset;
	//private double netDifference;
	private Hand hand;
	private Decision decision;

	public Player(String id, String name, double asset){
		this.id = id;
		this.name = name;
		this.asset = asset;

		betAmount = 0;
		hand = new Hand();
		decision = Decision.NO_DECISION;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void changeName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public double getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}

	public double getAsset() {
		return asset;
	}

	public void setAsset(double asset) {
		this.asset = asset;
	}

	public Decision getDecision() {
		return decision;
	}

	public void setDecision(Decision decision) {
		this.decision = decision;
	}

	public void lose(){
		asset = asset - betAmount;
	}

	public void win(){

	}

	public void draw(){

	}

	private void reset(){
		betAmount = 0;
		hand = null;
	}
}

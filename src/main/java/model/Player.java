package main.java.model;

import main.java.constants.BlackJackConstants;
import main.java.view.BlackJackView;

import static main.java.view.BlackJackView.askDecision;

public class Player extends CardHolder{

	private double betAmount;
	private double asset;
	//private double netDifference;

	public Player(String id, String name, double asset){
		this.id = id;
		this.name = name ;
		this.asset = asset;

		betAmount = 0;
		hand = new Hand();
		decision = Decision.NO_DECISION;
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

	public boolean betDouble(){
		if (asset < betAmount * 2){
			return false;
		}
		betAmount = betAmount * 2;
		return true;
	}

	public void lose(){
		BlackJackView.showMessage(this.name + " loses!!\n==========================================\n");
		asset = asset - betAmount;
		showInfo();
		reset();
	}

	public void win(){
		BlackJackView.showMessage(this.name + " wins!!\n==========================================\n");
		asset = asset + betAmount;
		showInfo();
		reset();
	}

	public void draw(){
		BlackJackView.showMessage(this.name + " draws!!\n==========================================\n" );
		showInfo();
		reset();
	}

	public void blackJackWin(){
		BlackJackView.showMessage(this.name + " !! * BLACK JACK * !!\n==========================================\n" );
		asset = Math.floor(asset + (betAmount * 1.5));
		showInfo();
		reset();
	}

	private void showInfo(){
		BlackJackView.showMessage("------------------------------------------------------\n" + " id || name || betAmount ||  asset \n" + id + " || " + name + " || " + betAmount + " || " + asset + "\n------------------------------------------------------");
	}

	@Override
	public void reset(){
		super.reset();
		betAmount = 0;
	}

	public Decision makeDecision(){
		Decision tempDecision = askDecision(this.getName());
		this.setDecision(tempDecision);
		return tempDecision;
	}
}

package main.java.Controller;

import main.java.constants.BlackJackConstants;
import main.java.model.Card;
import main.java.model.Dealer;
import main.java.model.Player;
import main.java.model.Table;
import static main.java.view.BlackJackView.*;

import java.util.Collection;
import java.util.Iterator;

public class BlackJackPlay {

    private Table table;
    private Collection<Player> players;
    private Dealer dealer;

    public BlackJackPlay(Table table){
        this.table = table;
        players = table.getPlayers();
        dealer = table.getDealer();
    }

    public void play(){

        dealer.shuffleShoe();

        playersBet();

        dealFirstHand();

        //TODO: maybe add dealer checking his face card
        if (dealer.getHand().getValue() == BlackJackConstants.BLACKJACK_VALUE){

        }

    }


    private void playersBet(){
        Collection<Player> players = table.getPlayers();

        //TODO: find players without assets and remove them from table

        for (Iterator<Player> iter = players.iterator(); iter.hasNext();){
            Player player = iter.next();
            double betAmount = askBetAmount(player.getName());
            player.setBetAmount(betAmount);
        }
    }

    private void dealFirstHand(){
        for (int i = 0; i < 2; i++) {
            for (Iterator<Player> iter = players.iterator(); iter.hasNext(); ) {
                Card playerCard = table.getDealer().drawACard();
                Player player = iter.next();
                player.getHand().addCard(playerCard);
            }
            Card dealerCard = table.getDealer().drawACard();
            dealer.getHand().addCard(dealerCard);
        }
    }



}

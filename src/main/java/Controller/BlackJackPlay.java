package main.java.Controller;

import main.java.constants.BlackJackConstants;
import main.java.model.*;
import main.java.view.BlackJackView;

import static main.java.view.BlackJackView.*;

import java.util.Collection;
import java.util.Iterator;

public class BlackJackPlay {

    private Table table;
    private Collection<Player> players;
    private Dealer dealer;

    public BlackJackPlay(Table table) {
        this.table = table;
        players = table.getPlayers();
        dealer = table.getDealer();
    }

    public void play() {

        dealer.getShoe().shuffleShoe();


        while (true) {

            if (dealer.getShoe().isShufflePointReached()) {
                dealer.getShoe().reShuffleShoe();
            }

            playersBet();

            dealFirstHand();

            //TODO: maybe add dealer checking his face card

            //Dealer shows face card
            BlackJackView.showDealerFaceCard(dealer.getHand().getFaceCard());

            //Dealer gets blackJack
            if (dealer.getHand().getValue() == BlackJackConstants.BLACKJACK_VALUE) {
                BlackJackView.showHand(dealer.getName(), dealer.getHand());
                for (Iterator<Player> iter = players.iterator(); iter.hasNext(); ) {
                    Player player = iter.next();
                    BlackJackView.showHand(player.getName(), player.getHand());
                    if (player.getHand().getValue() == BlackJackConstants.BLACKJACK_VALUE) {
                        player.draw();
                    } else {
                        player.lose();
                    }
                }
            }
            //Play start
            else {
                //Each Player plays
                for (Iterator<Player> iter = players.iterator(); iter.hasNext(); ) {
                    Player player = iter.next();
                    haveTurn(player);

                    //if player Busts
                    if (player.getHand().getValue() > BlackJackConstants.BLACKJACK_VALUE) {
                        player.lose();
                    }
                }
                //Dealer plays
                BlackJackView.showHand("Dealer", dealer.getHand());
                haveTurn(dealer);
                int dealerHandValue = dealer.getHand().getValue();
                if (dealerHandValue > BlackJackConstants.BLACKJACK_VALUE) {
                    for (Iterator<Player> iter = players.iterator(); iter.hasNext(); ) {
                        Player player = iter.next();
                        if (player.getHand() != null) {
                            player.win();
                        }
                    }
                } else {

                    for (Iterator<Player> iter = players.iterator(); iter.hasNext(); ) {
                        Player player = iter.next();
                        int playerHandValue = player.getHand().getValue();
                        if (playerHandValue > dealerHandValue) {
                            player.win();
                        } else if (playerHandValue == dealerHandValue) {
                            player.draw();
                        } else {
                            player.lose();
                        }
                    }
                }

            }
        }

    }

    private void haveTurn(CardHolder cardHolder) {
        BlackJackView.showHand(cardHolder.getName(), cardHolder.getHand());
        while (cardHolder.getHand().getValue() < BlackJackConstants.BLACKJACK_VALUE && cardHolder.getDecision() != Decision.STAND && cardHolder.getDecision() != Decision.DOUBLE) {
            cardHolder.makeDecision();
            Decision decision = cardHolder.getDecision();
            switch (decision) {
                case HIT:
                    recieveACard(cardHolder);
                    break;
                case DOUBLE:
                    if (((Player) cardHolder).betDouble()) {
                        recieveACard(cardHolder);
                    } else {
                        BlackJackView.showMessage("Warning!!: player \"" + cardHolder.getName() + "\" does not have enough asset to double bet");
                        cardHolder.setDecision(Decision.NO_DECISION);
                    }
                    break;
                case STAND:

                    break;
                case SPLIT:
                    //TODO
                    break;
            }

        }
    }


    private void recieveACard(CardHolder cardHolder) {
        Card card = dealer.drawACard();
        BlackJackView.showCard(card);
        cardHolder.recieveACard(card);
        BlackJackView.showHand(cardHolder.getName(), cardHolder.getHand());
    }

    private void playersBet() {
        Collection<Player> players = table.getPlayers();

        //TODO: find players without assets and remove them from table

        for (Iterator<Player> iter = players.iterator(); iter.hasNext(); ) {
            Player player = iter.next();
            double betAmount = askBetAmount(player.getName());
            player.setBetAmount(betAmount);
        }
    }

    private void dealFirstHand() {
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

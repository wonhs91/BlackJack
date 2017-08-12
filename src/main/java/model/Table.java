package main.java.model;

import java.util.Collection;

/**
 * Created by stephen on 7/14/17.
 */
public class Table {

    private Collection<Player> players;
    private Dealer dealer;
    //TODO: add table rules such as max number of seats etc

    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
}

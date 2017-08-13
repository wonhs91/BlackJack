package main.java.Controller;

import main.java.model.Dealer;
import main.java.model.Player;
import main.java.model.Shoe;
import main.java.model.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static main.java.view.BlackJackView.*;


public class BlackJackPreparation { ;


    //TODO: find a better way to create players and dealer so that the future modification doesn't require too much change in code
    // ex) adding fields or removing fields

    public Table prepareTable(){
        Collection<Player> players = generatePlayers();
        Dealer dealer = generateDealer();

        Table table = new Table(players, dealer);
        return table;
    }

    private Collection<Player> generatePlayers() {
        Collection<Player> players = new ArrayList<Player>();
        int numPlayers = askNumPlayers();

        for (int i = 0; i < numPlayers; i++) {
            HashMap<String, Object> playerDetails = askPlayerDetails();
            Player player = setPlayerDetails(playerDetails);
            players.add(player);
        }

        return players;
    }

    private Dealer generateDealer() {
        boolean doDealerSetting = askDoDealerSettings();
        HashMap<String, Object> dealerSettings;
        if (doDealerSetting) {
            dealerSettings = askDealerSettings();
        }
        // use default dealer settings
        else {
            dealerSettings = new HashMap<String, Object>();
            dealerSettings.put("numDecks", 1);
            dealerSettings.put("shufflePoint", 0.2);
        }
        Dealer dealer = setDealerDetails(dealerSettings);

        return dealer;
    }


    private Dealer setDealerDetails(HashMap<String, Object> DealerSettingHmap) {
        int numDecks = (Integer) DealerSettingHmap.get("numDecks");
        double shufflePoint = (Double) DealerSettingHmap.get("shufflePoint");

        Shoe shoe = new Shoe(numDecks, shufflePoint);

        Dealer dealer = new Dealer(shoe);

        return dealer;
    }


    private Player setPlayerDetails(HashMap<String, Object> playerSettingHmap) {



        String id = (String) playerSettingHmap.get("id");
        String name = (String) playerSettingHmap.get("name");
        double asset = (Double) playerSettingHmap.get("asset");

        Player player = new Player(id, name, asset);

        return player;
    }
}


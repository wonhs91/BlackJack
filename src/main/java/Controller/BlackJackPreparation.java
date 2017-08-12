package main.java.Controller;

import main.java.model.Dealer;
import main.java.model.Player;
import main.java.model.Shoe;
import main.java.model.Table;
import main.java.view.BlackJackView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static main.java.view.BlackJackView.*;


public class BlackJackPreparation {
    Table table;

    public BlackJackPreparation(Table table) {
        this.table = table;
    }


    //TODO: find a better way to create players and dealer so that the future modification doesn't require too much change in code
    // ex) adding fields or removing fields

    public Table prepareTable(){
        generatePlayers();
        generateDealer();
        return table;
    }

    private void generatePlayers() {
        Collection<Player> players = new ArrayList<Player>();
        int numPlayers = askNumPlayers();

        for (int i = 0; i < numPlayers; i++) {
            HashMap<String, Object> playerDetails = askPlayerDetails();
            Player player = setPlayerDetails(playerDetails);
            players.add(player);
        }

        table.setPlayers(players);
    }

    private void generateDealer() {
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
        setDealerDetails(dealerSettings);
    }


    private void setDealerDetails(HashMap<String, Object> DealerSettingHmap) {
        Dealer dealer = new Dealer();

        int numDecks = (Integer) DealerSettingHmap.get("numDecks");
        double shufflePoint = (Double) DealerSettingHmap.get("shufflePoint");

        Shoe shoe = new Shoe(numDecks);

        shoe.setShufflePoint(shufflePoint);

        dealer.setShoe(shoe);

        table.setDealer(dealer);
    }


    private Player setPlayerDetails(HashMap<String, Object> playerSettingHmap) {

        Player player = new Player();

        String id = (String) playerSettingHmap.get("id");
        String name = (String) playerSettingHmap.get("name");
        double asset = (Double) playerSettingHmap.get("asset");

        player.setId(id);
        player.setName(name);
        player.setAsset(asset);

        return player;
    }
}


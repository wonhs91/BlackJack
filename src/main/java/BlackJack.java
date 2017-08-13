package main.java;

import main.java.Controller.BlackJackPlay;
import main.java.Controller.BlackJackPreparation;
import main.java.model.Table;

public class BlackJack {



    public void start(){

        BlackJackPreparation blackJackPreparation = new BlackJackPreparation();

        Table table = blackJackPreparation.prepareTable();

        BlackJackPlay blackJackPlay = new BlackJackPlay(table);

    }

}

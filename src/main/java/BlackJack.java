package main.java;

import main.java.Controller.BlackJackPreparation;
import main.java.model.Table;
import main.java.view.BlackJackView;

public class BlackJack {



    public void start(){

        Table table  = new Table();
        BlackJackPreparation blackJackPreparation = new BlackJackPreparation(table);
        table = blackJackPreparation.prepareTable();

    }

}

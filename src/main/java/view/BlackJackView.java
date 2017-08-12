package main.java.view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class BlackJackView {

    private static final Scanner in = new Scanner(System.in);

    private static int askAndGetInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input Type does not match, please re-enter");
                in.nextLine();
            }
        }
    }

    private static String askAndGetString(String prompt){
        while (true) {
            try {
                System.out.println(prompt);
                return in.next();
            } catch (InputMismatchException e) {
                System.out.println("Input Type does not match, please re-enter");
                in.nextLine();
            }
        }
    }

    private static double askAndGetDouble(String prompt){
        while (true) {
            try {
                System.out.println(prompt);
                return in.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Input Type does not match, please re-enter");
                in.nextLine();
            }
        }
    }

    private static boolean askAndGetYN(String prompt){
        while (true) {
            try {
                System.out.println(prompt);
                String YNString = in.next().toUpperCase();
                if (YNString.equals("Y") || YNString.equals("YES")) {
                    return true;
                } else if (YNString.equals("N") || YNString.equals("NO")){
                    return false;
                }
                else {
                    System.out.println("Please answer the question with Y or N");
                    in.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Input Type does not match, please re-enter");
                in.nextLine();
            }
        }
    }


    public static int askNumPlayers() {
        int numPlayers = askAndGetInt("How many players?");
        return numPlayers;
    }

    public static HashMap<String, Object> askPlayerDetails() {
        System.out.println("PlayerSettings: ");
        String uniqueId = UUID.randomUUID().toString();

        String name = askAndGetString("    player  name: ");
        double asset = askAndGetDouble("    asset: ");

        HashMap<String, Object> playerSettingsHmap = new HashMap<String, Object>();

        playerSettingsHmap.put("id", uniqueId);
        playerSettingsHmap.put("name", name);
        playerSettingsHmap.put("asset", asset);

        return playerSettingsHmap;
    }

    public static boolean askDoDealerSettings() {

        boolean doDealerSetting = askAndGetYN("Do Dealer Settings? (Y/N)");

        return doDealerSetting;
    }

    public static HashMap<String, Object> askDealerSettings() {
        HashMap<String, Object> dealerSettingsHmap = new HashMap<String, Object>();


        System.out.println("Dealer Settings: ");

        // Dealer's Shoe Settings

        System.out.println("Shoe Settings: ");

        double shufflePoint;
        do {
            shufflePoint = askAndGetDouble("Shuffle Point (0 < x  < 1): ");
        }
        while (shufflePoint > 1 || shufflePoint < 0);

        int numDecks;
        do {
            numDecks = askAndGetInt("Number of Decks: ");
        }
        while (numDecks < 0);

        dealerSettingsHmap.put("shufflePoint", shufflePoint);
        dealerSettingsHmap.put("numDecks", numDecks);

        return dealerSettingsHmap;
    }

}

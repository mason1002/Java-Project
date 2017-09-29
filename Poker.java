import java.util.*;

/*
   The poker's main function that create players and print out the result.
 */

public class Poker {

    private static final String validRankInput = "23456789TtJjQqKkAa";
    private static final String validSuitInput = "CcDdHhSs";

    public static void main(String[] args) {

        //For the simpler asst
        if (args.length > 5) {
            System.out.println("NOT UNDERTAKEN");
            System.exit(0);
        }

        //for the challenging problem
        if (args.length <= 0 || args.length % 5 != 0) {
            System.out.println("Error: wrong number of arguments; " +
                    "must be a multiple of 5");
            System.exit(0);
        }
        //check if the input is valid
        for (String arg : args) {
            if (arg.length() != 2 || !validRankInput.contains(
                    arg.substring(0, 1))
                    || !validSuitInput.contains(arg.substring(1, 2))) {
                System.out.println("Error: invalid card name " + "'"
                        + arg + "'");
                System.exit(0);
            }
        }

        //making every 5-input-args be a cardArray
        for (int i = 0; i < args.length / 5; i++) {
            Card[] cardArray = new Card[5];
            for (int j = 0; j < 5; j++) {
                cardArray[j] = new Card(args[i * 5 + j].substring(0, 1),
                        args[i * 5 + j].substring(1, 2));
            }

            Hand hand = new Hand(i + 1, cardArray);
            System.out.println("Player " + hand.getPlayerID() + ": "
                    + hand.getDescription());
        }

    }
}

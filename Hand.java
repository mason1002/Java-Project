import java.util.*;

/*
     Discription: Hand class
                  Describing different kind of hands and the Poker lingo.

     2017/9/19 20:04
*/

public class Hand {

//    private Category category;

    private Card[] hand;  // a hand to store an array of cards
    /*
        playerID & its accessor
     */
    private int playerID;

    int getPlayerID() {
        return playerID;
    }

    /*
     *       description & its getter and setter
     */
    private String description;

    String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    /* Constructors
     * Construct Hand to make hand be an array of cards and sort it ascending
     */
    Hand(int playerID, Card[] cards) {
        this.playerID = playerID;
        this.hand = cards;
        Arrays.sort(hand);
        whichCategory(hand);
    }

    /**
     * @return the hand
     */
    public Card[] getHand() {
        return this.hand;
    }

    /*
        Checking which category  Card[] array c belongs to.
     */

    private void whichCategory(Card[] c) {

        //is Straight flush?
        if (!"N".equals(flush(c)) && !"N".equals(straight(c))) {
            setDescription(straight(c) + "-high straight flush");
            return;
        }

        //is Four-of-a-kind?
        if (nOfAKind(c, 4).size() > 0) {
            setDescription("Four " + nOfAKind(c, 4).get(0) + "s");
            return;
        }

//        //bad sol: is four-of-a-kind?
//        if (!"N".equals(fourOfAKind(c))) {
//            setDescription("Four " + fourOfAKind(c) + "s");
//            return;
//        }
        //is Full house?
        if (nOfAKind(c, 3).size() > 0 && nOfAKind(c, 2).size() > 0) {
            setDescription(nOfAKind(c, 3).get(0) + "s full of "
                    + nOfAKind(c, 2).get(0) + "s");
            return;
        }
//        //bad sol: is full house?
//        if (!"N".equals(fullHouse(c))) {
//            setDescription(fullHouse(c).substring(0, 1) +
//                    "s full of " + fullHouse(c).substring(1, 2) + "s");
//            return;
//        }

        //is Flush?
        if (!"N".equals(flush(c))) {
            setDescription(flush(c) + "-high flush");
            return;
        }

        //is Straight?
        if (!"N".equals(straight(c))) {
            setDescription(straight(c) + "-high straight");
            return;
        }

        //is Three-of-a-kind?
        if (nOfAKind(c, 3).size() > 0) {
            setDescription("Three " + nOfAKind(c, 3).get(0) + "s");
            return;
        }
//       //bad sol: is three-of-a-kind?
//        if (!"N".equals(threeOfAKind(c))) {
//            setDescription("Three " + threeOfAKind(c) + "s");
//            return;
//        }

        //is Two pair?
        if (nOfAKind(c, 2).size() == 2) {
            setDescription(nOfAKind(c, 2).get(1) + "s over "
                    + nOfAKind(c, 2).get(0) + "s");
            return;
        }
        //is One pair?
        if (nOfAKind(c, 2).size() == 1) {
            setDescription("Pair of " + nOfAKind(c, 2).get(0) + "s");
            return;
        }
        //the last must be High card
        setDescription(hand[4].getRank().getValue() + "-high");

    }

    /*
     * methods that define different category
     */

    //straight method
    private String straight(Card[] hand) {
        for (int i = 1; i < 5; i++) {
            if (hand[i - 1].getRank().ordinal()
                    != (hand[i].getRank().ordinal() - 1)) {
                return "N";
            }
        }
        return hand[4].getRank().getValue();
    }

    //flush method
    private String flush(Card[] hand) {
        for (int i = 1; i < 5; i++) {
            if (hand[0].getSuit() != hand[i].getSuit()) {
                return "N";
            }
        }
        return hand[4].getRank().getValue();
    }

    //n-of-a-kind method
    private ArrayList<String> nOfAKind(Card[] hand, int n) {
        ArrayList<String> nOfAKind = new ArrayList<>();
        if (n < 2 || n > 4) {
            return nOfAKind;
        }
        int i = 0;
        while (i <= 5 - n) {
            int N = 0;
            while (i + N < 5 && hand[i].getRank() == hand[i + N].getRank()) {
                N++;
            }
            //when a hand is "n-of-a-kind"
            if (N == n) {
                nOfAKind.add(hand[i + N - 1].getRank().getValue());
            }
            i += N;
        }

        return nOfAKind;
    }

//    //four-of-a-kind method
//    private String fourOfAKind(Card[] hand) {
//        if (hand[0].getRank() != hand[3].getRank()
//                && hand[1].getRank() != hand[4].getRank()) {
//            return "N";
//        } else if (hand[0].getRank() == hand[3].getRank()) {
//            return hand[0].getRank().getValue();
//        } else {
//            return hand[1].getRank().getValue();
//        }
//
//    }

//    //full house method
//    private String fullHouse(Card[] hand) {
//        Card card1 = hand[0];
//        Card card2 = hand[1];
//        Card card3 = hand[2];
//        Card card4 = hand[3];
//        Card card5 = hand[4];
//
//        String s1;
//        String s2;
//        String s3;
//        String s4;
//        String s5;
//        String s6;
//
//        if ((card1.getRank() != card2.getRank()
//                || card2.getRank() == card3.getRank()
//                || card3.getRank() != card5.getRank()) &&
//                (card1.getRank() != card3.getRank()
//                        || card3.getRank() == card4.getRank()
//                        || card4.getRank() != card5.getRank())) {
//            return "N";
//        } else if (card1.getRank() == card2.getRank()
//                && card2.getRank() != card3.getRank()
//                && card3.getRank() == card5.getRank()) {
//            s1 = card5.getRank().getValue();
//            s2 = card1.getRank().getValue();
//            s3 = s1 + s2;
//            return s3;
//        } else {
//            s4 = card1.getRank().getValue();
//            s5 = card5.getRank().getValue();
//            s6 = s4 + s5;
//            return s6;
//        }
//
//    }

//    //three of a kind method
//    private String threeOfAKind(Card[] hand) {
//
//        if (hand[0] != hand[2] && hand[1] != hand[3] && hand[2] != hand[4]) {
//            return "N";
//        } else if (hand[0] == hand[2]) {
//            return hand[0].getRank().getValue();
//        } else if (hand[1] == hand[3]) {
//            return hand[1].getRank().getValue();
//        } else {
//            return hand[2].getRank().getValue();
//        }
//
//    }


}






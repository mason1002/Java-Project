/*
    Description: Card class
                 Define a card by two instances, Rank and Suit.
                 Enumerate two instances by enum.
 */

public class Card implements Comparable {

    @Override
    public int compareTo(Object o) {
        return this.rank.compareTo(((Card)o).getRank());
    }

    enum Rank {
        TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
        EIGHT("8"), NINE("9"), TEN("10"), JACK("J"), QUEEN("Queen"), KING("King"),
        ACE("Ace");// All possible ranks
        // Construct method
        private String value;

        Rank(String value) {
            this.value = value;
        }
        /**
         * @return the value of Rank
         */
        public String getValue() {
            return this.value;
        }
    }

    enum Suit {
        CLUB("C"), DIAMOND("D"), HEART("H"), SPADE("S");// All possible suits
        // Construct method
        private String value;

        Suit(String value) {
            this.value = value;
        }

        /**
         * @return the value of Suit
         */
        public String getValue() {
            return this.value;
        }
    }

    private Rank rank;
    /**
     * @return the Rank
     */
    Rank getRank() {
        return rank;
    }

    private Suit suit;
    /**
     * @return the Rank
     */
    Suit getSuit() {
        return suit;
    }

    //Constrain two instances of Card as enum value of Rank and Suit
    Card(String s1, String s2) {
        switch (s1) {
            case "2":
                rank = Rank.TWO;
                break;

            case "3":
                rank = Rank.THREE;
                break;

            case "4":
                rank = Rank.FOUR;
                break;

            case "5":
                rank = Rank.FIVE;
                break;

            case "6":
                rank = Rank.SIX;
                break;

            case "7":
                rank = Rank.SEVEN;
                break;

            case "8":
                rank = Rank.EIGHT;
                break;

            case "9":
                rank = Rank.NINE;
                break;

            case "T":
            case "t":
                rank = Rank.TEN;
                break;

            case "J":
            case "j":
                rank = Rank.JACK;
                break;

            case "Q":
            case "q":
                rank = Rank.QUEEN;
                break;

            case "K":
            case "k":
                rank = Rank.KING;
                break;

            case "A":
            case "a":
                rank = Rank.ACE;
                break;
        }

        switch (s2) {
            case "C":
            case "c":
                suit = Suit.CLUB;
                break;

            case "D":
            case "d":
                suit = Suit.DIAMOND;
                break;

            case "H":
            case "h":
                suit = Suit.HEART;
                break;

            case "S":
            case "s":
                suit = Suit.SPADE;
                break;
        }

    }


}

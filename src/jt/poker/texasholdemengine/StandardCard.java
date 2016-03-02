package jt.poker.texasholdemengine;

import java.util.ArrayList;
import java.util.List;

/**
 * http://wikipedia.org/wiki/Standard_52-card_deck
 */
public class StandardCard implements Card {

    private static final List<StandardCard> sProtoDeck = new ArrayList<>();

    public enum Rank {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
    }

    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    private final Rank mRank;
    private final Suit mSuit;

    // Initialize prototype deck
    static {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                sProtoDeck.add(new StandardCard(rank, suit));
            }
        }
    }

    private StandardCard(Rank rank, Suit suit) {
        mRank = rank;
        mSuit = suit;
    }

    public static ArrayList<StandardCard> newDeck()
    {
        return new ArrayList<>(sProtoDeck); // Return copy of prototype deck
    }

    public static StandardCard getCard(Rank rank, Suit suit) {
        return sProtoDeck.get((Rank.values().length * suit.ordinal()) + rank.ordinal());
    }

    public Rank getRank() {
        return mRank;
    }

    public Suit getSuit() {
        return mSuit;
    }

    public String toString() {
        return mRank + " of " + mSuit;
    }

    @Override
    public int compareTo(Card o) {
        try {
            return getRank().compareTo(((StandardCard) o).getRank());
        } catch (ClassCastException e) {
            throw new IncomparableCardException("method accepts argument of type " + getClass().getName(), e);
        }
    }
}
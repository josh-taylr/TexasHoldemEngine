package jt.poker.texasholdemengine;

import java.util.ArrayList;
import java.util.List;

public class Card implements Comparable<Card> {
    private static final List<Card> sProtoDeck = new ArrayList<>();

    private final Rank mRank;
    private final Suit mSuit;

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

    // Initialize prototype deck
    static {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                sProtoDeck.add(new Card(rank, suit));
            }
        }
    }

    private Card(Rank rank, Suit suit) {
        mRank = rank;
        mSuit = suit;
    }

    public static ArrayList<Card> newDeck()
    {
        return new ArrayList<>(sProtoDeck); // Return copy of prototype deck
    }

    public static Card getCard(Rank rank, Suit suit) {
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

    public int compareRank(Card o) {
        return getRank().compareTo(o.getRank());
    }

    /**
     * WARNING: The natural ordering of {@link Card} is not consistent with {@link Card#equals(Object)}.
     */
    @Override
    public int compareTo(Card o) {
        if (o == null) {
            throw new NullPointerException();
        }
        return getRank().compareTo(o.getRank());
    }

    /**
     * WARNING: The natural ordering of {@link Card} is not consistent with equals(Object).
     */
    @SuppressWarnings("SimplifiableIfStatement")
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        return compareTo((Card) obj) == 0 && getSuit().compareTo(((Card) obj).getSuit()) == 0;
    }
}
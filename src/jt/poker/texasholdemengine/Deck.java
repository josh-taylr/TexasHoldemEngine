package jt.poker.texasholdemengine;

import java.util.List;
import java.util.Random;

/**
 * Created by Josh on 26/02/16.
 */
public class Deck implements IDeck {
    private final List<Card> mCards;
    private final Random mRandom;

    public Deck(List<Card> cards) {
        this(cards, new Random(System.currentTimeMillis()));
    }

    public Deck(List<Card> cards, Random random) {
        if (cards == null || random == null) {
            throw new IllegalArgumentException("Constructor passed null argument");
        }
        mCards = cards;
        mRandom = random;
    }

    @Override
    public Card draw() {
        if (mCards.isEmpty()) {
            return null;
        }
        return mCards.remove(mRandom.nextInt(mCards.size()));
    }
}

package jt.poker.texasholdemengine;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static jt.poker.texasholdemengine.Card.Rank.*;
import static jt.poker.texasholdemengine.Card.Suit.*;
import static jt.poker.texasholdemengine.Card.getCard;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Josh on 27/02/16.
 */
public class CardTest {

    private Card mLowCard;
    private Card mMidCard;
    private Card mHighCard;

    @Before
    public void setUp() throws Exception {
        mLowCard = getCard(TWO, HEARTS);
        mMidCard = getCard(EIGHT, HEARTS);
        mHighCard = getCard(ACE, HEARTS);
    }

    @Test
    public void testNewDeck() throws Exception {
        List<Card> cards = Card.newDeck();
        assertTrue(cards.size() == 52);
    }

    @Test
    public void testGet() throws Exception {
        assertTrue(EIGHT.equals(mMidCard.getRank()));
        assertTrue(HEARTS.equals(mMidCard.getSuit()));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(getCard(THREE, HEARTS).toString(), "THREE of HEARTS");
    }

    @Test
    public void testCompareTo() throws Exception {
        assertTrue(0 > mMidCard.compareTo(mHighCard));
        assertTrue(0 > mMidCard.compareTo(getCard(NINE, HEARTS)));
        assertTrue(0 == mMidCard.compareTo(mMidCard));
        assertTrue(0 < mMidCard.compareTo(getCard(SEVEN, HEARTS)));
        assertTrue(0 < mMidCard.compareTo(mLowCard));

        assertTrue(0 == mMidCard.compareTo(getCard(EIGHT, SPADES)));

        assertTrue(0 > mLowCard.compareTo(mHighCard));
        assertTrue(0 < mHighCard.compareTo(mLowCard));
    }
}
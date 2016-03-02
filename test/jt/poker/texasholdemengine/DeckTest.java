package jt.poker.texasholdemengine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static jt.poker.texasholdemengine.StandardCard.Rank.*;
import static jt.poker.texasholdemengine.StandardCard.Suit.*;
import static jt.poker.texasholdemengine.StandardCard.getCard;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Josh on 26/02/16.
 */
public class DeckTest {
    private Deck mDeck;
    private Deck mEmptyDeck;

    @Before
    public void setUp() throws Exception {
        mDeck = new Deck(new ArrayList<Card>(StandardCard.newDeck()), new Random(0));
        mEmptyDeck = new Deck(new ArrayList<Card>());
    }

    @Test
    public void testDraw() throws Exception {
        assertEquals(mDeck.draw(), getCard(SEVEN, SPADES));
    }

    @Test
    public void testDrawEmptyDeck() throws Exception {
        assertNull(mEmptyDeck.draw());
    }
}
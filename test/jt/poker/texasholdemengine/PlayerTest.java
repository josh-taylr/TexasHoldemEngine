package jt.poker.texasholdemengine;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static jt.poker.texasholdemengine.Card.Rank.*;
import static jt.poker.texasholdemengine.Card.Suit.*;
import static jt.poker.texasholdemengine.Card.getCard;
import static org.junit.Assert.*;

public class PlayerTest {

    private IPlayer mJohnDoe;

    @Before
    public void setUp() throws Exception {
        mJohnDoe = new Player("John Doe", 0);
    }

    @Test
    public void testSetCardsIsShallowCopy() throws Exception {
        List<Card> cards = Arrays.asList(getCard(TEN, HEARTS), getCard(FOUR, CLUBS));
        mJohnDoe.setHoldCards(cards);
        cards.set(0, getCard(FIVE, DIAMONDS));
        cards.set(1, getCard(SIX, SPADES));

        final List<Card> holdCards = mJohnDoe.getHoldCards();

        assertNotNull(holdCards);
        assertTrue(holdCards.containsAll(Arrays.asList(getCard(TEN, HEARTS), getCard(FOUR, CLUBS))));
    }
}
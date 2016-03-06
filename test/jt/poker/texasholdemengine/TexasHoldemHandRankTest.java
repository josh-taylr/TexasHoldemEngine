package jt.poker.texasholdemengine;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static jt.poker.texasholdemengine.Card.Rank.*;
import static jt.poker.texasholdemengine.Card.Suit.*;
import static jt.poker.texasholdemengine.Card.getCard;
import static org.junit.Assert.assertTrue;

/**
 * Created by Josh on 6/03/16.
 */
public class TexasHoldemHandRankTest {
    private IPlayer mJohnDoe;
    private TexasHoldemHandRank mHandRank;

    @Before
    public void setUp() throws Exception {
        mJohnDoe = new Player("John Doe", null);
        mHandRank = new TexasHoldemHandRank();
    }

    @Test
    public void testSetCommunityCards() throws Exception {

    }

    @Test
    public void testGetCommunityCards() throws Exception {

    }

    @Test
    public void testUpdatePlayerHand() throws Exception {

    }

    @Test
    public void testUpdatePlayerHighCard() throws Exception {
        mHandRank.setCommunityCards(Arrays.<Card>asList(
                getCard(ACE, SPADES),
                getCard(KING, HEARTS),
                getCard(JACK, DIAMONDS),
                getCard(SEVEN, SPADES),
                getCard(TWO, SPADES)));
        mJohnDoe.setHoldCards(Arrays.<Card>asList(getCard(EIGHT, SPADES), getCard(FIVE, CLUBS)));
        mHandRank.updatePlayerHand(mJohnDoe);
        List<Card> hand = mJohnDoe.getHand();
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(ACE, SPADES),
                getCard(KING, HEARTS),
                getCard(JACK, DIAMONDS),
                getCard(EIGHT, SPADES),
                getCard(SEVEN, SPADES)
        )));
    }

    @Test
    public void testUpdatePlayerPair() throws Exception {

    }

    @Test
    public void testUpdatePlayerTwoPair() throws Exception {

    }

    @Test
    public void testUpdatePlayerThreeOfAKind() throws Exception {

    }

    @Test
    public void testUpdatePlayerStraight() throws Exception {

    }

    @Test
    public void testUpdatePlayerFlush() throws Exception {

    }

    @Test
    public void testUpdatePlayerFullHouse() throws Exception {

    }

    @Test
    public void testUpdatePlayerFourOfAKind() throws Exception {

    }

    @Test
    public void testUpdatePlayerStraightFlush() throws Exception {

    }
}
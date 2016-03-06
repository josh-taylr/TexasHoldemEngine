package jt.poker.texasholdemengine;

import org.junit.Before;
import org.junit.BeforeClass;
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
    private static TexasHoldemHandRank mHandRank;

    @BeforeClass
    public static void oneTimeSetUp() {
        mHandRank = new TexasHoldemHandRank();
    }

    @Test
    public void testSetCommunityCards() throws Exception {

    }

    @Test
    public void testGetCommunityCards() throws Exception {

    }

    @Test
    public void testGetHandHand() throws Exception {

    }

    @Test
    public void testGetHandHighCard() throws Exception {
        List<Card> communitCards = Arrays.asList(
                getCard(ACE, SPADES),
                getCard(KING, HEARTS),
                getCard(JACK, DIAMONDS),
                getCard(SEVEN, SPADES),
                getCard(TWO, SPADES));

        List<Card> playerCards = Arrays.asList(getCard(EIGHT, SPADES), getCard(FIVE, CLUBS));

        List<Card> hand = mHandRank.getHand(communitCards, playerCards);

        assertTrue(hand.containsAll(Arrays.asList(
                getCard(ACE, SPADES),
                getCard(KING, HEARTS),
                getCard(JACK, DIAMONDS),
                getCard(EIGHT, SPADES),
                getCard(SEVEN, SPADES)
        )));
    }

    @Test
    public void testGetHandPair() throws Exception {

    }

    @Test
    public void testGetHandTwoPair() throws Exception {

    }

    @Test
    public void testGetHandThreeOfAKind() throws Exception {

    }

    @Test
    public void testGetHandStraight() throws Exception {

    }

    @Test
    public void testGetHandFlush() throws Exception {

    }

    @Test
    public void testGetHandFullHouse() throws Exception {

    }

    @Test
    public void testGetHandFourOfAKind() throws Exception {

    }

    @Test
    public void testGetHandStraightFlush() throws Exception {

    }
}
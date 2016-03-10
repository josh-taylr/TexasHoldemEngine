package jt.poker.texasholdemengine;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static jt.poker.texasholdemengine.Card.Rank.*;
import static jt.poker.texasholdemengine.Card.Suit.*;
import static jt.poker.texasholdemengine.Card.getCard;
import static org.junit.Assert.assertEquals;
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
    public void testGetHandHighCard() throws Exception {
        List<Card> communityCards = Arrays.asList(
                getCard(ACE, SPADES),
                getCard(KING, HEARTS),
                getCard(JACK, DIAMONDS),
                getCard(SEVEN, SPADES),
                getCard(TWO, CLUBS));

        List<Card> playerCards = Arrays.asList(getCard(EIGHT, SPADES), getCard(FIVE, CLUBS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertTrue(hand.size() == 5);
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
        List<Card> communityCards = Arrays.asList(
                getCard(ACE, SPADES),
                getCard(JACK, DIAMONDS),
                getCard(SEVEN, SPADES),
                getCard(FIVE, CLUBS),
                getCard(TWO, CLUBS));

        List<Card> playerCards = Arrays.asList(getCard(ACE, HEARTS), getCard(EIGHT, DIAMONDS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertTrue(hand.size() == 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(ACE, SPADES),
                getCard(ACE, HEARTS),
                getCard(JACK, DIAMONDS),
                getCard(EIGHT, DIAMONDS),
                getCard(SEVEN, SPADES)
        )));
    }

    @Test
    public void testGetHandTwoPair() throws Exception {
        final List<Card> communityCards = Arrays.asList(
                getCard(ACE, SPADES),
                getCard(SEVEN, DIAMONDS),
                getCard(TWO, CLUBS),
                getCard(TEN, HEARTS),
                getCard(QUEEN, CLUBS));
        final List<Card> playerCards = Arrays.asList(getCard(ACE, HEARTS), getCard(SEVEN, SPADES));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(ACE, SPADES),
                getCard(ACE, HEARTS),
                getCard(SEVEN, DIAMONDS),
                getCard(SEVEN, SPADES),
                getCard(QUEEN, CLUBS))));
    }

    @Test
    public void testGetHandThreeOfAKind() throws Exception {
        final List<Card> communityCards = Arrays.asList(
                getCard(ACE, SPADES),
                getCard(ACE, HEARTS),
                getCard(SEVEN, SPADES),
                getCard(TEN, HEARTS),
                getCard(QUEEN, CLUBS));
        final List<Card> playerCards = Arrays.asList(getCard(ACE, DIAMONDS), getCard(TWO, CLUBS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(ACE, SPADES),
                getCard(ACE, HEARTS),
                getCard(ACE, DIAMONDS),
                getCard(QUEEN, CLUBS),
                getCard(TEN, HEARTS))));
    }

    @Test
    public void testGetHandStraight() throws Exception {
        final List<Card> communityCards = Arrays.asList(
                getCard(FOUR, CLUBS),
                getCard(THREE, SPADES),
                getCard(SEVEN, SPADES),
                getCard(QUEEN, CLUBS),
                getCard(FIVE, DIAMONDS));
        final List<Card> playerCards = Arrays.asList(getCard(SIX, SPADES), getCard(TEN, HEARTS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(FOUR, CLUBS),
                getCard(THREE, SPADES),
                getCard(SEVEN, SPADES),
                getCard(FIVE, DIAMONDS),
                getCard(SIX, SPADES))));
    }

    @Test
    public void testGetHandStraightOverThreeOfAKind() throws Exception {
        final List<Card> communityCards = Arrays.asList(
                getCard(ACE, SPADES),
                getCard(ACE, CLUBS),
                getCard(QUEEN, SPADES),
                getCard(ACE, DIAMONDS),
                getCard(TEN, SPADES));
        final List<Card> playerCards = Arrays.asList(getCard(KING, HEARTS), getCard(JACK, DIAMONDS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(KING, HEARTS),
                getCard(QUEEN, SPADES),
                getCard(JACK, DIAMONDS),
                getCard(TEN, SPADES))) &&
                hand.contains(getCard(ACE, SPADES)) ||
                hand.contains(getCard(ACE, CLUBS)) ||
                hand.contains(getCard(ACE, DIAMONDS)));
    }

    @Test
    public void testGetHandFlush() throws Exception {
        final List<Card> communityCards = Arrays.asList(
                getCard(ACE, SPADES),
                getCard(SEVEN, SPADES),
                getCard(QUEEN, SPADES),
                getCard(JACK, DIAMONDS),
                getCard(TEN, SPADES));
        final List<Card> playerCards = Arrays.asList(getCard(KING, SPADES), getCard(TWO, DIAMONDS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(ACE, SPADES),
                getCard(KING, SPADES),
                getCard(QUEEN, SPADES),
                getCard(SEVEN, SPADES),
                getCard(TEN, SPADES))));
    }

    @Test
    public void testGetHandFlushOverStraight() throws Exception {
        final List<Card> communityCards = Arrays.asList(
                getCard(JACK, SPADES),
                getCard(FIVE, HEARTS),
                getCard(SEVEN, HEARTS),
                getCard(TEN, HEARTS),
                getCard(EIGHT, DIAMONDS));
        final List<Card> playerCards = Arrays.asList(getCard(TWO, HEARTS), getCard(NINE, HEARTS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(FIVE, HEARTS),
                getCard(SEVEN, HEARTS),
                getCard(TEN, HEARTS),
                getCard(TWO, HEARTS),
                getCard(NINE, HEARTS))));
    }

    @Test
    public void testGetHandFullHouse() throws Exception {
        final List<Card> communityCards = Arrays.asList(
                getCard(ACE, SPADES),
                getCard(ACE, HEARTS),
                getCard(QUEEN, SPADES),
                getCard(SEVEN, SPADES),
                getCard(TEN, SPADES));
        final List<Card> playerCards = Arrays.asList(getCard(ACE, DIAMONDS), getCard(SEVEN, DIAMONDS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(ACE, SPADES),
                getCard(ACE, HEARTS),
                getCard(ACE, DIAMONDS),
                getCard(SEVEN, SPADES),
                getCard(SEVEN, DIAMONDS))));
    }

    @Test
    public void testGetHandFourOfAKind() throws Exception {
        final List<Card> communityCards = Arrays.asList(
                getCard(TEN, SPADES),
                getCard(TEN, HEARTS),
                getCard(QUEEN, SPADES),
                getCard(TWO, HEARTS),
                getCard(SEVEN, DIAMONDS));
        final List<Card> playerCards = Arrays.asList(getCard(TEN, DIAMONDS), getCard(TEN, CLUBS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(TEN, SPADES),
                getCard(TEN, HEARTS),
                getCard(TEN, DIAMONDS),
                getCard(TEN, CLUBS),
                getCard(QUEEN, SPADES))));
    }

    @Test
    public void testGetHandStraightFlush() throws Exception {
        final List<Card> communityCards = Arrays.asList(
                getCard(JACK, HEARTS),
                getCard(TEN, HEARTS),
                getCard(SEVEN, HEARTS),
                getCard(NINE, HEARTS),
                getCard(QUEEN, HEARTS));
        final List<Card> playerCards = Arrays.asList(getCard(EIGHT, HEARTS), getCard(EIGHT, CLUBS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(JACK, HEARTS),
                getCard(TEN, HEARTS),
                getCard(NINE, HEARTS),
                getCard(QUEEN, HEARTS),
                getCard(EIGHT, HEARTS))));
    }

    @Test
    public void testGetHandStraightFlushOverFlush() throws Exception {
        final List<Card> communityCards = Arrays.asList(
                getCard(NINE, SPADES),
                getCard(ACE, SPADES),
                getCard(JACK, SPADES),
                getCard(EIGHT, SPADES),
                getCard(TEN, SPADES));
        final List<Card> playerCards = Arrays.asList(getCard(SEVEN, SPADES), getCard(QUEEN, DIAMONDS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(NINE, SPADES),
                getCard(JACK, SPADES),
                getCard(EIGHT, SPADES),
                getCard(TEN, SPADES),
                getCard(SEVEN, SPADES))));
    }

    @Test
    public void testGetHandFiveHighStraightFlushOverFlush() throws Exception {
        final List<Card> communityCards = Arrays.asList(
                getCard(FOUR, SPADES),
                getCard(TWO, SPADES),
                getCard(QUEEN, SPADES),
                getCard(ACE, SPADES),
                getCard(FIVE, SPADES));
        final List<Card> playerCards = Arrays.asList(getCard(THREE, SPADES), getCard(KING, SPADES));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(FOUR, SPADES),
                getCard(TWO, SPADES),
                getCard(THREE, SPADES),
                getCard(ACE, SPADES),
                getCard(FIVE, SPADES))));
    }

    @Test
    public void testGetHandRoyalFlush() throws Exception {
        final List<Card> communityCards = Arrays.asList(
                getCard(ACE, SPADES),
                getCard(SEVEN, SPADES),
                getCard(QUEEN, SPADES),
                getCard(JACK, SPADES),
                getCard(TEN, SPADES));
        final List<Card> playerCards = Arrays.asList(getCard(KING, SPADES), getCard(TWO, DIAMONDS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(ACE, SPADES),
                getCard(KING, SPADES),
                getCard(QUEEN, SPADES),
                getCard(JACK, SPADES),
                getCard(TEN, SPADES))));
    }
}
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
                getCard(ACE, SPADES),
                getCard(ACE, CLUBS),
                getCard(QUEEN, SPADES),
                getCard(ACE, DIAMONDS),
                getCard(TEN, SPADES));
        final List<Card> playerCards = Arrays.asList(getCard(KING, HEARTS), getCard(JACK, DIAMONDS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        List<Card> aceOfSpades = Arrays.asList(
                getCard(ACE, SPADES),
                getCard(KING, HEARTS),
                getCard(QUEEN, SPADES),
                getCard(JACK, DIAMONDS),
                getCard(TEN, SPADES));
        List<Card> aceOfClubs = Arrays.asList(
                getCard(ACE, HEARTS),
                getCard(KING, HEARTS),
                getCard(QUEEN, SPADES),
                getCard(JACK, DIAMONDS),
                getCard(TEN, SPADES));
        List<Card> aceOfDiamonds = Arrays.asList(
                getCard(ACE, DIAMONDS),
                getCard(KING, HEARTS),
                getCard(QUEEN, SPADES),
                getCard(JACK, DIAMONDS),
                getCard(TEN, SPADES));
        assertTrue(hand.containsAll(aceOfSpades) || hand.containsAll(aceOfClubs) || hand.containsAll(aceOfDiamonds));
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
                getCard(ACE, SPADES),
                getCard(ACE, HEARTS),
                getCard(SIX, SPADES),
                getCard(TWO, HEARTS),
                getCard(SEVEN, DIAMONDS));
        final List<Card> playerCards = Arrays.asList(getCard(ACE, DIAMONDS), getCard(ACE, CLUBS));

        List<Card> hand = mHandRank.getHand(communityCards, playerCards);

        assertEquals(hand.size(), 5);
        assertTrue(hand.containsAll(Arrays.asList(
                getCard(ACE, SPADES),
                getCard(ACE, HEARTS),
                getCard(ACE, DIAMONDS),
                getCard(ACE, CLUBS),
                getCard(SEVEN, DIAMONDS))));
    }

    @Test
    public void testGetHandStraightFlush() throws Exception {
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
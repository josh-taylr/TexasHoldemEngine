package jt.poker.texasholdemengine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static jt.poker.texasholdemengine.StandardCard.Rank.*;
import static jt.poker.texasholdemengine.StandardCard.Suit.*;
import static jt.poker.texasholdemengine.StandardCard.getCard;
import static org.junit.Assert.*;

/**
 * Created by Josh on 28/02/16.
 */
public class PlayerTest {

    private IPlayer mJohnDoe;
    private List<Card> mCommunityCards;

    @Before
    public void setUp() throws Exception {
        mCommunityCards = new ArrayList<>();
        mJohnDoe = new Player("John Doe");
        mJohnDoe.setCommunityCards(mCommunityCards);
    }

    @Test
    public void testSetCards() throws Exception {

    }

    @Test
    public void testSetCardsShallowCopy() throws Exception {

    }

    @Test
    public void testGetStackSize() throws Exception {

    }


    @Test
    public void testGetHandHighCard() throws Exception {
        mCommunityCards.addAll(Arrays.asList(
                getCard(ACE, SPADES),
                getCard(KING, HEARTS),
                getCard(JACK, DIAMONDS),
                getCard(SEVEN, SPADES),
                getCard(TWO, SPADES)
        ));
        mJohnDoe.setHoldCards(Arrays.<Card>asList(getCard(EIGHT, SPADES), getCard(FIVE, CLUBS)));

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
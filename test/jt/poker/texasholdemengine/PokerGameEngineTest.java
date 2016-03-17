package jt.poker.texasholdemengine;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

import static jt.poker.texasholdemengine.Card.Rank.*;
import static jt.poker.texasholdemengine.Card.Suit.*;
import static jt.poker.texasholdemengine.Card.getCard;
import static org.junit.Assert.*;

public class PokerGameEngineTest {

    private IPlayer mPlayer1;
    private IPlayer mPlayer2;
    private IPlayer mPlayer3;
    private IDeck mDeck;

    private PokerGameEngine mGame;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        mPlayer1 = new Player("John Doe", 2000);
        mPlayer2 = new Player("Jane Doe", 1500);
        mPlayer3 = new Player("Jameson Doe", 500);
        mDeck = new Deck(new ArrayList<>(Card.newDeck()), new Random(0));

        mGame = new PokerGameEngine(mDeck, Arrays.asList(mPlayer1, mPlayer2));
        mGame.setBigBlind(100);
        mGame.setSmallBlind(50);
    }

    @Test
    public void testConstructor() {
        assertNotNull(mGame);
    }

    @Test
    public void testDeal() {
        mGame.dealHoleCards();

        List<Card> holdCards1 = mPlayer1.getHoldCards();
        List<Card> holdCards2 = mPlayer2.getHoldCards();
        List<Card> holdCards3 = mPlayer3.getHoldCards();

        assertNotNull(holdCards1);
        assertEquals(2, holdCards1.size());
        assertTrue(holdCards1.containsAll(Arrays.asList(getCard(SEVEN, SPADES), getCard(FOUR, HEARTS))));

        assertNotNull(holdCards2);
        assertEquals(2, holdCards2.size());
        assertTrue(holdCards2.containsAll(Arrays.asList(getCard(SIX, HEARTS), getCard(FOUR, CLUBS))));

        assertNotNull(holdCards3);
        assertEquals(2, holdCards3.size());
        assertTrue(holdCards3.containsAll(Arrays.asList(getCard(SIX, HEARTS), getCard(FOUR, CLUBS))));
    }

    @Test
    public void testTakeBlinds() throws Exception {
        mGame.dealHoleCards();

        mGame.takeBlinds();

        assertEquals(1900, mPlayer1.getStack());
        assertEquals(1450, mPlayer2.getStack());
        assertEquals(500, mPlayer3.getStack());
    }

    @Test
    public void testPlayerCall() throws Exception {
        mGame.dealHoleCards();
        mGame.takeBlinds();

        mPlayer3.bet(100);

        assertEquals(400, mPlayer3.getStack());
        assertTrue(mGame.inMainPot(mPlayer3));
    }

    @Test
    public void testPlayerBetFold() throws Exception {
        mGame.dealHoleCards();
        mGame.takeBlinds();

        mPlayer3.fold();

        assertEquals(500, mPlayer3.getStack());
        assertFalse(mGame.inMainPot(mPlayer3));
    }

    @Test
    public void testPlayerBetRaise() throws Exception {
        mGame.dealHoleCards();
        mGame.takeBlinds();

        mPlayer3.bet(300);

        assertEquals(200, mPlayer3.getStack());
        assertTrue(mGame.inMainPot(mPlayer1));
    }

    @Test
    public void testPlayerBetAllIn() throws Exception {
        mGame.dealHoleCards();
        mGame.takeBlinds();

        mPlayer3.bet(500);

        assertEquals(0, mPlayer3.getStack());
        assertTrue(mGame.inMainPot(mPlayer3));
    }

    @Test
    public void testPlayerBetSplitsPot() throws Exception {
        mGame.dealHoleCards();
        mGame.takeBlinds();
        mPlayer3.bet(300);
        mPlayer1.bet(1500);
        mPlayer2.bet(1500);

        mPlayer3.bet(200);

        assertEquals(500, mPlayer1.getStack());
        assertTrue(mGame.inMainPot(mPlayer1));
        assertEquals(0, mPlayer2.getStack());
        assertTrue(mGame.inMainPot(mPlayer2));
        assertEquals(0, mPlayer3.getStack());
        assertFalse(mGame.inMainPot(mPlayer3));
    }

    @Test
    public void testPlayer1BetOutOfTurn() throws Exception {
        mGame.dealHoleCards();
        mGame.takeBlinds();

        thrown.expect(BetOutOfTurnException.class);

        mPlayer1.bet(300);
    }

    @Test
    public void testPlayer2BetOutOfOrder() throws Exception {
        mGame.dealHoleCards();
        mGame.takeBlinds();

        thrown.expect(BetOutOfTurnException.class);

        mPlayer2.bet(300);
    }

    @Test
    public void testPlayerBetAfterFold() throws Exception {
        mGame.dealHoleCards();
        mGame.takeBlinds();
        mPlayer3.fold();
        mPlayer1.bet(300);
        mPlayer2.bet(300);

        thrown.expect(NotInPotException.class);

        mPlayer3.bet(300);
    }

    @Test
    public void testPlayerBetInsufficientStack() throws Exception {
        mGame.dealHoleCards();
        mGame.takeBlinds();

        thrown.expect(InsufficientStack.class);

        mPlayer3.bet(501);
    }

    @Test
    public void testDealFlop() throws Exception {
        mGame.dealHoleCards();
        mGame.takeBlinds();
        mPlayer3.bet(300);
        mPlayer2.bet(200);
        mPlayer1.bet(250);
        //first round of betting ends

        mGame.dealFlop();
        final List<Card> communityCards = mGame.getCommunityCards();

        assertEquals(3, communityCards.size());
        thrown.expect(UnsupportedOperationException.class);
        communityCards.clear();
    }

    @Test
    public void testDealTurn() throws Exception {
        mGame.dealHoleCards();
        mGame.takeBlinds();
        mPlayer3.bet(300);
        mPlayer1.bet(200);
        mPlayer2.bet(250);
        mGame.dealFlop();
        mPlayer1.bet(100);
        mPlayer2.bet(0);
        mPlayer3.bet(50);

        mGame.dealTurn();
        final List<Card> communityCards = mGame.getCommunityCards();

        assertEquals(4, communityCards.size());
        thrown.expect(UnsupportedOperationException.class);
        communityCards.clear();
    }

    @Test
    public void testDealRiver() throws Exception {
        mGame.dealHoleCards();
        mGame.takeBlinds();
        mPlayer3.bet(300);
        mPlayer1.bet(200);
        mPlayer2.bet(250);
        mGame.dealFlop();
        mPlayer1.bet(100);
        mPlayer2.bet(0);
        mPlayer3.bet(50);
        mGame.dealTurn();
        mPlayer3.bet(100);
        mPlayer1.bet(0);
        mPlayer2.bet(50);
        mGame.dealRiver();

        final List<Card> communityCards = mGame.getCommunityCards();

        assertEquals(5, communityCards.size());
        thrown.expect(UnsupportedOperationException.class);
        communityCards.clear();
    }
}
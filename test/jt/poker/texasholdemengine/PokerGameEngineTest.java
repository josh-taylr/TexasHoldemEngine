package jt.poker.texasholdemengine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Josh on 26/02/16.
 */
public class PokerGameEngineTest {

    private IPlayer mPlayer1;
    private IPlayer mPlayer2;
    private IDeck mDeck;
    private PokerGameEngine mGame;

    @Before
    public void setUp() {
        mPlayer1 = new Player("John Doe");
        mPlayer2 = new Player("Jane Doe");
        mDeck = new Deck(new ArrayList<>(Card.newDeck()), new Random(0));

        mGame = new PokerGameEngine(mDeck, new ArrayList<>(Arrays.asList(mPlayer1, mPlayer2)));
    }

    @Test
    public void testConstructor() {
        assertNotNull(mGame);
    }

    @Test
    public void testDeal() {

    }
}
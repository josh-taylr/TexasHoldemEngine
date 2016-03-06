package jt.poker.texasholdemengine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
}
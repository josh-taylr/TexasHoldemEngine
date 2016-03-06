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
        mJohnDoe = new Player("John Doe", null);
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
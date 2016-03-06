package jt.poker.texasholdemengine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Josh on 26/02/16.
 */
public class Player implements IPlayer {
    private final String mName;
    private ArrayList<Card> mHoldCards;
    private List<Card> mCommunityCards;
    private int mStack;

    public Player(String name) {
        mName = name;
    }

    @Override
    public void setHoldCards(List<Card> holeCards) {
        mHoldCards = new ArrayList<>(holeCards); //store a copy of the list
    }

    @Override
    public List<Card> getHoldCards() {
        return mHoldCards;
    }

    @Override
    public void setCommunityCards(List<Card> communityCards) {
        mCommunityCards = communityCards;
    }

    @Override
    public List<Card> getCommunityCards() {
        return mCommunityCards;
    }

    @Override
    public void addStack(int increment) {
        mStack += increment;
    }

    @Override
    public int getStackSize() {
        return mStack;
    }
}

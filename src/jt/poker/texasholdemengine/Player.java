package jt.poker.texasholdemengine;

import java.util.ArrayList;
import java.util.List;

public class Player implements IPlayer {
    private final String mName;
    private ArrayList<Card> mHoldCards;
    private List<Card> mCommunityCards;
    private int mStack;

    public Player(String name, int stack) {
        mName = name;
        mStack = stack;
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
    public void setStack(int stack) {
        mStack = stack;
    }

    @Override
    public int getStack() {
        return mStack;
    }

    @Override
    public void bet(int size) {

    }

    @Override
    public void fold() {

    }
}

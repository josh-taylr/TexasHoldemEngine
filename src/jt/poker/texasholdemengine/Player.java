package jt.poker.texasholdemengine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Josh on 26/02/16.
 */
public class Player implements IPlayer {
    private String mName;
    private ArrayList<Card> mHoldCards;
    private int stack;
    private List<Card> mCommunityCards;

    public Player(String name, PokerGameEngine game) {
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

    }

    @Override
    public int getStackSize() {
        return 0;
    }

    @Override
    public void setHand(List<Card> hand) {

    }

    @Override
    public List<Card> getHand() {
        List<Card> cards = new ArrayList<>(7);
        cards.addAll(getHoldCards());
        cards.addAll(getCommunityCards());
        Collections.sort(cards);
        Collections.reverse(cards);
        return new ArrayList<>(cards.subList(0, Math.min(cards.size(), 5)));
    }
}

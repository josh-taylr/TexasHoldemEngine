package jt.poker.texasholdemengine;

import java.util.Arrays;
import java.util.List;

public class PokerGameEngine {

    private static final int FOLD = 0;
    private int mDealer;
    private IDeck mDeck;
    private List<IPlayer> mPlayers;
    private int mBigBlind;
    private int mSmallBlind;
    private List<Card> mCommunityCards;

    public PokerGameEngine(IDeck deck, List<IPlayer> players) {
        mDeck = deck;
        mPlayers = players;
        mDealer = 0;
    }

    public void setBigBlind(int bigBlind) {
        mBigBlind = bigBlind;
    }

    public int getBigBlind() {
        return mBigBlind;
    }

    public void setSmallBlind(int smallBlind) {
        mSmallBlind = smallBlind;
    }

    public int getSmallBlind() {
        return mSmallBlind;
    }

    public List<Card> getCommunityCards() {
        return mCommunityCards;
    }

    public void dealHoleCards() {
        for (IPlayer player : mPlayers) {
            player.setHoldCards(Arrays.asList(mDeck.draw(), mDeck.draw()));
        }
    }

    public void takeBlinds() {
        IPlayer bigBlind = mPlayers.get(mDealer);
        bigBlind.setStack(bigBlind.getStack() - getBigBlind());

        IPlayer smallBlind = mPlayers.get(mDealer + 1);
        smallBlind.setStack(smallBlind.getStack() - getSmallBlind());
    }

    public boolean inMainPot(IPlayer player) {
        return false;
    }

    public void dealFlop() {

    }

    public void dealTurn() {

    }

    public void dealRiver() {

    }
}

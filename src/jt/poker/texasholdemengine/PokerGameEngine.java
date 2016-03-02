package jt.poker.texasholdemengine;

import java.util.List;

/**
 * Created by Josh on 26/02/16.
 */
public class PokerGameEngine {

    private IDeck mDeck;
    private List<IPlayer> mPlayers;

    public PokerGameEngine(IDeck deck, List<IPlayer> players) {
        mDeck = deck;
        mPlayers = players;
    }


    public void run() {
        //deal Hole cards
        for (IPlayer player : mPlayers) {
//            player.setHoldCards(mDeck.draw(2));
        }
    }

    private boolean isWinner() {
        int playableCount = 0;
        for (IPlayer player : mPlayers) {
            playableCount += player.getStackSize() > 0 ? 1 : 0;
        }
        return playableCount == 1;
    }
}

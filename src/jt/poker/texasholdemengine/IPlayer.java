package jt.poker.texasholdemengine;

import java.util.List;

/**
 * Created by Josh on 26/02/16.
 */
public interface IPlayer {
    void setHoldCards(List<Card> cards);

    List<Card> getHoldCards();

    void setCommunityCards(List<Card> cards);

    List<Card> getCommunityCards();

    void addStack(int increment);

    int getStackSize();

    void setHand(List<Card> hand);

    List<Card> getHand();
}

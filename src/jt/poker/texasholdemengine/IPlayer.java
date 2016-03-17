package jt.poker.texasholdemengine;

import java.util.List;

public interface IPlayer {
    void setHoldCards(List<Card> cards);
    List<Card> getHoldCards();
    void setCommunityCards(List<Card> cards);
    List<Card> getCommunityCards();
    void setStack(int amount);
    int getStack();

    void bet(int size);

    void fold();
}

package jt.poker.texasholdemengine;

/**
 * Created by Josh on 26/02/16.
 */
public interface Card extends Comparable<Card> {
    boolean hasSameSuit(Card other);

    int compareRank(Card other);
}

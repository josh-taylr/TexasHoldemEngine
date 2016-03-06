package jt.poker.texasholdemengine;

/**
 * Created by Josh on 26/02/16.
 */
public interface IDeck<T extends Card> {
    T draw();
}

package jt.poker.texasholdemengine;

import java.util.ArrayList;

/**
 * Created by Josh on 26/02/16.
 */
public interface IDeck<T extends Card> {
    T draw();
}

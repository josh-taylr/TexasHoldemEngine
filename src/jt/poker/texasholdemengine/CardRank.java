package jt.poker.texasholdemengine;

import com.sun.tools.javac.util.List;

/**
 * Created by Josh on 29/02/16.
 */
public interface CardRank<T extends Card> {
    /**
     * @return up to five cards taken from the player's hole and community cards representing their best hand
     */
    List<T> pickHand(IPlayer player);
}

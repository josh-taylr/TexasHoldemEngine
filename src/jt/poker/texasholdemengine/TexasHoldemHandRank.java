package jt.poker.texasholdemengine;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class TexasHoldemHandRank {
	private final static int TWO_PAIR = 2;
	private final static int THREE_OF_A_KIND = 3;
	private static final int MAX_HAND_SIZE = 5;
    private List<Card> mCommunityCards;

    public TexasHoldemHandRank() {

	}

	public void setCommunityCards(List<Card> communityCards) {
		mCommunityCards = communityCards;
	}

	public List<Card> getCommunityCards() {
		return mCommunityCards;
	}

	public void updatePlayerHand(IPlayer player)
	{
		final List<Card> pool = new ArrayList<>();
		pool.addAll(getCommunityCards());
		pool.addAll(player.getHoldCards());

		final List<Card> hand = new ArrayList<>();

		Collections.sort(pool, Collections.reverseOrder());

        //straight flush
        for (int i = 0; i < pool.size() && hand.size() < MAX_HAND_SIZE; i++) {
            Card card = pool.get(i);
            for (int j = i+1; j < pool.size(); j++) {
                Card other = pool.get(j);
                if (card.hasSameSuit(other) && Math.abs(card.compareRank(other)) == 1) {

                }
            }
        }

		//three of a kind
        for (int i = 0; i + THREE_OF_A_KIND <= pool.size() && hand.size() + THREE_OF_A_KIND <= MAX_HAND_SIZE;) {
            List<Card> window = pool.subList(i, i + THREE_OF_A_KIND);
            if (Collections.frequency(window, window.get(0)) == THREE_OF_A_KIND) {
                hand.addAll(window);
                pool.removeAll(window);
            } else {
                i++;
            }
        }

		//pairs
		for (int i = 0; i + TWO_PAIR <= pool.size() && hand.size() + TWO_PAIR <= MAX_HAND_SIZE;) {
            List<Card> window = pool.subList(i, i + TWO_PAIR);
            if (Collections.frequency(window, window.get(0)) == TWO_PAIR) {
                hand.addAll(window);
                pool.removeAll(window);
            } else {
                i++;
            }
		}

		//high card
        for (int i = 0; i < pool.size() && hand.size() < MAX_HAND_SIZE; i++) {
            hand.add(pool.remove(i));
        }

		player.setHand(hand);
	}
}
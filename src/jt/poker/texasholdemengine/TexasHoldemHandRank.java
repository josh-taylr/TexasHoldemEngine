package jt.poker.texasholdemengine;

import jt.poker.texasholdemengine.Card.Rank;

import java.util.*;

public class TexasHoldemHandRank {
	private final static int TWO_PAIR = 2;
	private final static int THREE_OF_A_KIND = 3;
    private final static int FOUR_OF_A_KIND = 4;
	private static final int MAX_HAND_SIZE = 5;

	public List<Card> getHand(List<Card> communityCards, List<Card> playerCards)
	{
		final List<Card> pool = new ArrayList<>();
		pool.addAll(communityCards);
		pool.addAll(playerCards);

		final List<Card> hand = new ArrayList<>();

		Collections.sort(pool, Collections.reverseOrder());

        //straight flush


        //flush
        final Map<Card.Suit, List<Card>> map = new EnumMap<>(Card.Suit.class);
        for (Card card : pool) {
            List<Card> cards = map.get(card.getSuit());
            if (cards == null) {
                cards = new LinkedList<>();
                map.put(card.getSuit(), cards);
            }
            cards.add(card);
        }
        for (Card.Suit suit : Card.Suit.values()) {
            List<Card> cards = map.get(suit);
            if (cards != null && MAX_HAND_SIZE <= cards.size()) {
                hand.addAll(cards.subList(0, MAX_HAND_SIZE));
                return hand;
            }
        }

        //straight
        for (int i = 0; i + MAX_HAND_SIZE <= pool.size(); i++) {
            List<Card> window = pool.subList(i, i + MAX_HAND_SIZE);
            if (allRanksConsecutive(window)) {
                hand.addAll(window);
                return hand;
            }
        }
        //ace low straight
        if (pool.get(0).getRank() == Rank.ACE && pool.get(pool.size()-1).getRank() == Rank.TWO) {
            List<Card> window = pool.subList(pool.size() - (MAX_HAND_SIZE - 1), pool.size());
            if (allRanksConsecutive(window)) {
                hand.addAll(window);
                hand.add(pool.get(0));
                return hand;
            }
        }

        //four of a kind
        for (int i = 0; i + FOUR_OF_A_KIND <= pool.size() && hand.size() + FOUR_OF_A_KIND <= MAX_HAND_SIZE;) {
            List<Card> window = pool.subList(i, i + FOUR_OF_A_KIND);
            if (allRanksMatch(window)) {
                hand.addAll(window);
                window.clear();
            } else {
                i++;
            }
        }

		//three of a kind
        for (int i = 0; i + THREE_OF_A_KIND <= pool.size() && hand.size() + THREE_OF_A_KIND <= MAX_HAND_SIZE;) {
            List<Card> window = pool.subList(i, i + THREE_OF_A_KIND);
            if (allRanksMatch(window)) {
                hand.addAll(window);
                window.clear();
            } else {
                i++;
            }
        }

		for (int i = 0; i + TWO_PAIR <= pool.size() && hand.size() + TWO_PAIR <= MAX_HAND_SIZE;) {
            List<Card> window = pool.subList(i, i + TWO_PAIR);
            if (allRanksMatch(window)) {
                hand.addAll(window);
                window.clear();
            } else {
                i++;
            }
		}

		//high card
        hand.addAll(pool.subList(0, MAX_HAND_SIZE - hand.size()));

		return hand;
	}

    private boolean allRanksConsecutive(List<Card> cards) {
        for (int i = 0; i+1 < cards.size(); i++) {
            if (Math.abs(cards.get(i).compareRank(cards.get(i+1))) != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean allRanksMatch(List<Card> cards) {
        for (int i = 0; i+1 < cards.size(); i++) {
            if (cards.get(i).compareRank(cards.get(i+1)) != 0) {
                return false;
            }
        }
        return true;
    }
}
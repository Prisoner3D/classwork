package lab4_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A deck class which contains cards.
 * @author Thomas Zhou
 *
 */
public class Deck {

	private ArrayList<Card> Dealt = new ArrayList<Card>();
	private ArrayList<Card> unDealt = new ArrayList<Card>();

	/**
	 * Deck constructor
	 * 
	 * @param ranks The possible ranks for the deck.
	 * @param suits The possible suits for the deck.
	 * @param pointValues The corresponding point values of the ranks.
	 */
	public Deck(String[] ranks, String[] suits, int[] pointValues) {
		for (int rank = 0; rank < ranks.length; rank++) {
			for (int suit = 0; suit < suits.length; suit++) {
				Card card = new Card(ranks[rank], suits[suit], pointValues[rank]);
				unDealt.add(card);
			}
		}
	}

	/** 
	 * Deals a card from unDealt and moves it to Dealt.
	 * @return card The card dealt.
	 */
	public Card deal() {
		if (!unDealt.isEmpty()) {
			Card dealingCard = unDealt.get(0);
			unDealt.remove(0);
			Dealt.add(dealingCard);
			return dealingCard;
		}
		return null;
	}

	/**
	 * Checks if the deck is empty.
	 * @return empty
	 */
	public boolean isEmpty() {
		return unDealt.isEmpty();
	}
	
	/**
	 * Shuffles the deck
	 */
	public void shuffle() {
		unDealt.addAll(Dealt);
		Dealt.clear();
		Random random = new Random();
		for (int k = 51; k >= 1; k--) {
			int r = random.nextInt(k);
			Collections.swap(unDealt, k, r);
		}
	}

	/**
	 * The size of the deck
	 * @return
	 */
	public int size() {
		return unDealt.size();
	}
}

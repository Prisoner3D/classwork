package lab4_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

	private ArrayList<Card> unDealt = new ArrayList<Card>();
	private ArrayList<Card> Dealt = new ArrayList<Card>();
	
	public Deck(String[] ranks, String[] suits, int[] pointValues) {
		for (int rank = 0; rank < ranks.length; rank++)
		{
			for (int suit = 0; suit < suits.length; suit++)
			{
				Card card = new Card(ranks[rank], suits[suit], pointValues[rank]);
				unDealt.add(card);
			}
		}
	}

	public boolean isEmpty()
	{
		return unDealt.isEmpty();
	}
	
	public Card deal()
	{
		if (!unDealt.isEmpty())
		{
			Card dealingCard = unDealt.get(0);
			unDealt.remove(0);
			Dealt.add(dealingCard);
			return dealingCard;
		}
		return null;
	}
	
	public void shuffle()
	{
		unDealt.addAll(Dealt);
		Dealt.clear();
		Random random = new Random();
		for (int k = 51; k >= 1; k--)
		{
			int r = random.nextInt(k);
			Collections.swap(unDealt, k, r);
		}
	}
}

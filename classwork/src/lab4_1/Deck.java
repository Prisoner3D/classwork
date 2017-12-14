package lab4_1;

import java.util.ArrayList;

public class Deck {

	private ArrayList<Card> unDealt;
	private ArrayList<Card> Dealt;
	
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
		return unDealt.size() + Dealt.size() == 0;
	}
}

package lab4_1;

public class Runner {

	public static void main(String[] args) {
		String[] ranks = new String[] { "Jack", "Queen", "King", "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		String[] suits = new String[] { "Hearts", "Clubs", "Diamond", "Spades" };
		int[] pointValues = new int[] { 11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Deck deck = new Deck(ranks, suits, pointValues);
		deck.shuffle();
		for (int i = 0; i < deck.size(); i++) {
			Card current = deck.deal();
			i--;
			System.out.println(current);
		}
	}
}

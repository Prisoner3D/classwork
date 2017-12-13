package lab4_1;

public class Card {

	private String rank;
	private String suit;
	private int pointValue;
	
	public Card(String rank, String suit, int pointValue) {
		this.rank = rank;
		this.suit = suit;
		this.pointValue = pointValue;
	}

	public String getRank() {
		return rank;
	}

	public String getSuit() {
		return suit;
	}

	public int getPointValue() {
		return pointValue;
	}
	
	public boolean equals(Card otherCard)
	{
		return this.suit.equals(otherCard.getSuit()) && this.rank.equals(otherCard.getSuit()) && this.pointValue == otherCard.getPointValue();
	}
	
	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + ", pointValue=" + pointValue + "]";
	}

}

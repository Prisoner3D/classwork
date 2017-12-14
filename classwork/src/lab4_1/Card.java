package lab4_1;

public class Card {

	private String rank;
	private String suit;
	private int pointValue;
	
	/**
	 * Card constructor
	 * @param rank The rank of the card
	 * @param suit The suit of the card
	 * @param pointValue The 
	 */
	public Card(String rank, String suit, int pointValue) {
		this.rank = rank;
		this.suit = suit;
		this.pointValue = pointValue;
	}

	/**
	 * Returns the rank of the card.
	 * @return rank The rank of the card.
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * Returns the suit of the card.
	 * @return suit The suit of the card.
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * Returns the pointValue of the card.
	 * @return pointValue The point value of the card.
	 */
	public int getPointValue() {
		return pointValue;
	}
	
	/**
	 * Checks if two cards are equal
	 * @param otherCard The card checked with.
	 * @return equal Are the cards equal
	 */
	public boolean equals(Card otherCard)
	{
		return this.suit.equals(otherCard.getSuit()) && this.rank.equals(otherCard.getSuit()) && this.pointValue == otherCard.getPointValue();
	}
	
	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + ", pointValue=" + pointValue + "]";
	}

}

//imports

public class Card {
	//instance variables
	private int rank;
	private int suit;
	private int points;
	//constructor
	public Card(int rank, int suit){
		this.rank = rank;
		this.suit = suit;
		if(rank > 10){
			points = 10;
		} else {
			points = rank;
		}
		//this.points = rank;
	}
	//getters
	public int getRank(){
		return rank;
	}
	public int getSuit(){
		return suit;
	}
	public int getPoints(){
		return points;
	}
	//setters
	public void setPoints(int points){//ace can be 1 or 11
		this.points = points;
	}
	//methods
	public String toString(){
		String[] ranks = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		String[] suits = {"Spades", "Diamonds", "Clubs", "Hearts"};
		String cardName = ranks[rank] + " of " + suits[suit];
		return cardName;
	}
}
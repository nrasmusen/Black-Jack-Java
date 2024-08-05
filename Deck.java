//imports
import java.util.ArrayList;
import java.lang.Math;

public class Deck{
	//class Vars
	private ArrayList<Card> cardArr;
	private ArrayList<Card> usedCards;

	//Constructor
	public Deck(){
		cardArr = new ArrayList<Card>();
		usedCards = new ArrayList<Card>();
	}

	//Done
	public void createDeck(){
		//clear anything in arraylist
		cardArr.clear();
		//add cards
		for(int i = 1; i < 14; i++){//rank
			for(int j = 0; j < 4; j++){//suit
				Card card = new Card(i,j);//Rank-Suit Backwards
				cardArr.add(card);
			}
		}
	}

	//Done
	public void shuffleDeck(){
		Card temp;
		int index1 = (int) (Math.random()*52);
		int index2 = (int) (Math.random()*52);
		for(int i=0; i<401; i++){
			temp = cardArr.get(index1);
			cardArr.set(index1, cardArr.get(index2));
			cardArr.set(index2, temp);

			index1 = (int) (Math.random()*52);
			index2 = (int) (Math.random()*52);
		}
	}

	//Done
	public Card drawCard(){//draw the top card
		int index = (int) (Math.random()*52-usedCards.size());
		Card temp = cardArr.get(index);
		cardArr.remove(index);
		usedCards.add(temp);
		return temp;
	}
	

	//Done
	public void printDeck(){
		for(int i=0; i<cardArr.size(); i++){
			System.out.println(cardArr.get(i).toString() + " Points: " + cardArr.get(i).getPoints());
		}
	}
	//Done
	public int currentDeckSize(){
		return cardArr.size();
	}
}
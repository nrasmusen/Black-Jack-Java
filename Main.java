//imports
import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Main main = new Main();
		main.runProgram();
	}

	public void runProgram(){
		Deck deck = new Deck();
		Scanner scanner = new Scanner(System.in);
		boolean program = true;
		int totalPoints = 0;
		int deckSize = 0;
		Card currentCard;
		int highScore = 0;


		while(program){
			System.out.println("--------------------");
			System.out.println("High Score: " + highScore);
			System.out.println("Please select:");
			System.out.println("1: Play");
			System.out.println("2. Quit");
			int userInput = scanner.nextInt();
			if(userInput == 1){
				//Game
				deck.createDeck();
				deck.shuffleDeck();

				totalPoints = 0;
				currentCard = deck.drawCard();
				deckSize = deck.currentDeckSize();
				totalPoints += currentCard.getPoints();
				
				boolean game = true;
				while(game){
					System.out.println("--------------------");
					System.out.println("Current Card: " + currentCard.toString());
					System.out.println("Total Points: " + totalPoints);
					System.out.println("Cards Left: " + deckSize);
					System.out.println("");
					System.out.println("Would you like to:");
					System.out.println("1. Hit");
					System.out.println("2. Stay");
					int playerInput = scanner.nextInt();

					if(playerInput == 1){
						currentCard = deck.drawCard();
						deckSize = deck.currentDeckSize();
						totalPoints += currentCard.getPoints();

						if(totalPoints > 21){
							System.out.println("------------------");
							System.out.println("You Lose!");
							System.out.println("Points: " + totalPoints);
							game = false;
						}
					}
					else if(playerInput == 2){
						currentCard = deck.drawCard();
						totalPoints += currentCard.getPoints();

						if (totalPoints < 22) {
							System.out.println("------------------");
							System.out.println("You Win!");
							System.out.println("Points: " + totalPoints);
							game = false;

							if (totalPoints > highScore) {
								highScore = totalPoints;
							}
						}
						else {
							System.out.println("------------------");
							System.out.println("You Lose!");
							System.out.println("Points: " + totalPoints);
							game = false;
						}
					}
					else{
						System.out.println("Please select valid input");
					}

				}
			}
			else if(userInput == 2){
				program = false;
				scanner.close();
			}
			else{
				System.out.println("Please select valid input");
			}
		}
	}
}
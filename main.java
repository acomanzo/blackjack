import java.util.Random;
import java.util.Scanner;


public class blackjack {
	
	public static void main(String args[]){
		blackjackFunctions game = new blackjackFunctions();
		blackjackFunctions myFunction = new blackjackFunctions();
		Scanner kbReader = new Scanner(System.in);
		//Deck myDeck = new Deck();
		while(true)
		{
			//myDeck = myDeck.reset(myDeck);
			
			//blackjackFunctions myFunction = new blackjackFunctions();
			myFunction.blackjack = myFunction.blackjack.reset(myFunction.blackjack);
			myFunction.blackjack.shuffle(myFunction.blackjack);
			
			game.main();
			while(true){
				System.out.println("Your score: " + blackjackFunctions.winCount);
				System.out.println("Dealer score: " + blackjackFunctions.loseCount);
				System.out.println("Play again? Yes or no.");
				String newGame = kbReader.nextLine();
				if(newGame.equals("yes"))
				{
					blackjackFunctions.reset = true;
					blackjackFunctions.amtGames++;
					break;
				}
				else if(newGame.equals("no"))
				{
					blackjackFunctions.amtGames++;
					blackjackFunctions.reset = false;
					
					break;
				}
				else{
					System.out.println("Enter yes or no.");
				}
			}
			if(blackjackFunctions.reset == false){
				break;
			}
		}
		System.out.println(blackjackFunctions.amtGames);
		System.out.println(blackjackFunctions.winCount);
		System.out.println(blackjackFunctions.loseCount);
		System.out.println("Your win rate was " + 
		blackjackFunctions.winCount/(blackjackFunctions.winCount + blackjackFunctions.loseCount) * 100
		+"%, and your lose rate was " + 
		blackjackFunctions.loseCount/(blackjackFunctions.winCount + blackjackFunctions.loseCount) * 100
		+"%, and your blackjack rate was " + blackjackFunctions.blackjackCount/blackjackFunctions.amtGames + "%.");
	}
}



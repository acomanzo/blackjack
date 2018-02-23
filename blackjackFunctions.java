import java.util.Scanner;


public class blackjackFunctions {
	//Scanner kbReader = new Scanner(System.in);
	static boolean reset = true;
	static boolean doubleDown = false;
	static boolean twentyone = false;
	static boolean split = false;
	static boolean stay = false;
	public static double amtGames = 0;
	public static double winCount = 0;
	public static double loseCount = 0;
	public static double blackjackCount = 0;
	public static int playerHand = 0;
	public static int dealerHand = 0;
	public static int secondHand = 0;
	static int firstCard = 0;
	static int secondCard = 0;
	static int hitCount = 0; //keeping track of hits after split
	static int hitCount2 = 0;
	public static boolean ace = false;//could add code that initially puts ace in as 11, and if handsize goes over 21, then subtract 10
	//static int faceDown = 0;
	static Card facedown;
	//static blackjackFunctions foop = new blackjackFunctions();
	static blackjack poof = new blackjack();
	static Deck blackjack = new Deck();
	//blackjack myBlackjack = new blackjack();
	//myBlackjack.myDeck.shuffle(myBlackjack.myDeck);
	static public void main()
	{
		Scanner kbReader = new Scanner(System.in);
		//while(true)
		//{
			String choice = "";
			doubleDown = false;
			twentyone = false;
			split = false;
			stay = false;
			String wannaSplit = "";
			//blackjack.shuffle(blackjack);
			//blackjack.shuffle(blackjack);
			System.out.println("Welcome to Blackjack.");
			System.out.println("The dealer dealt themself the " + blackjack.getNextCard(0) + " and one face down card.");
			dealerHand = blackjack.getNextCard(0).getValue() + blackjack.getNextCard(1).getValue();
			//faceDown = blackjack.getNextCard(1).getValue();
			facedown = blackjack.getNextCard(1);
			blackjack.removeCard(0);
			blackjack.removeCard(1);
			System.out.println("The dealer has dealt you the "+ blackjack.getNextCard(0) + " and the " + blackjack.getNextCard(1) +".");
			if((blackjack.getNextCard(0).isAce() == true) || blackjack.getNextCard(1).isAce() == true)
			{
				playerHand = blackjack.getNextCard(0).getValue() + blackjack.getNextCard(1).getValue() + 10;
			}
			else{
				playerHand = blackjack.getNextCard(0).getValue() + blackjack.getNextCard(1).getValue();
			}
			firstCard = blackjack.getNextCard(0).getValue();
			secondCard = blackjack.getNextCard(1).getValue();
			blackjack.removeCard(0);
			blackjack.removeCard(1);
			if(firstCard == secondCard)//for splitting
			{
				System.out.println("Do you want to split your hand and play 2 concurrent hands? You'll be dealt up to two more cards per hand.");
				while(true)
				{
					wannaSplit = kbReader.nextLine();
					if(wannaSplit.equals("yes"))
					{
						split = true;
						//foop.splitting();
						blackjackFunctions.splitting();
						break;
					}
					else if(wannaSplit.equals("no"))
					{
						break;
					}
					else
					{
						System.out.println("ENTER yes OR no");
					}
				}
			}
			if(playerHand == 21 && dealerHand != 21)//if the user has a blackjack
			{
				twentyone = true;
				System.out.println("You blackjacked! That's when you have 21 exactly and the dealer does not.");
				blackjackCount++;
			}
			else if(playerHand == 11)//for double down
			{
				System.out.println("Double down? You'll get one more card, no more, and if you beat the dealer, you get 2 wins." +
						"But, if you lose, you get 2 losses. Enter yes or no.");
				while(true)
				{
					choice = "";
					choice = kbReader.nextLine();
					if(choice.equals("yes"))
					{
						doubleDown = true;
						//foop.doubleDown();
						blackjackFunctions.doubleDown();
						break;
					}
					else if(choice.equals("no"))
					{
						break;
					}
				}
			}
			if(twentyone == false && doubleDown == false && split == false){//for regular gameplay
				//foop.hitStay();
				blackjackFunctions.hitStay();
				//break;
			}
			blackjackFunctions.lastStuff();
			//if(reset == false){
			//	break;
			//}
		}
	//}

	static public void doubleDown(){
		System.out.println("You got the " + blackjack.getNextCard(0) + "!");
		playerHand = playerHand + blackjack.getNextCard(0).getValue();
		blackjack.removeCard(0);
		System.out.println("The dealer revealed their facedown card and it's the... " +
				facedown + ".");
		while(true)
		{
			System.out.println("The dealer drew the " + blackjack.getNextCard(0) + ".");
			if(blackjack.getNextCard(0).isAce() ==  true)
			{
				if(dealerHand + 11 > 21)
				{
					dealerHand = dealerHand + 1;
				}
				else
				{
					dealerHand = dealerHand + blackjack.getNextCard(0).getValue();
				}
			}
			dealerHand = dealerHand + blackjack.getNextCard(0).getValue();
			blackjack.removeCard(0);
			if(dealerHand >= 17)
			{
				break;
			}
		}
	}
	
	static public void lastStuff(){
		Scanner kbReader = new Scanner(System.in);
		String newGame = "";
		if(split == true)
		{
			System.out.println("Your first hand: " + blackjackFunctions.playerHand);
			System.out.println("Your second hand: " + blackjackFunctions.secondHand);
			System.out.println("Dealer's hand: " + blackjackFunctions.dealerHand);
		}
		else{
			System.out.println("Your hand: " + blackjackFunctions.playerHand);
			System.out.println("Dealer's hand: " + blackjackFunctions.dealerHand);
		}
		if(blackjackFunctions.dealerHand > 21 && doubleDown == false && (split == false))
		{
			System.out.println("You win!!!a");
			blackjackFunctions.winCount++;
		}
		else if((blackjackFunctions.playerHand >= 21 && blackjackFunctions.dealerHand >= 21) || (blackjackFunctions.playerHand == blackjackFunctions.dealerHand) && (split == false))
		{
			System.out.println("Push (tie)");
		}
		else if(blackjackFunctions.playerHand > blackjackFunctions.dealerHand && blackjackFunctions.playerHand <= 21 && doubleDown == false && (split == false))
		{
			System.out.println("You win!!!b");
			blackjackFunctions.winCount++;
		}
		else if(blackjackFunctions.playerHand < blackjackFunctions.dealerHand && blackjackFunctions.dealerHand <=21 && doubleDown == false && (split == false))
		{
			System.out.println("You lose!!!c");
			blackjackFunctions.loseCount++;
		}
		else if(blackjackFunctions.playerHand > 21 && blackjackFunctions.dealerHand <= 21 && doubleDown == false && (split == false))
		{
			System.out.println("You lose!d");
			blackjackFunctions.loseCount++;
		}
		//taking into account extra wins/losses from doubleDown
		if(blackjackFunctions.dealerHand > 21 && doubleDown == true)
		{
			System.out.println("You win!!!e");
			blackjackFunctions.winCount+=2;
		}
		else if(blackjackFunctions.playerHand > blackjackFunctions.dealerHand && blackjackFunctions.playerHand <= 21 && doubleDown == true)
		{
			System.out.println("You win!!!f");
			blackjackFunctions.winCount+=2;
		}
		else if(blackjackFunctions.playerHand < blackjackFunctions.dealerHand && blackjackFunctions.dealerHand <=21 && doubleDown == true)
		{
			System.out.println("You lose!!!g");
			blackjackFunctions.loseCount+=2;
		}
		else if(blackjackFunctions.playerHand > 21 && blackjackFunctions.dealerHand <= 21 && doubleDown == true)
		{
			System.out.println("You lose!h");
			blackjackFunctions.loseCount+=2;
		}
		//for splitting
		if(blackjackFunctions.dealerHand > 21 && split == true && doubleDown == false)
		{
			System.out.println("You win!!!i");
			blackjackFunctions.winCount+=2;
		}
		else if(blackjackFunctions.dealerHand == 21 && blackjackFunctions.playerHand != 21 && blackjackFunctions.secondHand != 21 && split == true)
		{
			System.out.println("You lost on both hand.");
			blackjackFunctions.loseCount-=2;
		}
		else if((blackjackFunctions.playerHand == 21 && blackjackFunctions.dealerHand != 21 && blackjackFunctions.secondHand < blackjackFunctions.dealerHand) || (blackjackFunctions.secondHand == 21 && blackjackFunctions.dealerHand != 21 && blackjackFunctions.playerHand < blackjackFunctions.dealerHand) && split == true)
		{
			System.out.println("You only won on one hand.");
			blackjackFunctions.winCount++;
		}
		else if((blackjackFunctions.playerHand >= 21 && blackjackFunctions.dealerHand >= 21 && blackjackFunctions.secondHand >= 21) || (blackjackFunctions.playerHand == blackjackFunctions.dealerHand && blackjackFunctions.playerHand == blackjackFunctions.secondHand) && (split == true) && doubleDown == false)
		{
			System.out.println("Push (tie)j");
		}
		else if(((blackjackFunctions.playerHand >= 21 && blackjackFunctions.dealerHand >= 21 && blackjackFunctions.secondHand < 22) || (blackjackFunctions.secondHand >= 21 && blackjackFunctions.dealerHand >= 21 && blackjackFunctions.playerHand < 22) || (blackjackFunctions.playerHand == blackjackFunctions.dealerHand && blackjackFunctions.secondHand > blackjackFunctions.dealerHand && blackjackFunctions.secondHand < 22) || (blackjackFunctions.secondHand == blackjackFunctions.dealerHand && blackjackFunctions.playerHand > blackjackFunctions.dealerHand && blackjackFunctions.playerHand < 22)) && split == true && doubleDown == false)
		{
			System.out.println("You only won on 1 hand.k");
			blackjackFunctions.winCount++;
		}
		else if((blackjackFunctions.playerHand == blackjackFunctions.dealerHand && blackjackFunctions.secondHand < blackjackFunctions.dealerHand) || (blackjackFunctions.secondHand == blackjackFunctions.dealerHand && blackjackFunctions.playerHand < blackjackFunctions.dealerHand) && split == true && doubleDown == false)
		{
			System.out.println("You only lost on 1 hand.l");
			blackjackFunctions.loseCount++;
		}
		else if((blackjackFunctions.playerHand > blackjackFunctions.dealerHand && blackjackFunctions.playerHand <= 21) && (blackjackFunctions.secondHand > blackjackFunctions.dealerHand && blackjackFunctions.secondHand <= 21) && (split == true) && doubleDown == false)
		{
			System.out.println("You win on both hands!!!m");
			blackjackFunctions.winCount+=2;
		}
		else if((blackjackFunctions.playerHand < blackjackFunctions.dealerHand && blackjackFunctions.dealerHand <=21) && (blackjackFunctions.secondHand < blackjackFunctions.dealerHand && blackjackFunctions.dealerHand <=21) && (split == true) && doubleDown == false)
		{
			System.out.println("You lose on both hands!!!n");
			blackjackFunctions.loseCount+=2;
		}
		else if((blackjackFunctions.playerHand > 21 && blackjackFunctions.dealerHand <= 21) && (blackjackFunctions.secondHand > 21 && blackjackFunctions.dealerHand <= 21) && (split == true) && doubleDown == false)
		{
			System.out.println("You lose!o");
			blackjackFunctions.loseCount++;
		}
		System.out.println(blackjackFunctions.amtGames);
		System.out.println(blackjackFunctions.winCount);
		System.out.println(blackjackFunctions.loseCount);
		
		/*while(true){
			System.out.println("Your score: " + winCount);
			System.out.println("Dealer score: " + loseCount);
			System.out.println("Play again? Yes or no.");
			newGame = kbReader.nextLine();
			if(newGame.equals("yes"))
			{
				reset = true;
				amtGames++;
				blackjack.reset(blackjack);
				break;
			}
			else if(newGame.equals("no"))
			{
				amtGames++;
				reset = false;
				
				break;
			}
			else{
				System.out.println("Enter yes or no.");
			}
		}*/
	}

	static public void splitting(){
		Scanner kbReader = new Scanner(System.in);
		secondHand = secondCard;
		playerHand-=firstCard;
		if(firstCard == 11 && secondCard == 11)//splitting aces
		{
			if(blackjack.getNextCard(0).isAce() == true)
			{
				if(playerHand + 11 > 21)
				{
					playerHand = playerHand + 1;
				}
				else
				{
					playerHand = blackjack.getNextCard(0).getValue() + playerHand;
				}
			}
			else
			{
				playerHand = playerHand + blackjack.getNextCard(0).getValue();
			}
			if(blackjack.getNextCard(1).isAce() == true)
			{
				if(playerHand + 11 > 21)
				{
					playerHand = playerHand + 1;
				}
				else
				{
					playerHand = blackjack.getNextCard(1).getValue() + playerHand;
				}
			}
			else
			{
				playerHand = playerHand + blackjack.getNextCard(1).getValue();
			}
			System.out.println("Okay, since your first two cards were aces, you can only be hit 1 " +
					"card in each hand. You are dealt the " + blackjack.getNextCard(0) + " for " +
							"your first hand, and the " + blackjack.getNextCard(1) + " for " +
									"your second hand.");
			blackjack.removeCard(0);
			blackjack.removeCard(1);
		}
		else
		{
			System.out.println("The dealer deals you the " + blackjack.getNextCard(0) + " for your first hand," +
					" and the " + blackjack.getNextCard(1) + " for your second hand.");
			playerHand += blackjack.getNextCard(0).getValue();
			secondHand += blackjack.getNextCard(1).getValue();
			blackjack.removeCard(0);
			blackjack.removeCard(1);
			System.out.println("Hit or stay on your first hand? (Value = " + playerHand);
			while(hitCount < 2 && playerHand < 22){
				String myChoice = "";
				myChoice = kbReader.nextLine();
				if(myChoice.equals("hit")){
					System.out.println("It's the " + blackjack.getNextCard(0) + "!");
					if(blackjack.getNextCard(0).isAce() == true)
					{
						if(playerHand + 11 > 21)
						{
							playerHand = playerHand + 1;
						}
						else
						{
							playerHand = blackjack.getNextCard(0).getValue() + playerHand;
						}
					}
					else
					{
						playerHand = playerHand + blackjack.getNextCard(0).getValue();
					}
					blackjack.removeCard(0);
					System.out.println("Hit again or stay?");
				}
				else if(myChoice.equals("stay")){
					break;
				}
				else{
					System.out.println("Enter hit or stay!!!");
				}
			}
			System.out.println("Hit or stay on your second hand? Value = " + secondHand);
			while(hitCount2 < 2 && secondHand < 22){
				String myChoice = "";
				myChoice = kbReader.nextLine();
				if(myChoice.equals("hit")){
					System.out.println("It's the " + blackjack.getNextCard(0) + "!");
					if(blackjack.getNextCard(0).isAce() == true)
					{
						if(secondHand + 11 > 21)
						{
							secondHand = secondHand + 1;
						}
						else
						{
							secondHand = blackjack.getNextCard(0).getValue() + secondHand;
						}
					}
					else
					{
						secondHand = secondHand + blackjack.getNextCard(0).getValue();
					}
					blackjack.removeCard(0);
					System.out.println("Hit again or stay?");
				}
				else if(myChoice.equals("stay")){
					break;
				}
				else{
					System.out.println("Enter hit or stay!!!");
				}
			}
		}
		
		System.out.println("Now the dealer draws.");
		System.out.println("The dealer revealed their facedown card and it's the... " +
				facedown + ".");
		while(true)
		{
			System.out.println("The dealer drew the " + blackjack.getNextCard(0) + ".");
			if(blackjack.getNextCard(0).isAce() ==  true)
			{
				if(dealerHand + 11 > 21)
				{
					dealerHand = dealerHand + 1;
				}
				else
				{
					dealerHand = dealerHand + blackjack.getNextCard(0).getValue();
				}
			}
			dealerHand = dealerHand + blackjack.getNextCard(0).getValue();
			blackjack.removeCard(0);
			if(dealerHand >= 17)
			{
				break;
			}
		}
	}

	static public void hitStay(){
		Scanner kbReader = new Scanner(System.in);
		//System.out.println("Do you want to hit or stay? Hand value = " + playerHand);
		while(playerHand <= 21){
			System.out.println("Do you want to hit or stay? Hand value = " + playerHand);
			String myChoice = "";
			myChoice = kbReader.nextLine();
			if(myChoice.equals("hit")){
				System.out.println("It's the " + blackjack.getNextCard(0) + "!");
				if(blackjack.getNextCard(0).isAce() == true)
				{
					if(playerHand + 11 > 21)
					{
						playerHand = playerHand + 1;
					}
					else
					{
						playerHand = blackjack.getNextCard(0).getValue() + playerHand;
					}
				}
				else
				{
					playerHand = playerHand + blackjack.getNextCard(0).getValue();
				}
				blackjack.removeCard(0);
				/*if(playerHand >= 21)
				{
					break;
				}*/
				//System.out.println("Hit again or stay?");
			}
			else if(myChoice.equals("stay")){
				stay = true;
				System.out.println("The dealer revealed their facedown card and it's the... " +
						facedown + ".");
				while(true)
				{
					System.out.println("The dealer drew the " + blackjack.getNextCard(0) + ".");
					if(blackjack.getNextCard(0).isAce() ==  true)
					{
						if(dealerHand + 11 > 21)
						{
							dealerHand = dealerHand + 1;
						}
						else
						{
							dealerHand = dealerHand + blackjack.getNextCard(0).getValue();
						}
					}
					dealerHand = dealerHand + blackjack.getNextCard(0).getValue();
					blackjack.removeCard(0);
					if(dealerHand >= 17)
					{
						break;
					}
				}
			}
			else{
				System.out.println("Enter hit or stay!!!");
			}
			if(stay == true){
				break;
			}
		}
	}
}




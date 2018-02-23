import java.util.ArrayList;
import java.util.Random;

public class Deck {
	public ArrayList<Card> deck = new ArrayList<Card>();
	public ArrayList<Card> shuffled = new ArrayList<Card>();

	public Deck() {
		for (int s = 0; s < 4; s++) {
			for (int k = 0; k < 13; k++) {
				if (k == 0) {
					if (s == 0) {
						deck.add(new Card("ace", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("ace", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("ace", "spades"));
					} else if (s == 3) {
						deck.add(new Card("ace", "diamonds"));
					}
				} else if (k == 1) {
					if (s == 0) {
						deck.add(new Card("two", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("two", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("two", "spades"));
					} else if (s == 3) {
						deck.add(new Card("two", "diamonds"));
					}
				} else if (k == 2) {
					if (s == 0) {
						deck.add(new Card("three", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("three", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("three", "spades"));
					} else if (s == 3) {
						deck.add(new Card("three", "diamonds"));
					}
				} else if (k == 3) {
					if (s == 0) {
						deck.add(new Card("four", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("four", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("four", "spades"));
					} else if (s == 3) {
						deck.add(new Card("four", "diamonds"));
					}
				} else if (k == 4) {
					if (s == 0) {
						deck.add(new Card("five", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("five", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("five", "spades"));
					} else if (s == 3) {
						deck.add(new Card("five", "diamonds"));
					}
				} else if (k == 5) {
					if (s == 0) {
						deck.add(new Card("six", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("six", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("six", "spades"));
					} else if (s == 3) {
						deck.add(new Card("six", "diamonds"));
					}
				} else if (k == 6) {
					if (s == 0) {
						deck.add(new Card("seven", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("seven", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("seven", "spades"));
					} else if (s == 3) {
						deck.add(new Card("seven", "diamonds"));
					}
				} else if (k == 7) {
					if (s == 0) {
						deck.add(new Card("eight", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("eight", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("eight", "spades"));
					} else if (s == 3) {
						deck.add(new Card("eight", "diamonds"));
					}
				} else if (k == 8) {
					if (s == 0) {
						deck.add(new Card("nine", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("nine", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("nine", "spades"));
					} else if (s == 3) {
						deck.add(new Card("nine", "diamonds"));
					}
				} else if (k == 9) {
					if (s == 0) {
						deck.add(new Card("ten", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("ten", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("ten", "spades"));
					} else if (s == 3) {
						deck.add(new Card("ten", "diamonds"));
					}
				} else if (k == 10) {
					if (s == 0) {
						deck.add(new Card("jack", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("jack", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("jack", "spades"));
					} else if (s == 3) {
						deck.add(new Card("jack", "diamonds"));
					}
				} else if (k == 11) {
					if (s == 0) {
						deck.add(new Card("queen", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("queen", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("queen", "spades"));
					} else if (s == 3) {
						deck.add(new Card("queen", "diamonds"));
					}
				} else if (k == 12) {
					if (s == 0) {
						deck.add(new Card("king", "hearts"));
					} else if (s == 1) {
						deck.add(new Card("king", "clubs"));
					} else if (s == 2) {
						deck.add(new Card("king", "spades"));
					} else if (s == 3) {
						deck.add(new Card("king", "diamonds"));
					}
				}
			}
		}
	}
	
	public Card getNextCard(int a){
		return deck.get(a+1);
	}
	
	public ArrayList shuffle(Deck a){
		Random rand = new Random();
		for(int i=0;i<52;i++){
			shuffled.add(deck.remove(rand.nextInt(deck.size())));
		}
		for(int i=0;i<52;i++){
			deck.add(shuffled.get(i));
		}
		
		return deck;
	}
	
	public Deck reset(Deck a){
		
		return new Deck();//deck name = deck name.reset
	}
	
	public String toString(){
		return deck+".";
	}
	
	public ArrayList removeCard(int a){
		deck.remove(a);
		return deck;
	}
}



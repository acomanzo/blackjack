public class Card {
	String kind; //type of card (five, king, ten, etc.)
	String suit; //shape of card (spades, diamonds, clubs, hearts)
	
	public Card(String a, String b){
		kind = a.toLowerCase();
		suit = b.toLowerCase();
	}
	
	public String getKind(){
		return kind;
	}
	
	public String getSuit(){
		return suit;
	}
	
	public int getValue(){
		if(kind.equals("ace")){
			return 1;
		}
		else if(kind.equals("two")){
			return 2;
		}
		else if(kind.equals("three")){
			return 3;
		}
		else if(kind.equals("four")){
			return 4;
		}
		else if(kind.equals("five")){
			return 5;
		}
		else if(kind.equals("six")){
			return 6;
		}
		else if(kind.equals("seven")){
			return 7;
		}
		else if(kind.equals("eight")){
			return 8;
		}
		else if(kind.equals("nine")){
			return 9;
		}
		else if(kind.equals("ten")){
			return 10;
		}
		else if(kind.equals("jack")){
			return 10;
		}
		else if(kind.equals("queen")){
			return 10;
		}
		else if(kind.equals("king")){
			return 10;
		}
		else{
			return 0;
		}
	}
	
	public boolean isAce(){
		if(kind.equals("ace")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isFace(){
		if(kind.equals("king") || kind.equals("queen") || kind.equals("jack")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		return kind+" of "+suit;
	}
}



/**
 * 
 */

/**
 * @author eldad and vlad
 * 
 *
 */
public class Card {

	private int num;
	private int suit;

	public Card(int num, int suit) {

		this.num = num;
		this.suit = suit;
	}

	public int getNum() {
		return this.num;
	}

	public int getSuit() {
		return this.suit;
	}

	public String toString() {
		String str = "" + this.getNum();
		switch (this.getSuit()) {
		case 0:
			str += "C";
			break;
		case 1:
			str += "D";
			break;
		case 2:
			str += "H";
			break;
		case 3:
			str += "S";
			break;
		}
		return str;
	}

	public int compareTo(Card other) {
		int numDif = this.getNum() - other.getNum();

		return numDif == 0 ? this.getSuit() - other.getSuit() : numDif;
	}

}
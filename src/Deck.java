
public class Deck {

	private Card[] cards;
	private int size;
	private static final int CARD_TYPES = 4;

	public Deck(int num) {
		this.size = num * CARD_TYPES;
		cards = new Card[this.size];
		for (int i = 0; i < num; i++)
			for (int j = 0; j < CARD_TYPES; j++)
				cards[CARD_TYPES * i + j] = new Card(i, j);
	}

	public Deck(Deck from, int num) {
		this.size = from.getNumCards() > num ? num : from.getNumCards();
		this.cards = new Card[this.size];
		for (int i = 0; i < num; i++)
			cards[i] = from.takeOne();
	}

	public Deck(Deck first, Deck second) {
		boolean flag = true;
		int i;
		this.size = first.getNumCards() + second.getNumCards();
		this.cards = new Card[this.size];
		for (i = 0; i < this.size && first.getNumCards() != 0 && second.getNumCards() != 0; i++) {
			this.cards[i] = i % 2 == 0 ? first.takeOne() : second.takeOne();
			flag = !flag;
		}
		while (first.getNumCards() != 0)
			this.cards[i++] = first.takeOne();
		while (second.getNumCards() != 0)
			this.cards[i++] = second.takeOne();
	}

	public int getNumCards() {
		return this.size;
	}

	public Card takeOne() {
		return cards[--size];
	}

	public String toString() {
		String str = "[";
		if (this.size == 0)
			return str + "]";
		for (int i = 0; i < this.getNumCards() - 1; i++)
			str += this.cards[i].toString() + ", ";
		return str + this.cards[this.size - 1].toString() + "]";
	}

	private void swap(int i, int j) {
		Card tmp = this.cards[i];
		this.cards[i] = this.cards[j];
		this.cards[j] = tmp;
	}

	public void sort() {
		for (int i = 0; i < this.size; i++)
			for (int j = 0; j < this.size - i - 1; j++)
				if (this.cards[j].compareTo(this.cards[j + 1]) > 0)
					swap(j, j + 1);
	}
}

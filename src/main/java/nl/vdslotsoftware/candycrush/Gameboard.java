package nl.vdslotsoftware.candycrush;

public class Gameboard {

	private Candy[][] candyRows;

	private Gameboard(Candy[][] candyRows) {
		this.candyRows = candyRows;
	}

	public boolean isMovePossible() {
		return true;
	}

	public static Gameboard create(Candy[][] candyRows) {
		return new Gameboard(candyRows);
	}

}

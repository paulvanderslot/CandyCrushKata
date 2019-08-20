package nl.vdslotsoftware.candycrush;

import java.util.stream.IntStream;

public class Gameboard {

	private Candy[][] candyRows;

	private Gameboard(Candy[][] candyRows) {
		this.candyRows = candyRows;
	}

	public static Gameboard create(Candy[][] candyRows) {
		return new Gameboard(candyRows);
	}

	public boolean isMovePossible() {
		Candy[] firstRow = candyRows[0];

		return isMovePossible(firstRow);
	}

	private boolean isMovePossible(Candy[] firstRow) {
		return IntStream.range(0, firstRow.length).anyMatch(number -> canSwap(firstRow, number));
	}

	private boolean canSwap(Candy[] row, int candyNumber) {
		return false;
	}

}

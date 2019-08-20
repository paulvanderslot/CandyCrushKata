package nl.vdslotsoftware.candycrush;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GameBoardSingleRowTest {

	@Test
	void moveIsPossible() throws Exception {
		Candy[][] candyRows = { { Candy.BLUE, Candy.GREEN, Candy.BLUE, Candy.BLUE } };
		Gameboard gameboard = Gameboard.create(candyRows);
		assertThat(gameboard.isMovePossible()).isTrue();
	}

	@Test
	void moveIsNotPossible() throws Exception {
		Candy[][] candyRows = { { Candy.BLUE, Candy.GREEN, Candy.GREEN, Candy.BLUE } };
		Gameboard gameboard = Gameboard.create(candyRows);
		assertThat(gameboard.isMovePossible()).isFalse();
	}

}

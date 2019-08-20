package nl.vdslotsoftware.candycrush;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CandyCrushAcceptanceTest {

	@Test
	void isMovePossible() throws Exception {
		Candy[][] candyRows = { { Candy.BLUE, Candy.GREEN, Candy.BLUE, Candy.BLUE }, };
		Gameboard gameboard = Gameboard.create(candyRows);
		assertThat(gameboard.isMovePossible()).isTrue();
	}

}

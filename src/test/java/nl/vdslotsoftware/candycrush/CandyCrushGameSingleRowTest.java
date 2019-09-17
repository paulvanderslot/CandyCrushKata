package nl.vdslotsoftware.candycrush;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CandyCrushGameSingleRowTest {

    @Test
    void moveIsPossible() throws Exception {
        Candy[][] candyRows = { { Candy.BLUE, Candy.GREEN, Candy.BLUE, Candy.BLUE } };
        GameBoard gameboard = GameBoard.create(candyRows);
        CandyCrushGame game = new CandyCrushGame(gameboard, new SwapDetector(new CandySwapper()));

        assertThat(game.isMovePossible()).isTrue();
    }

    @Test
    void moveIsNotPossible() throws Exception {
        Candy[][] candyRows = { { Candy.BLUE, Candy.GREEN, Candy.GREEN, Candy.BLUE } };
        GameBoard gameboard = GameBoard.create(candyRows);
        CandyCrushGame game = new CandyCrushGame(gameboard, new SwapDetector(new CandySwapper()));

        assertThat(game.isMovePossible()).isFalse();
    }

}

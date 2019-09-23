package nl.vdslotsoftware.candycrush;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CandyCrushGameAcceptenceTest {

    @Test
    void singleRowBoard_moveIsPossible() throws Exception {
        Candy[][] candyRows = { { Candy.BLUE, Candy.GREEN, Candy.BLUE, Candy.BLUE } };
        GameBoard gameboard = GameBoard.create(candyRows);

        assertThat(gameboard.isMovePossible()).isTrue();
    }

    @Test
    void singleRowBoard_moveIsNotPossible() throws Exception {
        Candy[][] candyRows = { { Candy.BLUE, Candy.GREEN, Candy.GREEN, Candy.BLUE } };
        GameBoard gameboard = GameBoard.create(candyRows);

        assertThat(gameboard.isMovePossible()).isFalse();
    }

    @Test
    void multiRowBoard_moveIsPossible() throws Exception {
        Candy[][] candyRows = {
            { Candy.YELLOW, Candy.GREEN, Candy.YELLOW, Candy.RED },
            { Candy.BLUE, Candy.GREEN, Candy.BLUE, Candy.BLUE },
            { Candy.BLUE, Candy.YELLOW, Candy.YELLOW, Candy.RED } };
        GameBoard gameboard = GameBoard.create(candyRows);

        assertThat(gameboard.isMovePossible()).isTrue();
    }

    @Test
    void multiRowBoard_moveIsNotPossible() throws Exception {
        Candy[][] candyRows = {
            { Candy.YELLOW, Candy.GREEN, Candy.YELLOW, Candy.RED },
            { Candy.RED, Candy.GREEN, Candy.BLUE, Candy.BLUE },
            { Candy.BLUE, Candy.YELLOW, Candy.YELLOW, Candy.RED } };
        GameBoard gameboard = GameBoard.create(candyRows);

        assertThat(gameboard.isMovePossible()).isFalse();
    }

}

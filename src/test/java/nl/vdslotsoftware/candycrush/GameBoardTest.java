package nl.vdslotsoftware.candycrush;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GameBoardTest {

    @Test
    void givenOneColorRow_aCrushIsPossible() throws Exception {
        GameBoard oneColorRow = GameBoard.create(new Candy[][] { { Candy.BLUE, Candy.BLUE, Candy.BLUE, Candy.BLUE } });

        boolean crushPossible = oneColorRow.isCrushPossible();

        assertThat(crushPossible).isEqualTo(true);
    }

    @Test
    void givenAllDifferentColorsRow_aCrushIsNotPossible() throws Exception {
        GameBoard differentColorRow = GameBoard.create(new Candy[][] { { Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW } });

        boolean crushPossible = differentColorRow.isCrushPossible();

        assertThat(crushPossible).isEqualTo(false);
    }

    @Test
    void givenThreeInARow_aCrushIsPossible() throws Exception {
        GameBoard threeInARow = GameBoard.create(new Candy[][] { { Candy.BLUE, Candy.BLUE, Candy.BLUE, Candy.YELLOW } });

        boolean crushPossible = threeInARow.isCrushPossible();

        assertThat(crushPossible).isEqualTo(true);
    }

    @Test
    void givenThreeInARowOnSecondRow_aCrushIsPossible() throws Exception {
        GameBoard oneColorRow = GameBoard.create(new Candy[][] {
            { Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW },
            { Candy.BLUE, Candy.BLUE, Candy.BLUE, Candy.GREEN },
            { Candy.YELLOW, Candy.GREEN, Candy.RED, Candy.YELLOW } });

        boolean crushPossible = oneColorRow.isCrushPossible();

        assertThat(crushPossible).isEqualTo(true);
    }

    @Test
    void givenThreeInAColumn_aCrushIsPossible() throws Exception {
        GameBoard oneColorColumn =
            GameBoard.create(new Candy[][] { { Candy.BLUE }, { Candy.BLUE }, { Candy.BLUE }, { Candy.BLUE } });

        boolean crushPossible = oneColorColumn.isCrushPossible();

        assertThat(crushPossible).isEqualTo(true);
    }

    @Test
    void givenAllDifferentColorsColumn_aCrushIsNotPossible() throws Exception {
        GameBoard differentColorColumn =
            GameBoard.create(new Candy[][] { { Candy.YELLOW }, { Candy.GREEN }, { Candy.RED }, { Candy.YELLOW } });

        boolean crushPossible = differentColorColumn.isCrushPossible();

        assertThat(crushPossible).isEqualTo(false);
    }

}

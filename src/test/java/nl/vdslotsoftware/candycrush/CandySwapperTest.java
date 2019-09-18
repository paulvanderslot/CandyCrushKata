package nl.vdslotsoftware.candycrush;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CandySwapperTest {

    @Test
    void swapNeighbours() throws Exception {
        GameBoard gameboard = GameBoard.create(new Candy[][] { { Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW } });

        Neighbours neighbours = new Neighbours(new CandyLocation(0, 0), new CandyLocation(0, 1));
        GameBoard swappedBoard = gameboard.swap(neighbours);

        GameBoard expected = GameBoard.create(new Candy[][] { { Candy.GREEN, Candy.BLUE, Candy.RED, Candy.YELLOW } });
        assertThat(swappedBoard).isEqualTo(expected);
    }

    @Test
    void swapNeighboursDoesNotChangeOriginal() throws Exception {
        GameBoard gameboard = GameBoard.create(new Candy[][] { { Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW } });

        Neighbours neighbours = new Neighbours(new CandyLocation(0, 0), new CandyLocation(0, 1));
        gameboard.swap(neighbours);

        GameBoard expected = GameBoard.create(new Candy[][] { { Candy.GREEN, Candy.BLUE, Candy.RED, Candy.YELLOW } });
        assertThat(gameboard).isNotEqualTo(expected);
    }
}

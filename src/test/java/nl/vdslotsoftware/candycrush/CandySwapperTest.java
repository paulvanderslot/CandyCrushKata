package nl.vdslotsoftware.candycrush;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CandySwapperTest {

    private GameBoard gameboard;
    private Neighbours swappingNeighbours;

    @BeforeEach
    void before() {
        gameboard = GameBoard.create(new Candy[][] { { Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW } });
        swappingNeighbours = new Neighbours(new CandyLocation(0, 0), new CandyLocation(0, 1));
    }

    @Test
    void swapNeighbours() throws Exception {
        GameBoard swappedBoard = gameboard.swap(swappingNeighbours);

        GameBoard expected = GameBoard.create(new Candy[][] { { Candy.GREEN, Candy.BLUE, Candy.RED, Candy.YELLOW } });
        assertThat(swappedBoard).isEqualTo(expected);
    }

    @Test
    void swapNeighboursDoesNotChangeOriginal() throws Exception {
        GameBoard swappedBoard = gameboard.swap(swappingNeighbours);

        assertThat(gameboard).isNotEqualTo(swappedBoard);
    }
}

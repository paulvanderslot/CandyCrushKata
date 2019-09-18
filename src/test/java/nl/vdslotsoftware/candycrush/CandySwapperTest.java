package nl.vdslotsoftware.candycrush;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CandySwapperTest {

    @Test
    void swapNeighbours() throws Exception {
        GameBoard differentColorRow = GameBoard.create(new Candy[][] { { Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW } });

        CandySwapper candySwapper = new CandySwapper();
        Neighbours neighbours = new Neighbours(new CandyLocation(0, 0), new CandyLocation(0, 1));
        GameBoard swappedBoard = candySwapper.swap(neighbours, differentColorRow);

        GameBoard expected = GameBoard.create(new Candy[][] { { Candy.GREEN, Candy.BLUE, Candy.RED, Candy.YELLOW } });
        assertThat(swappedBoard).isEqualTo(expected);
        // assertThat(differentColorRow).isNotEqualTo(expected); //TODO gameboard immutable
    }
}

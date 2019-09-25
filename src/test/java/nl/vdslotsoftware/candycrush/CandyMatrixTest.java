package nl.vdslotsoftware.candycrush;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CandyMatrixTest {

    private CandyMatrix candyMatrix;
    private Neighbours swappingNeighbours;

    @BeforeEach
    void before() {
        candyMatrix = new CandyMatrix(new Candy[][] {
            { Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW },
            { Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW } });
        swappingNeighbours = new Neighbours(new CandyLocation(0, 0), new CandyLocation(0, 1));
    }

    @Test
    void swapNeighbours() throws Exception {
        CandyMatrix swappedBoard = candyMatrix.swap(swappingNeighbours);

        CandyMatrix expected = new CandyMatrix(new Candy[][] {
            { Candy.GREEN, Candy.BLUE, Candy.RED, Candy.YELLOW },
            { Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW } });
        assertThat(swappedBoard).isEqualTo(expected);
    }

    @Test
    void swapNeighboursDoesNotChangeOriginal() throws Exception {
        CandyMatrix swappedBoard = candyMatrix.swap(swappingNeighbours);

        assertThat(candyMatrix).isNotEqualTo(swappedBoard);
    }

    @Test
    void getNeighboursFromCandyMatrix() throws Exception {
        Collection<Neighbours> neighbours = candyMatrix.getNeighbours();

        assertThat(neighbours).containsExactly(
            new Neighbours(new CandyLocation(0, 0), new CandyLocation(0, 1)),
            new Neighbours(new CandyLocation(0, 1), new CandyLocation(0, 2)),
            new Neighbours(new CandyLocation(0, 2), new CandyLocation(0, 3)),
            new Neighbours(new CandyLocation(1, 0), new CandyLocation(1, 1)),
            new Neighbours(new CandyLocation(1, 1), new CandyLocation(1, 2)),
            new Neighbours(new CandyLocation(1, 2), new CandyLocation(1, 3)),
            new Neighbours(new CandyLocation(0, 0), new CandyLocation(1, 0)),
            new Neighbours(new CandyLocation(0, 1), new CandyLocation(1, 1)),
            new Neighbours(new CandyLocation(0, 2), new CandyLocation(1, 2)),
            new Neighbours(new CandyLocation(0, 3), new CandyLocation(1, 3)));
    }

    @Test
    void getRowsFromCandyMatrix() throws Exception {
        Collection<List<Candy>> rows = candyMatrix.getRows();

        assertThat(rows).containsExactly(
            Arrays.asList(Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW),
            Arrays.asList(Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW));
    }

    @Test
    void getColumnsFromCandyMatrix() throws Exception {
        Collection<List<Candy>> columns = candyMatrix.getColumns();

        assertThat(columns).containsExactly(
            Arrays.asList(Candy.BLUE, Candy.BLUE),
            Arrays.asList(Candy.GREEN, Candy.GREEN),
            Arrays.asList(Candy.RED, Candy.RED),
            Arrays.asList(Candy.YELLOW, Candy.YELLOW));
    }

}

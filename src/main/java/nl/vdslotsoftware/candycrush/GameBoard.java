package nl.vdslotsoftware.candycrush;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.stream.IntStream;

public class GameBoard {

    private Candy[][] candyRows;

    private GameBoard(Candy[][] candyRows) {
        this.candyRows = candyRows;
    }

    public static GameBoard create(Candy[][] candyRows) {
        return new GameBoard(candyRows);
    }

    public Collection<Neighbours> getNeighbours() {
        Candy[] firstRow = candyRows[0];

        return IntStream.range(0, (firstRow.length - 1)).boxed()
            .map(colNum -> new Neighbours(firstRow[colNum], firstRow[colNum + 1]))
            .collect(toList());
    }

}

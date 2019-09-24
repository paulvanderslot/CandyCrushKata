package nl.vdslotsoftware.candycrush;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class CandyMatrix {

    Candy[][] state;
    private int numberOfRows;
    private int numerOfColumns;

    public CandyMatrix(Candy[][] candyMatrix) {
        this.state = candyMatrix;
        numberOfRows = candyMatrix.length;
        numerOfColumns = candyMatrix[0].length;
    }

    public List<List<Candy>> getRows() {
        return IntStream.range(0, numberOfRows).boxed()
            .map(rowNum -> Arrays.stream(state[rowNum]).collect(toList()))
            .collect(toList());
    }

    public List<List<Candy>> getColumns() {
        return IntStream.range(0, numerOfColumns).boxed()
            .map(this::getColumn)
            .collect(toList());
    }

    private List<Candy> getColumn(int colNum) {
        return IntStream.range(0, numberOfRows).boxed()
            .map(i -> state[i][colNum])
            .collect(toList());
    }

    public Candy getCandy(CandyLocation location) {
        return state[location.rowNumber][location.columNumber];
    }

    public Collection<Neighbours> getNeighbours() {
        Collection<Neighbours> allNeighbours = new ArrayList<>();
        allNeighbours.addAll(getHorizontalNeighbours());
        allNeighbours.addAll(getVerticalNeighbours());
        return allNeighbours;
    }

    private Collection<Neighbours> getVerticalNeighbours() {
        return IntStream.range(0, numerOfColumns).boxed()
            .flatMap(colNum -> getNeighBoursForColumn(colNum).stream())
            .collect(toList());
    }

    private List<Neighbours> getNeighBoursForColumn(int colNum) {
        return IntStream.range(0, (numberOfRows - 1)).boxed()
            .map(rowNum -> new Neighbours(new CandyLocation(rowNum, colNum), new CandyLocation(rowNum + 1, colNum)))
            .collect(toList());
    }

    private List<Neighbours> getHorizontalNeighbours() {
        return IntStream.range(0, numberOfRows).boxed()
            .flatMap(rowNum -> getNeighBoursForRow(rowNum).stream())
            .collect(toList());
    }

    private List<Neighbours> getNeighBoursForRow(int rowNum) {
        return IntStream.range(0, (numerOfColumns - 1)).boxed()
            .map(colNum -> new Neighbours(new CandyLocation(rowNum, colNum), new CandyLocation(rowNum, colNum + 1)))
            .collect(toList());
    }
}

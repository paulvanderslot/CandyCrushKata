package nl.vdslotsoftware.candycrush;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class GameBoard {

    private final Candy[][] candyMatrix;

    private GameBoard(Candy[][] candyRows) {
        this.candyMatrix = candyRows;
    }

    public static GameBoard create(Candy[][] candyRows) {
        return new GameBoard(candyRows);
    }

    public boolean isMovePossible() {
        Collection<Neighbours> neighboursCollection = getNeighbours();
        return neighboursCollection.stream().anyMatch(this::isCrushPossibleAfterSwap);
    }

    private boolean isCrushPossibleAfterSwap(Neighbours neighbours) {
        GameBoard newGameBoard = swap(neighbours);
        return newGameBoard.isCrushPossible();
    }

    private Collection<Neighbours> getNeighbours() {
        return getHorizontalNeighbours();
    }

    private List<Neighbours> getHorizontalNeighbours() {
        return IntStream.range(0, candyMatrix.length).boxed()
            .flatMap(rowNum -> getNeighBoursForRow(rowNum).stream())
            .collect(toList());
    }

    private List<Neighbours> getNeighBoursForRow(int rowNum) {
        Candy[] candyRow = candyMatrix[rowNum];
        return IntStream.range(0, (candyRow.length - 1)).boxed()
            .map(colNum -> new Neighbours(new CandyLocation(rowNum, colNum), new CandyLocation(rowNum, colNum + 1)))
            .collect(toList());
    }

    public boolean isCrushPossible() {
        return IntStream.range(0, candyMatrix.length).anyMatch(i -> containsThreeInARow(candyMatrix[i]));
    }

    private boolean containsThreeInARow(Candy[] candies) {
        int candyCounter = 1;
        Candy previous = null;

        for (Candy candy : candies) {
            if (previous != null && previous.equals(candy)) {
                candyCounter++;
                if (candyCounter == 3) {
                    return true;
                }
            }
            else {
                candyCounter = 1;
            }
            previous = candy;
        }

        return false;
    }

    public GameBoard swap(Neighbours neighbours) {
        Candy[][] candyRowsCopy = deepCopy(candyMatrix);

        Candy candy1 = getCandy(neighbours.location1);
        Candy candy2 = getCandy(neighbours.location2);

        setCandy(candyRowsCopy, neighbours.location1, candy2);
        setCandy(candyRowsCopy, neighbours.location2, candy1);

        return GameBoard.create(candyRowsCopy);
    }

    private Candy[][] deepCopy(Candy[][] original) {
        final Candy[][] result = new Candy[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    private void setCandy(Candy[][] candyRowsCopy, CandyLocation location, Candy candy) {
        candyRowsCopy[location.rowNumber][location.columNumber] = candy;
    }

    private Candy getCandy(CandyLocation location) {
        return candyMatrix[location.rowNumber][location.columNumber];
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(candyMatrix);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GameBoard other = (GameBoard) obj;
        return Arrays.deepEquals(candyMatrix, other.candyMatrix);
    }

    @Override
    public String toString() {
        return "GameBoard [candyRows=" + Arrays.toString(candyMatrix) + "]";
    }

}

package nl.vdslotsoftware.candycrush;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GameBoard {

    private final CandyMatrix candyMatrix;

    private GameBoard(CandyMatrix candyMatrix) {
        this.candyMatrix = candyMatrix;
    }

    public static GameBoard create(Candy[][] candyMatrix) {
        return new GameBoard(new CandyMatrix(candyMatrix));
    }

    public boolean isMovePossible() {
        Collection<Neighbours> neighboursCollection = candyMatrix.getNeighbours();
        return neighboursCollection.stream().anyMatch(this::isCrushPossibleAfterSwap);
    }

    private boolean isCrushPossibleAfterSwap(Neighbours neighbours) {
        GameBoard newGameBoard = swap(neighbours);
        return newGameBoard.isCrushPossible();
    }

    public boolean isCrushPossible() {
        return candyMatrix.getRows().stream().anyMatch(this::containsThreeInARow)
            || candyMatrix.getColumns().stream().anyMatch(this::containsThreeInARow);
    }

    private boolean containsThreeInARow(List<Candy> candies) {
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
        Candy[][] candyRowsCopy = deepCopy(candyMatrix.state);

        Candy candy1 = candyMatrix.getCandy(neighbours.location1);
        Candy candy2 = candyMatrix.getCandy(neighbours.location2);

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(candyMatrix.state);
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
        return Arrays.deepEquals(candyMatrix.state, other.candyMatrix.state);
    }

    @Override
    public String toString() {
        return "GameBoard [candyRows=" + Arrays.deepToString(candyMatrix.state) + "]";
    }

}

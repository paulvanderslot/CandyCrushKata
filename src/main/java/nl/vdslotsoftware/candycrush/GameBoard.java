package nl.vdslotsoftware.candycrush;

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
        CandyMatrix newState = candyMatrix.swap(neighbours);
        return isCrushPossible(newState);
    }

    public boolean isCrushPossible() {
        return isCrushPossible(candyMatrix);
    }

    private boolean isCrushPossible(CandyMatrix newState) {
        return newState.getRows().stream().anyMatch(this::containsThreeInARow)
            || newState.getColumns().stream().anyMatch(this::containsThreeInARow);
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

}

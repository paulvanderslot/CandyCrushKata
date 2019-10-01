package nl.vdslotsoftware.candycrush;

import java.util.Collection;

public class GameBoard {

    private final CandyMatrix candyMatrix;
    private final CrushDetector crushDetector;

    private GameBoard(CandyMatrix candyMatrix, CrushDetector crushDetector) {
        this.candyMatrix = candyMatrix;
        this.crushDetector = crushDetector;
    }

    public static GameBoard create(Candy[][] candyMatrix) {
        return new GameBoard(new CandyMatrix(candyMatrix), new CrushDetector());
    }

    public boolean isMovePossible() {
        Collection<Neighbours> neighboursCollection = candyMatrix.getNeighbours();
        return neighboursCollection.stream().anyMatch(this::isCrushPossibleAfterSwap);
    }

    private boolean isCrushPossibleAfterSwap(Neighbours neighbours) {
        CandyMatrix newState = candyMatrix.swap(neighbours);
        return crushDetector.isCrushPossible(newState);
    }
}

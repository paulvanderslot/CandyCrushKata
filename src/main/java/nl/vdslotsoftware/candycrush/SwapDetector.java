package nl.vdslotsoftware.candycrush;

import java.util.Collection;

public class SwapDetector {

    private CandySwapper candySwapper;
    private CrushDetector crushDetector;

    SwapDetector(CandySwapper candySwapper, CrushDetector crushDetector) {
        this.candySwapper = candySwapper;
        this.crushDetector = crushDetector;
    }

    public boolean isSwapPossible(GameBoard gameBoard) {
        Collection<Neighbours> neighboursCollection = gameBoard.getNeighbours();
        return neighboursCollection.stream().anyMatch(neighbours -> isCrushPossibleAfterSwap(gameBoard, neighbours));
    }

    private boolean isCrushPossibleAfterSwap(GameBoard gameBoard, Neighbours neighbours) {
        GameBoard newGameBoard = candySwapper.swap(neighbours, gameBoard);
        return crushDetector.isCrushPossible(newGameBoard);
    }
}

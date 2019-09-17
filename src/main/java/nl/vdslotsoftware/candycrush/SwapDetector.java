package nl.vdslotsoftware.candycrush;

import java.util.Collection;

public class SwapDetector {

    private CandySwapper candySwapper;

    SwapDetector(CandySwapper candySwapper) {
        this.candySwapper = candySwapper;
    }

    public boolean isSwapPossible(GameBoard gameBoard) {
        Collection<Neighbours> neighboursCollection = gameBoard.getNeighbours();
        return neighboursCollection.stream().anyMatch(neighbours -> isCrushPossibleAfterSwap(gameBoard, neighbours));
    }

    private boolean isCrushPossibleAfterSwap(GameBoard gameBoard, Neighbours neighbours) {
        GameBoard newGameBoard = candySwapper.swap(neighbours, gameBoard);
        return newGameBoard.isCrushPossible();
    }
}

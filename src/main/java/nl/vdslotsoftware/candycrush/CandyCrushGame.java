package nl.vdslotsoftware.candycrush;

public class CandyCrushGame {

    private GameBoard gameBoard;
    private SwapDetector swapDetector;

    public CandyCrushGame(GameBoard gameBoard, SwapDetector swapDetector) {
        this.gameBoard = gameBoard;
        this.swapDetector = swapDetector;
    }

    public boolean isMovePossible() {
        return swapDetector.isSwapPossible(gameBoard);
    }

}

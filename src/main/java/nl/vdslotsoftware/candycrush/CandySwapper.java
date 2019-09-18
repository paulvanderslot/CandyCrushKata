package nl.vdslotsoftware.candycrush;

public class CandySwapper {

    GameBoard swap(Neighbours neighbours, GameBoard gameBoard) {
        return gameBoard.swap(neighbours);
    }
}

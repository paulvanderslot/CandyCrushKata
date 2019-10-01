package nl.vdslotsoftware.candycrush;

import java.util.List;

public class CrushDetector {

    public boolean isCrushPossible(CandyMatrix candyMatrix) {
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
}

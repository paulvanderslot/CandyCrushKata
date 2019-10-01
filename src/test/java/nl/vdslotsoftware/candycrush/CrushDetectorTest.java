package nl.vdslotsoftware.candycrush;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrushDetectorTest {

    private CrushDetector crushDetector;

    @BeforeEach
    void before() {
        crushDetector = new CrushDetector();
    }

    @Test
    void givenOneColorRow_aCrushIsPossible() throws Exception {
        CandyMatrix oneColorRow = new CandyMatrix(new Candy[][] { { Candy.BLUE, Candy.BLUE, Candy.BLUE, Candy.BLUE } });

        boolean crushPossible = crushDetector.isCrushPossible(oneColorRow);

        assertThat(crushPossible).isEqualTo(true);
    }

    @Test
    void givenAllDifferentColorsRow_aCrushIsNotPossible() throws Exception {
        CandyMatrix differentColorRow = new CandyMatrix(new Candy[][] { { Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW } });

        boolean crushPossible = crushDetector.isCrushPossible(differentColorRow);

        assertThat(crushPossible).isEqualTo(false);
    }

    @Test
    void givenThreeInARow_aCrushIsPossible() throws Exception {
        CandyMatrix threeInARow = new CandyMatrix(new Candy[][] { { Candy.BLUE, Candy.BLUE, Candy.BLUE, Candy.YELLOW } });

        boolean crushPossible = crushDetector.isCrushPossible(threeInARow);

        assertThat(crushPossible).isEqualTo(true);
    }

    @Test
    void givenThreeInARowOnSecondRow_aCrushIsPossible() throws Exception {
        CandyMatrix oneColoredSecondRow = new CandyMatrix(new Candy[][] {
            { Candy.BLUE, Candy.GREEN, Candy.RED, Candy.YELLOW },
            { Candy.BLUE, Candy.BLUE, Candy.BLUE, Candy.GREEN },
            { Candy.YELLOW, Candy.GREEN, Candy.RED, Candy.YELLOW } });

        boolean crushPossible = crushDetector.isCrushPossible(oneColoredSecondRow);

        assertThat(crushPossible).isEqualTo(true);
    }

    @Test
    void givenThreeInAColumn_aCrushIsPossible() throws Exception {
        CandyMatrix oneColorColumn =
            new CandyMatrix(new Candy[][] { { Candy.BLUE }, { Candy.BLUE }, { Candy.BLUE }, { Candy.BLUE } });

        boolean crushPossible = crushDetector.isCrushPossible(oneColorColumn);

        assertThat(crushPossible).isEqualTo(true);
    }

    @Test
    void givenAllDifferentColorsColumn_aCrushIsNotPossible() throws Exception {
        CandyMatrix differentColorColumn =
            new CandyMatrix(new Candy[][] { { Candy.YELLOW }, { Candy.GREEN }, { Candy.RED }, { Candy.YELLOW } });

        boolean crushPossible = crushDetector.isCrushPossible(differentColorColumn);

        assertThat(crushPossible).isEqualTo(false);
    }

}

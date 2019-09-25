package nl.vdslotsoftware.candycrush;

import java.util.Objects;

public class CandyLocation {

    final int rowNumber;
    final int columNumber;

    CandyLocation(int rowNumber, int columNumber) {
        this.rowNumber = rowNumber;
        this.columNumber = columNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(columNumber, rowNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CandyLocation other = (CandyLocation) obj;
        return columNumber == other.columNumber && rowNumber == other.rowNumber;
    }

    @Override
    public String toString() {
        return "CandyLocation [rowNumber=" + rowNumber + ", columNumber=" + columNumber + "]";
    }

}

package nl.vdslotsoftware.candycrush;

import java.util.Objects;

public class Neighbours {

    final CandyLocation location1;
    final CandyLocation location2;

    public Neighbours(CandyLocation location1, CandyLocation location2) {
        this.location1 = location1;
        this.location2 = location2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location1, location2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Neighbours other = (Neighbours) obj;
        return Objects.equals(location1, other.location1) && Objects.equals(location2, other.location2);
    }

    @Override
    public String toString() {
        return "Neighbours [location1=" + location1 + ", location2=" + location2 + "]";
    }

}

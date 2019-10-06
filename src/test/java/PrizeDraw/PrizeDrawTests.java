package PrizeDraw;

import com.gardner.adam.codewarspractice.PrizeDraw.PrizeDraw;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrizeDrawTests {
    @Test
    public void noNamesReturnsNoParticipants() {
        String st = "";
        Integer[] we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        String results = PrizeDraw.nthRank(st, we, 4);
        assertEquals("No participants", results);
    }

    @Test
    public void lessNamesThanNReturnsNotEnoughParticipants() {
        String st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
        Integer[] we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        String results = PrizeDraw.nthRank(st, we, 8);
        assertEquals("Not enough participants", results);
    }

    @Test
    public void shouldReturnBen() {
        String st = "Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin";
        Integer[] we = new Integer[]{4, 2, 1, 4, 3, 1, 2};
        assertEquals("Benjamin", PrizeDraw.nthRank(st, we, 4));
    }

    @Test
    public void shouldReturnMatthew() {

        String st = "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden";
        Integer[] we = new Integer[]{1, 3, 5, 5, 3, 6};
        assertEquals("Matthew", PrizeDraw.nthRank(st, we, 2));
    }


}


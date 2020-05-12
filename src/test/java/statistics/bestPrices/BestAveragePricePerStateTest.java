package statistics.bestPrices;


import org.junit.jupiter.api.Test;
import statistics.State;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BestAveragePricePerStateTest {

    @Test
    void shouldReturnAveragePriceOfSingleRecordList() {
        //given
        List<State> states = List.of(new State("New York", new BigDecimal(300), new BigDecimal(200),
                new BigDecimal(100), new BigDecimal(200), LocalDate.of(2005, 4, 15)));
        BestAveragePrice averagePricePerState = new BestAveragePrice(states);
        //when
        List<State> actual = averagePricePerState.bestPriceForEachState();
        List<State> expected = List.of(new State("New York", new BigDecimal(300), new BigDecimal(200),
                new BigDecimal(100), new BigDecimal(200), LocalDate.of(2005, 4, 15)));
        //then
        assertEquals(actual, expected);
    }

    @Test
    void shouldReturnBestAveragePriceRecordForSameStateList() {
        //given
        List<State> states = List.of(new State("New York", new BigDecimal(200), new BigDecimal(150),
                new BigDecimal(100), new BigDecimal(150), LocalDate.of(2005, 4, 15)),
                new State("New York", new BigDecimal(300), new BigDecimal(200),
                        new BigDecimal(100), new BigDecimal(200), LocalDate.of(2005, 4, 15)),
                new State("New York", new BigDecimal(100), new BigDecimal(100),
                        new BigDecimal(100), new BigDecimal(100), LocalDate.of(2005, 4, 15)),
                new State("New York", new BigDecimal(400), new BigDecimal(220),
                        new BigDecimal(130), new BigDecimal(250), LocalDate.of(2005, 4, 15)));
        BestAveragePrice averagePricePerState = new BestAveragePrice(states);

        //when
        List<State> actual = averagePricePerState.bestPriceForEachState();
        List<State> expected = List.of(new State("New York", new BigDecimal(100), new BigDecimal(100),
                new BigDecimal(100), new BigDecimal(100), LocalDate.of(2005, 4, 15)));
        //then
        assertEquals(expected, actual);
    }

}
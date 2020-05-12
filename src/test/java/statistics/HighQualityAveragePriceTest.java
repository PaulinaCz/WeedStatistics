package statistics;

import org.junit.jupiter.api.Test;
import statistics.averagePrices.HighQualityAveragePrice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class HighQualityAveragePriceTest {

    @Test
    void shouldReturnHighQualityPriceForOneRecordList() {
        //given
        List<State> states = List.of(new State("Alabama", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(60), new BigDecimal(80), LocalDate.of(2014, 8, 1)));
        HighQualityAveragePrice highQualityAveragePrice = new HighQualityAveragePrice(states);
        //when
        BigDecimal result = highQualityAveragePrice.averagePricePerState("Alabama");
        BigDecimal expected = new BigDecimal("100");
        //then
        assertEquals(expected, result);

    }

}
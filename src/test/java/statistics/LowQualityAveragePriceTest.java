package statistics;

import org.junit.jupiter.api.Test;
import statistics.averagePrices.LowQualityAveragePrice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LowQualityAveragePriceTest {

    @Test
    void shouldTReturnAverageForLowQuality() {
        //given
        List<State> states = List.of(new State("Alabama", new BigDecimal("100"), new BigDecimal(100), new BigDecimal("100"), new BigDecimal(100), LocalDate.of(2014, 8, 1)),
                new State("Alabama", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(60),new BigDecimal(80), LocalDate.of(2014, 8, 1)),
                new State("Nevada", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(60), new BigDecimal(80), LocalDate.of(2014, 8, 1)),
                new State("New Mexico", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(60), new BigDecimal(80), LocalDate.of(2014, 8, 1)));
        LowQualityAveragePrice lowQualityAveragePrice = new LowQualityAveragePrice(states);
        //when
        BigDecimal result = lowQualityAveragePrice.averagePricePerState("Alabama");
        BigDecimal expected = new BigDecimal("80");
        //then
        assertEquals(expected, result);

    }


    @Test
    void shouldReturnLowQualityPriceForOneRecordList() {
        //given
        List<State> states = List.of(new State("Alabama", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(60),new BigDecimal(80),  LocalDate.of(2014, 8, 1)));
        LowQualityAveragePrice lowQualityAveragePrice = new LowQualityAveragePrice(states);
        //when
        BigDecimal result = lowQualityAveragePrice.averagePricePerState("Alabama");
        BigDecimal expected = new BigDecimal("60");
        //then
        assertEquals(expected, result);

    }
}
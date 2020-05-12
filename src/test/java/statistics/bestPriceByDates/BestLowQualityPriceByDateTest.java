package statistics.bestPriceByDates;

import org.junit.jupiter.api.Test;
import statistics.State;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BestLowQualityPriceByDateTest {

    @Test
    void shouldReturnBestLQPForOneDateRecords() {
        //given
        List<State> states = List.of(
                new State("Ohio", BigDecimal.valueOf(250), BigDecimal.valueOf(200), BigDecimal.valueOf(150),
                        BigDecimal.valueOf(200), LocalDate.of(2020, 1, 1)),
                new State("Illinois", BigDecimal.valueOf(200), BigDecimal.valueOf(150), BigDecimal.valueOf(100),
                        BigDecimal.valueOf(150), LocalDate.of(2020, 1, 1)),
                new State("West Virginia", BigDecimal.valueOf(150), BigDecimal.valueOf(100), BigDecimal.valueOf(50),
                        BigDecimal.valueOf(100), LocalDate.of(2020, 1, 1))
        );
        BestPriceByDate priceByDate = new BestLowQualityPriceByDate(states);
        //when
        Map<LocalDate, Optional<State>> result = priceByDate.bestPricePerDate();
        Map<LocalDate, Optional<State>> expected = new HashMap<>();
        expected.put(LocalDate.of(2020, 1, 1), Optional.of(new State("West Virginia", BigDecimal.valueOf(150), BigDecimal.valueOf(100), BigDecimal.valueOf(50),
                BigDecimal.valueOf(100), LocalDate.of(2020, 1, 1))));
        //then
        assertEquals(expected, result);
    }

}
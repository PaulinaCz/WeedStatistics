package statistics.bestPricesByYears;

import org.junit.jupiter.api.Test;
import statistics.State;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BestHighQualityPriceByYearTest {

    @Test
    void shouldReturnMapOfBestHQPOverYears() {
        //given
        List<State> states = List.of(
                new State("Mexico", BigDecimal.valueOf(50), BigDecimal.valueOf(100), BigDecimal.valueOf(150),
                        BigDecimal.valueOf(100), LocalDate.of(2015, 1, 1)),
                new State("Kentucky", BigDecimal.valueOf(150), BigDecimal.valueOf(200), BigDecimal.valueOf(250),
                        BigDecimal.valueOf(200), LocalDate.of(2015, 2, 2)),
                new State("Nebraska", BigDecimal.valueOf(60), BigDecimal.valueOf(110), BigDecimal.valueOf(160),
                        BigDecimal.valueOf(110), LocalDate.of(2015, 1, 1)),
                new State("Mexico", BigDecimal.valueOf(50), BigDecimal.valueOf(100), BigDecimal.valueOf(150),
                        BigDecimal.valueOf(100), LocalDate.of(2017, 1, 1)),
                new State("Kentucky", BigDecimal.valueOf(150), BigDecimal.valueOf(200), BigDecimal.valueOf(250),
                        BigDecimal.valueOf(200), LocalDate.of(2017, 2, 2)),
                new State("Nebraska", BigDecimal.valueOf(60), BigDecimal.valueOf(110), BigDecimal.valueOf(160),
                         BigDecimal.valueOf(110), LocalDate.of(2017, 1, 1))
                );

        BestPriceByYear bestHighQualityPricePerYear = new BestHighQualityPriceByYear(states);
        //when
        Map<Integer, Optional<State>> result = bestHighQualityPricePerYear.bestPricePerYear();
        Map<Integer, Optional<State>> expected = new HashMap<>();
        expected.put(2015, Optional.of(new State("Mexico", BigDecimal.valueOf(50), BigDecimal.valueOf(100), BigDecimal.valueOf(150),
                BigDecimal.valueOf(100), LocalDate.of(2015, 1, 1))));
        expected.put(2017, Optional.of(new State("Mexico", BigDecimal.valueOf(50), BigDecimal.valueOf(100), BigDecimal.valueOf(150),
                BigDecimal.valueOf(100), LocalDate.of(2017, 1, 1))));
        //then
        assertEquals(expected, result);
    }

}
package statistics;

import org.junit.jupiter.api.Test;
import statistics.averagePrices.StatesWithAveragePrices;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StatesWithAveragePricesTest {


    @Test
    void shouldReturnAveragePriceForOneRecordList() {
        //given
        List<State> states =  List.of(new State("Alabama", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(60),new BigDecimal(80),  LocalDate.of(2014, 8, 1)));
        StatesWithAveragePrices statesWithAveragePrices = new StatesWithAveragePrices(states);
        //when
        Map<String, BigDecimal> result = statesWithAveragePrices.averagePriceForEachState();
        Map<String, BigDecimal> expected = new HashMap<>();
        expected.put("Alabama", new BigDecimal(80));
        //then
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnMapOfAveragePriceForEachState() {
        //given
        List<State> states =  List.of(new State("Alabama", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(60),new BigDecimal(80),  LocalDate.of(2014, 8, 1)),
                new State("Florida", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(60), new BigDecimal(80), LocalDate.of(2014, 8, 1)),
                new State("Nebraska", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(60), new BigDecimal(80), LocalDate.of(2014, 8, 1)));
        StatesWithAveragePrices statesWithAveragePrices = new StatesWithAveragePrices(states);
        //when
        Map<String, BigDecimal> result = statesWithAveragePrices.averagePriceForEachState();
        Map<String, BigDecimal> expected = new HashMap<>();
        expected.put("Alabama", new BigDecimal(80));
        expected.put("Florida", new BigDecimal(80));
        expected.put("Nebraska", new BigDecimal(80));
        //then
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnMapOfAveragePriceForEachStateWithMultipleStateAppearance() {
        //given
        List<State> states =  List.of(new State("Alabama", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(90), new BigDecimal(90), LocalDate.of(2014, 8, 1)),
                new State("Florida", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(60),new BigDecimal(80),  LocalDate.of(2014, 8, 1)),
                new State("Nebraska", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(60),new BigDecimal(80),  LocalDate.of(2014, 8, 1)),
                new State("Alabama", new BigDecimal("100"), new BigDecimal(80), new BigDecimal(60), new BigDecimal(80), LocalDate.of(2014, 8, 1)));
        StatesWithAveragePrices statesWithAveragePrices = new StatesWithAveragePrices(states);
        //when
        Map<String, BigDecimal> result = statesWithAveragePrices.averagePriceForEachState();
        Map<String, BigDecimal> expected = new HashMap<>();
        expected.put("Alabama",new BigDecimal(85));
        expected.put("Florida", new BigDecimal(80));
        expected.put("Nebraska", new BigDecimal(80));
        //then
        assertEquals(expected, result);
    }

}